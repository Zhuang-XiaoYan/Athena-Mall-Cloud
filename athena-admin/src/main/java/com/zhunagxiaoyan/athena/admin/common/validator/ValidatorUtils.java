package com.zhunagxiaoyan.athena.admin.common.validator.group;

import com.zhunagxiaoyan.athena.admin.common.exception.AthenaException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @description hibernate-validator校验工具类
 * @date: 2022/7/30 8:54
 * @author: xjl
*/
public class ValidatorUtils {

    private static final Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws AthenaException 校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws AthenaException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new AthenaException(msg.toString());
        }
    }
}
