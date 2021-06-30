package ewallet.sample.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ewallet.sample.FileManager;

class testFileManager {

	private FileManager fileManager;
	File folder, fileUser, fileTransact;
	@BeforeEach
	void setUp() throws Exception {
		fileManager = new FileManager();
		fileManager.createFolderFiles();
		folder = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "ewallet");
		fileUser = new File(folder + File.separator + "users.json");
		fileTransact = new File(folder + File.separator + "transactions.json");
	}

	@AfterEach
	void tearDown() throws Exception {
		fileUser.delete();
		fileTransact.delete();
		folder.delete();
	}

	@Test
	@DisplayName("Ensure Folder is created")
	void testCreateFolder() {
		assertTrue(folder.exists());
	}
	
	@Test
	@DisplayName("Ensure File is created")
	void testCreateFileUser() {
		assertTrue(fileUser.exists());
	}
	
	@Test
	@DisplayName("Ensure File is created")
	void testCreateFileTransact() {
		assertTrue(fileTransact.exists());
	}
}
