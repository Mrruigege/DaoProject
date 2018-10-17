package com.rui.text;

import com.rui.factory.ServceFactory;
import com.rui.vo.Student;

import java.util.Iterator;
import java.util.List;

public class ServceFactoryText {
    public static void main(String[] args) {
     Student vo = new Student();
     vo.setId(2);
     vo.setName("我");
     vo.setAge(22);
        try {
            List<Student> list = ServceFactory.getIStudentServceInstanc().list();
            Iterator<Student> iterator = list.iterator();
            while (iterator.hasNext()){
                Student student1 = iterator.next();
                System.out.println("name : " + student1.getName() + "age:" + student1.getAge());
            }
           // System.out.println(ServceFactory.getIStudentServceInstanc().list());
            //System.out.println(ServceFactory.getIStudentServceInstanc().update(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
