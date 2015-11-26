package jsone_studios.settings;

public class Converters
{
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
            return Boolean.valueOf(s);
        }
    };
}
