package jsone_studios.settings;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jsone_studios.settings.Converters.BYTE_CONVERTER;
import static org.junit.Assert.assertEquals;

public class ByteConverterTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testByteFromString()
    {
        assertEquals(Byte.valueOf(Byte.MIN_VALUE), BYTE_CONVERTER.fromString("-128"));
        assertEquals(Byte.valueOf((byte)-100), BYTE_CONVERTER.fromString("-100"));
        assertEquals(Byte.valueOf((byte)-1), BYTE_CONVERTER.fromString("-1"));
        assertEquals(Byte.valueOf((byte)0), BYTE_CONVERTER.fromString("0"));
        assertEquals(Byte.valueOf((byte)1), BYTE_CONVERTER.fromString("1"));
        assertEquals(Byte.valueOf((byte)100), BYTE_CONVERTER.fromString("100"));
        assertEquals(Byte.valueOf(Byte.MAX_VALUE), BYTE_CONVERTER.fromString("127"));
    }

    @Test
    public void testByteFromStringThrowsException()
    {
        exception.expect(NumberFormatException.class);
        BYTE_CONVERTER.fromString("-500");
    }

    @Test
    public void testByteFromStringThrowsException1()
    {
        exception.expect(NumberFormatException.class);
        BYTE_CONVERTER.fromString("-129");
    }

    @Test
    public void testByteFromStringThrowsException2()
    {
        exception.expect(NumberFormatException.class);
        BYTE_CONVERTER.fromString("128");
    }

    @Test
    public void testByteFromStringThrowsException3()
    {
        exception.expect(NumberFormatException.class);
        BYTE_CONVERTER.fromString("500");
    }

    @Test
    public void testByteAsString()
    {
        assertEquals("-128", BYTE_CONVERTER.asString(Byte.MIN_VALUE));
        assertEquals("-1", BYTE_CONVERTER.asString((byte) -1));
        assertEquals("0", BYTE_CONVERTER.asString((byte) 0));
        assertEquals("1", BYTE_CONVERTER.asString((byte) 1));
        assertEquals("127", BYTE_CONVERTER.asString(Byte.MAX_VALUE));
    }
}
