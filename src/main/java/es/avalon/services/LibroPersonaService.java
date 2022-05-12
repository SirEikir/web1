package es.avalon.services;

import java.util.List;

import es.avalon.dominio.Libro;
import es.avalon.dominio.Persona;
import es.avalon.repository.LibroRepository;
import es.avalon.repository.PersonaRepositoy;

public class LibroPersonaService {

    private LibroRepository repoLibro = new LibroRepository();
    private PersonaRepositoy repoPersona = new PersonaRepositoy();

    public List<Persona> buscarTodasLasPersonas() {

        return repoPersona.buscarTodos();
    }

    public void insertarPersona (Persona persona) {

        repoPersona.insertar(persona);
    }

    public void borrarPersona(Persona persona) {
        repoPersona.borrar(persona);

    }
    public Persona buscarUnaPersona(Persona persona) {
        return repoPersona.buscarUnaPersona(persona);
    }
    

    public List<Libro> buscarTodosLosLibros() {

        return repoLibro.buscarTodos();
    }

    public void insertarLibro (Libro lib) {

        repoLibro.insertar(lib);
    }

    public void borrarLibro (Libro lib) {
        repoLibro.borrar(lib);

    }

    
    
}
