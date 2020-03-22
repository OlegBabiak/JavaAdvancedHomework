package HomeWork01_03;

import org.junit.*;
import org.junit.rules.TestWatcher;

/**
 * Unit test for simple Salary.
 */
public class SalaryTest {

    private Salary salary;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        protected void failed(Throwable e, org.junit.runner.Description description) {
            System.out.println("FAILED: " + description.getMethodName());
        }

        protected void succeeded(org.junit.runner.Description description) {
            System.out.println("SUCCEED: " + description.getMethodName());
        }
    };

    @Before
    public void beforeTest() {
        salary = new Salary();
    }

    @After
    public void afterTest() {
        salary = null;
    }

    @Test
    public void itCalculatesBonus() {
        double actual = salary.calculateBonus(6500.0, 0.35);
        double expected = 2275.0;
        Assert.assertEquals(expected, actual, 0.001);

    }

    @Test
    public void itCalculatesSalary() {
        double actual = salary.calculateSalary(6500.0, 2275, 5725.5);
        double expected = 14500.50;
        Assert.assertEquals(expected, actual, 0.001);

    }

    @Test
    public void itCalculatesPayrollAfterTax() {
        double realCalculatePayrollAfterTax = salary.calculatePayrollAfterTax
                (14500.50, 2610.09);
        double expectedCalculatePayrollAfterTax = 11890.41;

        Assert.assertEquals(expectedCalculatePayrollAfterTax, realCalculatePayrollAfterTax, 0.001);
    }
}
