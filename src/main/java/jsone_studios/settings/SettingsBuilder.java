package jsone_studios.settings;

import java.util.ArrayList;
import java.util.List;

public class SettingsBuilder implements StepLoggingListener, StepProvider, StepMoreProvider, StepBuild
{
    List<SettingsProvider> providerList;

    private SettingsBuilder()
    {
        providerList = new ArrayList<>();
    }

    public static StepLoggingListener create()
    {
        return new SettingsBuilder();
    }

    @Override
    public StepProvider addLoggingListener(LoggingListener listener)
    {
        LogHandler.setLoggingListener(listener);
        return this;
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
