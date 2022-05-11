package es.avalon.activerecord;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaActiveRecord {

    private int isbn;
    private String autor;
    private String titulo;


    


    public BibliotecaActiveRecord(int isbn) {
        this.isbn = isbn;
    }

    public BibliotecaActiveRecord(String autor, int isbn, String titulo) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void insertar() {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con
                        .prepareStatement("insert into libros (titulo,ISBN,autor) values (?,?,?)");) {
            sentencia.setString(1, getTitulo());
            sentencia.setInt(3, getIsbn());
            sentencia.setString(2, getAutor());
            sentencia
                    .executeUpdate();

        } catch (SQLException | IOException e) {
           throw new RuntimeException(e);
        }
    }

    public void borrar() {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement(" delete from libros where ISBN=?");) {
            sentencia.setInt(1, getIsbn());
            sentencia.executeUpdate();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizar() {
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("update libros set titulo=?,ISBN=? where ISBN=?");) {
                    sentencia.setString(1, getTitulo());
                    sentencia.setInt(3, getIsbn());
                    sentencia.setString(2, getAutor());


        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BibliotecaActiveRecord buscarUno(Integer isbn) {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from libros  where ISBN=?");) {
            sentencia.setInt(1, isbn);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            return new BibliotecaActiveRecord(rs.getString("autor"), 
                rs.getInt("edad"), rs.getString("titulo"));

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<BibliotecaActiveRecord> buscarTodos() {
        List<BibliotecaActiveRecord> lista = new ArrayList<>();
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Personas");) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new BibliotecaActiveRecord(rs.getString("autor"), 
                rs.getInt("edad"), rs.getString("titulo")));
            }
            return lista;

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }


    }

}


