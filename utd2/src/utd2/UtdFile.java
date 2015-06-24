package utd2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UtdFile {
	private String fileName;
	
	private List<String> lines;

	public UtdFile(String fileName) {
		this.fileName = fileName;
		this.lines = new ArrayList<>();
	}
	
	public void addLine(final String line) {
		this.lines.add(line);
	}
	
	private String getFileName() {
		return this.fileName;
	}
	
	public void write() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(this.getFileName(), StandardCharsets.UTF_8.name());
		
		for (String line : lines) {
			writer.println(line);
		}
		writer.close();
	}

	@Override
	public String toString() {
		return "UtdFile [fileName=" + fileName + ", lines=" + lines + "]";
	}
}
