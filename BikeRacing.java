package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BikeRacing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        BikeRacing__PlayerList list = new BikeRacing__PlayerList();
        while (t-- > 0) {
            BikeRacing__Player pl = new BikeRacing__Player(input.nextLine(), input.nextLine(), input.nextLine());
            list.add(pl);
        }
        list.sort();
        list.show();
        input.close();
    }
}

class BikeRacing__Player {
    private String name;
    private String country;
    private Long time;
    private String id;
    private Long speed;

    public BikeRacing__Player() {
        this.name = "";
        this.country = "";
        this.time = 0l;
        this.id = "";
        this.speed = 0l;
    }

    public BikeRacing__Player(String name, String country, String time) {
        this.id = "";
        this.name = name;
        this.country = country;
        setTime(time);
        setId();
        setSpeed();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(String time) {
        String[] temp = time.trim().split(":");
        this.time = Long.valueOf(temp[0]) * 60 + Long.valueOf(temp[1]);
    }

    public String getId() {
        return id;
    }

    public void setId() {
        String[] tempA = this.country.replaceAll("^[a-z]+|[a-z]+$", "").split("[a-z]+\\s?");
        String[] tempB = this.name.replaceAll("^[a-z]+|[a-z]+$", "").split("[a-z]+\\s?");
        for (String x : tempA) {
            this.id += x;
        }
        for (String x : tempB) {
            this.id += x;
        }
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed = Math.round(120 / ((this.time - 360) / 60.0));
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d Km/h", this.id, this.name, this.country, this.speed);
    }
}

class BikeRacing__PlayerList {
    private ArrayList<BikeRacing__Player> list;

    BikeRacing__PlayerList() {
        this.list = new ArrayList<>();
    }

    protected void add(BikeRacing__Player pl) {
        this.list.add(pl);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<BikeRacing__Player>() {
            public int compare(BikeRacing__Player a, BikeRacing__Player b) {
                return a.getTime() > b.getTime() ? 1 : -1;
            }
        });
    }

    protected void show() {
        for (BikeRacing__Player pl : this.list) {
            System.out.println(pl);
        }
    }
}