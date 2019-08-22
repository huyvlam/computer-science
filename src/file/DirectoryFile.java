package file;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * DirectoryFile perform read operation on files, folders of a given directory
 */
public class DirectoryFile {
	private static PriorityQueue<Integer> heap;
	private static int HEAP_CAPACITY;
	
	// Find the largest filesize in the specified directory
	// Create a heap to store filesize in natural order
	public static Integer[] getLargestFile(String dir, int numberOfFile) {
		HEAP_CAPACITY = numberOfFile;
		heap = new PriorityQueue<>(HEAP_CAPACITY);
		File root = new File(dir);
		return getLargestFile(root);
	}
	
	// Iterate thru and check the filesize:
		// 1. if filesize is greater then heap min value -> add filesize to heap
			// a. if heap is full -> remove min value before add filesize
	private static Integer[] getLargestFile(File dir) {
		File[] list = dir.listFiles();

		for (File content: list) {
			if (content.isDirectory()) {
				getLargestFile(content);
			} else {
				int filesize = (int) content.length();

				if (heap.size() < HEAP_CAPACITY) {
					heap.add(filesize);
				} else if (heap.peek() != null && heap.peek() < filesize) {
					if (heap.size() == HEAP_CAPACITY) 
						heap.poll();

					heap.add(filesize);
				}
			}
		}

		return (Integer[]) heap.toArray(new Integer[] {});
	}
	
	public static void printDirContent(String dir) {
		File root = new File(dir);
		printDirContent(root);
	}
	
	private static void printDirContent(File file) {
		try {
			File[] list = file.listFiles();
			for (File content: list) {
				if (content.isDirectory()) {
					System.out.println("dir: " + content.getCanonicalPath());
					printDirContent(content);
				} else {
					System.out.println("file: " + content.length() + " " + content.getCanonicalPath());
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
