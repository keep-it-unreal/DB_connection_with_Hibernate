import org.junit.Assert;
import org.junit.Test;
import sbp.PersonsDB.DBAction;
import sbp.PersonsDB.Person;

public class DBTest {
    DBAction dbAction = new DBAction();

    /**
     * Данный тест проверяет корректность работы метода .createPerson(Person person).
     */
    @Test
    public void createPersonTest() {
        dbAction.createPerson(new Person("Ivan", "Moscow", 22));
        dbAction.createPerson(new Person("Marina", "Ivanovo", 21));
        dbAction.createPerson(new Person("Maria", "Omsk", 34));
        dbAction.createPerson(new Person("Olga", "Kemerovo", 65));
        Assert.assertEquals(4, dbAction.getAllPersons().size());
    }

    /**
     * Данный тест проверяет корректность работы метода .getPerson(Long id).
     */
    @Test
    public void getPersonTest() {
        Assert.assertEquals("Ivan", dbAction.getPerson(1L).getName());
    }

    /**
     * Данный тест проверяет корректность работы метода .getAllPersons().
     */
    @Test
    public void getAllPersonsTest() {
        Assert.assertEquals("Marina", dbAction.getAllPersons().get(1).getName());
    }

    /**
     * Данный тест проверяет корректность работы метода .deletePerson(Long id).
     */
    @Test
    public void deletePersonTest() {
        Assert.assertEquals(1, dbAction.deletePerson(2L));
    }

    /**
     * Данный тест проверяет корректность работы метода .updatePerson(Person person).
     */
    @Test
    public void updatePersonTest() {
        Person person = dbAction.getPerson(1L);
        person.setCity("Paris");
        dbAction.updatePerson(person);
        Assert.assertEquals("Paris", dbAction.getPerson(1L).getCity());
    }
}
