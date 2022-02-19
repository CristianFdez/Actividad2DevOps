package requerimiento1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class PruebasAltas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = null;
		
		// 1. DAR DE ALTA 3 AUTORES
		
		Autor a1 = new Autor();
		a1.setIdAutor(1);
		a1.setNombreAutor("Paulo");
		a1.setApellidosAutor("Coelho");
		a1.setFechaNac(new Date());
		
		Autor a2 = new Autor();
		a2.setIdAutor(2);
		a2.setNombreAutor("Ken");
		a2.setApellidosAutor("Follet");
		a2.setFechaNac(new Date());
		
		Autor a3 = new Autor();
		a3.setIdAutor(3);
		a3.setNombreAutor("Julia");
		a3.setApellidosAutor("Navarro");
		a3.setFechaNac(new Date());
		
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		System.out.println(" ----- Añadiendo a los 3 autores ----- ");
		
		
		em.getTransaction().commit(); 
		System.out.println(" ----- Autores dados de alta ----- ");
		
		em.close();
		
		
		// 2. DAR DE ALTA DOS EDITORIALES
		
		Editorial e1 = new Editorial();
		e1.setNombreEditorial("DEBOLSILLO");
		e1.setLibrosEditorial(new ArrayList<Libro>());
		
		Direccion d1 = new Direccion();
		d1.setTipoVia("Paseo");
		d1.setNombreVia("Gracia");
		d1.setCiudad("Barcelona");

		
		e1.setDireccion(d1);
		
		Editorial e2 = new Editorial();
		e2.setNombreEditorial("Plaza & Janés");
		e2.setLibrosEditorial(new ArrayList<Libro>());
		
		Direccion d2 = new Direccion();
		d2.setTipoVia("Travessera");
		d2.setNombreVia("Gracia");
		d2.setCiudad("Barcelona");
		
		e2.setDireccion(d2);
		
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(e1);
		em.persist(e2);
		
		System.out.println(" ----- Añadiendo las 2 editoriales ----- ");
		
		em.getTransaction().commit(); 
		System.out.println(" ----- Editoriales dadas de alta ----- ");
		
		em.close();
		
		// 3. DAR DE ALTA 8 LIBROS CON AUTORES Y EDITORIALES AÑADIDOS PREVIAMENTE
		
		em = emf.createEntityManager();
		
		List<Editorial> listaEditoriales = em.createQuery("from Editorial e").getResultList();
		Editorial edit1 = listaEditoriales.get(0);
		Editorial edit2 = listaEditoriales.get(1);
		
		List<Autor> listaAutores = em.createQuery("from Autor a").getResultList();
		
		Autor autor1 = listaAutores.get(0); // Coelho
		Autor autor2 = listaAutores.get(1); // Follet
		Autor autor3 = listaAutores.get(2);// Navarro
		
		
		Libro l1 = new Libro();
		l1.setTitulo("La clave está en Rebeca"); // Ken Follet
		l1.setEditorial(e1);
		l1.setAutor(autor2);
		l1.setPrecio(29.90);
		
		Libro l2 = new Libro();
		l2.setTitulo("El alquimista"); // Paulo Coelho
		l2.setEditorial(e1);
		l2.setAutor(autor1);
		l2.setPrecio(23.79);
		
		Libro l3 = new Libro();
		l3.setTitulo("Dime tu nombre"); // Julia Navarro
		l3.setEditorial(e2);
		l3.setAutor(autor3);
		l3.setPrecio(26);
		
		Libro l4 = new Libro();
		l4.setTitulo("La caída de los gigantes");// Ken Follet
		l4.setEditorial(e1);
		l4.setAutor(autor2);
		l4.setPrecio(28.36);
		
		Libro l5 = new Libro();
		l5.setTitulo("Las tinieblas y el alba"); // Ken Follet
		l5.setEditorial(e1);
		l5.setAutor(autor2);
		l5.setPrecio(23.85);
		
		Libro l6 = new Libro();
		l6.setTitulo("La sangre de los inocentes"); // Julia Navarro
		l6.setEditorial(e2);
		l6.setAutor(autor3);
		l6.setPrecio(18.40);
		
		Libro l7 = new Libro();
		l7.setTitulo("El baile de las marionetas"); // Julia Navarro
		l7.setEditorial(e2);
		l7.setAutor(autor3);
		l7.setPrecio(14.20);
		
		Libro l8 = new Libro();
		l8.setTitulo("El peregrino"); // Paulo Coelho
		l8.setEditorial(e1);
		l8.setAutor(autor1);
		l8.setPrecio(15.70);
		
		System.out.println("==============================================");
		em.getTransaction().begin();
		
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		em.persist(l5);
		em.persist(l6);
		em.persist(l7);
		em.persist(l8);

		System.out.println(" ----- Dando de alta los 8 libros ----- ");	
		
		em.getTransaction().commit(); 
		System.out.println(" ----- Libros añadidos ----- ");
		em.close();	
		
		// 4. DOS LIBRERÍAS, CADA LIBRERÍA TENDRÁ 4 LIBROS DADOS DE ALTA PREVIAMENTE
		
		em = emf.createEntityManager();
		
		List<Libro> listaLibros = em.createQuery("from Libro l").getResultList();
		
		// Para simplificar hemos decidido añadir los libros impares a una libreria
		// y los impares a otra
		List<Libro> librosLib1 = new ArrayList<Libro>();
		List<Libro> librosLib2 = new ArrayList<Libro>();
		for(int i=0; i<listaLibros.size(); i++) {
			if(i % 2 == 0) {
				librosLib1.add(listaLibros.get(i));
			} else {
				librosLib2.add(listaLibros.get(i));
			}
		}
		
		
		Direccion dir1 = new Direccion();
		dir1.setTipoVia("calle");
		dir1.setNombreVia("Gran Via");
		dir1.setCiudad("Madrid");
		
		Libreria libreria1 = new Libreria();
		libreria1.setNombreLibreria("Casa del Libro");
		libreria1.setNombreDueno("Perico");
		libreria1.setDireccion(dir1);
		libreria1.setLibrosLibreria(librosLib1);
		
		Direccion dir2= new Direccion();
		dir2.setTipoVia("calle");
		dir2.setNombreVia("Goya");
		dir2.setCiudad("Madrid");
		
		Libreria libreria2 = new Libreria();
		libreria2.setNombreLibreria("Los libros de Ana");
		libreria2.setNombreDueno("Ana");
		libreria2.setDireccion(dir2);
		libreria2.setLibrosLibreria(librosLib2);
		
		System.out.println("==============================================");
		em.getTransaction().begin();
		
		em.persist(libreria1);
		em.persist(libreria2);
		
		System.out.println(" ----- Dando de alta las 2 librerias ----- ");	
		
		em.getTransaction().commit(); 
		System.out.println(" ----- Librerias añadidos ----- ");
		em.close();	

		
		
	}

}
