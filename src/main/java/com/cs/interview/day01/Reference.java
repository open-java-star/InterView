package com.cs.interview.day01;

/**
 * @author Star.Cs
 * @data 22/11/02 21:49
 */
public class Reference {

    static ThreadLocal<Person> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.set(new Person("cs"));
            t1.set(new Person("cs1"));
            System.out.println(t1.get().name);

        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t1.get());
        }).start();
    }


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
