package com.swallow.util;


import org.junit.Assert;
import org.junit.Test;

public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws Exception {
        Assert.assertNotNull(JDBCUtil.getConnection());
    }

}
