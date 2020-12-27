package ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

public class OrderedByteBufferTest {
    final String source = "Hello world";

    @Test
    public void pooledHeapBufferTest() {
        ByteBuf buf = Unpooled.buffer();
        assertEquals(ByteOrder.BIG_ENDIAN, buf.order());

        buf.writeShort(1);

        buf.markReaderIndex();
        assertEquals(1, buf.readShort());

        buf.resetReaderIndex();

        ByteBuf lettleEndianBuf = buf.order(ByteOrder.LITTLE_ENDIAN);
        assertEquals(256, lettleEndianBuf.readShort());
    }

    @Test
    public void convertNettyBufferToJavaBuffer() {
        ByteBuf buf = Unpooled.buffer(1);

        buf.writeBytes(source.getBytes());
        assertEquals(source, buf.toString(Charset.defaultCharset()));

        ByteBuffer nioByteBuffer = buf.nioBuffer();
        assertNotNull(nioByteBuffer);
        assertEquals(source, new String(nioByteBuffer.array(),
                                    nioByteBuffer.arrayOffset(), nioByteBuffer.remaining()));

    }

    @Test
    public void convertJavaBufferToNettyBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(source.getBytes());
        ByteBuf nettyBuffer = Unpooled.wrappedBuffer(byteBuffer);

        assertEquals(source, nettyBuffer.toString(Charset.defaultCharset()));
    }

}
