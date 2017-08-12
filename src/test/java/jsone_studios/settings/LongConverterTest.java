package jsone_studios.settings;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.LONG_CONVERTER;
import static org.junit.Assert.assertEquals;

public class LongConverterTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testLongFromString() throws ConversionException
    {
        assertEquals(Long.valueOf(Long.MIN_VALUE), LONG_CONVERTER.fromString("-9223372036854775808"));
        assertEquals(Long.valueOf(-99999), LONG_CONVERTER.fromString("-99999"));
        assertEquals(Long.valueOf(-1), LONG_CONVERTER.fromString("-1"));
        assertEquals(Long.valueOf(0), LONG_CONVERTER.fromString("0"));
        assertEquals(Long.valueOf(1), LONG_CONVERTER.fromString("1"));
        assertEquals(Long.valueOf(99999), LONG_CONVERTER.fromString("99999"));
        assertEquals(Long.valueOf(Long.MAX_VALUE), LONG_CONVERTER.fromString("9223372036854775807"));
    }

    @Test
    public void testLongFromStringThrowsException0() throws ConversionException
    {
        exception.expect(ConversionException.class);
        LONG_CONVERTER.fromString("-9999999999999999999");
    }

    @Test
    public void testLongFromStringThrowsException1() throws ConversionException
    {
        exception.expect(ConversionException.class);
        LONG_CONVERTER.fromString("-9223372036854775809");
    }

    @Test
    public void testLongFromStringThrowsException2() throws ConversionException
    {
        exception.expect(ConversionException.class);
        LONG_CONVERTER.fromString("9223372036854775808");
    }

    @Test
    public void testLongFromStringThrowsException3() throws ConversionException
    {
        exception.expect(ConversionException.class);
        LONG_CONVERTER.fromString("9999999999999999999");
    }

    @Test
    public void testLongAsString()
    {
        assertEquals("-9223372036854775808", LONG_CONVERTER.asString(Long.MIN_VALUE));
        assertEquals("-1", LONG_CONVERTER.asString(-1L));
        assertEquals("0", LONG_CONVERTER.asString(0L));
        assertEquals("1", LONG_CONVERTER.asString(1L));
        assertEquals("9223372036854775807", LONG_CONVERTER.asString(Long.MAX_VALUE));
    }
}
