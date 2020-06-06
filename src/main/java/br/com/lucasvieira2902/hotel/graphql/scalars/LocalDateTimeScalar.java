package br.com.lucasvieira2902.hotel.graphql.scalars;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeScalar extends GraphQLScalarType {
    public LocalDateTimeScalar() {
        super("LocalDateTime", "Local Date Time Type", new Coercing<LocalDateTime, String>() {
            @Override
            public String serialize(Object result) throws CoercingSerializeException {
                if(result instanceof LocalDateTime){
                    return ((LocalDateTime) result).toString();
                }
                return "";
            }

            @Override
            public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
                if (input instanceof String){
                    return  LocalDateTime.parse((String)input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                }
                return null;
            }

            @Override
            public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                if(!(input instanceof StringValue)) return null;
                return LocalDateTime.parse(((StringValue)input).getValue(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }
        });
    }
}
