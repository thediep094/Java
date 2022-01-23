package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Recruitment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        CandidatesList list = new CandidatesList();
        for (int i = 0; i < t; i++) {
            Candidate c = new Candidate();
            c.setId(i + 1);
            c.setName(input.nextLine());
            c.setTheoryScore(input.nextDouble());
            c.setPracticeScore(input.nextDouble());
            c.findAverage();
            input.nextLine();
            list.add(c);
        }
        list.sort();
        list.show();
        input.close();
    }
}

class Candidate {
    private String id;
    private String name;
    private Double theoryScore;
    private Double practiceScore;
    private Double averageScore;
    private String level;

    Candidate() {
        this.id = "";
        this.name = "";
        this.theoryScore = 0.0;
        this.practiceScore = 0.0;
        this.level = "";
        this.averageScore = 0.0;
    }

    public Candidate(String id, String name, Double theoryScore, Double practiceScore) {
        this.id = id;
        this.name = name;
        this.theoryScore = theoryScore;
        this.practiceScore = practiceScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "TS" + (id < 10 ? "0" + String.valueOf(id) : String.valueOf(id));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTheoryScore() {
        return theoryScore;
    }

    public void setTheoryScore(Double theoryScore) {
        this.theoryScore = (theoryScore > 10 ? theoryScore / 10 : theoryScore);
    }

    public Double getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(Double practiceScore) {
        this.practiceScore = (practiceScore > 10 ? practiceScore / 10 : practiceScore);
    }

    public void findAverage() {
        this.averageScore = (this.theoryScore + this.practiceScore) / 2;
        if (this.averageScore < 5) {
            this.level = "TRUOT";
        } else if (this.averageScore < 8) {
            this.level = "CAN NHAC";
        } else if (this.averageScore <= 9.5) {
            this.level = "DAT";
        } else {
            this.level = "XUAT SAC";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", this.id, this.name, this.averageScore, this.level);
    }
}

class CandidatesList {
    private ArrayList<Candidate> list;

    CandidatesList() {
        this.list = new ArrayList<>();
    }

    protected void add(Candidate c) {
        this.list.add(c);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<Candidate>() {
            public int compare(Candidate a, Candidate b) {
                return a.getAverageScore() > b.getAverageScore() ? -1 : 1;
            }
        });
    }

    protected void show() {
        for (Candidate c : this.list) {
            System.out.println(c);
        }
    }
}