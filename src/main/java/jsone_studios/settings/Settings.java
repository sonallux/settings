package jsone_studios.settings;

import java.util.ArrayList;
import java.util.List;

public class Settings
{
    private List<SettingsProvider> settingsProviders;

    Settings(SettingsBuilder builder)
    {
        this.settingsProviders = new ArrayList<>(builder.providerList);
    }

    private <T> String getValueAsString(SettingsElement<T> element)
    {
        for (SettingsProvider provider : settingsProviders)
        {
            String value = provider.getValue(element.getKey());
            if (value != null)
            {
                return value;
            }
        }
        return element.asString(element.getDefaultValue());
    }

    public byte getByte(SettingsElement element)
    {
        return Byte.decode(getValueAsString(element));
    }

    public int getInt(SettingsElement element)
    {
        return Integer.parseInt(getValueAsString(element));
    }

    public long getLong(SettingsElement element)
    {
        return Long.parseLong(getValueAsString(element));
    }

    public float getFloat(SettingsElement element)
    {
        return Float.parseFloat(getValueAsString(element));
    }

    public double getDouble(SettingsElement element)
    {
        return Double.parseDouble(getValueAsString(element));
    }

    public boolean getBoolean(SettingsElement element)
    {
        return Boolean.parseBoolean(getValueAsString(element));
    }

    public <T> T get(SettingsElement<T> element)
    {
        return element.parseValue(getValueAsString(element));
    }

    public boolean hasValue(SettingsElement element)
    {
        return settingsProviders.stream().anyMatch(settingsProvider -> settingsProvider.hasValue(element.getKey()));
    }

    public Editor edit()
    {
        return new Editor(this);
    }

    void put(SettingsElement element, String value)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.put(element.getKey(), value));
    }

    void save()
    {
        settingsProviders.forEach(SettingsProvider::save);
    }
}
