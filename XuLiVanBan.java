package javaoop;

import java.util.Scanner;

public class XuLiVanBan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String documents = "";
        while (in.hasNextLine()) {
            documents += in.nextLine();
        }
        String[] sentences = documents.trim().toLowerCase().split("[.?!]+");
        show(sentences);
        in.close();
    }

    public static void show(String[] arrayString) {
        for (String s : arrayString) {
            s = s.trim().replaceAll("\\s+", " ");
            System.out.println(s.toUpperCase().charAt(0) + s.substring(1));
        }
    }
}
