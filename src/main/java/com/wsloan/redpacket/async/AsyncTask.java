package com.wsloan.redpacket.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by EdsionGeng on 2018/4/23.
 */
@Component
public class AsyncTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private UserMapper userMapper;


//    @Async("myTaskAsyncPool")
//    public void addAwardUser(String userid, int inviteUserId, String ip, String phone, String isNew) throws InterruptedException {
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("phone", phone);
//        map.put("userIp", ip);
//        map.put("userId", userid);
//        map.put("inviteUserId", inviteUserId);
//        map.put("addTime", DateUtil.getTime());
//        map.put("isNew", isNew);
//        /**
//         * 添加操作
//         */
//        int result = userMapper.regUser(map);
//        if (result != 0) {
//            /**
//             * 添加推荐人信息，异步执行
//             */
//            logger.info(Thread.currentThread().getName() + "线程名");
//            if (inviteUserId != 0) {
///**
// * 如果查询为空，代表么有记录，进行添加操作。不为空则更新邀请人数
// */
//                int results = userMapper.insertAwardUser(inviteUserId, 1, 0, "0", DateUtil.getTime());
//                if (results == 0) {
//                    userMapper.updateInvitePcs(inviteUserId);
//                }
//            } else {
//                /**
//                 * 邀请人为空，
//                 */
//                userMapper.insertAwardUser(Integer.parseInt(userid), 0, 0, "0", DateUtil.getTime());
//            }
//
//        }
//
//    }

}
