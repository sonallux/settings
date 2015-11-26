import jsone_studios.settings.*;
import jsone_studios.settings.providers.PropertiesProvider;

import java.io.File;
import java.sql.Timestamp;

public class Test
{
    public static void main(String[] args)
    {
        SettingsElement element = SettingsElement.create("key", 13);
        SettingsElement<Timestamp> timestampSettingsElement = SettingsElement.create("time", new Timestamp(System.currentTimeMillis()),
            new Converter<Timestamp>()
            {
                @Override
                public String asString(Timestamp type)
                {
                    return type.toString();
                }

                @Override
                public Timestamp fromString(String s)
                {
                    return Timestamp.valueOf(s);
                }
            });

        Settings settings = SettingsBuilder.create().provider(new PropertiesProvider(new File(""))).build();
        settings.get(element);
    }
}
