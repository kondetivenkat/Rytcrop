package Farmer;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

abstract class File_Manager {
	
	public void File_copy(String source, String destination)
	{
		Path temp;
		try {
			temp = Files.copy(Paths.get(source),Paths.get(destination));
			if(temp != null)
			{
				//System.out.println("File renamed and moved successfully");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void File_Delete(String source)
	{
		File myObj = new File(source);
			    if (myObj.delete()) { 
			    }
	}
	
	// function to delete subdirectories and files
    public static void deleteDirectory(File file)
    {
        // store all the paths of files and folders present
        // inside directory
        for (File subfile : file.listFiles()) {
  
            // if it is a subfolder,e.g Rohan and Ritik,
            // recursiley call function to empty subfolder
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
  
            // delete files and empty subfolders
            subfile.delete();
        }
    }
  
    public void directory()
    {
    	try {
        // store file path
        String filepath = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\rytcrop";
        File file = new File(filepath);
  
        // call deleteDirectory function to delete
        // subdirectory and files
        deleteDirectory(file);
  
        // delete main GFG folder
        file.delete();
    	}
    	catch (NullPointerException e)
    	{
    		
    	}
    }

}
