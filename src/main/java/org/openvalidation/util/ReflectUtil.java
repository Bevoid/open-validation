package org.openvalidation.util;

/**
 * 
 * @author Bevoid
 * @version $Id: ReflecUtil.java, v 0.1 2014年3月23日 下午12:21:02 Bevoid Exp $
 */
public class ReflectUtil {

    /**
     * Get get method from a field name.</br>
     * For example:</br>
     * <code>getGetMethodName("userName") --> "getUserName"</code></br>
     * <code>getGetMethodName("r") --> "getR"</code></br>
     * <code>getGetMethodName("password") --> "getPassword"</code></br>
     * <code>getGetMethodName("") --> null</code></br>
     * <code>getGetMethodName(null) --> null</code></br>
     * 
     * @param fieldName
     * @return
     */
    public static String getGetMethodName(String fieldName) {
        if (fieldName == null || "".equals(fieldName.trim())) {
            return null;
        } else {
            StringBuffer result = new StringBuffer("get");
            result.append(Character.toUpperCase(fieldName.charAt(0)));
            if (fieldName.length() > 1) {
                result.append(fieldName.substring(1));
            }
            return result.toString();
        }
    }
}
