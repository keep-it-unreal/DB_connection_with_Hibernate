package sbp.PersonsDB;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ConnectManager {
private static final String url = "jdbc:postgresql://localhost:5432/Person";
private static final String username = "postgres";
private static final String password = "postgres";
public static SessionFactory sessionFactory;

public static SessionFactory getSessionFactory(){
    if(sessionFactory == null){
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.connection.driver", "org.postgresql.Driver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        sessionFactory = configuration.buildSessionFactory();
    }
    return sessionFactory;
    }
}
