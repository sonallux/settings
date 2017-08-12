package jsone_studios.settings;

/**
 * Thrown to indicate a failed conversion.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ConversionException extends Exception
{
    public ConversionException()
    {
    }

    public ConversionException(String message)
    {
        super(message);
    }

    public ConversionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ConversionException(Throwable cause)
    {
        super(cause);
    }
}
