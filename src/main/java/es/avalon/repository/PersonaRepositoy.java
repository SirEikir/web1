package es.avalon.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.avalon.activerecord.DataBaseHelper;
import es.avalon.dominio.Persona;

public class PersonaRepositoy {

    public List<Persona> buscarTodos() {

        List<Persona> lista = new ArrayList<>();
            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con.prepareStatement("select * from Personas");) {
                    ResultSet rs = sentencia.executeQuery();
                    while (rs.next()) {
    
                    lista.add(new Persona(rs.getString("dni"),
                            rs.getString("Nombre"), rs.getInt("Edad")));
                }
                return lista;
    
            } catch (SQLException | IOException e) {
                
                throw new RuntimeException(e);
            }
    
    
        }

    public Persona buscarUnaPersona(Persona p) {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Personas where dni=?");) 
                {
                    sentencia.setString(1, p.getDni());
                ResultSet rs = sentencia.executeQuery();
                rs.next();

                Persona persona = new Persona(rs.getString("dni"),
                        rs.getString("Nombre"), rs.getInt("Edad"));
            
            return persona;

        } catch (SQLException | IOException e) {
            
            throw new RuntimeException(e);
        }
    
        }
        public void insertar(Persona p) {

            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con
                            .prepareStatement("insert into Personas (dni,Nombre,Edad) values (?,?,?)");) {
                sentencia.setString(1, p.getDni());
                sentencia.setString(2, p.getNombre());
                sentencia.setInt(3, p.getEdad());
                sentencia
                        .executeUpdate();
    
            } catch (SQLException | IOException e) {
               throw new RuntimeException(e);
            }
        }

        public void borrar(Persona p) {

            try (
                    Connection con = DataBaseHelper.getConexion();
                    PreparedStatement sentencia = con.prepareStatement(" delete from Personas where dni=?");) {
                sentencia.setString(1, p.getDni());
                sentencia.executeUpdate();
    
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
    
        }

    }   

