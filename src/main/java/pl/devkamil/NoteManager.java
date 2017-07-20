package pl.devkamil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class NoteManager {

	protected void create(Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();

		session.save(note);

		session.getTransaction().commit();
		session.close();
	}

	protected void read(HttpServletRequest request, HttpServletResponse response, String id) {
		Note n = getById(Long.valueOf(id));

		request.setAttribute("notes", n);
		try {
			request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public List<Note> getAllNotes() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Note> notatkiAll = new ArrayList<Note>();
		try {
			session.beginTransaction();
			notatkiAll = session.createQuery("from Note").list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return notatkiAll;

	}

	public Note getById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Note> notatkiAll = new ArrayList<Note>();
		try {
			session.beginTransaction();
			notatkiAll = session.createQuery("from Note where id=:abc").setParameter("abc", id).list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return notatkiAll.get(0);

	}

	public NoteManager() {
	}

}
