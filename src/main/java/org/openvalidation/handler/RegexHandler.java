package org.openvalidation.handler;

import java.util.regex.PatternSyntaxException;

import org.openvalidation.CheckItem;
import org.openvalidation.annotation.Regex;

/**
 * 
 * @author Bevoid
 * @version $Id: RegexHandler.java, v 0.1 2014年3月23日 上午11:51:59 Bevoid Exp $
 */
public class RegexHandler implements AnnotationHandler {

    /** 
     * If the regular expression is empty, the handler will return true. <br/>
     * If the object is not a <code>String</code> object, will return false.
     * 
     * @see org.openvalidation.handler.AnnotationHandler#check(org.openvalidation.CheckItem)
     */
    public boolean check(CheckItem checkItem) {
        Regex regex = (Regex) checkItem.getAnnotation();
        if (regex.value() == null || "".equals(regex.value().trim())) {
            return true;
        }
        if (!String.class.isInstance(checkItem.getObj())) {
            return false;
        }
        String target = (String) checkItem.getObj();
        boolean result = false;
        try {
            result = target.matches(regex.value());
        } catch (PatternSyntaxException e) {
            return false;
        }
        return result;
    }
}
