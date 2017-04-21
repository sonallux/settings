package jsone_studios.settings;

/**
 * This class describes a SettingsElement of the type <code>T</code>
 * @param <T> the type
 */
//TODO: add description what this element is for
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class SettingsElement<T>
{
    private String key;

    SettingsElement(String key)
    {
        this.key = key;
    }

    /**
     * Gets the key of this SettingsElement
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Gets the default value of this SettingsElement
     *
     * @return the default value
     */
    public abstract T getDefaultValue();

    abstract T parseValue(String value);

    abstract String asString(T value);

    /**
     * Creates new SettingsElement of type String.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<String> create(String key, String defaultValue)
    {
        return new StringSettingsElement(key, defaultValue);
    }

    /**
     * Creates new SettingsElement of type Byte.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Byte> create(String key, byte defaultValue)
    {
        return create(key, defaultValue, Converters.BYTE_CONVERTER);
    }

    /**
     * Creates new SettingsElement of type Integer.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Integer> create(String key, int defaultValue)
    {
        return create(key, defaultValue, Converters.INT_CONVERTER);
    }

    /**
     * Creates new SettingsElement of type Long.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Long> create(String key, long defaultValue)
    {
        return create(key, defaultValue, Converters.LONG_CONVERTER);
    }

    /**
     * Creates new SettingsElement of type Float.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Float> create(String key, float defaultValue)
    {
        return create(key, defaultValue, Converters.FLOAT_CONVERTER);
    }

    /**
     * Creates new SettingsElement of type Double.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Double> create(String key, double defaultValue)
    {
        return create(key, defaultValue, Converters.DOUBLE_CONVERTER);
    }

    /**
     * Creates new SettingsElement of type Boolean.
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @return the new SettingsElement
     */
    public static SettingsElement<Boolean> create(String key, boolean defaultValue)
    {
        return create(key, defaultValue, Converters.BOOLEAN_CONVERTER);
    }

    /**
     * Creates new SettingsElement of Type <code>T</code>
     *
     * @param key the key of the new SettingsElement
     * @param defaultValue the default value
     * @param converter a converter to convert from and to string representations of the type <code>T</code>
     * @return the new SettingsElement
     */
    public static <T> SettingsElement<T> create(String key, T defaultValue, Converter<T> converter)
    {
        return new SettingsElementImpl<>(key, defaultValue, converter);
    }
}
