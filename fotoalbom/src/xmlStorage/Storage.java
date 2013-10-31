package xmlStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import modul.Album;
import modul.BasicFile;
import modul.Foto;
import modul.User;

public class Storage {
	
	static Map<Long, Foto> fotos;	
	static Map<Long, Album> albums;
	static Map<String, User> users;
	
	public static String EMPLOYEE_ROOT = "Tables";
	public static String EMPLOYEE_ELEMENT = "Employees";	

	public List<?> find(String query, String cl){			
		if(cl.equals("Foto")){
			List<Foto> l = new ArrayList<Foto>();		
			try{
				Pattern p = Pattern.compile(".*" + query + ".*");		
				for(Map.Entry<Long, Foto> i:  fotos.entrySet()){
					if (checkAccordance(i.getValue().getName(), p)){
						l.add(i.getValue()); 
					}
				}
				return l;
			}catch(Exception e){
				System.err.println("illegal pattern");
				Foto emp = new Foto();			
				emp.setName("NO ONE");
				l.add(emp);
				return l;
			} 
		} else if(cl.equals("Album")){
			List<Album> l = new ArrayList<Album>();		
			try{
				Pattern p = Pattern.compile(".*" + query + ".*");		
				for(Entry<Long, Album> i:  albums.entrySet()){
					if (checkAccordance(i.getValue().getName(), p)){
						l.add(i.getValue()); 
					}
				}
				return l;
			}catch(Exception e){
				System.err.println("illegal pattern");
				Album c = new Album();			
				c.setName("NO");
				l.add(c);
				return l;
			} 
		
		} else if(cl.equals("User")){
			List<User> l = new ArrayList<User>();		
			try{
				Pattern p = Pattern.compile(".*" + query + ".*");		
				for(Entry<String, User> i:  users.entrySet()){
					if (checkAccordance(i.getValue().getFIO(), p)){
						l.add(i.getValue()); 
					}
				}
				return l;
			}catch(Exception e){
				System.err.println("illegal pattern");
				User c = new User();			
				c.setFIO("NO");
				l.add(c);
				return l;
			}		 		
		}
		return null;
	}
	
	public void add(){
		try{
			Employee e = new Employee();
			Scanner s = new Scanner(System.in);
			e.setId(""+Employee.nextId());				
			e.setFirstName(s.next());
			e.setLastName(s.next());
			e.setDepartmentId(s.next());
			e.setNumber(s.next());
			e.setJobId(s.next());
			e.setSalary(""+s.nextInt());
			employees.put(e.getId(),e);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void edit(long id){
		try{
			Employee e = employees.get(id);
			Scanner s = new Scanner(System.in);
			//e.setId(id);				
			e.setFirstName(s.next());
			e.setLastName(s.next());
			e.setDepartmentId(s.next());
			e.setNumber(s.next());
			e.setJobId(s.next());
			e.setSalary(""+s.nextInt());
			//Employees.put(e.getId(),e);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void del(long id){
		employees.remove(id);
	}
	
	private boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if(inputString == null && pattern == null)
            return true;
        if (inputString == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        return pattern.matcher(inputString).matches();
    }		
		

	}
	

	
}
	