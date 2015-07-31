package com.github.chat;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer
{
    private ServerSocket server;
    
    public void listen()
    {
        Socket socket = null;
        
        try
        {
            server = new ServerSocket(18080);
            System.out.println("Server started ... ...");
            
            while(true)
            {
                socket = server.accept();
                System.out.println("new connect ... ...");
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
        }
    }
    
    
    
	public static void main(String[] arguments)
	{
        ChatServer chat = new ChatServer();
        chat.listen();
	}
}

