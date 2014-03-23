package org.openvalidation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Bevoid
 * @version $Id: Regex.java, v 0.1 2014年3月23日 上午11:47:58 Bevoid Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Regex {
    String value();
}
