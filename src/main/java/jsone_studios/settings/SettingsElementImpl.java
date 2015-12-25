package jsone_studios.settings;

/**
 * Default implementation of SettingsElement which uses a Converter to convert from and to the stored Strings
 * @param <T> the type of this SettingsElement
 */
class SettingsElementImpl<T> extends SettingsElement<T>
{
    private T defaultValue;
    private Converter<T> converter;

    public SettingsElementImpl(String key, T defaultValue, Converter<T> converter)
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
        return converter.fromString(value);
    }

    @Override
    public String asString(T value)
    {
        return converter.asString(value);
    }
}
