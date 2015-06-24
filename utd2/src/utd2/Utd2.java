package utd2;

import java.io.IOException;
import java.util.List;

public class Utd2 {

	public static void main(String[] args) throws IOException {
		if (args.length == 1 && ImportFileChecker.checkFileName(args[0])) {
			List<String> file = FileHandler.read(args[0]);
			List<UtdFile> utdFiles = FileHandler.fetchFiles(file);
			
			for (UtdFile utdFile : utdFiles) {
				System.out.println(utdFile.toString());
				utdFile.write();
			}
		} else {
			System.out.println("File name not valid");
		}
	}
}
