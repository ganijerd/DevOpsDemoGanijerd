package ch.zhaw.iwi.devops.demo;

public class Person {
    private int id;
    private String vorname;
    private String nachname;
    private int alter;
    private String herkunftsland;

    public Person() {
    }
    
    public Person(int id, String vorname, String nachname, int alter, String herkunftsland) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.herkunftsland = herkunftsland;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
    public int getAlter() {
        return alter;
    }
    public String getHerkunftsland() {
        return herkunftsland;
    }
}
