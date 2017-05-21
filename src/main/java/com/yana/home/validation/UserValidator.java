package com.yana.home.validation;

import com.yana.home.persistence.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Admin on 19.05.2017.
 */
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user=(User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","invalid.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"secondName","invalid.secondName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","invalid.phone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","invalid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","invalid.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","invalid.email");


    }
}
