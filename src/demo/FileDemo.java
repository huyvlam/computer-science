package demo;
import file.*;

public class FileDemo {
	public static void main(String[] args) {
		largestFile(".", 10);
		printContent(".");
	}
	
	public static void largestFile(String dir, int numOfFile) {
		for (Integer filesize: DirectoryFile.getLargestFile(dir, numOfFile)) 
			System.out.println(filesize);
	}
	
	public static void printContent(String dir) {
		DirectoryFile.printDirContent(dir);
	}
}