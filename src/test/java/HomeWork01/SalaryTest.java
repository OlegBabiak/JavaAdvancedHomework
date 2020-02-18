package HomeWork01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple Salary.
 */
public class AppTest {


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
    public void itNadbavka() {
        double actual = salary.nadbavka(6500.0, 0.35);
        double expected = 2275.0;
        Assert.assertEquals(expected, actual, 0.001);

    }

    @Test
    public void itZarplata() {
        double actual = salary.zarplata(6500.0, 2275, 5725.5);
        double expected = 14500.50;
        Assert.assertEquals(expected, actual, 0.001);

    }

    @Test
    public void doVydachi() {
        double realDoVydachi = salary.doVydachi(14500.50, 2610.09);
        double expectedDoVydachi = 11890.41;

        Assert.assertEquals(expectedDoVydachi, realDoVydachi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doVydachiWithExceptionTest() {
        double realDoVydachi = salary.doVydachi(14500.50, 15000.50);
        double expectedDoVydachi = -500.00;

        Assert.assertEquals(expectedDoVydachi, realDoVydachi, 0.001);
    }

}
