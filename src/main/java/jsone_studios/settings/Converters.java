package jsone_studios.settings;

/**
 * This utility class implements <code>Converters</code> for primitives.
 */
public class Converters
{
    /**
     * A converter for <code>Byte</code>
     */
    public static final Converter<Byte> BYTE_CONVERTER = new Converter<Byte>()
    {
        @Override
        public String asString(Byte type)
        {
            return String.valueOf(type);
        }

        @Override
        public Byte fromString(String s)
        {
            return Byte.valueOf(s);
        }
    };

    /**
     * A converter for <code>Integer</code>
     */
    public static final Converter<Integer> INT_CONVERTER = new Converter<Integer>()
    {
        @Override
        public String asString(Integer type)
        {
            return String.valueOf(type);
        }

        @Override
        public Integer fromString(String s)
        {
            return Integer.valueOf(s);
        }
    };

    /**
     * A converter for <code>Long</code>
     */
    public static final Converter<Long> LONG_CONVERTER = new Converter<Long>()
    {
        @Override
        public String asString(Long type)
        {
            return String.valueOf(type);
        }

        @Override
        public Long fromString(String s)
        {
            return Long.valueOf(s);
        }
    };

    /**
     * A converter for <code>Float</code>
     */
    public static final Converter<Float> FLOAT_CONVERTER = new Converter<Float>()
    {
        @Override
        public String asString(Float type)
        {
            return String.valueOf(type);
        }

        @Override
        public Float fromString(String s)
        {
            return Float.valueOf(s);
        }
    };

    /**
     * A converter for <code>Double</code>
     */
    public static final Converter<Double> DOUBLE_CONVERTER = new Converter<Double>()
    {
        @Override
        public String asString(Double type)
        {
            return String.valueOf(type);
        }

        @Override
        public Double fromString(String s)
        {
            return Double.valueOf(s);
        }
    };

    /**
     * A converter for <code>Boolean</code>
     */
    public static final Converter<Boolean> BOOLEAN_CONVERTER = new Converter<Boolean>()
    {
        @Override
        public String asString(Boolean type)
        {
            return String.valueOf(type);
        }

        @Override
        public Boolean fromString(String s)
        {
            return s != null && (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1"));
        }
    };
}
