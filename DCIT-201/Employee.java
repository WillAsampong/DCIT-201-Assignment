abstract public class Employee {
    private String name;
    private String employeeId;

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract double calculatePay();

    @Override
    public String toString() {
        return "Employee Name: " + name + ", Employee ID: " + employeeId;
    }

    public static void main(String[] args) {
        Employee employee1 = new FullTimeEmployee("Asampong Godswill", "5748", 10000.00);

        System.out.println(employee1);
    }

}

class FullTimeEmployee extends Employee {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public FullTimeEmployee(String name, String employeeId, double salary){
        super(name, employeeId);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: $" + salary;
    }


}
