package jsone_studios.settings;

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

    public <T> Editor put(SettingsElement<T> element, T value)
    {
        return putValue(element, element.asString(value));
    }

    public <T> Editor reset(SettingsElement<T> element)
    {
        return putValue(element, element.asString(element.getDefaultValue()));
    }

    public Editor delete(SettingsElement element)
    {
        this.settings.delete(element);
        return this;
    }

    public void save()
    {
        settings.save();
    }
}
