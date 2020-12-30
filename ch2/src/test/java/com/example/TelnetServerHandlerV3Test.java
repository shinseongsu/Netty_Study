package com.example;

import com.example.V2.TelnetServerHandlerV3;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.junit.Assert.*;

public class TelnetServerHandlerV3Test {

    @Test
    public void testConnect() {
        StringBuilder builder = new StringBuilder();

        try {
            builder.append("환영합니다. ")
                    .append(InetAddress.getLocalHost().getHostName())
                    .append("에 접속하셨습니다!\r\n")
                    .append("현재 시간은 ")
                    .append(new Date().toString())
                    .append(" 입니다.\r\n");

        } catch (UnknownHostException e) {
            fail();
            e.printStackTrace();
        }

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new TelnetServerHandlerV3());

        String expected = (String) embeddedChannel.readOutbound();
        assertNotNull(expected);

        assertEquals(builder.toString(), (String) expected);

        String request = "hello";
        expected = "입력하신 명령이 '" + request + "' 입니까?\r\n";

        embeddedChannel.writeInbound(request);

        String response = (String) embeddedChannel.readOutbound();
        assertEquals(expected, response);

        embeddedChannel.finish();
    }

}
