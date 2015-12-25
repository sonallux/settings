package jsone_studios.settings;

/**
 * A simple wrapper for SettingsElements of type String because Strings needn't be converted
 */
class StringSettingsElement extends SettingsElement<String>
{
    private String defaultValue;

    public StringSettingsElement(String key, String defaultValue)
    {
        super(key);
        this.defaultValue = defaultValue;
    }

    @Override
    public String getDefaultValue()
    {
        return defaultValue;
    }

    @Override
    protected String asString(String value)
    {
        return value;
    }

    @Override
    protected String parseValue(String value)
    {
        return value;
    }
}
