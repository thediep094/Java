package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TheYoungestAndTheOldest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PersonList list = new PersonList();
        while (n-- > 0) {
            Person ps = new Person(in.next(), in.next());
            list.add(ps);
            ps = null;
        }
        list.sort();
        System.out.println(list.getTheYoungest().getName());
        System.out.println(list.getTheOldest().getName());
        in.close();
    }
}

class Person {
    private String name;
    private String birthday;

    Person() {

    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String birthdayToCompare() {
        String[] temp = this.birthday.split("/");
        return temp[2] + temp[1] + temp[0];
    }
}

class PersonList {
    private ArrayList<Person> list;

    PersonList() {
        this.list = new ArrayList<>();
    }

    protected void add(Person ps) {
        this.list.add(ps);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<Person>(){
            public int compare(Person a, Person b) {
                return b.birthdayToCompare().compareTo(a.birthdayToCompare());
            }
        });
    }

    protected Person getTheYoungest() {
        return this.list.get(0);
    }

    protected Person getTheOldest() {
        return this.list.get(this.list.size() - 1);
    }
}