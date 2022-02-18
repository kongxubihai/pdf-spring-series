package com.crab.spring.validation.demo01;

import org.springframework.validation.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/17 18:00
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Address p = (Address) obj;
        if (p.getCode() < 0) {
            e.rejectValue("code", "less than 0");
        } else if (p.getCode() > 100) {
            e.rejectValue("code", "larger than 110 ");
        }
    }

    public static void main(String[] args) {
        Address target = new Address("", -1);
        BindException bindException = new BindException(target, "Address");
        new AddressValidator().validate(target, bindException);
        for (FieldError fieldError : bindException.getBindingResult().getFieldErrors()) {
            System.out.println(fieldError.getField() + " : " + fieldError.getCode());
        }
    }
}
