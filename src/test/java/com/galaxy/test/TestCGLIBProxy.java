package com.galaxy.test;

import com.galaxy.dao.impl.UserDaoImpl;
import com.galaxy.util.CGLIBProxy;
import org.junit.Test;

public class TestCGLIBProxy {


    @Test
    public void testCGLIBProxy(){
        CGLIBProxy proxy = new CGLIBProxy();
        UserDaoImpl userDao = (UserDaoImpl) proxy.createNewObject(new UserDaoImpl());
        userDao.addUser();
    }

}
