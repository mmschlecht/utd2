package utd2;

import java.io.IOException;
import java.util.List;

public class Utd2 {

	public static void main(final String[] args) throws IOException {
		if (args.length == 1 && FileHandler.checkFileName(args[0])) {
			final List<String> file = FileHandler.read(args[0]);
			final List<UtdFile> utdFiles = FileHandler.handle(file);

			for (final UtdFile utdFile : utdFiles) {
				LoopHandler.handle(utdFile);
				System.out.println(utdFile.toString());
				utdFile.write();
			}
		} else {
			System.out.println("File name not valid");
		}
	}
}
