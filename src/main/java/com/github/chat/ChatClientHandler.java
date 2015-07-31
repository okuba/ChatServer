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
    private int clientNumber;
	
	 /**
 	 * コンストラクタ
	 */	
	ChatClientHandler(Socket socket, ArrayList<ChatClientHandler> clients)
	{
		this.socket = socket;
		this.clients = clients;
		this.name = "undefiend"+(clients.size()+1);
        this.clientNumber = clients.size();
	}

	/**
	* コマンドを受け付け, 対応する各処理を行う.
	*/
	public void run()
	{
		try
		{
			open();
			
			while (true)
			{
				String message = receive();
                String[] commands = message.split(" ");
                if (commands[0].equalsIgnoreCase("bye"))
                {
                    bye();
                }
				else if (commands[0].equalsIgnoreCase("post"))
				{
					post(commands[1]);
				}
                else if (commands[0].equalsIgnoreCase("name"))
                {
                    name(commands[1]);
                }
			}
		}
		catch (IOException anException)
		{
		}		
		finally
		{
			close();
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
	
	/**
	* ストリームとソケットを閉じる.
	*/
	public void close()
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
	/**
		* 他のクライアント全てに指定したメッセージを送信する.
		*/
	public void post(String message) throws IOException
	{
		ArrayList<ChatClientHandler> allClientHandler = new ArrayList<ChatClientHandler>();
		
		for (ChatClientHandler clientHandler: clients)
		{
			if (clientHandler	!= this)
			{
				clientHandler.send("["+this.getClientName()+"]"+message);
			}
		}
	}
	
    public void bye() throws IOException
    {
        for (ChatClientHandler aHandler: clients)
        {
            if (aHandler != this)
            {
                aHandler.send("["+this.getClientName()+"]leaved");
            }
        }
        clients.remove(this.clientNumber);
        close();
    }
    
    /**
     *名前を取得する.
     */
	public String getClientName()
    {
        return name;
    }
    
    /**
     *名前を変更する.
     */
    public void setClientName(String setName)
    {
        this.name = setName;
    }
    
	/**
	* メッセージを受け取ったときに表示し, その文字列を返す.
	*/
	String receive() throws IOException
	{
		String line = in.readLine();
		System.out.println(line);

		return line;
	}
	
	/**
	* メッセージを送信する.
	*/
	void send(String message) throws IOException
	{
		out.write(message);
		out.write("\r\n");
		out.flush();
	}

    /**
     *名前を付ける.
     */
    public void name(String name) throws IOException
    {
        String beforeName = getClientName();
        
        for (ChatClientHandler aHandler: clients)
        {
            if ((aHandler.getClientName()).equals(name))
            {
                if(aHandler != this)
                {
                    this.send("同じ名前のクライアントが存在します");
                    this.setClientName(beforeName);
                    break;
                }
            }
            else
            {
                setClientName(name);
                this.send("["+getClientName()+"]に名前を変更");
            }
        }
    }
}