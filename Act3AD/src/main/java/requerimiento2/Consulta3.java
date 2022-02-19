package requerimiento2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;

@SuppressWarnings("unchecked")
public class Consulta3 {
	
	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	public static void main(String[] args) {
		// 3. MOSTRAR TODAS LAS LIBRERIAS, CON SOLAMENTE SUS LIBROS ASOCIADOS
		
		emf = Persistence.createEntityManagerFactory("PruebaJPA");
		em = emf.createEntityManager();
		
		System.out.println("===================================");

		Query query = em.createQuery("Select l from Libreria l");
		List<Libreria> listaLibrerias = query.getResultList();
				
		System.out.println("==== listado de librerias con sus libros ====");

		for(Libreria l: listaLibrerias) {
			System.out.println("\nLibreria -> " + l.getNombreLibreria());
			Query query2 = em.createQuery("SELECT b.librosLibreria FROM Libreria b WHERE b.idLibreria = " + l.getIdLibreria()); 

			List<Libro> listaLibros = query2.getResultList();
			for(Libro b: listaLibros) {
				System.out.println("Libro: " + b.getTitulo());		
			}
		}
		em.close();
		emf.close();
	}

}
