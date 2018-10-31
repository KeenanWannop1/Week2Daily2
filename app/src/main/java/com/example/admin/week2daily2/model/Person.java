package com.example.admin.week2daily2.model;

public class Person {
    String name;
    String age;
    int id;

    public Person(int i, String name, String age) {
        super();
        this.id = i;
        this.name = name;
        this.age = age;
    }
    public Person(){
        super();
    }
    public Person(String personName, String personAge){
        this.name = personName;
        this.age = personAge;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}

