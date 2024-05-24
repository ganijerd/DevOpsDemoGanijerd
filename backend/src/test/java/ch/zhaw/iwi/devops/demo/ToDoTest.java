package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {

    @Test
    public void testToDoConstructorAndGetters() {
        var toDo1 = new ToDo(1, "title", "description");
        assertEquals(1, toDo1.getId());
        assertEquals("title", toDo1.getTitle());
        assertEquals("description", toDo1.getDescription());
    }
    
    @Test
    public void testSetId() {
        var toDo = new ToDo(1, "title", "description");
        toDo.setId(2);
        assertEquals(2, toDo.getId());
    }

    @Test
    public void testBoundaryConditions() {
        var toDo = new ToDo(-1, null, null);
        assertEquals(-1, toDo.getId());
        assertEquals(null, toDo.getTitle());
        assertEquals(null, toDo.getDescription());
    }
    
}
