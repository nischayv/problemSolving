package Hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomHashmapTest {

    @Test
    public void testGetAndSet() {
        CustomHashmap<String> testHashMap = new CustomHashmap<String>(10);
        testHashMap.set("K", "Kleiner");
        testHashMap.set("P", "Perkins");
        testHashMap.set("C", "Caufield");
        testHashMap.set("B", "Byers");
        assertEquals("Kleiner", testHashMap.get("K"));
        assertEquals("Perkins", testHashMap.get("P"));
        assertEquals("Caufield", testHashMap.get("C"));
        assertEquals("Byers", testHashMap.get("B"));
    }

    @Test
    public void testFixedSizeContraint() {
        CustomHashmap<String> testHashMap = new CustomHashmap<String>(1);
        testHashMap.set("K", "Kleiner");
        assertFalse(testHashMap.set("P", "Perkins"));
    }

    @Test
    public void testGetNull() {
        CustomHashmap<String> testHashMap = new CustomHashmap<String>(2);
        testHashMap.set("K", "Kleiner");
        assertNull(testHashMap.get("P"));
    }

    @Test
    public void testDeleteNull() {
        CustomHashmap<String> testHashMap = new CustomHashmap<>(2);
        testHashMap.set("K", "Kleiner");
        assertNull(testHashMap.delete("PSS"));
    }

    @Test
    public void testNormalDelete() {
        CustomHashmap<String> testHashMap = new CustomHashmap<>(2);
        testHashMap.set("K", "Kleiner");
        testHashMap.set("P", "Perkins");
        assertEquals("Perkins", testHashMap.get("P"));
        assertEquals("Perkins", testHashMap.delete("P"));
        assertNull(testHashMap.get("P"));
    }

    @Test
    public void testNormalLoadFactor() {
        CustomHashmap<Integer> testHashMap = new CustomHashmap<>(2);
        for (int i = 0; i < 5; i++) {
            testHashMap.set(String.valueOf(i), i);
        }
        assertTrue(testHashMap.load() <= 1);
    }

    @Test
    public void testExactLoadFactor() {
        CustomHashmap<Integer> testHashMap = new CustomHashmap<>(10);
        for (int i = 0; i < 10; i++) {
            testHashMap.set(String.valueOf(i), i);
        }
        assertTrue(testHashMap.load() <= 0.75);
    }

    @Test
    public void testOverrideValues() {
        CustomHashmap<String> testHashMap = new CustomHashmap<>(10);
        testHashMap.set("K", "Kleiner");
        testHashMap.set("B", "Byers");
        assertEquals("Kleiner", testHashMap.get("K"));
        assertEquals("Byers", testHashMap.get("B"));
        testHashMap.set("K", "Kevin");
        testHashMap.set("B", "Bacon");
        assertEquals("Kevin", testHashMap.get("K"));
        assertEquals("Bacon", testHashMap.get("B"));
    }
}