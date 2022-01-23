package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortingTeacherList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        SortingTeacherList__TeacherList list = new SortingTeacherList__TeacherList();
        for (int i = 0; i < t; i++) {
            SortingTeacherList__Teacher tc = new SortingTeacherList__Teacher(i + 1, in.nextLine(), in.nextLine());
            list.add(tc);
            tc = null;
        }
        list.sort();
        list.show();
        in.close();
    }
}

class SortingTeacherList__Teacher {
    private String id;
    private String name;
    private String apartmentId;

    SortingTeacherList__Teacher() {

    }

    public SortingTeacherList__Teacher(int id, String name, String apartmentId) {
        setId(id);
        setName(name);
        setApartmentId(apartmentId);
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "GV" + (id > 9 ? String.valueOf(id) : "0" + String.valueOf(id));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = "";
        String[] temp = apartmentId.toUpperCase().split("(?<=[A-Z]{1})[A-Z]+\\s?");
        for (String i : temp) {
            this.apartmentId += i;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.apartmentId);
    }

}


class SortingTeacherList__TeacherList {
    private ArrayList<SortingTeacherList__Teacher> list;

    SortingTeacherList__TeacherList() {
        this.list = new ArrayList<>();
    }

    protected void add(SortingTeacherList__Teacher tc) {
        this.list.add(tc);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<SortingTeacherList__Teacher>(){
            public int compare(SortingTeacherList__Teacher a, SortingTeacherList__Teacher b) {
                String[] tempA = a.getName().split("\\s+");
                String[] tempB = b.getName().split("\\s+");
                if (tempA[tempA.length - 1].compareToIgnoreCase(tempB[tempB.length - 1]) == 0) {
                    return a.getId().compareTo(b.getId());
                }
                return tempA[tempA.length - 1].compareToIgnoreCase(tempB[tempB.length - 1]);
            }
        });
    }

    protected void show() {
        for (SortingTeacherList__Teacher tc : this.list) {
            System.out.println(tc);
        } 
    }
}