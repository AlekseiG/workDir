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
		//���� ����. ������ ��� ���������� ������
	    StringBuilder sb = new StringBuilder();
	    File file = new File(srcFile);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	 
	    try {
	        //������ ��� ������ ����� � �����
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            //� ����� ��������� ��������� ����
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            //����� �� �������� ������� ����
	            in.close();
	        }
	    } finally {};
	     
	    //���������� ���������� ����� � �����
	    source = sb.toString();
    
    }
	
		
	public void setSourceFile (String fileName, String obj) throws IOException {
	    //���������� ����
	    File file = new File(fileName);
	 
	    try {
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        //PrintWriter ��������� ����������� ������ � ����
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //���������� ����� � ����
	            out.print(obj);
	        } finally {
	            //����� ���� �� ������ ������� ����
	            //����� ���� �� ����������
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		
	}


	
}
