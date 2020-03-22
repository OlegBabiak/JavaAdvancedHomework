package HomeWork01_03;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Salary {

    private static Logger LOG = Logger.getLogger(Salary.class);

    public static void main(String[] args) {

        DOMConfigurator.configure("loggerConfig.xml");

        double bonus = calculateBonus(6500, 0.35);
        double salary = calculateSalary(6500.0, 2275, 5725.5);
        double payrollAfterTax = calculatePayrollAfterTax(14500.5, 20000);

        System.out.println("Bonus = " + bonus);
        System.out.println("Salary = " + salary);
        System.out.println("PayrollAfterTax = " + payrollAfterTax);

    }

    public static double calculateBonus(double wage, double bonusPercent) {
        LOG.info("User trying to calculate bonus");
        return wage * bonusPercent;

    }

    public static double calculateSalary(double wage, double calculateBonus, double premium) {
        LOG.warn("User trying to calculate salary");
        return wage + calculateBonus + premium;
    }

    public static double calculatePayrollAfterTax(double calculateSalary, double tax) {
        if (calculateSalary <= tax) {
            String message = String.format("Trying to calculate Payroll After Tax where tax = %.2f," +
                    " is more than salary = %.2f", tax, calculateSalary);
            LOG.error(message);
            throw new IllegalArgumentException("Salary must be greater than tax");
        } else {
            return calculateSalary - tax;
        }
    }
}
