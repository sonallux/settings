package jsone_studios.settings;

public interface SettingsProvider
{
    void save();
    String getValue(String key);
    boolean hasValue(String key);
    void put(String key, String value);
}
