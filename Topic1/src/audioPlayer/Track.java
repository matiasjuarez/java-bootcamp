package audioPlayer;

import java.io.File;

public class Track {
	private String name;
	private File file;
	
	
	public Track(File file){
		this.setFile(file);
		this.name = file.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
