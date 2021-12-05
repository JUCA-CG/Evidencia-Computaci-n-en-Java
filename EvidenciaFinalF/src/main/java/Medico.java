
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc_ca
 */


public class Medico extends Persona
{
    //Atributos del médico
    private String especialidad; 
    
    //Lista donde se guardarán todos los médicos
    private List <Medico> Medico;
  //Constructor para crear el médico 
    public Medico(int id,String nombre, String apellido,String especialidad,int edad) 
    {
        super(id,nombre, apellido,edad);
        this.especialidad = especialidad;
    }
    
    
    public Medico() {}
    
    //Métodos Get y Set 
    public String getEspecialidad() {return especialidad;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public List<Medico> getMedico() {return Medico;}
    public void setMedico(List<Medico> Medico) {this.Medico = Medico;}
    
    
       public static boolean altaDoctor(String archivoM) throws Exception
    {
        //Variables 
        
        String  nombre_medico, apellido_medico, especialidad;
        int id = 0,edad;
      int r=1;
        Medico Medico;
            
        try
        {
            id += 1;
            do{
            
            //Se piden los datos del medico
            r=1;
            
            nombre_medico  = JOptionPane.showInputDialog("Ingrese el nombre del Doctor:");
            apellido_medico = JOptionPane.showInputDialog("Ingrese el apellido del Doctor:");
            especialidad = JOptionPane.showInputDialog("Ingrese especialidad del doctor: ");
            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del doctor:"));
            if(nombre_medico.isEmpty()||apellido_medico.isEmpty()||especialidad.isEmpty()||edad<25||edad>100){
                JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
            }
       } while(r==2);
           
            //Se crea el objeto medico       
            Medico = new Medico(id,nombre_medico, apellido_medico,especialidad,edad);
            
            //Se guardan los objetos 
            guardaMedico(Medico, archivoM);
            return true;
        }
        
        catch(Exception e)
        {throw new Exception("No se puede guardar el paciente");}
    }
    
    //Método para guardar los datos
    public static void guardaMedico(Medico medico, String archivoM) throws Exception
    {
        String jsonMedico;
        
        //Se convierte el objeto a JSON.
        Gson gson = new Gson();
        
        jsonMedico = gson.toJson(medico);
        System.out.println("Medico JSON: " + jsonMedico);
        try
        {
            FileWriter fileWriter = new FileWriter(archivoM);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(jsonMedico);
            printWriter.close();
        }
        catch (Exception e)
        {throw new Exception("Error de guardado");}
    }
    
    //Método para cargar el archivo
    public static void cargaMedico(String archivoM) throws Exception
    {
        try
        {
            File file = new File(archivoM);
        
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();

            String cadena;

            while ((cadena = lector.readLine()) != null)
            {
                System.out.println(cadena);
                json.append(cadena);
            }

            Gson gson = new Gson();
           Medico Medico = gson.fromJson(json.toString(), Medico.class);

            System.out.println("Médico cargado");
        }
        
        catch (Exception e)
        {throw new Exception("Error de carga de datos");}
    }
}


