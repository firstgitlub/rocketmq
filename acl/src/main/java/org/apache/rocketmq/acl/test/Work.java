package org.apache.rocketmq.acl.test;

public class Work {

    private String name;
    private int age;
    public Work() {

    }
    public Work(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String workDetails(String name, int age) {
        return name+"--"+age;
    }
}