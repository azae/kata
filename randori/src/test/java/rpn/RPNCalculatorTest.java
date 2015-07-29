package rpn;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RPNCalculatorTest {

    @DataProvider(name = "SimpleProvider")
    public Object[][] messageProvider() {
        return new Object[][]{
                {4.0, "20 5 /"}
                , {10.0, "2 5 *"}
                , {14.0, "2 5 * 4 +"}
                , {4.0, "2 5 * 6 + SQRT"}

        };
    }

    @Test(dataProvider = "SimpleProvider")
    public void testMessageConsumer(double expected, String rpnEntry) throws Exception {
        Assert.assertEquals(RPNCalculatorLambda.compute(rpnEntry), expected);
    }
}
