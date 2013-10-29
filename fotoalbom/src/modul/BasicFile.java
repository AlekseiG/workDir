package modul;


import java.io.*;

public class BasicFile {
	String source;
	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public void getSourceFile (String srcFile) throws IOException {		
		//Этот спец. объект для построения строки
	    StringBuilder sb = new StringBuilder();
	    File file = new File(srcFile);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	 
	    try {
	        //Объект для чтения файла в буфер
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            //В цикле построчно считываем файл
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            //Также не забываем закрыть файл
	            in.close();
	        }
	    } finally {};
	     
	    //Возвращаем полученный текст с файла
	    source = sb.toString();
    
    }
	
		
	public void setSourceFile (String fileName, String obj) throws IOException {
	    //Определяем файл
	    File file = new File(fileName);
	 
	    try {
	        //проверяем, что если файл не существует то создаем его
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //Записываем текст у файл
	            out.print(obj);
	        } finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишеться
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		
	}


	
}
