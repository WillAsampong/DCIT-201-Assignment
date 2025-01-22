public class CommissionEmployee {
    
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate ) {
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
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
}
