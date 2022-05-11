package es.avalon.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.avalon.activerecord.DataBaseHelper;
import es.avalon.dominio.Libro;

public class LibroRepository {

    public List<Libro> buscarTodos() {

        List<Libro> lista = new ArrayList<>();
            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con.prepareStatement("select * from libros");) {
                    ResultSet rs = sentencia.executeQuery();
                    while (rs.next()) {
    
                    lista.add(new Libro(rs.getString("autor"), rs.getInt("ISBN"),
                    rs.getString("titulo")));
                }
                return lista;
    
            } catch (SQLException | IOException e) {
                
                throw new RuntimeException(e);
            }
    
    
        }
        public void insertar(Libro libros) {

            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con
                            .prepareStatement("insert into libros (autor,ISBN,titulo) values (?,?,?)");) {
                sentencia.setString(1, libros.getAutor());
                sentencia.setInt(2, libros.getIsbn());
                sentencia.setString(3, libros.getTitulo());
                sentencia
                        .executeUpdate();
    
            } catch (SQLException | IOException e) {
               throw new RuntimeException(e);
            }
        }

        public void borrar(Libro libros) {

            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con.prepareStatement(" delete from libros where ISBN=?");) {
                sentencia.setInt(1, libros.getIsbn());
                sentencia.executeUpdate();
    
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
    
        }

        
    }   


