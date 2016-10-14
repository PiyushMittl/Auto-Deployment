

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;




public class PiyushDeployAutomation
{
    public static void main(String[] args)
    {	
    	
    	ArrayList<Date> al=new ArrayList<Date>();
    	
    	
    	File srcFolder = new File("D:\\AMGEN_UI_4_11_16\\spff\\src\\main\\webapp\\assets");   
    	//File destFolder = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\tempbe9a67f0e97b8b3d\\spff.war-e793c8e26b8f97be\\assets");
    	File destFolder = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\temp4fd3e2919e5f49c6\\spff.war-bee751ebcb10d977\\assets");
    	
    	
    	
    	//File srcFolder2 = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\tempbe9a67f0e97b8b3d\\spff.war-e793c8e26b8f97be\\WEB-INF\\classes\\com");
    	//File destFolder2 = new File("D:\\AMGEN_UI_4_11_16\\spff\\target\\classes\\com");
    	
    	File srcFolder2 = new File("D:\\AMGEN_UI_4_11_16\\spff\\target\\classes\\com");
    	File destFolder2 = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\temp4fd3e2919e5f49c6\\spff.war-bee751ebcb10d977\\WEB-INF\\classes\\com");
    	
    	
    	
    	//File file = new File("C:\\Windows");
    	File file = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs");
    	String[] names = file.list();

    	for(String name : names)
    	{
    	    //if (new File("C:\\Windows\\" + name).isDirectory())
    	    	if (new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).isDirectory())
    	    {
    	    		System.out.println(name);
    	    		System.out.println(new Date(new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).lastModified()));
        	        al.add(new Date(new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).lastModified()));
    	    }
    	    	/*List l*/
    	}
    	
    	//ArrayList al=new Date(new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).lastModified());
    	
    	Collections.sort(al);
    	
    	Date lastModi=al.get(al.size()-2);
    	
    	
    	
    	String foldername="";
    	for(String name : names)
    	{
    	    //if (new File("C:\\Windows\\" + name).isDirectory())
    	    	if (new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).isDirectory())
    	    {
    	    		Date d=new Date(new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\" + name).lastModified());
    	    		
    	    		if(lastModi.compareTo(d)==0)
        	        {
        	        	System.out.println(lastModi.compareTo(d));
        	        	System.out.println("found and name is ="+name);
        	        	System.out.println(""+d);
        	        	System.out.println(""+lastModi);
        	        	foldername=name;
        	        
        	        }
    	    }
    	    	/*List l*/
    	}
    	
    	
    	
    	File file1 = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\"+foldername+"");
    	String[] names1 = file1.list();
    	
    	
    	
    	
    	File srcFolder_auto = new File("D:\\AMGEN_UI_4_11_16\\spff\\src\\main\\webapp\\assets");   
    	//File destFolder = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\tempbe9a67f0e97b8b3d\\spff.war-e793c8e26b8f97be\\assets");
    	File destFolder_auto = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\"+foldername+"assets");
    	
    	
    	
    	//File srcFolder2 = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\tempbe9a67f0e97b8b3d\\spff.war-e793c8e26b8f97be\\WEB-INF\\classes\\com");
    	//File destFolder2 = new File("D:\\AMGEN_UI_4_11_16\\spff\\target\\classes\\com");
    	
    	File srcFolder2_auto = new File("D:\\AMGEN_UI_4_11_16\\spff\\target\\classes\\com");
    	File destFolder2_auto = new File("C:\\jboss-as-7.1.1.Final_AMGEN\\jboss-as-7.1.1.Final\\standalone\\tmp\\vfs\\"+foldername+"WEB-INF\\classes\\com");
    	
    	
    	
    	
    	
    	
    	
    	//make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	   copyFolder(srcFolder,destFolder);
        	   copyFolder(srcFolder2,destFolder2);
           	
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    	
    	System.out.println("Done");
    }
    
    public static void copyFolder(File src, File dest)
    	throws IOException{
    	
    	if(src.isDirectory()){
    		
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
    		
    		//list all the directory contents
    		String files[] = src.list();
    		
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}
    	   
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
    	                     
    	        byte[] buffer = new byte[1024];
    	    
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }
}