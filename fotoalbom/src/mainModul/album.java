package mainModul;

import java.io.IOException;

import modul.BasicFile;

public interface album <T extends BasicFile>  {
	
	void load (T obj, String path) throws IOException;
	
	void list(T obj) ;
	
	void add(T obj);
	
	void remove (T obj, String path);
	
	void modify (long id);
	
	void save (T obj, String path) throws IOException;

}
