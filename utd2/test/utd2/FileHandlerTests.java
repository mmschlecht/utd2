package utd2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileHandlerTests {

	@Test
	public void testCheckFileName() {
		assertFalse(FileHandler.checkFileName(""));
		assertFalse(FileHandler.checkFileName("filename"));
		assertFalse(FileHandler.checkFileName("filename.csv"));
		assertTrue(FileHandler.checkFileName("filename.utd"));
		assertTrue(FileHandler.checkFileName("filename.UTD"));
	}

	@Test
	public void testHandle() {
		final UtdFile file = new UtdFile("testfile.utd");
		file.addLine("out");
		file.addLine("::BEGINLOOP:3");
		file.addLine("inloop1");
		file.addLine("::BEGINLOOP:3");
		file.addLine("inloop2");
		file.addLine("::ENDLOOP");
		file.addLine("::ENDLOOP");

		LoopHandler.handle(file);

		assertEquals(13, file.getLines().size());
	}
}
