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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

public class cita 
{
    //Atributos de la cita
    private int id;
    private String fecha;
    private String hora;
    private String motivo;
    private int idMedico;
    private int idPaciente;
    //Lista que guardará todas las citas
    private List <cita> cita;

    //Constructor
    public cita(int id,int idPaciente,int idMedico,String fecha, String hora, String motivo) 
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.cita = cita;
    }


    //Métodos Get y Set
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
    public String getMotivo() {return motivo;}
    public void setMotivo(String motivo) {this.motivo = motivo;}
    public int getMedico() {return idMedico;}
    public void setMedico(int Medico) {this.idMedico = idMedico;}
    public int getPaciente() {return idPaciente;}
    public void setPaciente(int Paciente) {this.idPaciente = idPaciente;}
    public List<cita> getCita() {return cita;}
    public void setCita(List<cita> cita) {this.cita = cita;}
    
    //Método para dar de alta una cita
     public static boolean altaCita(String archivoC) throws Exception
    {
        //Variables 
        
        String fecha, hora, motivo ;
        int id = 0, idPaciente, idDoctor;
        int r=1;
        cita Cita;
            
        try
        {do{
              r=1;
        
            id =+1;
            idPaciente  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del paciente:"));
            idDoctor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del doctor:"));
            fecha = JOptionPane.showInputDialog("Ingrese la fecha en formato : DD/MM/AA doctor: ");
            hora = JOptionPane.showInputDialog("Ingrese la hora de cita en formato 24 horas (HH:MM");
            motivo = JOptionPane.showInputDialog("Ingrese el motivo de la cita ");
            if(idPaciente<0||idDoctor<0||fecha.isEmpty()||hora.isEmpty()||hora.isEmpty()||motivo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
            }
            } while(r==2);
           
            //Se crea el objeto      
            Cita = new cita( id,idPaciente, idDoctor, fecha, hora, motivo );
            
          
          
            //Se guardan los objetos n
            guardaCita(Cita, archivoC);
            return true;
        }
        
        catch(Exception e)
        {throw new Exception("No se puede guardar el paciente");}
    }
    
    //Método para guardar los datos
    public static void guardaCita(cita Cita, String archivoC) throws Exception
    {
        String jsonCita;
        
        //Se convierte el objeto a JSON.
        Gson gson = new Gson();
        
        jsonCita = gson.toJson(Cita);
        System.out.println("Cita JSON: " + jsonCita);
        try
        {
            FileWriter fileWriter = new FileWriter(archivoC);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(jsonCita);
            printWriter.close();
        }
        catch (Exception e)
        {throw new Exception("Error de guardado");}
    }
    
    //Método para cargar archivo 
    public static void cargaCita(String archivoC) throws Exception
    {
        try
        {
            File file = new File(archivoC);
        
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();

            String cadena;

            while ((cadena = lector.readLine()) != null)
            {
                System.out.println(cadena);
                json.append(cadena);
            }

            Gson gson = new Gson();
           cita Cita = gson.fromJson(json.toString(), cita.class);

            System.out.println("Cita cargado");
        }
        
        catch (Exception e)
        {throw new Exception("Error de carga de datos");}
    }
}


