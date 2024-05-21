package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PersonController {
    private Map<Integer, Person> persons = new HashMap<Integer, Person>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.persons.put(1,new Person(1, "Christoph", "Blocher",62, "Schweiz"));
        this.persons.put(2,new Person(2, "Simonetta", "Sommaruga",52, "Schweiz"));
        this.persons.put(3,new Person(3, "Maximilian", "Weigl",24, "Schweiz"));
        this.persons.put(4,new Person(4, "Patrick", "Trachsler",35, "Schweiz"));
        this.persons.put(5,new Person(5, "Jonathan", "Mörgeli",12, "Schweiz"));
        System.out.println("Init Data");
    }

    @GetMapping("/persontest")
    public String test() {
        return "person app is up and running!";
    }

    @GetMapping("/personcount")
    public int count() {
        return this.persons.size();
    }

    @GetMapping("/services/person")
    public List<PathListEntry<Integer>> person() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var person : this.persons.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(person.getId(), "todoKey");
            entry.setName(person.getVorname());
            entry.getDetails().add(person.getNachname());
            entry.setTooltip(person.getNachname());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/person/{key}")
    public Person getPerson(@PathVariable Integer key) {
        return this.persons.get(key);
    }

    @PostMapping("/services/person")
    public void createPerson(@RequestBody Person person) {
        var newId = this.persons.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        person.setId(newId);
        this.persons.put(newId, person);
    }

    @PutMapping("/services/person/{id}")
    public void createPerson(@PathVariable Integer id, @RequestBody Person person) {
        person.setId(id);
        this.persons.put(id, person);
    }

    @DeleteMapping("/services/person/{key}")
    public Person deletePerson(@PathVariable Integer key) {
        return this.persons.remove(key);
    }


}

