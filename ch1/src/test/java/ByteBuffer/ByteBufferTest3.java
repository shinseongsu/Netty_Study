package ByteBuffer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;

public class ByteBufferTest3 {

    @Test
    public void test() {
        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        System.out.println("초기 상태 : " + firstBuffer);

        firstBuffer.put((byte) 1);
        System.out.println(firstBuffer.get());
        System.out.println(firstBuffer);
    }
}
