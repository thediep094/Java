package javaoop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeClassListSorted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        ArrayList<Employee2> list = new ArrayList<Employee2>();
        while (t-- > 0) {
            Employee2 emp = new Employee2();
            emp.id(list.size() + 1);
            emp.fullname(input.nextLine());
            emp.sex(input.nextLine());
            emp.birthday(input.nextLine());
            emp.address(input.nextLine());
            emp.taxId(input.nextLine());
            emp.agreementDate(input.nextLine());
            list.add(emp);
        }
        list.sort(Comparator.comparing(Employee2::birthday));
        for (Employee2 emp : list) {
            System.out.println(emp);
        }
        input.close();
    }
}

class Employee2 {
    private String id;
    private String fullname;
    private String sex;
    private String birthday;
    private String address;
    private String taxId;
    private String agreementDate;

    Employee2() {
        this.id = "";
        this.fullname = "";
        this.birthday = "";
        this.sex = "";
        this.address = "";
        this.taxId = "";
        this.agreementDate = "";
    }

    protected void id(int id) {
        this.id = "00" + (id < 10 ? "00" + id : "0" + id);
    }

    protected void fullname(String fullname) {
        this.fullname = fullname.trim();
    }

    protected void sex(String sex) {
        this.sex = sex.trim();
    }

    protected String birthday() {
        String[] temp = this.birthday.split("/");
        return temp[2] + temp[0] + temp[1];
    }

    protected void birthday(String birthday) {
        this.birthday = birthday.trim();
    }

    protected void address(String address) {
        this.address = address.trim();
    }

    protected void taxId(String taxId) {
        this.taxId = taxId.trim();
    }

    protected void agreementDate(String agreementDate) {
        this.agreementDate = agreementDate.trim();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", this.id, this.fullname, this.sex, this.birthday, this.address,
                this.taxId, this.agreementDate);
    }
}
