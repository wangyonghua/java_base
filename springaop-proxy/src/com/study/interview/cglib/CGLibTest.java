package com.study.interview.cglib;

import com.study.interview.AdminServiceImpl;

/**
 * Created by wangyonghua on 2017/9/7.
 */
public class CGLibTest {
    public static void main(String[] args) {
        CGlibProxy proxy = new CGlibProxy();
        AdminServiceImpl adminService = (AdminServiceImpl) proxy.getProxy(AdminServiceImpl.class);
        int userId = 10;
        String topic = "cglibProxyEnhanceTest";
        adminService.addTopic(userId, topic);
    }
}
