package jsone_studios.settings;

/**
 * A simple interface to handle converting from and to Strings.
 *
 * @param <T> the type the String to convert to and from
 */
public interface Converter<T>
{
    /**
     * Converts the given object of <code>T</code> to a String
     *
     * @param type the object of type <code>T</code> to convert
     * @return type as string
     */
    String asString(T type);

    /**
     * Converts the given string to <code>T</code>
     *
     * @param s the String to convert
     * @return the converted element of type <code>T</code>
     * @throws ConversionException if the given string could not be passe to <code>T</code>
     */
    T fromString(String s) throws ConversionException;
}
