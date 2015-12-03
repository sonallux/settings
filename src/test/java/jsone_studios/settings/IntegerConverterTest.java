package jsone_studios.settings;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.INT_CONVERTER;
import static org.junit.Assert.assertEquals;

public class IntegerConverterTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testIntFromString()
    {
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), INT_CONVERTER.fromString("-2147483648"));
        assertEquals(Integer.valueOf(-999), INT_CONVERTER.fromString("-999"));
        assertEquals(Integer.valueOf(-1), INT_CONVERTER.fromString("-1"));
        assertEquals(Integer.valueOf(0), INT_CONVERTER.fromString("0"));
        assertEquals(Integer.valueOf(1), INT_CONVERTER.fromString("1"));
        assertEquals(Integer.valueOf(999), INT_CONVERTER.fromString("999"));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), INT_CONVERTER.fromString("2147483647"));
    }

    @Test
    public void testIntFromStringThrowsException0()
    {
        exception.expect(NumberFormatException.class);
        INT_CONVERTER.fromString("-3333333333");
    }

    @Test
    public void testIntFromStringThrowsException1()
    {
        exception.expect(NumberFormatException.class);
        INT_CONVERTER.fromString("-2147483649");
    }

    @Test
    public void testIntFromStringThrowsException2()
    {
        exception.expect(NumberFormatException.class);
        INT_CONVERTER.fromString("2147483648");
    }

    @Test
    public void testIntFromStringThrowsException3()
    {
        exception.expect(NumberFormatException.class);
        INT_CONVERTER.fromString("3333333333");
    }

    @Test
    public void testIntAsString()
    {
        assertEquals("-2147483648", INT_CONVERTER.asString(Integer.MIN_VALUE));
        assertEquals("-1", INT_CONVERTER.asString(-1));
        assertEquals("0", INT_CONVERTER.asString(0));
        assertEquals("1", INT_CONVERTER.asString(1));
        assertEquals("2147483647", INT_CONVERTER.asString(Integer.MAX_VALUE));
    }
}
