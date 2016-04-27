package proxy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Proxy {

    Socket socket;
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        
        try { 
        // Instancia o ServerSocket ouvindo a porta 12345 
        ServerSocket servidor = new ServerSocket(12345); 
        System.out.println("Servidor ouvindo a porta 12345");
            while(true) {
            Socket cliente = servidor.accept(); 
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress()); 
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream()); 
            saida.flush();
            saida.writeObject(new Date()); 
            saida.close();
            cliente.close(); 
        }
        }catch(Exception e) { 
            System.out.println("Erro: " + e.getMessage());
        }
       
    } 


}
