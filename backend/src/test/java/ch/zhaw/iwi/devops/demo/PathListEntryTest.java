package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathListEntryTest {
    @Test
    void testSetAndGetKey() {
        PathListEntry <Integer> entry = new PathListEntry<>();
        entry.setKey(1, "Key 1");
        Assertions.assertEquals(1,entry.getKey().getKey());
        Assertions.assertEquals("Key 1",entry.getKey().getName());
    }
}
