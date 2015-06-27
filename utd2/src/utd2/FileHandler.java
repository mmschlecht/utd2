package utd2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	public static boolean checkFileName(final String fileName) {
		if (!fileName.toLowerCase().endsWith(".utd")) {
			return false;
		}

		return true;
	}

	public static List<UtdFile> handle(final List<String> lines) {
		final List<UtdFile> files = new ArrayList<>();

		UtdFile utdFile = null;
		for (final String line : lines) {
			if (line.startsWith("::BEGINFILE:")) {
				utdFile = new UtdFile(line.substring(12, line.length()).trim());
				files.add(utdFile);
				continue;
			}

			if (line.startsWith("::ENDFILE")) {
				continue;
			}

			utdFile.addLine(line);
		}

		return files;
	}

	public static List<String> read(final String filename) throws IOException {
		final Path path = Paths.get(filename);
		return Files.readAllLines(path, StandardCharsets.UTF_8);
	}
}
