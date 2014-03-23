package org.openvalidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openvalidation.handler.AnnotationHandler;
import org.openvalidation.handler.AnnotationHandlerFinder;
import org.openvalidation.util.ReflectUtil;

/**
 * 这是验证的主类，并且希望成为用户使用OpenValidation会用到的直接一个接口，意思是为了完成验证用尽量少的类。 <br/>
 * This the main class for validation and hopefully become the only interface for end user.
 * 
 * @author Bevoid
 * @version $Id: Validate.java, v 0.1 2014年3月19日 下午3:06:46 Bevoid Exp $
 */
public class Validation {

    private final static String ANNOTATION_PACKAGE_NAME = "org.openvalidation.annotation";

    private List<ValidateError> validateError;

    public Validation() {
        validateError = new ArrayList<ValidateError>();
    }

    /**
     * 这个方法是一个入口，通过注解机制验证一个Bean的属性。 <br/>
     * This method is an entrance for validate properties of a bean via <code>Annotation</code>.
     * 
     * @param bean
     */
    public void validateBean(Object bean) {
        List<CheckItem> checkItemList = new ArrayList<CheckItem>();
        try {
            for (Field field : bean.getClass().getDeclaredFields()) {
                for (Annotation annotation : field.getAnnotations()) {
                    if (annotation.annotationType().getName().startsWith(ANNOTATION_PACKAGE_NAME)) {
                        // Access the object through field.
                        boolean flagToGetValueByField = true;
                        Object obj = null;
                        try {
                            obj = field.get(bean);
                        } catch (Exception e) {
                            flagToGetValueByField = false;
                        }
                        if (flagToGetValueByField) {
                            CheckItem checkItem = new CheckItem(annotation, obj, field.getName());
                            checkItemList.add(checkItem);
                        } else { // If failed, access the object through getter method.
                            boolean flagToGetValueByMethod = false;
                            for (Method method : bean.getClass().getDeclaredMethods()) {
                                String getMethodName = ReflectUtil
                                    .getGetMethodName(field.getName());
                                if (method.getGenericParameterTypes().length == 0
                                    && method.getName().equals(getMethodName)) {
                                    try {
                                        CheckItem checkItem = new CheckItem(annotation,
                                            method.invoke(bean), field.getName());
                                        checkItemList.add(checkItem);
                                        flagToGetValueByMethod = true;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            if (!flagToGetValueByMethod) {
                                throw new RuntimeException(
                                    "The annoation @"
                                            + annotation.annotationType().getName()
                                            + " on field "
                                            + field.getName()
                                            + " is not accessible, and not exist a corresponding getter method.");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        handleCheckItemList(checkItemList);
    }

    /**
     * 处理需要检查的属性列表。
     * 
     * @param checkItemList
     */
    private void handleCheckItemList(List<CheckItem> checkItemList) {
        AnnotationHandlerFinder handleFinder = new AnnotationHandlerFinder();
        for (CheckItem checkItem : checkItemList) {
            AnnotationHandler annotationHandler = handleFinder.findHandler(checkItem);
            if (!annotationHandler.check(checkItem)) {
                validateError.add(new ValidateError(checkItem));
            }
        }
    }

    /**
     * Getter method for property <tt>validateError</tt>.
     * 
     * @return property value of validateError
     */
    public List<ValidateError> getValidateError() {
        return validateError;
    }

    /**
     * Setter method for property <tt>validateError</tt>.
     * 
     * @param validateError value to be assigned to property validateError
     */
    public void setValidateError(List<ValidateError> validateError) {
        this.validateError = validateError;
    }

}
