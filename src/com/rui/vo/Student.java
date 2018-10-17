package com.rui.vo;

import java.io.Serializable;

/**
 * 1.vo里面是简单java类，必须实现Serializable的接口，里面的数据类型不能使用基本数据类型，
 * 因为基本数据类型的默认值是0，封装的数据类型的默认值是null
 * 2.里面的基本属性必须提供setter和getter的方法
 */
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
