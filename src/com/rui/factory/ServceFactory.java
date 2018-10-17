package com.rui.factory;

import com.rui.servce.IStudentServcer;
import com.rui.servce.servceImpl.StudentServceImpl;

/**
 * 服务层的工厂类
 */
public class ServceFactory {
    public static IStudentServcer getIStudentServceInstanc(){
        return new StudentServceImpl();
    }
}
