package utd2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ImportFileCheckerTests {
	
	@Test
	public void testCheckFileName() {
		assertFalse(ImportFileChecker.checkFileName(""));
		assertFalse(ImportFileChecker.checkFileName("filename"));
		assertFalse(ImportFileChecker.checkFileName("filename.csv"));
		assertTrue(ImportFileChecker.checkFileName("filename.utd"));
		assertTrue(ImportFileChecker.checkFileName("filename.UTD"));
	}
}
