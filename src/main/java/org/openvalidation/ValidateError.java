package org.openvalidation;

/**
 * 
 * @author Bevoid
 * @version $Id: ValidateError.java, v 0.1 2014年3月20日 下午4:50:42 Bevoid Exp $
 */
public class ValidateError {

    private final CheckItem checkItem;

    public ValidateError(CheckItem checkItem) {
        this.checkItem = checkItem;
    }

    @Override
    public String toString() {
        //TODO 按照某种特定格式进行输出错误
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unpassed: @")
            .append(checkItem.getAnnotation().annotationType().getSimpleName()).append(" field: ")
            .append(checkItem.getFieldName()).append(" value: ").append(checkItem.getObj());
        return stringBuffer.toString();
    }
}
