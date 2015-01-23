package point3;

import static org.junit.Assert.*;

import org.junit.Test;

public class _Test {

	RecentFilesController recentFiles;

	@Test
	public void openedFile() {
		MyFile file = new MyFile("File 1");

		recentFiles = new RecentFilesController();

		recentFiles.fileOpened(file);

		assertTrue("File 1".equals(recentFiles.getFile(0).getName()));

		file = new MyFile("File 2");

		recentFiles.fileOpened(file);

		assertTrue("File 2".equals(recentFiles.getFile(0).getName()));

	}

	@Test
	public void openAlreadyStoredFile() {
		MyFile file1 = new MyFile("File 1");
		MyFile file2 = new MyFile("File 2");
		MyFile file3 = new MyFile("File 3");

		recentFiles = new RecentFilesController();

		recentFiles.fileOpened(file1);
		recentFiles.fileOpened(file2);
		recentFiles.fileOpened(file3);

		assertTrue("File 3".equals(recentFiles.getFile(0).getName()));

		recentFiles.fileOpened(file1);

		assertEquals(3, recentFiles.size());

		assertTrue("File 1".equals(recentFiles.getFile(0).getName()));

	}

	@Test
	public void addFileWithMaxCapacityReached() {
		
		recentFiles = new RecentFilesController();
		
		MyFile file1 = new MyFile("File 1");
		MyFile file2 = new MyFile("File 2");
		MyFile file3 = new MyFile("File 3");
		MyFile file4 = new MyFile("File 4");
		MyFile file5 = new MyFile("File 5");
		MyFile file6 = new MyFile("File 6");
		
		recentFiles.fileOpened(file1);
		recentFiles.fileOpened(file2);
		recentFiles.fileOpened(file3);
		recentFiles.fileOpened(file4);
		recentFiles.fileOpened(file5);
		recentFiles.fileOpened(file6);
		
		assertEquals(5, recentFiles.size());
		
		assertTrue(recentFiles.getFile(4).getName().equals("File 2"));
	}

}
