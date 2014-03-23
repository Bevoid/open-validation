package org.openvalidation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Bevoid
 * @version $Id: Max.java, v 0.1 2014年3月20日 下午5:29:23 Bevoid Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Max {
    double value() default Double.MAX_VALUE;
}
