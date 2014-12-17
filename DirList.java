import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
public class DirList {
	public static int depth = 0;
	public static int fileCount, dirCount = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File pathname = new File(args[0]);
		
		if(pathname.isDirectory() && args.length == 1){
			recurseDirectory(pathname);
		}
		else if(args.length > 1){
			System.err.println("Please enter only one valid expression");
			System.exit(1);
		}
		else{
			System.err.println("Please enter a valid pathname");
			System.exit(1);
		}
		
		printFileCount(fileCount, dirCount);
	}
	
	public static void recurseDirectory(File rootDirectory){
		System.out.println("/" + rootDirectory + "/");
		recurseDirectoryHelper(rootDirectory, depth);
	}

	private static void recurseDirectoryHelper(File rootDirectory, int depth){
		File[] list = rootDirectory.listFiles();
		String indent = "";
		
		if(depth > 0){
			for(int i = depth; i >= 1; i--){
				indent += "    ";
			}
		}
		
		for(File file: list){
			if(file.isFile()){
				System.out.println(indent + file.getName());
				fileCount++;
			}
		}

		for(File dir: list){					
			if(dir.isDirectory()){
				depth++;
				System.out.println(indent + "subdir " + dir.getName() + ":");
				recurseDirectoryHelper(dir, depth--); 				
				dirCount++;
				
			}
		}	
	}
	
	public static void printFileCount(int fileCount, int dirCount){
		if(fileCount > 0 && dirCount > 0){
			System.out.print("Total Files: " + fileCount); 
			System.out.println("\tTotal Directories: " + dirCount); 
		}
		else{
			System.out.println("No files or directories were found");
		}
	}			

}



