package requerimiento2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;

@SuppressWarnings("unchecked")
public class Consulta4 {
	
	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	public static void main(String[] args) {
		// 4. MOSTRAR TODOS LAS LIBROS Y EN LA LIBRERÍA EN LA QUE ESTÁN
		
		emf = Persistence.createEntityManagerFactory("PruebaJPA");
		em = emf.createEntityManager();
		
		System.out.println("===================================");
		
		Query query = em.createQuery("Select l from Libreria l");
		List<Libreria> listaLibrerias = query.getResultList();
		
		System.out.println("==== listado de los libros con sus librerías ====");		
		
		for(Libreria l: listaLibrerias) {
			Query query2 = em.createQuery("SELECT b.librosLibreria FROM Libreria b"); 
			
			List<Libro> listaLibros = query2.getResultList();
			for(Libro b: listaLibros) {
				System.out.println("Libro: " + b.getTitulo() + "\nLibrería: " + l.getNombreLibreria() + "\n");

			}
		}
		
		em.close();
		emf.close();
	}

}
