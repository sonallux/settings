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

    void delete(SettingsElement element)
    {
        settingsProviders.forEach(settingsProvider -> settingsProvider.delete(element.getKey()));
    }

    void save()
    {
        settingsProviders.forEach(SettingsProvider::save);
    }
}
