package jsone_studios.settings;

public abstract class SettingsElement<T>
{
    private String key;

    SettingsElement(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    public abstract T getDefaultValue();

    abstract T parseValue(String value);

    abstract String asString(T value);

    public static SettingsElement<String> create(String key, String defaultValue)
    {
        return new StringSettingsElement(key, defaultValue);
    }

    public static SettingsElement<Byte> create(String key, byte defaultValue)
    {
        return create(key, defaultValue, Converters.BYTE_CONVERTER);
    }

    public static SettingsElement<Integer> create(String key, int defaultValue)
    {
        return create(key, defaultValue, Converters.INT_CONVERTER);
    }

    public static SettingsElement<Long> create(String key, long defaultValue)
    {
        return create(key, defaultValue, Converters.LONG_CONVERTER);
    }

    public static SettingsElement<Float> create(String key, float defaultValue)
    {
        return create(key, defaultValue, Converters.FLOAT_CONVERTER);
    }

    public static SettingsElement<Double> create(String key, double defaultValue)
    {
        return create(key, defaultValue, Converters.DOUBLE_CONVERTER);
    }

    public static SettingsElement<Boolean> create(String key, boolean defaultValue)
    {
        return create(key, defaultValue, Converters.BOOLEAN_CONVERTER);
    }

    public static <T> SettingsElement<T> create(String key, T defaultValue, Converter<T> converter)
    {
        return new SettingsElementImpl<>(key, defaultValue, converter);
    }
}
