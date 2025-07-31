package io.github.LCholakov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.close();
    }
}