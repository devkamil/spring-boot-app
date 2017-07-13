package pl.devkamil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class NoteManager {

	protected SessionFactory sessionFactory;

	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (HibernateException ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			ex.printStackTrace();
		} catch (Exception exception) {
			System.out.println("-------------------");
			exception.printStackTrace();
		}
	}

	protected void create(Note note) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(note);

		session.getTransaction().commit();
		session.close();
	}

	protected void exit() {
		sessionFactory.close();
	}

	public NoteManager() {
	}

}
