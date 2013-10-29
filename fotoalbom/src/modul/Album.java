package modul;

import java.util.ArrayList;

public class Album extends BasicFile {
	ArrayList<Integer> userId;
	ArrayList<Integer> fotos; //in albom
	ArrayList<Integer> childAlboms; //including albom
	int albomId;
	int parentId;
	String description;
	int ownerId;
	String name;
	
	public ArrayList<Integer> getUserId() {
		return userId;
	}
	public void setUserId(ArrayList<Integer> userId) {
		this.userId = userId;
	}
	public ArrayList<Integer> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Integer> fotos) {
		this.fotos = fotos;
	}
	public ArrayList<Integer> getChildAlboms() {
		return childAlboms;
	}
	public void setChildAlboms(ArrayList<Integer> childAlboms) {
		this.childAlboms = childAlboms;
	}
	public int getAlbomId() {
		return albomId;
	}
	public void setAlbomId(int albomId) {
		this.albomId = albomId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}	
