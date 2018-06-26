//This programme is used for reamed problems of idm downloads
// generally not completed idm downloads are in user/appdadata/idm/romaing
// we renamed this kind of videos according to real name and moved into another directory("A:/IDMTEMP") 
import java.util.*;
import java.io.*;
class idm
{
	public static void main(String args[]) throws IOException
	{	String path="A:/user";
		File file = new File(path);
        File[] files = file.listFiles();
        for(File f: files){
			String path1=path+"/"+f.getName();
			File file1 = new File(path1);
			File[] files1 = file1.listFiles();
			System.out.println("-------------");
			FileReader fr=new FileReader(files1[0]);    
			BufferedReader br=new BufferedReader(fr);
			while(br.readLine()!=null)
			{
				//System.out.println(br.readLine());
				 String s=br.readLine()+"";
				if(s.contains("filename="))
				{
					int first=s.indexOf("filename=");
					System.out.println(s.charAt(first+9));
					String inv="\""+"";
					int last=s.lastIndexOf(inv);
					System.out.println(s.charAt(last));
					String filename="";
					for(int i=first+10;i<last;i++)
					{
						filename=filename+s.charAt(i);
					}
					String changedname="";
					for(int i=0;i<filename.length();i++)
					{
						int val=(int)filename.charAt(i);
						if(val==32 || val==46 || val>64 && val<91 || val>96 && val<123 || val>47 && val<58)
						{
							changedname=changedname+filename.charAt(i);
						}
						else
						{
							
						}
						
					}
					System.out.println("file name "+filename);
					System.out.println("files1 "+files1[1]);
					//System.out.println("\""+files1[1]+"\"");
					String old=files1[1]+"";
					String path2="A:/IDMTEMP";
					String newone=path2+"/"+changedname;
					System.out.println("old "+old);
					System.out.println("new "+newone);
					
					 File oldfile = new File(old);
					File newFile = new File(newone);
					if(oldfile.renameTo(newFile)){
					System.out.println("File rename success");;
					}else{
					System.out.println("File rename failed");
					}
					
					
					break;
				}
			}
			
			
			//System.out.println(files1[0]);
			
			/*for(File f1: files1){
			
            System.out.println(f1.getName());
			}
			System.out.println("-------------");*/
		}
	}
}