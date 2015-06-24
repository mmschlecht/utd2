package utd2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	public static List<UtdFile> fetchFiles(List<String> file) {
		List<UtdFile> files = new ArrayList<>();
		
		UtdFile utdFile = null;
		for (String line : file) {
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

	public static List<String> read(String filename) throws IOException {
	    Path path = Paths.get(filename);
	    return Files.readAllLines(path, StandardCharsets.UTF_8);
	}
}
