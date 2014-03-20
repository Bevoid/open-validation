package org.bevoid.openvalidation.handler;

import org.bevoid.openvalidation.CheckItem;

/**
 * 
 * @author Bevoid
 * @version $Id: NotNullHandler.java, v 0.1 2014年3月20日 下午2:34:12 Bevoid Exp $
 */
public class NotNullHandler implements AnnotationHandler {

    public boolean check(CheckItem checkItem) {
        return checkItem.getObj() != null;
    }

}
