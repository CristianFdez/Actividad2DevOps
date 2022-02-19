package requerimiento3prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Requerimiento3prueba {

	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
	
		EntityManager em = factoria.createEntityManager();
	}

	}


