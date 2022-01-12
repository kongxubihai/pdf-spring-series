package com.crab.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.Period;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 10:55
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativeValue");
        } else if (p.getAge() > 120) {
            e.rejectValue("age", "age过大");
        }
    }
}
