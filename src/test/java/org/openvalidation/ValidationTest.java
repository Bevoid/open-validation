package org.openvalidation;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Bevoid
 * @version $Id: ValidationTest.java, v 0.1 2014年3月20日 下午2:30:39 Bevoid Exp $
 */
public class ValidationTest {

    Validation validation = null;

    public ValidationTest() {
        validation = new Validation();
    }

    /**
     * Test method for {@link org.openvalidation.Validation#validateBean(java.lang.Object)}.
     */
    @Test
    public void testValidateBean() {
        TestBean testBean = new TestBean();
        validation.validateBean(testBean);
        for (ValidateError ve : validation.getValidateError()) {
            System.out.println(ve);
        }
        Assert.assertEquals(validation.getValidateError().size(), 3);
    }
}
