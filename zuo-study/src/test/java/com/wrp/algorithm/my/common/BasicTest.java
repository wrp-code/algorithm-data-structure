package com.wrp.algorithm.my.common;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * @author wrp
 * @since 2025-02-22 17:46
 **/
public class BasicTest {

    @Test
    public void fu1 () {
        int res = -1 / 2;
        Assert.isTrue(res == 0, "Error");
    }
}
