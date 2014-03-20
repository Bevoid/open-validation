package org.bevoid.openvalidation.handler;

import java.util.HashMap;
import java.util.Map;

import org.bevoid.openvalidation.CheckItem;

/**
 * 
 * @author Bevoid
 * @version $Id: AnnotationHandlerFinder.java, v 0.1 2014年3月20日 下午4:28:33 Bevoid Exp $
 */
public class AnnotationHandlerFinder {

    private final static String                  ANNOTATION_PACKAGE_PRIFIX = "org.bevoid.openvalidation.handler";

    @SuppressWarnings("rawtypes")
    private static Map<Class, AnnotationHandler> cache                     = new HashMap<Class, AnnotationHandler>();

    /**
     * Find handler for <code>CheckItem</code>.
     * 
     * @param checkItem
     * @return
     */
    public AnnotationHandler findHandler(CheckItem checkItem) {
        String handleClassName = AnnotationHandlerFinder.ANNOTATION_PACKAGE_PRIFIX + "."
                                 + checkItem.getAnnotation().annotationType().getSimpleName()
                                 + "Handler";
        AnnotationHandler annotationHandler = null;
        try {
            @SuppressWarnings("unchecked")
            Class<? extends AnnotationHandler> handleClass = (Class<? extends AnnotationHandler>) Class
                .forName(handleClassName);
            synchronized (cache) {
                if (cache.containsKey(handleClass)) {
                    annotationHandler = cache.get(handleClass);
                } else {
                    annotationHandler = handleClass.newInstance();
                    cache.put(handleClass, annotationHandler);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not find Handle class");
        }
        return annotationHandler;
    }
}
