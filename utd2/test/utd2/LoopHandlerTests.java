package utd2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class LoopHandlerTests {

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

		final List<String> lines = file.getLines();
		assertEquals(13, lines.size());

		assertEquals("out", lines.get(0));
		assertEquals("inloop1", lines.get(1));
		assertEquals("inloop2", lines.get(2));
		assertEquals("inloop2", lines.get(3));
		assertEquals("inloop2", lines.get(4));
		assertEquals("inloop1", lines.get(5));
		assertEquals("inloop2", lines.get(6));
		assertEquals("inloop2", lines.get(7));
		assertEquals("inloop2", lines.get(8));
		assertEquals("inloop1", lines.get(9));
		assertEquals("inloop2", lines.get(10));
		assertEquals("inloop2", lines.get(11));
		assertEquals("inloop2", lines.get(12));
	}
}
