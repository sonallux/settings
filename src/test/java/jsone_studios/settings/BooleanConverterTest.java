package jsone_studios.settings;

import org.junit.Test;

import static jsone_studios.settings.Converters.BOOLEAN_CONVERTER;
import static org.junit.Assert.*;

public class BooleanConverterTest {

    @Test
    public void testBooleanFromString() {
        assertTrue(BOOLEAN_CONVERTER.fromString("true"));
        assertTrue(BOOLEAN_CONVERTER.fromString("True"));
        assertTrue(BOOLEAN_CONVERTER.fromString("TRUE"));
        assertTrue(BOOLEAN_CONVERTER.fromString("tRuE"));
        assertTrue(BOOLEAN_CONVERTER.fromString("1"));

        assertFalse(BOOLEAN_CONVERTER.fromString("false"));
        assertFalse(BOOLEAN_CONVERTER.fromString("False"));
        assertFalse(BOOLEAN_CONVERTER.fromString("FALSE"));
        assertFalse(BOOLEAN_CONVERTER.fromString("fAlSe"));
        assertFalse(BOOLEAN_CONVERTER.fromString("0"));

        assertFalse(BOOLEAN_CONVERTER.fromString("asdf"));
        assertFalse(BOOLEAN_CONVERTER.fromString(null));
        assertFalse(BOOLEAN_CONVERTER.fromString(""));
    }

    @Test
    public void testBooleanAsString()
    {
        assertEquals("true", BOOLEAN_CONVERTER.asString(true));
        assertEquals("false", BOOLEAN_CONVERTER.asString(false));
    }

}