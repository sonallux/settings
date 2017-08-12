package jsone_studios.settings.sample;

import jsone_studios.settings.Settings;
import jsone_studios.settings.SettingsBuilder;
import jsone_studios.settings.SettingsKey;
import jsone_studios.settings.providers.PropertiesProvider;
import jsone_studios.settings.providers.ReadOnlyProvider;

import java.io.File;

public class SettingsSample
{
    public static void main(String[] args)
    {
        File defaultFile = new File(SettingsSample.class.getClassLoader().getResource("test.txt").getFile());
        File testFile = new File(SettingsSample.class.getClassLoader().getResource("default.txt").getFile());

        Settings settings = SettingsBuilder
            .create()
            .provider(new ReadOnlyProvider(new PropertiesProvider(defaultFile)))
            .provider(new PropertiesProvider(testFile))
            .build();

        SettingsKey<String> testTextKey = SettingsKey.create("test_text", "default_text");
        SettingsKey<Integer> numberKey = SettingsKey.create("number", 0);
        SettingsKey<Double> unknownKey = SettingsKey.create("unknown", -1.0);
        SettingsKey<Boolean> defaultKey = SettingsKey.create("default", false);

        String testText = settings.get(testTextKey);
        int number = settings.get(numberKey);
        double unknown = settings.get(unknownKey);
        boolean defaultValue = settings.get(defaultKey);

        System.out.println(testText);
        System.out.println(number);
        System.out.println(unknown);
        System.out.println(defaultValue);

    }
}
