package HomeWork01;

public class Salary {

    public double calculateBonus(double wage, double bonusPercent) {
        return wage * bonusPercent;
    }

    public double calculateSalary(double wage, double calculateBonus, double premium) {
        return wage + calculateBonus + premium;
    }

    public double calculatePayrollAfterTax(double calculateSalary, double tax) {
        if (calculateSalary <= tax)
            throw new IllegalArgumentException("Salary must be greater than tax");

        return calculateSalary - tax;
    }
}
