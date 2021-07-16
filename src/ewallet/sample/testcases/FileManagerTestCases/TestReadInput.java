package ewallet.sample.testcases.FileManagerTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ewallet.sample.FileManager;

class TestReadInput {

	private FileManager fileManager;
	private static FileWriter tempFile;
	private JSONObject data;;
	File folder, fileUser, fileTransact, fileTest;
	JSONObject obj, obj2;
	@BeforeEach
	void setUp() throws Exception {
		fileManager = new FileManager();
		fileManager.createFolderFiles();
		folder = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "ewallet");
		fileUser = new File(folder + File.separator + "users.json");
		fileTransact = new File(folder + File.separator + "transactions.json");
		
		tempFile = new FileWriter(folder + File.separator + "testFile.json");
		try {
			obj = new JSONObject();
			obj.put("balance", 10000.0);
			obj.put("email", "test@email.com");
			tempFile.write(obj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tempFile.flush();
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		fileUser.delete();
		fileTransact.delete();
		fileTest.delete();
		folder.delete();
	}

	@Test
	void test() throws IOException {
		
		fileTest = new File(folder + File.separator + "testFile.json");
		data = fileManager.readInput(folder + File.separator + "testFile.json");
		tempFile = new FileWriter(folder + File.separator + "users.json");
		tempFile.write(data.toJSONString());
		tempFile.flush();
		
		boolean isEquals = FileUtils.contentEquals(fileUser, fileTest);
		assertEquals(true,isEquals);
	}

}
