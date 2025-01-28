// ENCAPSULATION

public class CommissionEmployee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setCommissionRate(commissionRate);
        setGrossSales(grossSales);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales >= 0.0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("grossSales cannot be negative.");
        }
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0.0 && commissionRate <= 1.0) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("commissionRate must be between 0.0 and 1.0.");
        }
    }

    public double earnings() {
        return grossSales * commissionRate;
    }

    public String toString() {
        return String.format("CommissionEmployee: %s %s%nSSN: %s%nGross Sales: %.2f%nCommission Rate: %.2f",
                firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
    }

    public static void main(String[] args) {
        CommissionEmployee employee1 = new CommissionEmployee("Godswill", "Asampong", "237482384", 230.67, 0.5);
        try {
            System.out.println(employee1);
            System.out.println("Earnings: " + employee1.earnings());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}

// INHERITANCE
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        if (baseSalary >= 0.0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double BaseSalary) {
        if (BaseSalary >= 0) {
            this.baseSalary = BaseSalary;
        } else {
            throw new IllegalArgumentException("baseSalary cannot be negative");
        }
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    public static void main(String[] args) {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Godswill", "Asampong", "540937457304", 530.34, 0.2, 1200);
        try {
            System.out.println(employee);
            System.out.println("Base Salary:" + employee.earnings());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}