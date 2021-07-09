package org.apache.rocketmq.acl.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        listComparatorSort();
    }
    /**
     * 对其他类型泛型的List进行排序，以Student为例。
     */
    public static void listComparatorSort() {
        List<Student> studentList = new ArrayList<Student>();
        List<Integer> list = getDiffNo(4, 1000);

        studentList.add(new Student(list.get(0) + "", "Mike"));
        studentList.add(new Student(list.get(1) + "", "Angela"));
        studentList.add(new Student(list.get(2) + "", "Lucy"));
        studentList.add(new Student(1000 + "", "Beyonce"));
        System.out.println("--------------排序前---------------");
        for (Student student : studentList) {
            System.out.println("学生：" + student.id + ":" + student.name);
        }
        // 实现Comparator<T>接口，设置ID比较方式
        Collections.sort(studentList);
        System.out.println("----------------按照ID排序后------------------");
        for (Student student : studentList) {
            System.out.println("学生：" + student.id + ":" + student.name);
        }

        // 实现Comparator<T>接口，设置特定比较方式，以name比较排序
        Collections.sort(studentList, new StudentComparator());
        System.out.println("----------------按照姓名排序后-----------------");
        for (Student student : studentList) {
            System.out.println("学生：" + student.id + ":" + student.name);
        }
    }


    /**
     * 生成随机不重复的数字 :n生成个数  max生成范围
     */
    public static List<Integer> getDiffNo(int n, int max) {
        // 生成 [0-n] 个不重复的随机数
        // list 用来保存这些随机数
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        Integer k;
        for (int i=0; i<n; i++) {
            do {
                k = random.nextInt(max);
            } while (list.contains(k));
            list.add(k);
        }
        return list;
    }
}
