package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@ReadingConverter
public class LocalDateReadConverter implements Converter<Date, LocalDate> {

    @Override
    public LocalDate convert(Date source) {
        return source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
