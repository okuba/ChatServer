package com.github.chat;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer
{
    private ServerSocket server;
    private ArrayList<ChatClientHandler> clients = new ArrayList<ChatClientHandler>();
    
    private BufferedReader in;
    private BufferedWriter out;
    
    
    public void listen()
    {
        Socket socket = null;
        ChatClientHandler handler = null;
        
        try
        {
            server = new ServerSocket(18080);
            System.out.println("Server started ... ...");
            
            while(true)
            {
                socket = server.accept();
                System.out.println("new connect ... ...");
                handler = new ChatClientHandler(socket,clients);
                
                clients.add(handler);
                handler.start();
            }
        }
        catch(IOException anException)
        {
            anException.printStackTrace();
        }
        finally
        {
            if(socket != null)
            {
                try
                {
                    socket.close();
                }
                catch(IOException anException)
                {
                    anException.printStackTrace();
                }
            }
            if(handler != null)
            {
                handler.close();
            }
        }
    }
    
    
    
	public static void main(String[] arguments)
	{
        ChatServer chat = new ChatServer();
        chat.listen();
	}
}

