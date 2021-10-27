import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RLETest {

    @Test
    public void testTruth() {
        assertTrue(true);
    }

    @Test
    public void testOneLetter() {
        String text = "b";
        assertEquals(RLEApp.compress(text), "b1");
    }

    @Test
    public void testStreamOneLetter() {
        String text = "b";
        assertEquals(RLEApp.compressStream(text), "b1");
    }

    @Test
    public void testDifferentSize() {
        String text = "aaaAAAaA";
        assertEquals(RLEApp.compress(text), "a3A3a1A1");
    }

    @Test
    public void testStreamDifferentSize(){
        String text = "aaaAAAaA";
        assertEquals(RLEApp.compressStream(text), "a3A3a1A1");
    }

    @Test
    public void testTime() {
        String text = "aaaajjjfjjeeeeKKKKKKKKKKKKKKKKKdddddddddAAAAAAfdGGGGGGGGGGGGGG";
        long start = System.currentTimeMillis();
        RLEApp.compress(text);
        long stop = System.currentTimeMillis();
        System.out.println("Czas wykonania:" + (stop - start));
    }

    @Test
    public void testStreamTime(){
        String text = "aaaajjjfjjeeeeKKKKKKKKKKKKKKKKKdddddddddAAAAAAfdGGGGGGGGGGGGGG";
        long start = System.currentTimeMillis();
        RLEApp.compressStream(text);
        long stop = System.currentTimeMillis();
        System.out.println("Czas wykonania:" + (stop - start));
    }

}
