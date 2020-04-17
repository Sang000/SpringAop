package com.galaxy.util;

public class TransationManager {
    public void startTransation(){
        System.out.println("开启事务");
    }
    public void commitTransation() {
        System.out.println("提交事务");
    }

    public void rollbackTansation() {
        System.out.println("回滚事务");
    }

    public void closeSession() {
        System.out.println("关闭session");
    }






}
