package xmlStorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modul.Album;
import modul.Foto;
import modul.User;



public class Storage {
	
	static Map<Long, Foto> photos;	
	static Map<Long, Album> albums;
	static Map<Long, User> users;
	
	public static String ROOT = "Tables";
	public static String ALBUM_ELEMENT = "Albums";	
	public static String USER_ELEMENT = "User";
	public static String Photo_ELEMENT = "Photo";	

	public List<?> ls(String cl){
		if(cl.equals("Photo")){
			List<Foto> l = new ArrayList<Foto>();		
			try{			
				for(Map.Entry<Long, Foto> i:  photos.entrySet()){
						l.add(i.getValue()); 
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
				for(Entry<Long, Album> i:  albums.entrySet()){
						l.add(i.getValue()); 
				}
				return l;
			}catch(Exception e){
				System.err.println("illegal pattern");
				Album c = new Album();			
				c.setName("NO ONE");
				l.add(c);
				return l;
			} 
		
		} else if(cl.equals("User")){
			List<User> l = new ArrayList<User>();		
			try{	
				for(Entry<Long, User> i:  users.entrySet()){
						l.add(i.getValue()); 
				}
				return l;
			}catch(Exception e){
				System.err.println("illegal pattern");
				User c = new User();			
				c.setFIO("NO ONE");
				l.add(c);
				return l;
			}		 		
		}
		return null;
	}
	
	public List<?> find(String query, String cl){			
		if(cl.equals("Photo")){
			List<Foto> l = new ArrayList<Foto>();		
			try{
				Pattern p = Pattern.compile(".*" + query + ".*");		
				for(Map.Entry<Long, Foto> i:  photos.entrySet()){
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
				for(Entry<Long, User> i:  users.entrySet()){
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
	
	/*public void add(){
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
	*/
	public void del(long id){
	//	employees.remove(id);
	}
	
	private boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if(inputString == null && pattern == null)
            return true;
        if (inputString == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        return pattern.matcher(inputString).matches();
    }		

	public static void fillAlbum(Map<Long, Album> alb){
		albums = alb;
	
	}

	public static void fillUser(Map<Long, User> usr){
		users = usr;
	
	}
	
	public static Set<Entry<Long, Album>> getAlbum(){
		return albums.entrySet();
	}
	
	public void myWrite(String fileName){
		 Document doc = null;       
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
	        try {
	            DocumentBuilder db = factory.newDocumentBuilder();
	            DOMImplementation domImplementation = db.getDOMImplementation();
	            doc = domImplementation.createDocument(null, "Tables", null);
	            
	            buildTree(doc, doc.getDocumentElement());
	            
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            
	            Properties transfProps = new Properties();
	            transfProps.put("method", "xml");
	            transfProps.put("indent", "yes");
	            transformer.setOutputProperties(transfProps);
	            
	            DOMSource source = new DOMSource(doc);
	            OutputStream out = new FileOutputStream(new File(fileName));
	            StreamResult result =  new StreamResult(out);
	            //StreamResult result =  new StreamResult(System.out);
	            transformer.transform(source, result);
	            try {
	                out.close();
	            } catch (Exception ex) {}            
	        } catch (Exception ex) {
	            System.err.println("XML error\n"+ex.toString());
	        }		
	}	
	
	
	
	private Element createElement(Document doc, String name, String textContent) {
		Element elem = doc.createElement(name);        
       if(textContent!=null)
           elem.setTextContent(textContent);
       return elem;
   }
	private Element createXmlObj(Document doc, String root, String[] args, String ... values){
		Element e = createElement(doc, root, null);
		for(int i = 0; i < args.length; i++){
			e.appendChild(createElement(doc, args[i], values[i]));
		}
		return e;
	}	
	private Document docInit(String fileName){
		try{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch(Exception e){
			return null;
		}
		
	}
	
	public void XmlRW (String fileName){	
		Document doc =  docInit(fileName);
		if (!doc.getDocumentElement().getNodeName().equals(Storage.ROOT)){ 
			System.err.println("root must be <Tables>");
		}
		NodeList fLevelNodes = doc.getChildNodes();
		
		NodeList nList = fLevelNodes.item(0).getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) { 
			if (nList.item(i).getNodeName().equals(Storage.ALBUM_ELEMENT)){
				nList = nList.item(i).getChildNodes();				
			}
		}
		Storage.fillAlbum(fillAlb(nList));			
		
	}
	
	
	
	private Map<Long, Album> fillAlb(NodeList nList){
		Map<Long, Album> alb = new HashMap<Long, Album>();
		Album e;		

		for (int i = 0; i < nList.getLength(); i++) {
			if (nList.item(i).getNodeName().equals("Album")){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new Album();
					Element eElement = (Element) nNode;		     			      		
					e.setUserId(getTagValue("userId", eElement));		      
					e.setAlbomId(getTagValue("albomId", eElement));	
					e.setName(getTagValue("Name", eElement));	
					e.setParentId(getTagValue("parentId", eElement));	
					e.setDescription(getTagValue("description", eElement));
					//e.setFotos("Fotos", eElement);
					//e.setChildAlboms;(getTagValue("description", eElement));		
					alb.put(e.getAlbomId(),e);
				}				
			} 
	    }
		return alb;
	}
	private static String getTagValue(String sTag, Element eElement) {
		try{
			NodeList nList = eElement.getChildNodes(); 		
			for (int i = 0; i < nList.getLength(); i++){
				if (nList.item(i).getNodeName().equals(sTag)){
					return nList.item(i).getChildNodes().item(0).getNodeValue(); 
				}	
			}	
			return null; 
		}catch (Exception e){
			return null;
		}       
	}
	
	
	private void buildTree(Document doc, Element root) {
        // setting up document
        doc.setXmlStandalone(true);
        doc.setStrictErrorChecking(true);
        doc.setXmlVersion("1.0");
        
        Element subRoot = createElement(doc, "Employees", null);       
        Element e;
        
        for(Map.Entry<Long, Album> i:  Storage.getAlbum()){	
        	String[] args = {"userId", "albomId", "Name",
        			"parentId", "description"};
        	e = createXmlObj(doc,"Employee", args, 
        			((Long)i.getValue().getUserId()).toString(),
        			((Long)i.getValue().getAlbomId()).toString(),
        			i.getValue().getName(),
        			((Long)i.getValue().getParentId()).toString(),
        			i.getValue().getDescription());
        	subRoot.appendChild(e); 
		}	  
        root.appendChild(subRoot);
        
   /*     subRoot = createElement(doc, "Countries", null);   
        for(Map.Entry<String, Country> i: Storage.getCountries()){
        	String[] args = {"CountryId", "CountryName", "RegionId"};
        	e = createXmlObj(doc,"Country", args,
        			i.getValue().getCountryId(),
        			i.getValue().getCountryName(),
        			((Long)i.getValue().getRegionId()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Locations", null);   
        for(Entry<Long, Location> i: Storage.getLocations()){
        	String[] args = {"LocationId", "Adress", "City","CountryId","PostalCode"};
        	e = createXmlObj(doc,"Location", args,
        			((Long)i.getValue().getLocationId()).toString(),
        			i.getValue().getAdress(),
        			i.getValue().getCity(),
        			i.getValue().getCountryId(),
        			i.getValue().getPostalCode());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Departments", null);   
        for(Entry<Long, Department> i: Storage.getDepartments()){
        	String[] args = {"DepId", "LocationId", "ManagerId","Name"};
        	e = createXmlObj(doc,"Department", args,
        			((Long)i.getValue().getDepId()).toString(),
        			((Long)i.getValue().getLocationId()).toString(),
        			((Long)i.getValue().getManagerId()).toString(),
        			i.getValue().getName());        			
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Jobs", null);   
        for(Entry<String, Job> i: Storage.getJobs()){
        	String[] args = {"JobId", "JobTitle", "MaxSalary","MinSalary"};
        	e = createXmlObj(doc,"Job", args,
        			i.getValue().getJobId(),
        			i.getValue().getJobTitle(),
        			((Long)i.getValue().getMaxSalary()).toString(),
        			((Long)i.getValue().getMinSalary()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        */
    }	
}
	