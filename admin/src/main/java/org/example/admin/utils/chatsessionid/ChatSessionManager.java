/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.admin.utils.chatsessionid;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static org.example.admin.comon.constant.RedisCacheConstant.ATOMIC_SESSION_ID_COUNTER;
import static org.example.admin.comon.constant.RedisCacheConstant.USER_HISTORY_SESSION_ID;

/**
 * 订单 ID 全局唯一生成器管理
 * <p>
 * 作者：马丁
 * 加项目群：早加入就是优势！500人内部项目群，分享的知识总有你需要的 <a href="https://t.zsxq.com/cw7b9" />
 */
@Component
@RequiredArgsConstructor
public final class ChatSessionManager implements InitializingBean {

    private final RedissonClient redissonClient;

    // 使用 RAtomicLong 来保证分布式环境下的原子递增
    private RAtomicLong atomicLong;
    
    // 用户会话历史记录的SortedSet
    private RScoredSortedSet<String> userSessionHistory;

    /**
     * 生成全局唯一的会话 ID。
     *
     * @param userId 用户 ID
     * @return 全局唯一的会话 ID，格式为 "时间戳-序列号"
     */
    public String generateId(long userId) {
        // 获取当前时间戳（毫秒级）
        long timestamp = System.currentTimeMillis();

        // 获取下一个序列号
        long sequence = atomicLong.incrementAndGet();

        // 组合生成唯一 ID
        String sessionId = String.format("%d-%d-%d", timestamp, userId % 1000000, sequence);
        
        // 将sessionId添加到用户的会话历史中，使用时间戳作为分数以保证时间顺序
        userSessionHistory.add(timestamp, String.valueOf(userId) + ":" + sessionId);
        
        return sessionId;
    }

    /**
     * 获取指定用户的所有会话ID
     *
     * @param userId 用户ID
     * @return 该用户的所有会话ID集合，按时间倒序排列
     */
    public Collection<String> getUserSessionIds(long userId) {
        String userPrefix = String.valueOf(userId) + ":";        
        Collection<String> allSessions = userSessionHistory.valueRange(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
        return allSessions.stream()
                .filter(session -> session.startsWith(userPrefix))
                .map(session -> session.substring(userPrefix.length()))
                .toList();
    }

    @Override
    public void afterPropertiesSet() {
        // 初始化 RAtomicLong
        atomicLong = redissonClient.getAtomicLong(ATOMIC_SESSION_ID_COUNTER);
        
        // 初始化用户会话历史SortedSet
        userSessionHistory = redissonClient.getScoredSortedSet(USER_HISTORY_SESSION_ID);

        // 可选：初始化序列号为当前时间戳的某部分，确保重启后不会立即重复
        // 例如，将序列号初始化为当前秒数
        long initialSequence = System.currentTimeMillis() / 1000 % 1000000; // 每秒最多生成 1,000,000 个 ID
        atomicLong.set(initialSequence);
    }
}