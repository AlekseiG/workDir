package modul;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import xmlStorage.Storage;
import mainModul.SystemImpl;

public class myMain {
	public static void main (String[] args) {
		SystemImpl mySystem = new SystemImpl();
		Storage myStorage = new Storage();
		Album myAlbum = new Album();
		myStorage.XmlRW("C:\\Users\\Aleksei\\Documents\\workspace\\fotoalbom\\src\\albom.xml");
		java.util.List<?>  myList  = new ArrayList<Album>();
		//myList  = 	myStorage.find("lol", "Album");
		myList  = 	myStorage.ls( "Album");
		myStorage.myWrite("C:\\Users\\Aleksei\\Documents\\workspace\\fotoalbom\\src\\storage.xml"); 
	}
}
	

