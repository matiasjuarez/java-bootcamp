package point3;

import java.util.LinkedList;

public class RecentFilesController {
	private LinkedList<MyFile> recentFiles = new LinkedList<MyFile>();
	private int maxCapacity;

	public RecentFilesController() {
		maxCapacity = 5;
	}

	// This method is called when a file is opened
	public void fileOpened(MyFile file) {

		// If the file we are opening, we remove that file from the recentFiles
		// list and we add it again at the beginning of the list
		for (MyFile _file : recentFiles) {
			if (_file.getName().equals(file.getName())) {
				recentFiles.remove(_file);
				break;
			}
		}

		// If the list has reached its max capacity, we remove the last item
		if (recentFiles.size() == maxCapacity)
			recentFiles.removeLast();

		recentFiles.addFirst(file);

	}

	public MyFile getFile(int index) {
		return recentFiles.get(index);
	}

	public Object size() {
		return recentFiles.size();
	}

}
