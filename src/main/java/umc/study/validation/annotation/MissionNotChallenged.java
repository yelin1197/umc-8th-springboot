package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MissionNotChallengedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotChallengedValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotChallenged {
    String message() default "이미 이 미션에 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}