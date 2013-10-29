package modul;
import java.io.IOException;

import mainModul.albumImpl;

public class myMain {
	public static void main (String[] args) {
		albumImpl Albom = new albumImpl();
		Foto foto = new Foto();
		try {
			Albom.load(foto, "C:\\Users\\Aleksei\\Documents\\workspace\\fotoalbom\\src\\test.txt");
			Albom.save(foto, "C:\\Users\\Aleksei\\Documents\\workspace\\fotoalbom\\src\\tmp\\test.txt");
			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
	

