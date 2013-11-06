package modul;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

import xmlStorage.Storage;

public class Album extends BasicFile {
	long userId;
	ArrayList<Integer> fotos; //in albom
	ArrayList<Integer> childAlboms; //including albom
	long albomId;
	long parentId;
	String description;
//	long ownerId;
	String name;
	

	public long getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		long val = Long.parseLong(userId);	
		this.userId = val;	
	}
	public ArrayList<Integer> getFotos() {
		return fotos;
	}
	public void setFotos(String fotos) {
		
		
		//this.fotos = fotos;
	}
	public ArrayList<Integer> getChildAlboms() {
		return childAlboms;
	}
	public void setChildAlboms(ArrayList<Integer> childAlboms) {
		this.childAlboms = childAlboms;
	}
	public long getAlbomId() {
		return albomId;
	}
	public void setAlbomId(String albomId) {
		long val = Long.parseLong(albomId);	
		this.albomId = val;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		long val = Long.parseLong(parentId);	
		this.parentId = val;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
