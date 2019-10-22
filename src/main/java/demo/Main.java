package demo;

import demo.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("jpa_inheritance_demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(new Employee("Worker"));
            entityManager.persist(new Employee("Worker"));
            entityManager.persist(new Employee("Manager"));

            Object employeesCount = entityManager
                    .createQuery("SELECT COUNT(e) FROM Employee e")
                    .getSingleResult();

            System.out.println("Employees: " + employeesCount);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e.toString());
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManagerFactory.isOpen()) {
                entityManager.close();
            }
            if (entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
            }
        }
    }
}
