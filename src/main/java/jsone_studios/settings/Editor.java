package jsone_studios.settings;

/**
 * This handles editing settings.
 */
@SuppressWarnings("unused")
public class Editor
{
    private Settings settings;

    Editor(Settings settings)
    {
        this.settings = settings;
    }

    private Editor putValue(SettingsElement element, String value)
    {
        settings.put(element, value);
        return this;
    }

    /**
     * Adds a new value for this SettingsElement or overrides the current if there is already a value associated with this key.
     *
     * @param element the SettingsElement
     * @param value the new value
     * @param <T> the type of the SettingsElement
     * @return the current Editor instance to allow chaining of Editor calls
     */
    public <T> Editor put(SettingsElement<T> element, T value)
    {
        return putValue(element, element.asString(value));
    }

    /**
     * Resets the SettingsElement to its default value.
     * Note: if no value is specified for this element, the default value will be added.
     *
     * @param element the SettingsElement
     * @param <T> the current Editor instance to allow chaining of Editor calls
     */
    public <T> Editor reset(SettingsElement<T> element)
    {
        return putValue(element, element.asString(element.getDefaultValue()));
    }

    /**
     * Deletes this SettingsElement. Does nothing if there is no value for this SettingsElement.
     *
     * @param element the SettingsElement
     * @return the current Editor instance to allow chaining of Editor calls
     */
    public Editor delete(SettingsElement element)
    {
        this.settings.delete(element);
        return this;
    }

    /**
     * Save the made changes, by this Editor.
     * It is save to use this Editor for further changes to this Settings.
     */
    public void save()
    {
        settings.save();
    }
}
