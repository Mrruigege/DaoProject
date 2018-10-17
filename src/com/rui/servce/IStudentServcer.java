package com.rui.servce;

import com.rui.vo.Student;

import java.util.List;
import java.util.Set;

/**
 * 定义业务层执行标准
 */
public interface IStudentServcer  {
    /**
     * 实现学生的增加操作，需要调用IStudentDao的findById方法查看是否存在，如果不存在，
     * 则调用doCreate方法实现学生的增加
     * @param vo 要增加的学生
     * @return true增加成功，false增加失败
     * @throws Exception 抛出sql异常
     */
    public boolean insert(Student vo) throws Exception;

    /**
     * 实现数据的更新操作，调用IStudentDao中的doUpdate方法
     * @param vo 传入要更新的学生信息
     * @return true更新成功，false更新失败
     * @throws Exception 抛出sql异常
     */
    public boolean update(Student vo) throws Exception;

    /**
     * 实现学生删除的操作，调用IStudentDao中的doRemove方法
     * @param ids 要删除的学生信息集合
     * @return true 删除成功，false 删除失败
     * @throws Exception 抛出sql异常
     */
    public boolean delete(Set<Student> ids) throws Exception;

    /**
     * 通过id查找，调用IStudentDao中的findById方法
     * @param id 传入要查询的id
     * @return 返回要Student
     * @throws Exception 抛出sql异常
     */
    public Student get(int id) throws Exception;

    /**
     * 查找全部学生的信息，通过调用IStudentDao中的findAll方法
     * @return 返回全部学生的信息
     * @throws Exception 抛出sql异常
     */
    public List<Student> list() throws Exception;
}
