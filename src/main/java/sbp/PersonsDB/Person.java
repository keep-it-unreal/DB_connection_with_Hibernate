package sbp.PersonsDB;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;
    @Column
    private String city;
    @Column
    private int age;

    public Person() {}
    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }
    public Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Person person = (Person) o;

        if(city == null || name == null || person.name == null || person.city == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return age == person.age && name.equalsIgnoreCase(person.name) && city.equalsIgnoreCase(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, age);
    }

    @Override
    public String toString() {
        return name + " lives in " + city + " " + age + "y.o.";
    }
}
