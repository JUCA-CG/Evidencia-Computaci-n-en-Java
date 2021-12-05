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
import java.io.FileReader;


public class Main
{
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)); 
    //Método main
    
   public static List<Usuario> usuarios;
    public static void main (String[] args) throws Exception
    {
        
        try
        {
            
            //Variables
          
            String user;
            String contrasena;
           
            System.out.println("****BIENVENIDO AL SISTEMA ADMINISTRADOR DE CITAS****");
            //Se especifican constantes para los archivos donde se almacenaran los datos
            String ARCHIVO = "pacientes.json";
            String ARCHIVOM = "medicos.json";
            String ARCHIVOC = "citas.json";
            String ARCHIVOU = "usuarios.json";
           
                //Se piden las credenciales 
                 int r=1;
               do{
               user= JOptionPane.showInputDialog("Introduzca su usuario:");
             
               contrasena = JOptionPane.showInputDialog("Introduzca su contraseña:");

            String us ="";
            try{
            BufferedReader leer = new BufferedReader(new FileReader(ARCHIVOU));
           String linea;
            while((linea = leer.readLine()) != null){
                us+= linea;
            } 
            }catch(FileNotFoundException ex){
    
           }
            //System.out.print(us);
            String usc ="\"user\":";
            String pass ="\"contrasena\":";
            String compara  = "{"+usc+"\""+user+"\","+pass+"\""+contrasena+"\""+"}";
                   
            //System.out.print(compara);
            if(us.equals(compara)){
                menu(user, ARCHIVO,ARCHIVOM,ARCHIVOC,ARCHIVOU,contrasena);
            }
            else{
           JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos,vuelve a intentar");
          r=2;
              
            }
          
           
 } while(r==2);
            System.out.println("Gracias por utilizar el programa");
        }

        catch (Exception e)
        {
            //Muestra al usuario que ha ocurrido un error y que se terminará el programa
            JOptionPane.showMessageDialog(null, "Ha ocurrido el error: " + e + "," + "\nFinalizando programa..."
                    , "El programa será finalizado", JOptionPane.ERROR_MESSAGE);
            //Se muestra en consola que el programa ha concluido
            System.out.println("\nPrograma finalizado. Ejecuta nuevamente el programa "
                    + "y vuelve a intentarlo.\n");
        }
    }

    public static void menu(String usuario, String archivo,String archivoM, String archivoC, String archivoU,String contrasena) throws Exception
    {
        boolean s =true;
         String opciones ;
         int m=0;
         int r=1;
        try
        {  do{
            do{
            r=1;
            opciones =(JOptionPane.showInputDialog( "¡Hola! " + usuario +  "Menú principal presiona:\n(1)Pacientes\n"
                    + "(2)Doctores \n(3)Citas\n(4) Registrar un nuevo usuario\n(0) Salir del sistema"));
             if(opciones.isEmpty())
               { JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;

             }
              }while(r==2);
            String opcion2;
           
            switch (opciones){
                case "0":
                    System.out.println("Haz elegido salir\n Gracias por utilizar el sistema");
                    m=5;
                    s = false;
                    break;
                case "1":
                     do{
                     r=1;
                opcion2 =(JOptionPane.showInputDialog(  "Menú paciente presiona:\n(a)Para registrar un paciente\n"
                    + "(b)Para imprimir los pacientes."));
               
                if(opcion2.isEmpty())
               { JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
             }
              }while(r==2);
                switch (opcion2){
                    //
                    case "a":
                      
                     System.out.println("Creando el paciente..." + Paciente.creaPaciente(archivo));
                     break;
                     //
                    case "b":
                     Paciente.cargaPaciente(archivo);
                     break;
                     default:
                      System.out.println("Selecciona una opción válida");  
                 
                } 
                break;
                //
                case "2":
                     do{
                     r=1;
                    opcion2 =(JOptionPane.showInputDialog(  "Menú doctores presiona:\n(a)Para registrar un doctor\n"
                    + "(b)Para imprimir los doctores."));
                   
                if(opcion2.isEmpty())
               { JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
             }
              }while(r==2);
                    switch (opcion2){
                    //
                    case "a":
                    System.out.println("Creando Doctor..." + Medico.altaDoctor(archivoM));
                      break;
                      //
                    case "b":
                        Medico.cargaMedico(archivoM);
                     break;
                     default:
                      System.out.println("Selecciona una opción válida"); 
                
                }  
                    break;
                    //
                case "3":
                do{
                     r=1;
                    opcion2 =(JOptionPane.showInputDialog(  "Menú Citas presiona:\n(a)Para registrar una cita\n"
                    + "(b)Para imprimir las citas."));
                    
                if(opcion2.isEmpty())
               { JOptionPane.showMessageDialog(null, "Te han faltado datos, o haz ingresado datos erroneos");
                r=2;
             }
              }while(r==2);
                    switch (opcion2){
                    //
                    case "a":
                     System.out.println("Creando cita..." +cita.altaCita(archivoC));
                      break;
                      //
                    case "b":
                     cita.cargaCita(archivoC);
                     break;
                     default:
                      System.out.println("Selecciona una opción válida"); 
                
                }
                    break;
                    //
                case "4":
                {
                    System.out.println("Creando usuario..." +Usuario.AltaUsuario(archivoU));
                    
                 break;
               
        }
                default:
                   System.out.println("Se selecciono una opción inválida"); 
                 m = 1;
        }
            if(s==true){
          int o=  Integer.parseInt(JOptionPane.showInputDialog("Presione (1) para volver a elegir una opción del menú o cualquier otra para salir"));
          if(o==1){
              m=1;
          }
            }}while(m==1);}
        catch(Exception e)
        {
            throw new Exception("Error en el proceso de ejecución del menú");
        }}
    }
    


