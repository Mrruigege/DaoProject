package com.rui.servce.servceImpl;

import com.rui.Jdb.DatabaseConnection;
import com.rui.factory.DaoFactory;
import com.rui.servce.IStudentServcer;
import com.rui.vo.Student;

import java.util.List;
import java.util.Set;

/**
 * IStudentServcer的实现了类
 */
public class StudentServceImpl implements IStudentServcer {
    //在这个类的内部提供了数据库连接的实例化对象
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Student vo) throws Exception {
        try {
            //判断要增加的学生id是否存在
            if(DaoFactory.getIStudentDaoinstance(dbc.getConnection()).findById(vo.getId()) == null) {
                return DaoFactory.getIStudentDaoinstance(dbc.getConnection()).doCreate(vo);
            }else{
                return false;
            }
        }catch (Exception e){
            throw  e;
        }finally {
            dbc.close();
        }
    }

    @Override
    public boolean update(Student vo) throws Exception {
        try {
           return DaoFactory.getIStudentDaoinstance(dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            throw  e;
        }finally {
            dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Student> ids) throws Exception {
        try {
           return DaoFactory.getIStudentDaoinstance(dbc.getConnection()).doRemovebatch(ids);
        }catch (Exception e){
            throw  e;
        }finally {
            dbc.close();
        }
    }

    @Override
    public Student get(int id) throws Exception {
        try {
           return DaoFactory.getIStudentDaoinstance(dbc.getConnection()).findById(id);
        }catch (Exception e){
            throw  e;
        }finally {
            dbc.close();
        }
    }

    @Override
    public List<Student> list() throws Exception {
        try {
            return DaoFactory.getIStudentDaoinstance(dbc.getConnection()).findAll();
        }catch (Exception e){
            throw  e;
        }finally {
            dbc.close();
        }
    }
}
