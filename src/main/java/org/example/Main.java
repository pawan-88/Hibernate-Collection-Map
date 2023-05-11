package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("Java is pgm lang.","ABC");
        hashMap.put("Java is lang..","PQR");

        HashMap<String,String> hashMap1 = new HashMap<String,String>();
        hashMap1.put("Servlet  is Tech..","XTZ");
        hashMap1.put("Servlet is API..", "LOJ");

        Question question= new Question("WHat is Java?","DOG",hashMap);
        Question question1 = new Question("WHat is Servlet?","CAT",hashMap1);

        session.save(question);
        session.save(question1);

        t.commit();
        session.close();
        System.out.println("Successfully save Map Data....");
    }
}