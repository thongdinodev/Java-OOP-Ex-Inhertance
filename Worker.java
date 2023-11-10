public class Worker extends Object { // if extends Object (toString()) method will call a hashFunction
    private String name;
    private String birthDate;
    protected String endDate;

    public Worker() {
    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        int currentYear = 2023;
        int birthYear = Integer.parseInt(birthDate.substring(6));
        return currentYear - birthYear;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    // Override toString of Object default method
    public String toString() {
        return "Worker: {" +
                "name = " + name +
                ", birthDate = " + birthDate +
                "}";
    }

}

// Employee, if specific class is "public class", in this case "class"
class Employee extends Worker {
    private long employeId;
    private String hireDate;

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    // Override

    public String toString() {
        return "Worker: {" +
                "Id = " + employeId +
                ", hireDate = " + hireDate;
    }
}

class SaliredEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired;

    public SaliredEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    // override collectPay
    public double collectPay() {

        double paycheck = annualSalary / 26;
        double adjustedPay = (isRetired) ? 0.9 * paycheck : paycheck;
        return (int) adjustedPay;
    }

    public void retire() {
        terminate("12/12/2025");
        isRetired = true;
    }
}