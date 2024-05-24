package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonControllerTest {
     private PersonController personController;

    @BeforeEach
    public void setup() {
        personController = new PersonController();
        personController.init();  // Füllt die `persons` Map mit Testdaten
    }

    @Test
    public void testAppRunning() {
        String response = personController.test();
        assertEquals("person app is up and running!", response);
    }

    @Test
    public void testPersonCount() {
        int count = personController.count();
        assertEquals(5, count); // Überprüft, ob die initiale Anzahl an Personen korrekt geladen wird
    }

    @Test
    public void testListPersons() {
        List<PathListEntry<Integer>> persons = personController.person();
        assertNotNull(persons);
        assertEquals(5, persons.size()); // Stellt sicher, dass alle Personen gelistet werden
        assertEquals("Christoph", persons.get(0).getName());
    }

    @Test
    public void testGetPerson() {
        Person person = personController.getPerson(1);
        assertNotNull(person);
        assertEquals("Christoph", person.getVorname());
        assertEquals("Blocher", person.getNachname());
    }

    @Test
    public void testCreatePerson() {
        Person newPerson = new Person(0, "Neuer", "Person", 30, "Schweiz");
        personController.createPerson(newPerson);
        assertEquals(6, personController.count());
    }

    @Test
    public void testUpdatePerson() {
        Person updatedPerson = new Person(1, "Geändert", "Person", 63, "Schweiz");
        personController.createPerson(1, updatedPerson);
        Person person = personController.getPerson(1);
        assertEquals("Geändert", person.getVorname());
    }

    @Test
    public void testDeletePerson() {
        Person deletedPerson = personController.deletePerson(1);
        assertNotNull(deletedPerson);
        assertEquals(4, personController.count());
    }
}
