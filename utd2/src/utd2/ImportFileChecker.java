package utd2;

public class ImportFileChecker {
	public static boolean checkFileName(final String fileName)  {
		if (!fileName.toLowerCase().endsWith(".utd")) {
			return false;
		}
		
		return true;
	}
}
