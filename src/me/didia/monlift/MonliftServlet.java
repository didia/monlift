package me.didia.monlift;

import java.io.IOException;

import javax.servlet.http.*;

import me.didia.monlift.helper.EMF;
import me.didia.monlift.entities.Passenger;
import me.didia.monlift.entities.User;
import me.didia.monlift.entities.UserFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@SuppressWarnings("serial")
public class MonliftServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		EntityManager em = EMF.getInstance().get().createEntityManager();
		try{
			UserFactory uf = UserFactory.getInstance();
			Passenger p = uf.createPassenger("Jake", "Massa", "jac.masssa0908@gmail.com", "7838073831");
			em.persist(p);
		}catch(Exception e){
			
		}finally{
			em.close();
		}
	}
}
