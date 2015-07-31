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
	String name;
	
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

	}
}