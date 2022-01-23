package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentClassList2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        ArrayList<Student2> list = new ArrayList<Student2>();
        while (t-- > 0) {
            input.nextLine();
            Student2 s = new Student2();
            s.id(list.size() + 1);
            s.fullname(input.nextLine());
            s.classId(input.nextLine());
            s.birthday(input.nextLine());
            s.GPA(input.nextFloat());
            list.add(s);
        }
        for (Student2 s : list) {
            System.out.println(s);
        }
        input.close();
    }
}

class Student2 {
    protected String id;
    protected String fullname;
    protected String classId;
    protected String birthday;
    protected float GPA;

    Student2() {
        this.id = "";
        this.fullname = "";
        this.classId = "";
        this.birthday = "";
        this.GPA = 0;
    }

    protected void id(int id) {
        this.id = "B20DCCN" + (id < 10 ? "00" + id : "0" + id);
    }

    protected void fullname(String fullname) {
        this.fullname = normalize(fullname.trim());
    }

    static String normalize(String name) {
        name = name.toLowerCase().trim().replaceAll("( )+", " ");
        String[] array_words = name.split(" ");
        String result = "";
        for (String word : array_words) {
            result += word.toUpperCase().charAt(0) + (word.length() > 1 ? word.toLowerCase().substring(1) : "") + " ";
        }
        return result.trim();
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
        return String.format("%s %s %s %s %.2f", this.id, this.fullname, this.classId, this.birthday, this.GPA)
                .toString();
    }
}
