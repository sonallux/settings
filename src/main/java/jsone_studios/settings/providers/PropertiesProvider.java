package jsone_studios.settings.providers;

import jsone_studios.settings.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider implements SettingsProvider
{
    private Properties properties;
    private File file;

    public PropertiesProvider(File file)
    {
        this.file = file;
        this.properties = new Properties();
        try
        {
            this.properties.load(new FileInputStream(file));
        }
        catch (IOException e)
        {
            LogHandler.warn("PropertiesProvider", "Failed to load properties: " + e.toString());
        }
    }

    @Override
    public void save()
    {
        try
        {
            this.properties.store(new FileOutputStream(file), null);
        }
        catch (IOException e)
        {
            LogHandler.error("PropertiesProvider", "Failed to save properties", e);
        }
    }

    @Override
    public boolean hasValue(String key)
    {
        return properties.containsKey(key);
    }

    @Override
    public void put(String key, String value)
    {
        this.properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key)
    {
        return properties.getProperty(key, null);
    }
}
