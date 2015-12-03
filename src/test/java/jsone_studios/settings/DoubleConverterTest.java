package jsone_studios.settings;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.DOUBLE_CONVERTER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class DoubleConverterTest
{
    private Double[] testDoubles = {
        Double.NaN,
        Double.NEGATIVE_INFINITY,
        Double.MIN_VALUE,
        -999999.999999D,
        -1.23456789D,
        -0.000001D,
        -0D,
        +0D,
        0.000001D,
        1.23456789D,
        999999.999999D,
        Double.MAX_VALUE,
        Double.POSITIVE_INFINITY
    };

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testDoubles()
    {
        for (Double f : testDoubles)
        {
            String DoubleString = DOUBLE_CONVERTER.asString(f);
            assertNotNull(DoubleString);
            assertFalse(DoubleString.length() == 0);
            Double convertedDouble = DOUBLE_CONVERTER.fromString(DoubleString);
            assertEquals(f, convertedDouble, 0);
        }
    }

    @Test
    public void testDoubleOutOfRange()
    {
        assertEquals(Double.NEGATIVE_INFINITY, DOUBLE_CONVERTER.fromString("-1.4e999"), 0);
        assertEquals(Double.POSITIVE_INFINITY, DOUBLE_CONVERTER.fromString("1.4e999"), 0);
    }

    @Test
    public void testDoubleFromStringWithNullString()
    {
        exception.expect(NullPointerException.class);
        DOUBLE_CONVERTER.fromString(null);
    }

    @Test
    public void testDoubleThrowsException0()
    {
        exception.expect(NumberFormatException.class);
        DOUBLE_CONVERTER.fromString("asdf");
    }

    @Test
    public void testDoubleThrowsException1()
    {
        exception.expect(NumberFormatException.class);
        DOUBLE_CONVERTER.fromString("--0.0");
    }

    @Test
    public void testDoubleThrowsException2()
    {
        exception.expect(NumberFormatException.class);
        DOUBLE_CONVERTER.fromString("0.1e");
    }
}
