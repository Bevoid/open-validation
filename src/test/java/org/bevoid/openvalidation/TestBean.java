package org.bevoid.openvalidation;

import org.bevoid.openvalidation.annotation.Max;
import org.bevoid.openvalidation.annotation.NotNull;

/**
 * 
 * @author Bevoid
 * @version $Id: TestBean.java, v 0.1 2014年3月20日 下午3:49:14 Bevoid Exp $
 */
public class TestBean {

    @NotNull
    public String  username = "example";

    @NotNull
    public String  password = null;

    @Max(100)
    public Integer age      = 80;

    @Max(100)
    public Double  count    = 101.;

}
