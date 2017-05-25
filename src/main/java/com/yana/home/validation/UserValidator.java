package com.yana.home.validation;

import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.service.UserService;
import com.yana.home.utill.ValidationPatterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Admin on 19.05.2017.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
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
if(user.getPhone().length()<13){
    errors.rejectValue("phone","invalid.characters");
}
if(!user.getEmail().matches(ValidationPatterns.EMAIL_PATTERN)){
    errors.rejectValue("email","invalid.wrongEmailFormat");
}
if(userService.findByLogin(user.getLogin())!=null){
    errors.rejectValue("firstName","invalid.alreadyExists");

}
    }
}
