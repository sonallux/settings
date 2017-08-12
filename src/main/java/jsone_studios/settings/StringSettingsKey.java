package jsone_studios.settings;

/**
 * A simple wrapper for SettingsKey of type String because Strings needn't be converted
 */
class StringSettingsKey extends SettingsKey<String>
{
    private String defaultValue;

    StringSettingsKey(String key, String defaultValue)
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
