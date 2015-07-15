package cc.aznc.utdojo.kata_1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class PersonTest
{

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getPayWillReturnSameValueInConstruct() throws Exception
    {
        int expectPay = 3;

        Person person = new Person(expectPay);

        assertEquals("value of pay should equal to value to constructor", expectPay, person.getPay());
    }

    @Test
    public void shouldCheckNegativePay() throws Exception
    {
        int invalidPay = -3;

        exception.expect(InvalidParameterException.class);
        Person person = new Person(invalidPay);
    }
}