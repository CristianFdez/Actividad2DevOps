package requerimiento2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Libro;


public class Consulta2 {
	
	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 2. MOSTRAR TODOS LOS AUTORES DADOS DE ALTA, CON SUS LIBROS ASOCIADOS
		
		emf = Persistence.createEntityManagerFactory("PruebaJPA");
		em = emf.createEntityManager();
		
		System.out.println("===================================");

		Query query = em.createQuery("Select a from Autor a");
		List<Autor> listaAutores = query.getResultList();

		System.out.println("==== listado de autores con sus libros ====");

		for(Autor a: listaAutores) {
			System.out.println("\nAutor -> " + a.getNombreAutor() + " " + a.getApellidosAutor());
			Query query2 = em.createQuery("SELECT l FROM Libro l WHERE l.autor.idAutor = " + a.getIdAutor()); 
			
			List<Libro> listaLibros = query2.getResultList();
			for(Libro l: listaLibros) {
				System.out.println("Libro: " + l.getTitulo());
			}
		}
		em.close();
		emf.close();
		
	}

}
