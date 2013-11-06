package modul;



public class Foto extends BasicFile {
	int fotoId;
//	String[] tags;
	String owner;
	int albomId;
	String path;
	String text;
	String Name;

	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getFotoId() {
		return fotoId;
	}
	public void setFotoId(int fotoId) {
		this.fotoId = fotoId;
	}
	public int getAlbomId() {
		return albomId;
	}
	public void setAlbomId(int albomId) {
		this.albomId = albomId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}


	
}
