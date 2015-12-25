package jsone_studios.settings.providers;

import jsone_studios.settings.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A SettingsProvider which handles settings stored in .properties files.
 */
public class PropertiesProvider implements SettingsProvider
{
    private Properties properties;
    private File file;

    /**
     * Constructs a new PropertiesProvider which uses the given file for storing and saving the settings.
     * @param file the file to load and save settings to
     */
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
    public void delete(String key)
    {
        this.properties.remove(key);
    }

    @Override
    public String getValue(String key)
    {
        return properties.getProperty(key, null);
    }
}
