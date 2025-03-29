package org.example.admin.config.async;


import lombok.extern.slf4j.Slf4j;
import org.example.admin.utils.spring.SpringUtils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 异步工厂（产生任务用）
 *
 * @Author: Administrator
 **/
@Slf4j
public class AsyncFactory {
  //  private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 同步session到数据库
     *
     * @param session 在线用户会话
     * @return 任务task
     */
/*   public static TimerTask syncSessionToDb(final OnlineSession session) {
        return new TimerTask() {
            @Override
            public void run() {
                SysUserOnline online = new SysUserOnline();
                online.setSessionId(String.valueOf(session.getId()));
                online.setLoginName(session.getLoginName());
                online.setStartTimestamp(session.getStartTimestamp());
                online.setLastAccessTime(session.getLastAccessTime());
                online.setExpireTime(session.getTimeout());
                online.setIpaddr(session.getHost());
                online.setLoginLocation(AddressUtils.getRealAddressByIP(session.getHost()));
                online.setBrowser(session.getBrowser());
                online.setOs(session.getOs());
                online.setStatus(session.getStatus());
                SpringUtils.getBean(SysUserOnlineService.class).saveOnline(online);
            }
        };
    }*/

    /**
     * 异步获取设备信息
     *
     * @param nodeId   设备ID
     * @param insField 设备有效字段
     * @return 设备信息
     */
//    public static Future<Instruments> asyncGetIns(Long nodeId, List<String> insField) {
//        return AsyncManager.me().asyncExecute(new Callable<Instruments>() {
//            @Override
//            public Instruments call() throws Exception {
//                return SpringUtils.getBean(InstrumentsMapper.class).selectInstrumentInfoById(nodeId, insField);
//            }
//        });
//    }

    /**
     * 异步获取设备数据
     *
     * @param nodeId    设备ID
     * @param infoField 设备信息有效字段
     * @return 设备信息数据
     */
//    public static Future<InstrumentsInfo> asyncGetInsInfo(Long nodeId, List<String> infoField) {
//        return AsyncManager.me().asyncExecute(
//                new Callable<InstrumentsInfo>() {
//                    @Override
//                    public InstrumentsInfo call() throws Exception {
//                        return SpringUtils.getBean(InstrumentsInfoMapper.class).selectInstrumentInfoById(nodeId, infoField);
//                    }
//                });
//    }

//    public static Future<InstrumentsInfo> asyncGetInsInfoNoLimit(Long nodeId, List<String> infoField) {
//        return AsyncManager.me().asyncExecute(
//                new Callable<InstrumentsInfo>() {
//                    @Override
//                    public InstrumentsInfo call() throws Exception {
//                        return SpringUtils.getBean(InstrumentsInfoMapper.class).selectInstrumentInfoByIdNoLimit(nodeId, infoField);
//                    }
//                });
//    }

    /**
     * 异步获取设备历史记录
     *
     * @param nodeId    设备ID
     * @param infoField 设备有效字段
     * @param day       天数
     * @return 设备信息集合
     */
//    public static Future<List<InstrumentsInfo>> asyncGetInsHistoryInfo(Long nodeId, List<String> infoField, Integer day) {
//        return AsyncManager.me().asyncExecute(
//                new Callable<List<InstrumentsInfo>>() {
//                    @Override
//                    public List<InstrumentsInfo> call() throws Exception {
//                        return SpringUtils.getBean(InstrumentsInfoMapper.class).selectInsHistoryInfoById(nodeId, infoField, day);
//                    }
//                });
//    }

    /**
     * 异步获取设备最新历史记录
     *
     * @param nodeId    设备ID
     * @param infoField 设备有效字段
     * @param count       数量
     * @return 设备信息集合
     */
//    public static Future<List<InstrumentsInfo>> asyncGetInsNewHistoryInfo(Long nodeId, List<String> infoField, Integer count) {
//        return AsyncManager.me().asyncExecute(
//                new Callable<List<InstrumentsInfo>>() {
//                    @Override
//                    public List<InstrumentsInfo> call() throws Exception {
//                        return SpringUtils.getBean(InstrumentsInfoMapper.class).selectInsNewHistoryInfoById(nodeId, infoField, count);
//                    }
//                });
//    }

    /**
     * 记录操作日志
     * @param sysLog 操作日志信息
     * @return 定时任务
     */
/*    public static TimerTask recordLog(SysLog sysLog) {
        return new TimerTask() {
            @Override
            public void run() {
                sysLog.setOperLocation(AddressUtils.getRealAddressByIP(sysLog.getOperIp()));
                SpringUtils.getBean(SysLogServiceImpl.class).addSysLog(sysLog);
                //TODO 插入数据库
            }
        };
    }*/

    /**
     * 记录登录信息
     * @param loginName 登录名
     * @param stats 状态
     * @param message 信息
     * @return 定时任务
     */
/*    public static TimerTask recordLoginInfo(String loginName, String stats, String message) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = ShiroUtils.getIp();

        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                //获取操作系统
                String os = userAgent.getOperatingSystem().getName();
                //获取客户浏览器
                String browser = userAgent.getBrowser().getName();
                //封装对象
                SysLoginInfo loginInfo = new SysLoginInfo();
                loginInfo.setLoginName(loginName);
                loginInfo.setIpaddr(ip);
                loginInfo.setLoginLocation(address);
                loginInfo.setBrowser(browser);
                loginInfo.setOs(os);
                loginInfo.setMsg(message);
                if (StringUtils.equalsAny(stats, GeneralConstants.LOGOUT, GeneralConstants.LOGIN_SUCCESS)) {
                    loginInfo.setStatus(GeneralConstants.SUCCESS);
                } else if (GeneralConstants.LOGIN_FAIL.equals(stats)) {
                    loginInfo.setStatus(GeneralConstants.FAIL);
                }
                SpringUtils.getBean(SysUserLoginInfoServiceImpl.class).insertLoginInfo(loginInfo);
            }
        };
    }*/
}
