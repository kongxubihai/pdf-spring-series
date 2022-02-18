package com.crab.spring.validation.demo01;

import lombok.Data;
import org.springframework.validation.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/17 18:10
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Data
public class CustomerNestedValidator implements Validator {

    private AddressValidator addressValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required");
        Customer customer = (Customer) target;
        try {
            errors.pushNestedPath("address");
            // 嵌套调用validator
            ValidationUtils.invokeValidator(addressValidator, customer.getAddress(), errors);
        } finally {
            errors.popNestedPath();
        }
    }

    public static void main(String[] args) {
        Address address = new Address("", -1);
        Customer customer = new Customer("", "", address);
        BindException bindException = new BindException(customer, "customer");

        AddressValidator addressValidator = new AddressValidator();
        CustomerNestedValidator customerNestedValidator = new CustomerNestedValidator();
        customerNestedValidator.setAddressValidator(addressValidator);

        customerNestedValidator.validate(customer, bindException);

        for (FieldError fieldError : bindException.getBindingResult().getFieldErrors()) {
            System.out.println(fieldError.getField() + " : " + fieldError.getCode());
        }
    }


}
