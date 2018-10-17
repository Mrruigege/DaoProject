package com.rui.dao;

import com.rui.vo.Student;

import java.util.List;
import java.util.Set;

public interface  IStudentDao {
    /**
     * 这是实现数据的增加操作
     * @param vo 传入一个vo对象
     * @return 如果返回true，则表示保存成功，如果返回false，则表明保存失败
     * @throws Exception 把问题抛出，让子类解决
     */
    public boolean doCreate(Student vo) throws Exception;

    /**
     * 实现数据的更新操作，根据id进行修改
     * @param vo 传入一个vo对象，包含了要修改的信息，一定要提供id信息
     * @return true保存成功，false保存失败
     * @throws Exception 把问题抛出
     */
    public boolean doUpdate(Student vo) throws Exception;

    /**
     * 批量删除，所有要删除的数据以set的集合传入
     * @param ids 要删除的id，不包含重复的内容
     * @return true删除成功，false删除失败
     * @throws Exception 抛出异常
     */
    public boolean doRemovebatch(Set<Student> ids) throws Exception;

    /**
     * 通过id查找学生信息
     * @param id 要查询学生的id
     * @return 如果存在，则封装为Student对象返回
     * @throws Exception 抛出异常
     */
    public Student findById(Integer id) throws Exception;

    /**
     * 查询所有的学生信息
     * @return 如果存在，则以list集合返回，没有则返回size=0，而不是null
     * @throws Exception 抛出异常
     */
    public List<Student> findAll() throws Exception;

    /**
     * 分页进行模糊查询，以list结合返回
     * @param currentpage 当前所在页
     * @param lineSize 每次显示数据的行数
     * @param column 要进行模糊查询的数据列
     * @param kyeWord 模糊查询的关键字
     * @return 如果存在，则以list集合返回，没有则返回size=0，而不是null
     * @throws Exception 抛出异常
     */
   // public List<Student> findAllSplit(Integer currentpage,Integer lineSize,String column,String kyeWord)throws Exception;

    /**
     * 进行迷糊查询的数据量的统计，如果表中没有，则返回0
     * @param column 迷糊查询的数据列
     * @param keyWord 模糊查询的关键字
     * @return 返回数据量，如果没有则返回0
     * @throws Exception 抛出异常
     */
   // public Integer getCount(String column,String keyWord) throws Exception;
}
