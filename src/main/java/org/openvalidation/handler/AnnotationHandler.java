package org.openvalidation.handler;

import org.openvalidation.CheckItem;

/**
 * 
 * @author Bevoid
 * @version $Id: AnnotationHandler.java, v 0.1 2014年3月20日 下午2:32:47 Bevoid Exp $
 */
public interface AnnotationHandler {

    /**
     * 验证<code>CheckItem</code>是否符合条件。
     * 
     * @return
     */
    public abstract boolean check(CheckItem checkItem);

}
