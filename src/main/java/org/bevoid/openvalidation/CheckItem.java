package org.bevoid.openvalidation;

import java.lang.annotation.Annotation;

/**
 * A check item for validation.
 * 
 * @author Bevoid
 * @version $Id: Check.java, v 0.1 2014年3月20日 下午3:56:06 Bevoid Exp $
 */
public class CheckItem {
    private Annotation annotation = null;

    private Object     obj        = null;

    private String     fieldName;

    /**
     * @param clazz Annotation of field.
     * @param obj Value of field.
     * @param fieldName Name of field.
     */
    public CheckItem(Annotation annotation, Object obj, String fieldName) {
        this.annotation = annotation;
        this.obj = obj;
        this.fieldName = fieldName;
    }

    /**
     * Getter method for property <tt>annotation</tt>.
     * 
     * @return property value of annotation
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Setter method for property <tt>annotation</tt>.
     * 
     * @param annotation value to be assigned to property annotation
     */
    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    /**
     * Getter method for property <tt>obj</tt>.
     * 
     * @return property value of obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * Setter method for property <tt>obj</tt>.
     * 
     * @param obj value to be assigned to property obj
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * Getter method for property <tt>fieldName</tt>.
     * 
     * @return property value of fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Setter method for property <tt>fieldName</tt>.
     * 
     * @param fieldName value to be assigned to property fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

}
