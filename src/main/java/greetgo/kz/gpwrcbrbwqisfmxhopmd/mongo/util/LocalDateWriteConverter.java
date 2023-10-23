package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateWriteConverter implements Converter<LocalDate, Date> {

    @Override
    public Date convert(LocalDate source) {
        return Date.from(source.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
