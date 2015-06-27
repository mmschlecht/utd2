package utd2;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class LoopHandler {
	private static boolean checkValidity(final UtdFile file) {
		final String content = file.getContent();
		return StringUtils.countMatches(content, "::BEGINLOOP") == StringUtils.countMatches(content, "::ENDLOOP");
	}

	public static void handle(final UtdFile file) {
		if (checkValidity(file)) {
			int loops = StringUtils.countMatches(file.getContent(), "::BEGINLOOP");

			while (loops > 0) {
				replaceLastLoop(file, loops);
				loops--;
			}
		} else {
			System.out.println("Loop structure not valid");
		}
	}

	private static void replaceLastLoop(final UtdFile file, final int loops) {
		int loopIndex = 0;
		int max = 0;
		final List<String> loop = new ArrayList<>();
		final List<String> lines = new ArrayList<>();

		for (final String line : file.getLines()) {
			if (line.startsWith("::BEGINLOOP")) {
				loopIndex++;

				if (loopIndex != loops) {
					lines.add(line);
				} else {
					max = max(line);
				}

				continue;
			}

			if (loopIndex == loops) {
				if (!line.startsWith("::ENDLOOP")) {
					loop.add(line);
				} else {
					loopIndex--;

					for (int n = 0; n < max; n++) {
						lines.addAll(loop);
					}
				}

				continue;
			}

			lines.add(line);
		}

		file.setLines(lines);
	}

	private static int max(final String line) {
		final String[] strings = StringUtils.split(line, ":");

		if (strings.length >= 2) {
			return Integer.valueOf(strings[1]).intValue();
		}

		return 3;
	}

	private static int min(final String line) {
		final String[] strings = StringUtils.split(line, ":");

		if (strings.length == 3) {
			return Integer.valueOf(strings[2]).intValue();
		}

		return 0;
	}
}
