package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Amount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        BillList list = new BillList();
        while (t-- > 0) {
            Bill bill = new Bill();
            bill.setId(input.nextLine());
            bill.setName(input.nextLine());
            bill.setQuantity(input.nextInt());
            bill.setPrice(input.nextLong());
            bill.setDiscount(input.nextLong());
            bill.setTotalAmount();
            list.add(bill);
            input.nextLine();
        }
        list.sort();
        list.show();
        input.close();
    }
}

class Bill {
    private String id;
    private String name;
    private Integer quantity;
    private Long price;
    private Long discount;
    private Long totalAmount;

    Bill() {
        this.id = "";
        this.name = "";
        this.quantity = 0;
        this.price = 0l;
        this.discount = 0l;
        this.totalAmount = 0l;
    }

    public Bill(String id, String name, Integer quantity, Long price, Long discount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount() {
        this.totalAmount = this.price * this.quantity - this.discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.quantity, this.price, this.discount,
                this.totalAmount);
    }
}

class BillList {
    private final ArrayList<Bill> list;

    BillList() {
        this.list = new ArrayList<>();
    }

    protected void add(Bill bill) {
        this.list.add(bill);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<Bill>() {
            public int compare(Bill a, Bill b) {
                return a.getTotalAmount() > b.getTotalAmount() ? -1 : 1;
            }
        });
    }

    protected void show() {
        for (Bill bill : this.list) {
            System.out.println(bill);
        }
    }
}