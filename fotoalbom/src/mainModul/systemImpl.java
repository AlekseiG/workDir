package mainModul;

import java.io.IOException;
import modul.BasicFile;

public class systemImpl<T extends BasicFile>  implements system <T>{

	@Override
	public void load (T obj, String path) throws IOException {
	
		 obj.getSourceFile(path);

		
	}

	@Override
	public void list(T obj) {// ������ �� ����
		
		
	}

	@Override
	public void add(T obj) { // �������� � ����������
		//if () // � �� ������ ������, ��� �� ���
		
	}

	@Override
	public void remove(T obj, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(T obj, String path) throws IOException {
		obj.setSourceFile(path, obj.getSource());
		
	}
	
}
