package modul;



public class Photo extends BasicFile {
	int photoId;
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
		return photoId;
	}
	public void setFotoId(int fotoId) {
		this.photoId = fotoId;
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
