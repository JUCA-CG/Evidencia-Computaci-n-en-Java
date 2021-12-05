/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc_ca
 */
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Persona
{
    //Atributos de la persona
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String email;
    
    private static List <Persona> Usuario;
    
    //Constructor 
    public Persona(int id, String nombre, String apellido, int edad, String genero, String email) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.email = email;
    }
    
    //Constructor médico
    public Persona(int id,String nombre, String apellido, int edad) 
    {
        this.id=id;
       this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
    public Persona() {}
    
    //Métodos Get y Set 
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}   
    public List<Persona> getUsuario() {return Usuario;}
    public void setUsuario(List<Persona> persona) {this.Usuario = Usuario;}
       
}
