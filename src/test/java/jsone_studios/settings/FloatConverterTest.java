package jsone_studios.settings;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.FLOAT_CONVERTER;
import static org.junit.Assert.*;

public class FloatConverterTest
{
    private float[] testFloats = {
        Float.NaN,
        Float.NEGATIVE_INFINITY,
        Float.MIN_VALUE,
        -999999.999999f,
        -1.23456789f,
        -0.000001f,
        -0f,
        +0f,
        0.000001f,
        1.23456789f,
        999999.999999f,
        Float.MAX_VALUE,
        Float.POSITIVE_INFINITY
    };

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testFloats() throws ConversionException
    {
        for (float f : testFloats)
        {
            String floatString = FLOAT_CONVERTER.asString(f);
            assertNotNull(floatString);
            assertFalse(floatString.length() == 0);
            float convertedFloat = FLOAT_CONVERTER.fromString(floatString);
            assertEquals(f, convertedFloat, 0);
        }
    }

    @Test
    public void testFloatOutOfRange() throws ConversionException
    {
        assertEquals(Float.NEGATIVE_INFINITY, FLOAT_CONVERTER.fromString("-1.4e99"), 0);
        assertEquals(Float.POSITIVE_INFINITY, FLOAT_CONVERTER.fromString("1.4e99"), 0);
    }

    @Test
    public void testFloatFromStringWithNullString() throws ConversionException
    {
        exception.expect(NullPointerException.class);
        FLOAT_CONVERTER.fromString(null);
    }

    @Test
    public void testFloatThrowsException0() throws ConversionException
    {
        exception.expect(ConversionException.class);
        FLOAT_CONVERTER.fromString("asdf");
    }

    @Test
    public void testFloatThrowsException1() throws ConversionException
    {
        exception.expect(ConversionException.class);
        FLOAT_CONVERTER.fromString("--0.0");
    }

    @Test
    public void testFloatThrowsException2() throws ConversionException
    {
        exception.expect(ConversionException.class);
        FLOAT_CONVERTER.fromString("0.1e");
    }
}
