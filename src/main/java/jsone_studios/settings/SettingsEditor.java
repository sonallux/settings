package jsone_studios.settings;

/**
 * This handles editing settings.
 */
@SuppressWarnings("unused")
public class SettingsEditor
{
    private Settings settings;

    SettingsEditor(Settings settings)
    {
        this.settings = settings;
    }

    private SettingsEditor putValue(SettingsKey key, String value)
    {
        settings.put(key, value);
        return this;
    }

    /**
     * Adds a new value for this SettingsKey or overrides the current if there is already a value associated with this key.
     *
     * @param key the SettingsKey
     * @param value the new value
     * @param <T> the type of the SettingsKey
     * @return the current SettingsEditor instance to allow chaining of SettingsEditor calls
     */
    public <T> SettingsEditor put(SettingsKey<T> key, T value)
    {
        return putValue(key, key.asString(value));
    }

    /**
     * Resets the SettingsKey to its default value.
     * Note: if no value is specified for this key, the default value will be added.
     *
     * @param key the SettingsKey
     * @param <T> the current SettingsEditor instance to allow chaining of SettingsEditor calls
     */
    public <T> SettingsEditor reset(SettingsKey<T> key)
    {
        return putValue(key, key.asString(key.getDefaultValue()));
    }

    /**
     * Deletes this SettingsKey. Does nothing if there is no value for this SettingsKey.
     *
     * @param key the SettingsKey
     * @return the current SettingsEditor instance to allow chaining of SettingsEditor calls
     */
    public SettingsEditor delete(SettingsKey key)
    {
        this.settings.delete(key);
        return this;
    }

    /**
     * Save the made changes, by this SettingsEditor.
     * It is save to use this SettingsEditor for further changes to this Settings.
     */
    public void save()
    {
        settings.save();
    }
}
