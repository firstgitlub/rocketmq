package org.apache.rocketmq.acl.test;

import java.lang.reflect.Field;

public class Reflect {

    public static void main(String[] args) throws Exception {

        Student stu = new Student();
        stu.setName("gzq");
        stu.setNickname("jiu ge");
        stu.setNo("100901016");

        System.setProperty("rocket.mq.name","rocket");

        System.out.println(System.getProperty("rocket.mq.name"));

        Field field = stu.getClass().getDeclaredField("name");

        field.set(stu, "九哥");//这里是执行不成功的
        System.out.println(field.isAccessible());
        field.setAccessible(true);//设置过以后
        field.set(stu, "九哥");//这里是可以操作private属性的
        System.out.println("field.get(stu):"+field.get(stu));

        Field field1 = stu.getClass().getField("name");
    }

}
