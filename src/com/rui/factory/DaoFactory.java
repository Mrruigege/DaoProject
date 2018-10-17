package com.rui.factory;

import com.rui.dao.IStudentDao;
import com.rui.dao.daoImpl.StudentDaoImpl;

import java.sql.Connection;

/**
 * 用工厂类实现接口子类，让不同业务层之间能够调用
 */
public class DaoFactory {
    public static IStudentDao getIStudentDaoinstance(Connection con){
        return new StudentDaoImpl(con);
    }
}
