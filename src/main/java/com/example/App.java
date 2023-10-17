package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         try{
            ServerSocket server = new ServerSocket(3000);
            System.out.print("creo il server\n");
            Socket s = server.accept();
            System.out.print("creo la socket\n");        

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out =  new DataOutputStream(s.getOutputStream());

            int random = (int)(Math.random()*100+1);
            System.out.println(random);
            int n = 0;
            int cont = 0;
            do{

                int ret = 0;
                n = Integer.parseInt(in.readLine());
                if(n < random)
                    ret = 1;
                else if(n > random)
                    ret = 2;
                else 
                    ret = 3;
                out.writeBytes(ret + "\n"); 

                cont++;
            }while(random != n);

            out.writeBytes(cont + "\n");

            server.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
