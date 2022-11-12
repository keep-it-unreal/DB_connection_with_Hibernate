package sbp.PersonsDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DBAction {
    private final SessionFactory sessionFactory = ConnectManager.getSessionFactory();

    public Long createPerson(Person person){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long personId = (Long) session.save(person);
            transaction.commit();
            return personId;
        }
    }

    public Person getPerson(Long id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Person.class, id);
        }
    }

    public List<Person> getAllPersons(){
        try(Session session = sessionFactory.openSession()){
            return (List<Person>) session.createQuery("SELECT p FROM Person p").getResultList();
        }
    }

    public int deletePerson(Long id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            int changedRows = session.createQuery("DELETE FROM Person p WHERE p.id = :id").setParameter("id", id).executeUpdate();
            transaction.commit();
            return changedRows;
        }
    }

    public Person updatePerson(Person person){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Person person1 = session.merge(person);
            transaction.commit();
            return person1;
        }
    }
}
