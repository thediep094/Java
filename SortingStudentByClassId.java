package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortingStudentByClassId {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        SortingStudentByClassId__StudentList list = new SortingStudentByClassId__StudentList();
        while (n-- > 0) {
            SortingStudentByClassId__Student st = new SortingStudentByClassId__Student(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
            list.add(st);
            st = null;
        }
        list.sort();
        list.show();
        in.close();
    }
}

class SortingStudentByClassId__Student {
    private String id;
    private String name;
    private String classId;
    private String email;

    SortingStudentByClassId__Student() {

    }

    public SortingStudentByClassId__Student(String id, String name, String classId, String email) {
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

class SortingStudentByClassId__StudentList {
    private ArrayList<SortingStudentByClassId__Student> list;

    SortingStudentByClassId__StudentList() {
        this.list = new ArrayList<>();
    }

    protected void add(SortingStudentByClassId__Student st) {
        this.list.add(st);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<SortingStudentByClassId__Student>() {
            public int compare(SortingStudentByClassId__Student a, SortingStudentByClassId__Student b) {
                if (a.getClassId().compareTo(b.getClassId()) == 0) {
                    return a.getId().compareTo(b.getId());
                }
                return a.getClassId().compareTo(b.getClassId());
            }
        });
    }

    protected void show() {
        for (SortingStudentByClassId__Student st : this.list) {
            System.out.println(st);
        }
    }
}
