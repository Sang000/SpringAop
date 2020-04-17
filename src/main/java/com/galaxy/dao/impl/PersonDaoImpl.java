package com.galaxy.dao.impl;

import com.galaxy.dao.IPersonDao;

public class PersonDaoImpl implements IPersonDao {

    @Override
    public void addPerson() {
        System.out.println("DAO实现了添加Person的方法");

    }

    @Override
    public void updatePerson() {
        System.out.println("DAO实现了修改Person的方法");

    }

    @Override
    public void deletePerson() {
        System.out.println("DAO实现了删除Person的方法");

    }

    @Override
    public void selectPerson() {
        System.out.println("DAO实现了查询Person的方法");

    }
}
