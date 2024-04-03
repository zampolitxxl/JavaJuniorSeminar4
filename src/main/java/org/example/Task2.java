package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Task2 {
    public static void main(String[] args) {

   SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();


        Course course = new Course(1, "Name", 22);
        session.save(course);

        Course course2 = new Course(7, "Petr", 32);

        session.save(course2);



        System.out.println("Объект КУРС сохранен успешно");



        Course retrivedCourse =session.get(Course.class, course.getId() );
        System.out.println("Retrived course object" + retrivedCourse);

        //Обновление

        retrivedCourse.updateName("Курс по програмированию");
        session.update(retrivedCourse);

        session.delete(retrivedCourse);

        session.getTransaction().commit();

    }
}
