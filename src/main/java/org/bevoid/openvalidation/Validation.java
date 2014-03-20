package org.bevoid.openvalidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.bevoid.openvalidation.handler.AnnotationHandler;
import org.bevoid.openvalidation.handler.AnnotationHandlerFinder;

/**
 * 这是验证的主类，并且希望成为用户使用OpenValidation会用到的直接一个接口，意思是为了完成验证用尽量少的类。 <br/>
 * This the main class for validation and hopefully become the only interface for end user.
 * 
 * @author Bevoid
 * @version $Id: Validate.java, v 0.1 2014年3月19日 下午3:06:46 Bevoid Exp $
 */
public class Validation {

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
                    if (annotation.annotationType().getName()
                        .startsWith("org.bevoid.openvalidation.annotation")) {
                        CheckItem checkItem = new CheckItem(annotation, field.get(bean),
                            field.getName());
                        checkItemList.add(checkItem);
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
