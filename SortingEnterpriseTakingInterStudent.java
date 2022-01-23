package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortingEnterpriseTakingInterStudent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        SortingEnterpriseTakingInterStudent__EnterpriseList list = new SortingEnterpriseTakingInterStudent__EnterpriseList();
        while (t-- > 0) {
            SortingEnterpriseTakingInterStudent__Enterprise temp = new SortingEnterpriseTakingInterStudent__Enterprise(
                    in.nextLine(), in.nextLine(), in.nextShort());
            in.nextLine();
            list.add(temp);
            temp = null;
        }
        list.sort();
        list.show();
        in.close();
    }
}

class SortingEnterpriseTakingInterStudent__Enterprise {
    private String id;
    private String name;
    private short count;

    SortingEnterpriseTakingInterStudent__Enterprise() {

    }

    public SortingEnterpriseTakingInterStudent__Enterprise(String id, String name, short count) {
        this.id = id;
        this.name = name;
        this.count = count;
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

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.count);
    }

}

class SortingEnterpriseTakingInterStudent__EnterpriseList {
    private ArrayList<SortingEnterpriseTakingInterStudent__Enterprise> list;

    public SortingEnterpriseTakingInterStudent__EnterpriseList() {
        this.list = new ArrayList<>();
    }

    protected void add(SortingEnterpriseTakingInterStudent__Enterprise e) {
        this.list.add(e);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<SortingEnterpriseTakingInterStudent__Enterprise>() {
            public int compare(SortingEnterpriseTakingInterStudent__Enterprise a,
                    SortingEnterpriseTakingInterStudent__Enterprise b) {
                if (a.getCount() == b.getCount()) {
                    return a.getId().compareToIgnoreCase(b.getId());
                }
                return b.getCount() - a.getCount();
            }
        });
    }

    protected void show() {
        for (SortingEnterpriseTakingInterStudent__Enterprise e : this.list) {
            System.out.println(e);
        }
    }

}