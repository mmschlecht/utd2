package utd2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UtdFile {

	private final String fileName;

	private List<String> lines;

	public UtdFile(final String fileName) {
		this.fileName = fileName;
		this.lines = new ArrayList<>();
	}

	public void addLine(final String line) {
		this.lines.add(line);
	}

	public List<String> getLines() {
		return this.lines;
	}

	public void setLines(final List<String> lines) {
		this.lines = lines;
	}

	public String getContent() {
		final StringBuilder content = new StringBuilder();

		for (final String line : this.getLines()) {
			content.append(line);
		}

		return content.toString();
	}

	private String getFileName() {
		return this.fileName;
	}

	@Override
	public String toString() {
		return "UtdFile [fileName=" + this.fileName + ", lines=" + this.lines + "]";
	}

	public void write() throws FileNotFoundException, UnsupportedEncodingException {
		final PrintWriter writer = new PrintWriter(this.getFileName(), StandardCharsets.UTF_8.name());

		for (final String line : this.getLines()) {
			writer.println(line);
		}

		writer.close();
	}
}
