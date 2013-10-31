package mainModul;

import java.io.IOException;
import java.util.ArrayList;

import modul.Album;
import modul.BasicFile;
import modul.Foto;
import modul.User;

public interface system <T extends BasicFile>  {
	
	ArrayList<Foto> Photos = new ArrayList<Foto>();
	
	ArrayList<Album> Albums = new ArrayList<Album>();
	
	ArrayList<User> Users = new ArrayList<User>();
	
	void load (T obj, String path) throws IOException;
	
	void list(T obj) ;
	
	void add(T obj);
	
	void remove (T obj, String path);
	
	void modify (long id);
	
	void save (T obj, String path) throws IOException;

}
