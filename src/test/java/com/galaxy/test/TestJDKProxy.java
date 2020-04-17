package com.galaxy.test;

import com.galaxy.dao.IPersonDao;
import com.galaxy.dao.impl.PersonDaoImpl;
import com.galaxy.util.JDKProxy;
import org.junit.Test;

public class TestJDKProxy {


    @Test
    public void testJdkProxy(){
        JDKProxy proxy = new JDKProxy();
        IPersonDao personDao = (IPersonDao) proxy.createNewObject(new PersonDaoImpl());
        personDao.addPerson();
    }

}
