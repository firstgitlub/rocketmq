package org.apache.rocketmq.acl.test;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class AccessiableTest {

    public static void main(String[] args) throws Exception {
        Work work = new Work("tina", 18);
        //获取class对象
        Class<?> clazz = work.getClass();
        //获取当前对象中声明的方法
        Method method = clazz.getDeclaredMethod("workDetails", new Class[]{String.class, int.class});
        //设置所有的成员都可以访问
        method.setAccessible(true);
        System.out.println(method.isAccessible());

        Method setName = clazz.getDeclaredMethod("setName", new Class[]{String.class});
        //设置所有的成员都可以访问
        setName.setAccessible(false);

        System.out.println(setName.isAccessible());

        setName.invoke(work,"test");

        String json = JSON.toJSONString(work);

        Work work1 = JSON.parseObject(json, Work.class);
        System.out.println(work1);

        //        setName.invoke(work,"test");
//        //获取类声明的所有方法
//        Method[] methods = clazz.getDeclaredMethods();
//        //批量设置类的所有方法d都可以被访问
//        AccessibleObject.setAccessible(methods, true);
        System.out.println("ssss");
    }
}