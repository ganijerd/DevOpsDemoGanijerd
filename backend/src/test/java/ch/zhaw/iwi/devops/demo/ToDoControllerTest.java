package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    private ToDoController controller;

    @BeforeEach
    public void setup() {
        controller = new ToDoController();
        controller.init();
    }

    @Test
    public void testCreate() {
        ToDo todo = new ToDo(0, "Test", "Test Beschreibung");
        controller.createTodo(todo);
        assertEquals(6, controller.count());
        assertEquals(6, controller.todo().size());
    }

    @Test
    public void testGetTodo() {
        ToDo retrievedTodo = controller.getTodo(1);
        assertEquals("Neuer Job", retrievedTodo.getTitle());
    }

    @Test
    public void testUpdateTodo() {
        ToDo updatedTodo = new ToDo(1, "Updated Title", "Updated Description");
        controller.createTodo(1, updatedTodo);
        ToDo todo = controller.getTodo(1);
        assertEquals("Updated Title", todo.getTitle());
        assertEquals("Updated Description", todo.getDescription());
    }

    @Test
    public void testDeleteTodo() {
        ToDo deletedTodo = controller.deleteTodo(1);
        assertEquals("Neuer Job", deletedTodo.getTitle());
        assertEquals(4, controller.count());
    }

    @Test
    public void testGetNonExistingTodo() {
        ToDo todo = controller.getTodo(999); // ID, die nicht existiert
        assertNull(todo);
    }

    @Test
    public void testDeleteNonExistingTodo() {
        ToDo todo = controller.deleteTodo(999); // ID, die nicht existiert
        assertNull(todo);
    }

    @Test
    public void testToDoConstructor() {
        // Erstellen eines ToDo-Objekts
        ToDo todo = new ToDo(1, "Neuer Job", "5 DevOps Engineers einstellen");

        // Überprüfen, ob die ID korrekt gesetzt wurde
        assertEquals(1, todo.getId(), "Die ID sollte 1 sein.");

        // Überprüfen, ob der Titel korrekt gesetzt wurde
        assertEquals("Neuer Job", todo.getTitle(), "Der Titel sollte 'Neuer Job' sein.");

        // Überprüfen, ob die Beschreibung korrekt gesetzt wurde
        assertEquals("5 DevOps Engineers einstellen", todo.getDescription(), "Die Beschreibung sollte '5 DevOps Engineers einstellen' sein.");
    }

}
