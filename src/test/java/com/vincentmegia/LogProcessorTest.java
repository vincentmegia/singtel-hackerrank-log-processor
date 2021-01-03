package com.vincentmegia;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LogProcessorTest {
    @Test
    public void testProcess() {
        int maxSpan = 5;
        List<String> rawLogs = Arrays.asList("101 1 sign-in",
                "100 10 sign-in",
                "50 20 sign-in",
                "100 15 sign-out",
                "50 26 sign-in",
                "101 2 sign-out");
        var results = new LogProcessor().process(rawLogs, maxSpan);
        Assert.assertEquals(results.get(0), "100");
        Assert.assertEquals(results.get(1), "101");
    }
}
