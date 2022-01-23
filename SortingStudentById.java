package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortingStudentById {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SortingStudentById__StudentList list = new SortingStudentById__StudentList();
        while (in.hasNextLine()) {
            SortingStudentById__Student st = new SortingStudentById__Student(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
            list.add(st);
            st = null;
        }
        list.sort();
        list.show();
        in.close();
    }
}

class SortingStudentById__Student {
    private String id;
    private String name;
    private String classId;
    private String email;

    SortingStudentById__Student() {

    }

    public SortingStudentById__Student(String id, String name, String classId, String email) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.classId, this.email);
    }
}

class SortingStudentById__StudentList {
    private ArrayList<SortingStudentById__Student> list;

    SortingStudentById__StudentList() {
        this.list = new ArrayList<>();
    }

    protected void add(SortingStudentById__Student st) {
        this.list.add(st);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<SortingStudentById__Student>() {
            public int compare(SortingStudentById__Student a, SortingStudentById__Student b) {
                return a.getId().compareTo(b.getId());
            }
        });
    }

    protected void show() {
        for (SortingStudentById__Student st : this.list) {
            System.out.println(st);
        }
    }
}
