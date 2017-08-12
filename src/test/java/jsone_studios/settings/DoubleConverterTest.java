package jsone_studios.settings;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.DOUBLE_CONVERTER;
import static org.junit.Assert.*;

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
    public void testDoubles() throws ConversionException
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
    public void testDoubleOutOfRange() throws ConversionException
    {
        assertEquals(Double.NEGATIVE_INFINITY, DOUBLE_CONVERTER.fromString("-1.4e999"), 0);
        assertEquals(Double.POSITIVE_INFINITY, DOUBLE_CONVERTER.fromString("1.4e999"), 0);
    }

    @Test
    public void testDoubleFromStringWithNullString() throws ConversionException
    {
        exception.expect(ConversionException.class);
        DOUBLE_CONVERTER.fromString(null);
    }

    @Test
    public void testDoubleThrowsException0() throws ConversionException
    {
        exception.expect(ConversionException.class);
        DOUBLE_CONVERTER.fromString("asdf");
    }

    @Test
    public void testDoubleThrowsException1() throws ConversionException
    {
        exception.expect(ConversionException.class);
        DOUBLE_CONVERTER.fromString("--0.0");
    }

    @Test
    public void testDoubleThrowsException2() throws ConversionException
    {
        exception.expect(ConversionException.class);
        DOUBLE_CONVERTER.fromString("0.1e");
    }
}
