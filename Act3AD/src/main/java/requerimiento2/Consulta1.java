package requerimiento2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Libro;

public class Consulta1 {
	
	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;

	@SuppressWarnings("unchecked")

	public static void main(String[] args) {
		// 1. MOSTRAR TODOS LOS LIBROS DADOS DE ALTA, CON SU EDITORIAL Y SU AUTOR
		
		emf = Persistence.createEntityManagerFactory("PruebaJPA");
		em = emf.createEntityManager();
		
		System.out.println("===================================");
		
		Query query = em.createQuery("Select l from Libro l");
		List<Libro> list = query.getResultList();
		System.out.println("==== listado de libros ====");
		listarLibrosConEditorialYAutor(list);
		
		em.close();
		emf.close();
		
	}
	
	public static void listarLibrosConEditorialYAutor(List<Libro> listaLibros) {
		for(Libro l: listaLibros) {
			System.out.println("Libro-> id: " + l.getIdLibro() + "; titulo: " + 
					l.getTitulo() + "; editorial : " + 
					l.getEditorial().getNombreEditorial() + 
					"; autor : " +  l.getAutor().getNombreAutor() + " " + 
					l.getAutor().getApellidosAutor());
		}
	}

}
