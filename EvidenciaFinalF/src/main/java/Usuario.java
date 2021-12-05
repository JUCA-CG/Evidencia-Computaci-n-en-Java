import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc_ca
 */
public class Usuario 
{
    //Atributos de la cita
    private static String ARCHIVOU = "Usuario.json";
    private  String user;
    private String contrasena;
  private static List <Usuario> usuarios = new ArrayList<>();
    //Lista que guardará todas las citas
    private List <Usuario> Usuario;

    //Constructor
    public Usuario ( String user, String contrasena) 
    {
        
        this.user = user;
        this.contrasena = contrasena;
      
    }
  

    //Métodos Get y Set 
   
    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}
    public String getContrasena() {return contrasena;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
     public List<Usuario> getUsuario() {return Usuario;}
    public void setUsuario(List<Usuario> Usuario) {this.Usuario = Usuario;}

     public static boolean AltaUsuario( String archivoU) throws Exception
    {
        //Variables 
        
        String user,contrasena ;
        
        
        Usuario Usuario;
        
        int r=1;
        try
        {
           
           
            //Se piden los datos del  nuevo user
            do{
                
            r=1;
            user  = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
            contrasena = JOptionPane.showInputDialog("Ingrese la contraseña del nuevo usuario:");     
           
            if(user.isEmpty()||contrasena.isEmpty()){
                JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
            }
       } while(r==2);
            //Se crea el objeto usuario      
                Usuario = new Usuario(user,contrasena);
                
          
            //Se guardan los objetos en archivo json
            guardaUsuario(Usuario, archivoU);
            return true;
        }
        
        catch(Exception e)
        {throw new Exception("No se puede guardar el paciente");}
    }
    
    //Método para guardar usuario
    public static void guardaUsuario(Usuario Usuario, String archivoU) throws Exception
    {
            String jsonUsuario;
        
        //Se convierte el objeto a JSON.
        Gson gson = new Gson();
        
            jsonUsuario = gson.toJson(Usuario);
        System.out.println("Usuario JSON: " + jsonUsuario);
        try
        {
            FileWriter fileWriter = new FileWriter(archivoU);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(jsonUsuario);
            printWriter.close();
        }
        catch (Exception e)
        {throw new Exception("Error de guardado");}
    }
   
    //Método para cargar archivo
    public static void CargaUsuario(String archivoU) throws Exception
    {
        try
        {
            File file = new File(archivoU);
        
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();

            String cadena;

            while ((cadena = lector.readLine()) != null)
            {
                System.out.println(cadena);
                json.append(cadena);
            }

            Gson gson = new Gson();
          Usuario Usuario = gson.fromJson(json.toString(), Usuario.class);
        }
        
        catch (Exception e)
        {throw new Exception("Error de carga de datos");}
    }

}


