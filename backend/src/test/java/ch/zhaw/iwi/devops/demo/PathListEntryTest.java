package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PathListEntryTest {
    private PathListEntry<Integer> entry;

    @BeforeEach
    void setUp() {
        entry = new PathListEntry<>();
    }

    @Test
    void testInitialState() {
        Assertions.assertTrue(entry.isActive(), "Entry should be active by default");
        Assertions.assertNull(entry.getKey(), "Key should initially be null");
        Assertions.assertNull(entry.getName(), "Name should initially be null");
    }

    @Test
    void testKeyClass() {
        entry.setKey(1, "Key Name");
        @SuppressWarnings("rawtypes")
        PathListEntry.Key key = entry.getKey();
        Assertions.assertEquals(1, key.getKey());
        Assertions.assertEquals("Key Name", key.getName());

        @SuppressWarnings("rawtypes")
        PathListEntry.Key key1 = entry.new Key(1, "Key Name");
        @SuppressWarnings("rawtypes")
        PathListEntry.Key key2 = entry.new Key(2, "Another Name");
        Assertions.assertTrue(key.equals(key1));
        Assertions.assertFalse(key.equals(key2));
        Assertions.assertEquals(key.hashCode(), key1.hashCode());
        Assertions.assertNotEquals(key.hashCode(), key2.hashCode());
    }

    @Test
    void testEqualsAndHashCode() {
        PathListEntry<Integer> anotherEntry = new PathListEntry<>();
        anotherEntry.setKey(1, "Key Name");

        entry.setKey(1, "Key Name");
        Assertions.assertTrue(entry.equals(anotherEntry));
        Assertions.assertEquals(entry.hashCode(), anotherEntry.hashCode());

        anotherEntry.setKey(2, "Different Key");
        Assertions.assertFalse(entry.equals(anotherEntry));
    }
}
