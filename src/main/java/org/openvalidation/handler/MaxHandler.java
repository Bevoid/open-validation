package org.openvalidation.handler;

import org.openvalidation.CheckItem;
import org.openvalidation.annotation.Max;

/**
 * 
 * @author Bevoid
 * @version $Id: MaxHandler.java, v 0.1 2014年3月20日 下午5:31:21 Bevoid Exp $
 */
public class MaxHandler implements AnnotationHandler {

    /** 
     * @see org.openvalidation.handler.AnnotationHandler#check(org.openvalidation.CheckItem)
     */
    public boolean check(CheckItem checkItem) {
        try {
            Max max = (Max) checkItem.getAnnotation();
            double maxValue = max.value();
            if (checkItem.getObj() == null) {
                return false;
            }
            return Double.parseDouble(checkItem.getObj().toString()) < maxValue;
        } catch (NumberFormatException e) {
            throw new RuntimeException("类型检查不符合。");
        }
    }
}
