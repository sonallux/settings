package jsone_studios.settings;

public interface Converter<T>
{
    String asString(T type);

    T fromString(String s);
}
