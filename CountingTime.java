package javaoop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CountingTime {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        ArrayList<Player> list = new ArrayList<Player>();
        while (t-- > 0) {
            Player pl = new Player();
            pl.id(input.nextLine());
            pl.fullname(input.nextLine());
            pl.inTime(input.nextLine());
            pl.outTime(input.nextLine());
            list.add(pl);
        }
        input.close();
        list.sort(Comparator.comparingLong(Player::getPlayedTime));
        for (Player pl : list) {
            System.out.println(pl);
        }
    }
}

class Player {
    public String id;
    public String fullname;
    public Long inTime;
    public Long outTime;

    Player() {
        this.id = "";
        this.fullname = "";
        this.inTime = 0l;
        this.outTime = 0l;
    }

    protected void id(String id) {
        this.id = id;
    }

    protected void fullname(String name) {
        this.fullname = name;
    }

    protected void inTime(String time) {
        String[] temp = time.split(":");
        this.inTime = Long.valueOf(temp[0]) * 60 + Long.valueOf(temp[1]);
    }

    protected void outTime(String time) {
        String[] temp = time.split(":");
        this.outTime = Long.valueOf(temp[0]) * 60 + Long.valueOf(temp[1]);
    }

    protected long getPlayedTime() {
        return this.outTime - this.inTime;
    }

    protected String countTime() {
        long time = getPlayedTime();
        return (time / 60l) + " gio " + (time % 60l) + " phut";
    }

    @Override
    public String toString() {
        return this.id + "  " + this.fullname + " " + this.countTime();
    }
}