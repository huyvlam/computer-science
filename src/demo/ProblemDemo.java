package demo;
import io.*;

public class ProblemDemo {
	public static void main(String[] args) {
		demoLargestDirectoryFile(".", 20);
	}
	
	public static void demoLargestDirectoryFile(String dir, int numOfFile) {
		for (Integer filesize: DirectoryFile.getLargestFile(dir, numOfFile)) 
			System.out.println(filesize);
	}
}
