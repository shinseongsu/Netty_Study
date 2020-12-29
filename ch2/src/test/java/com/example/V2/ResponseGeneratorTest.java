package com.example.V2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseGeneratorTest {

    @Test
    public void testZeroLengthString() {
        String request = "";

        ResponseGenerator generator = new ResponseGenerator(request);
        assertNotNull(generator);

        assertNotNull(generator.response());
        assertEquals("명령을 입력해 주세요.\r\n", generator.response());
        assertFalse(generator.isClose());
    }
}
