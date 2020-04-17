package com.galaxy.test;

import com.galaxy.dao.IPersonDao;
import com.galaxy.dao.impl.UserDaoImpl;
import com.galaxy.util.CGLIBProxy;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXML {


    @Test
    public void testXML(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        /*必须要用接口来进行接收：
        * 原因：
        */
        IPersonDao personDao = (IPersonDao) context.getBean("personDao");
        personDao.addPerson();
        System.out.println("--------------");
        personDao.updatePerson();
        System.out.println("--------------");
        personDao.deletePerson();
        System.out.println("--------------");
        personDao.selectPerson();
        System.out.println("--------------");
    }

}
