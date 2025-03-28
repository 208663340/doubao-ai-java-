package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.Logs;
import org.example.admin.service.LogsService;
import org.example.admin.dao.mapper.LogsMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【logs(记录系统操作日志)】的数据库操作Service实现
* @createDate 2025-03-28 11:07:46
*/
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs>
    implements LogsService{

}




