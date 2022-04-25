package com.crab.mvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转成Date的转换器 会注入都SpringMVC容器中做类型转换
 *
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 17:43
 */
@Component("dateConverter")
public class DateConverter implements Converter<String, Date> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
