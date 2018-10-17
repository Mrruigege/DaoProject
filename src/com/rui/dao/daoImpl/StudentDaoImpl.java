package com.rui.dao.daoImpl;

import com.rui.dao.IStudentDao;
import com.rui.vo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 数据层实现类
 */
public class StudentDaoImpl implements IStudentDao {
    private PreparedStatement pst;
    private Connection con;
    public StudentDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public boolean doCreate(Student vo) throws Exception {
        String sql = "insert into student(id,name,age) value(?,?,?)";
        this.pst = con.prepareStatement(sql);
        pst.setInt(1,vo.getId());
        pst.setString(2,vo.getName());
        pst.setInt(3,vo.getAge());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Student vo) throws Exception {
        String sql = "update student set id=? ,name=?, age=? where id=?";
        this.pst = con.prepareStatement(sql);
        pst.setInt(1,vo.getId());
        pst.setString(2,vo.getName());
        pst.setInt(3,vo.getAge());
        pst.setInt(4,vo.getId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean doRemovebatch(Set<Student> ids) throws Exception {
        StringBuffer sql = new StringBuffer("delete from student where id in(");
        if (ids.size() == 0 || ids == null){
            return  false;
        }
        Iterator<Student> iterator = ids.iterator();
        while (iterator.hasNext()){
            sql.append(iterator.next().getId() + ",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        this.pst = con.prepareStatement(sql.toString());
        return pst.executeUpdate() == ids.size();
    }

    @Override
    public Student findById(Integer id) throws Exception {
        Student student = null;
        String sql = "select id,name,age from student where id=?";
        this.pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            //一定要实例化才能设置，不然要报空指向
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
        }
        return student;
    }

    @Override
    public List<Student> findAll() throws Exception {
        List<Student> all = null;
        String sql = "select id,name,age from student";
        this.pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            all = new ArrayList<>();
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            all.add(student);
        }
        return all;
    }
}
