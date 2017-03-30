package com.zhoujian.litepal.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by zhoujian on 2017/3/29.
 */

public class Person extends DataSupport
{
    private String name;

    private int age;

    private int id;

    private String weight;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
