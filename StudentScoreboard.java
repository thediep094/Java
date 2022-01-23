package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentScoreboard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        StudentScoreboard__StudentList list = new StudentScoreboard__StudentList();
        for (int i = 0; i < t; i++) {
            StudentScoreboard__Student temp = new StudentScoreboard__Student();
            temp.setId(i + 1);
            temp.setFullname(input.nextLine());
            Double[] array = new Double[10];
            for (int j = 0; j < 10; j++) {
                array[j] = input.nextDouble();
            }
            temp.setAverageScore(array);
            list.add(temp);
            input.nextLine();
        }
        list.show();
        input.close();
    }
}

class StudentScoreboard__Student {
    private String id;
    private String fullname;
    private Double averageScore;
    private String level;

    StudentScoreboard__Student() {
        this.id = "";
        this.fullname = "";
        this.averageScore = 0.0;
        this.level = "";
    }

    public String getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = "HS" + (id < 10 ? "0" + String.valueOf(id) : String.valueOf(id));
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname.trim();
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double[] scoreArray) {
        Double sum = 0.0;
        for (int i = 0; i < scoreArray.length; i++) {
            if (i == 0 || i == 1) {
                sum += scoreArray[i] * 2;
            } else {
                sum += scoreArray[i];
            }
        }
        this.averageScore = sum / (scoreArray.length + 2);
        this.averageScore = Math.round(this.averageScore * 10.0) / 10.0;
        setLevel();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel() {
        if (this.averageScore < 5) {
            this.level = "YEU";
        } else if (this.averageScore < 7) {
            this.level = "TB";
        } else if (this.averageScore < 8) {
            this.level = "KHA";
        } else if (this.averageScore < 9) {
            this.level = "GIOI";
        } else {
            this.level = "XUAT SAC";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", this.id, this.fullname, this.averageScore, this.level);
    }
}

class StudentScoreboard__StudentList {
    private ArrayList<StudentScoreboard__Student> list;

    StudentScoreboard__StudentList() {
        list = new ArrayList<>();
    }

    public void add(StudentScoreboard__Student student) {
        list.add(student);
    }

    public void sort() {
        Collections.sort(this.list, new Comparator<StudentScoreboard__Student>() {
            public int compare(StudentScoreboard__Student a, StudentScoreboard__Student b) {
                if (a.getAverageScore() != b.getAverageScore()) {
                    return b.getAverageScore() - a.getAverageScore() < 0 ? -1 : 1;
                } else {
                    return a.getFullname().compareTo(b.getFullname());
                }
            }
        });
    }

    public void show() {
        sort();
        for (StudentScoreboard__Student st : this.list) {
            System.out.println(st);
        }
    }
}