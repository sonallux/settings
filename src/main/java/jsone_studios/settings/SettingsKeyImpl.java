package jsone_studios.settings;

/**
 * Default implementation of SettingsKey which uses a Converter to convert from and to the stored Strings
 * @param <T> the type of this SettingsKey
 */
class SettingsKeyImpl<T> extends SettingsKey<T>
{
    private T defaultValue;
    private Converter<T> converter;

    SettingsKeyImpl(String key, T defaultValue, Converter<T> converter)
    {
        super(key);
        this.defaultValue = defaultValue;
        this.converter = converter;
    }

    @Override
    public T getDefaultValue()
    {
        return defaultValue;
    }

    @Override
    public T parseValue(String value)
    {
        try
        {
            return converter.fromString(value);
        }
        catch (ConversionException e)
        {
            return defaultValue;
        }
    }

    @Override
    public String asString(T value)
    {
        return converter.asString(value);
    }
}
