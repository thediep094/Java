package javaoop;

import java.util.Scanner;


public class StudentClass {
    public static void main(String[] args) {
        Student s = new Student();
        Scanner input = new Scanner(System.in);
        s.fullname(input.nextLine());
        s.classId(input.nextLine());
        s.birthday(input.nextLine());
        s.GPA(input.nextFloat());
        System.out.println(s);
        input.close();
    }
}

class Student {
    protected String id;
    protected String fullname;
    protected String classId;
    protected String birthday;
    protected float GPA;

    Student() {
        this.id = "B20DCCN001";
        this.fullname = "";
        this.classId = "";
        this.birthday = "";
        this.GPA = 0;
    }

    protected void id() {

    }

    protected void fullname(String fullname) {
        this.fullname = fullname.trim();
    }

    protected void classId(String classId) {
        this.classId = classId;
    }

    protected void birthday(String birthday) {
        String[] temp = birthday.trim().split("/");
        String day = temp[0].length() == 2 ? temp[0] : "0" + temp[0];
        String month = temp[1].length() == 2 ? temp[1] : "0" + temp[1];
        String year = temp[2];
        this.birthday = day + "/" + month + "/" + year;
    }

    protected void GPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.fullname, this.classId, this.birthday, this.GPA);
    }
}
