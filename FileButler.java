package exp4;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class FileButler {
	public FileButler() {}
	public static void main (String[] args) {
		System.out.println("-Welcome to FileButler! put in help to know all the available commands");
		FileButler fb = new FileButler();
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		String temp1;
		String temp2;
		
		while(flag) {
			System.out.println("-Put in a command, master! qvq");
			String cmd = scan.nextLine();
			switch (cmd) {
			case "mkdir": 
				System.out.println("-Input the directory path name:");
				temp1 = scan.nextLine();
				fb.mkdir(temp1);
				break;
			case "rmdir":
				System.out.println("-Input the directory path name:");
				temp1 = scan.nextLine();
				fb.rmdir(temp1);
				break;
			case "mkfl":
				System.out.println("-Input the file path name:");
				temp1 = scan.nextLine();
				fb.mkfl(temp1);
				break;
			case "rmfl":
				System.out.println("-Input the file path name:");
				temp1 = scan.nextLine();
				fb.rmfl(temp1);
				break;
			case "write": 
				System.out.println("-Input the path name of file you want to write:");
				temp1 = scan.nextLine();
				System.out.println("-Input the context you want to write in:");
				temp2 = scan.nextLine();
				fb.write(temp1, temp2);
				break;
			case "read": 
				System.out.println("-Input the path name of file you want to read:");
				temp1 = scan.nextLine();
				fb.read(temp1);
				break;
			case "copy":
				System.out.println("-Input the path name of file you want to copy:");
				temp1 = scan.nextLine();
				System.out.println("-Input the path name of file afer copy:");
				temp2 = scan.nextLine();
				fb.copy(temp1, temp2);
				break;
			case "move": 
				System.out.println("-Input the path name of file you want to move:");
				temp1 = scan.nextLine();
				System.out.println("-Input the path name of file afer move:");
				temp2 = scan.nextLine();
				fb.move(temp1, temp2);
				break;
			case "list": 
				System.out.println("-Input the path name you want to list:");
				temp1 = scan.nextLine();
				fb.list(temp1);
				break;
			case "help": 
				System.out.print("Available commands are followed here:\n");
				System.out.print("mkdir: Create a directory (usage: mkdir -> C:\\a\\b)\n");
				System.out.print("rmdir: Remove a directory (usage: rmdir -> C:\\a\\b)\n");
				System.out.print("mkfl: Create a file (usage: mkfl -> C:\\a\\b.txt)\n");
				System.out.print("rmfl: Remove a file (usage: rmfl -> C:\\a\\b.txt)\n");
				System.out.print("write: Write text to a file (usage: write -> C:\\a\\b.txt -> 12345)\n");
				System.out.print("read: Read context from a file (usage: read -> C:\\a\\b.txt)\n");
				System.out.print("copy: Copy a file to the destination and rename (usage: copy -> C:\\a\\b.txt -> C:\\a\\c.txt)\n");
				System.out.print("move: Move a file to the destination and rename (usage: move -> C:\\a\\b.txt -> C:\\a\\c.txt)\n");
				System.out.print("list: List files under the path you give and describe them (usage: list -> C:\\a)\n");
				break;
			case "exit": 
				System.out.println("-FileButler is closing...");
				System.out.println("-Bye Bye~~");
				flag = false;
				break;
			default:
				System.out.println("Unknown command! put in help to know all the available commands");
			}
		}
		
		System.out.println("-FileButler Closed!");
	}
	

	
	
	public void mkdir(String path) {
		boolean point = true;
		File fl = new File(path);
		if (fl.exists()) {
			point = false;
			System.out.println("Error: mkdir:");
			System.out.println("Directory exists!");
		}
		else {
			point = fl.mkdir();
		}
		if(point){
			System.out.println("mkdir success!");
		}
	}
	
	public void rmdir(String path) {
		boolean point = true;
		File fl = new File(path);
		point = fl.delete();
		if(!point) {
			System.out.println("rmdir fail!");
		}
		else {
			System.out.println("rmdir success!");
		}
	}
	
	public void mkfl(String path) {
		boolean point = true;
		File fl = new File(path);
		if (fl.exists()) {
			point = false;
			System.out.println("Error: mkdir:");
			System.out.println("File exists!");
		}
		else {
			try {
				point = fl.createNewFile();
			}
			catch (IOException e) {
				System.out.println("mkfl fail!");
			}
		}
		if(point){
			System.out.println("mkfl success!");
		}
	}
	
	public void rmfl(String path) {
		boolean point = true;
		File fl = new File(path);
		point = fl.delete();
		if(!point) {
			System.out.println("rmfl fail!");
		}
		else {
			System.out.println("rmfl success!");
		}
	}
	
	
	public void write(String path, String context) {
		boolean point = true;
		try {
			FileWriter writer = new FileWriter(path,true);
			writer.write(context);
			writer.flush();
			writer.close();
		}
		catch(IOException e) {
			point = false;
		}
		if(!point) {
			System.out.println("write fail!");
		}
		else {
			System.out.println("write success!");
		}
	}
	
	public void read(String path) {
		boolean point = true;
		char[] context = new char[50];
		try {
			FileReader reader = new FileReader(path);
			reader.read(context);
	        for (char c : context)
	            System.out.print(c); 
	        System.out.print("\n");
	        reader.close();
		}
		catch(IOException e) {
			point = false;
		}
		if(!point) {
			System.out.println("read fail!");
		}
		else {
			System.out.println("read success!");
		}
	}
	
	
	public void copy(String srcPathStr, String desPathStr){
		boolean point = true;
        try
		{
             FileInputStream fis = new FileInputStream(srcPathStr);
             FileOutputStream fos = new FileOutputStream(desPathStr);        
             byte datas[] = new byte[1024*8];
             int len = 0; 
             while((len = fis.read(datas))!=-1)
			{
				fos.write(datas,0,len);
            } 
                fis.close();
                fos.close();
        }
			catch (Exception e)
			{
                e.printStackTrace();
                point = false;
            }
		if(!point) {
			System.out.println("copy fail!");
		}
		else {
			System.out.println("copy success!");
		}
	}
	
	
	public void move(String srcPathStr, String desPathStr){
		boolean point = true;
        File fl = new File(srcPathStr);
        try
		{
             FileInputStream fis = new FileInputStream(srcPathStr);
             FileOutputStream fos = new FileOutputStream(desPathStr);        
             byte datas[] = new byte[1024*8];
             int len = 0; 
             while((len = fis.read(datas))!=-1)
			{
				fos.write(datas,0,len);
            } 
                fis.close();
                fos.close();
        		point = fl.delete();
        }
			catch (Exception e)
			{
                e.printStackTrace();
                point = false;
            }
        
        
        
		if(!point) {
			System.out.println("move fail!");
		}
		else {
			System.out.println("move success!");
		}
		
	}
	
	public void list(String path) {
		String str1 = String.format("%-30s", "File Name");
		String str2 = String.format("%-25s", "Last Modified Date");
		String str3 = String.format("%-20s", "File Size");
		String str4 = new String(new char[79]).replace("\0", "-");
		System.out.println("|"+str1+"|"+str2+"|"+str3+"|");	
		System.out.println(str4);	
		boolean point = true;
		File fl = new File(path);
		File[] fls = fl.listFiles();
		for(File f:fls) {
			String fname = f.getName();
			long length = countsize(f.getAbsolutePath());
			String len = getPrintSize(length);
			Long lastModified = f.lastModified();
			Date date = new Date(lastModified);
			listprint(fname,date,len);
		}
		
	}
	public long countsize(String path) {
		long filesize = 0;
		File fl = new File(path); 
		if(fl.isDirectory()) {
			File[] fls = fl.listFiles();
			for(File f:fls) {
				String fname = f.getAbsolutePath();
				if(f.isDirectory()) {
					filesize += countsize(fname);
				}
				else {
					filesize += f.length();
				}
			}
		}
		else {
			filesize += fl.length();
		}
		return filesize;
	}
	public String getPrintSize(long size) {
		if (size < 1024) {
			return String.valueOf(size) + "B";
			} 
		else {
			size = size / 1024;
			}
		if (size < 1024) {
			return String.valueOf(size) + "KB";
			} 
		else {
			size = size / 1024;
			}
		if (size < 1024) {
			size = size * 100;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
			} 
		else {
			size = size * 100 / 1024;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
			}
		}
	
	public void listprint(String name, Date date, String size) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date_s = sdf.format(date);
		String str1 = String.format("%-30s", name);
		String str2 = String.format("%-25s", date_s);
		String str3 = String.format("%-20s", size);
		System.out.println("|"+str1+"|"+str2+"|"+str3+"|");	
	}
}
