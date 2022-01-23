package javaoop;

import java.util.Scanner;

public class EmployeeClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee emp = new Employee();
        emp.fullname(input.nextLine());
        emp.sex(input.nextLine());
        emp.birthday(input.nextLine());
        emp.address(input.nextLine());
        emp.taxId(input.nextLine());
        emp.agreementDate(input.nextLine());
        System.out.print(emp);
        input.close();
    }
}

class Employee {
    private String id;
    private String fullname;
    private String sex;
    private String birthday;
    private String address;
    private String taxId;
    private String agreementDate;

    Employee() {
        this.id = "00001";
    }

    protected void fullname(String fullname) {
        this.fullname = fullname.trim();
    }

    protected void sex(String sex) {
        this.sex = sex.trim();
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
