package com.github.chat;

import java.io.*;
import java.net.*;
import java.util.*;

/**
* サーバのハンドラを作成し, 複数のクライアントに対応する.
*/
class ChatClientHandler extends Thread
{
	ArrayList<ChatClientHandler> clients = new ArrayList<ChatClientHandler>();
	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	String name;
	
	 /**
 	 * コンストラクタ
	 */	
	ChatClientHandler(Socket socket, ArrayList<ChatClientHandler> clients)
	{
		this.socket = socket;
		this.clients = clients;
		this.name = "undefiend"+(clients.size()+1);
	}


	/**
	* コマンドを受け付け, 対応する各処理を行う.
	*/
	public void run()
	{
		try
		{
			open();
		}
		catch (IOException anException)
		{
		}		
		finally
		{
			if (in != null)
			{
				try
				{ 
					in.close();
				}
				catch (IOException anException)
				{
					anException.printStackTrace();
				}
			} 
			if (out != null)
			{
				try
				{
					out.close();
				}
				catch (IOException anException)
				{
					anException.printStackTrace();
				}
			}
			if (socket != null)
			{
				try
				{
					socket.close();
				}
				catch (IOException anException)
				{
					anException.printStackTrace();
				}
			}
		}
	}
	
	/**
	* 読み込むための準備をする.
	*/
	void open() throws IOException
	{
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
}