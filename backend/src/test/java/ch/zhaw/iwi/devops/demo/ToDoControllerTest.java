package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    @Test
    public void testCreate() {
        ToDoController controller = new ToDoController();
        var todo = new ToDo(1, "t", "d");
        controller.createTodo(1, todo);
        assertEquals(1, controller.count());
        assertEquals(1, controller.todo().size());
    }

    @Test
    void testToDoConstructor() {
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
