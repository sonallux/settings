package jsone_studios.settings;

/**
 * The SettingsProvider interface describes a way to loading and storing Settings.
 */
public interface SettingsProvider
{
    /**
     * Save the the Settings permanently, e.g. write the Settings to disk
     */
    void save();

    /**
     * Get the String representation of the SettingsElement specified by the given key.
     *
     * @param key the key
     * @return a String representation
     */
    String getValue(String key);

    /**
     * Checks if a SettingsElement is present for the given key
     *
     * @param key the key
     * @return <code>true</code> if a SettingsElement exists for this key, false otherwise
     */
    boolean hasValue(String key);

    /**
     * Add a new entry to the Settings, or updates the existing specified by the key.
     *
     * @param key the key
     * @param value the new string value of this key
     */
    void put(String key, String value);

    /**
     * Delete this entry specified by the key
     *
     * @param key the key
     */
    void delete(String key);
}
