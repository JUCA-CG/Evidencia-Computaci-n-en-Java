/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc_ca
 */
import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Paciente extends Persona
{
    private List <Paciente> Paciente;

    //Constructor
    public Paciente(int id, String nombre, String apellido, int edad, String genero, String email) 
    {
        super(id, nombre, apellido, edad, genero, email);
    }

    public Paciente() {}

    public List<Paciente> getPaciente() {return Paciente;}
    public void setPaciente(List<Paciente> paciente) {this.Paciente = paciente;}
    
    //Método Que solicita datos
    public static boolean altaPaciente(String archivo) throws Exception
    {
        //Variables 
        String nombre, apellido,genero;
        String email;
        int id = 0, edad;
         int r=1;
        try
        { id += 1;
        do{  r=1;
            
            nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            apellido = JOptionPane.showInputDialog("Apellido del paciente:");
            email = JOptionPane.showInputDialog("Correo electrónico del paciente: ");
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del paciente:"));
            genero = JOptionPane.showInputDialog("Ingrese su género (F) para femenino y (M) para masculino:");
            if(nombre.isEmpty()||apellido.isEmpty()||email.isEmpty()||edad<0||edad>120||genero.isEmpty()){
                JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
           }
       } while(r==2);
            //Se crea el objeto 
            Paciente Paciente = new Paciente(id, nombre, apellido, edad, genero, email);
            //Se guardan los objetos del paciente en el archivo json
            guardaPaciente(Paciente, archivo);
            return true;
        }
        
        catch(Exception e)
        {throw new Exception("No se puede guardar el paciente");}
    }
    
    //Método para guardar los archivos en el Json
    public static void guardaPaciente(Paciente paciente, String archivo) throws Exception
    {
        String jsonPaciente;
        
        //Se convierte el objeto a JSON.
        Gson gson = new Gson();
        
        jsonPaciente = gson.toJson(paciente);
        System.out.println("Paciente JSON: " + jsonPaciente);
        try
        {
            FileWriter fileWriter = new FileWriter(archivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(jsonPaciente);
            printWriter.close();
        }
        catch (Exception e)
        {throw new Exception("Error de guardado");}
    }
    
    //Método para cargar el archivo
    public static void cargaPaciente(String archivo) throws Exception
    {
        try
        {
            File file = new File(archivo);
        
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();

            String cadena;

            while ((cadena = lector.readLine()) != null)
            {
                System.out.println(cadena);
                json.append(cadena);
            }

            Gson gson = new Gson();
           Paciente Paciente = gson.fromJson(json.toString(), Paciente.class);

            System.out.println("Paciente cargado");
        }
        
        catch (Exception e)
        {throw new Exception("Error de carga de datos");}
    }
}
