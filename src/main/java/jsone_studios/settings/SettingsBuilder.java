package jsone_studios.settings;

import java.util.ArrayList;
import java.util.List;

public class SettingsBuilder implements StepProvider, StepMoreProvider, StepBuild
{
    List<SettingsProvider> providerList;

    private SettingsBuilder()
    {
        providerList = new ArrayList<>();
    }

    /**
     * Creates a new SettingsBuilder to build new Settings
     *
     * @return the new SettingsBuilder
     */
    public static StepProvider create()
    {
        return new SettingsBuilder();
    }

    @Override
    public StepMoreProvider provider(SettingsProvider settingsProvider)
    {
        providerList.add(settingsProvider);
        return this;
    }

    @Override
    public Settings build()
    {
        if (providerList == null)
        {
            throw new IllegalStateException("At least one SettingsProvider must be specified");
        }
        return new Settings(this);
    }
}
