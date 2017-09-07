package com.study.interview;

public class Main {

    public static void main(String[] args) {
        // write your code here
        AdminService target = new AdminServiceImpl();
        AdminService proxy = (AdminService) ServiceWithPerformanceMonitorProxy.newProxyInstance(target);
        int userId = 10;
        String topic = "jdkProxyTest";
        proxy.addTopic(userId, topic);
    }
}
