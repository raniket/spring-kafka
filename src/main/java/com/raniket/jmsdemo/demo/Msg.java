package com.raniket.jmsdemo.demo;

import java.io.Serializable;

public class Msg implements Serializable {
    private String name;
    private Number age;
    private boolean isMarried;

    public Msg() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        isMarried = isMarried;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                '}';
    }

}
