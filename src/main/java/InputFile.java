import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Vector;


public class InputFile extends Thread {

	class Mwrds{
		String wrd;
		int freq=1;
	}
	String str;
	Vector<String> wrds;
	Vector<Mwrds> same;
	//Constructor
	InputFile(String s)
	{
		str=s;
		wrds=new Vector<String>();
		same=new Vector<Mwrds>();
	}
	@Override
	public void run()
	{
		System.out.println(str+" thread");
		String file=str;
		boolean chck=false;String s=" ";
			File info=new File(file);
			FileReader fr;
			try {
			//	File info=new File(file);
				fr=new FileReader(info);
				BufferedReader br = new BufferedReader(fr);
			
			try {
				while((s=br.readLine())!=null)
				{
					chck=false;
					StringTokenizer tok=new StringTokenizer(s," ");
					while(tok.hasMoreTokens())
					{
						String inf;
						inf=tok.nextToken();
						
						if(!chck)
						{
							wrds.add(inf);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File NOT FOUND");
			
		}
		
	}
	
	public void ALLVECTORS()
	{
		for(String i : wrds)
		{
			System.out.println(i);
		}
	}
	public void displayMatch()
	{
		for(Mwrds i : same)
		{
			System.out.println(i.wrd+","+i.freq);
		}
	//	System.out.println("It's Working");
	}
	public void match(BinarySearchTree temp)
	{
		boolean chck=false;
		for(String i : wrds)
		{
			chck=false;
			//chck=false;
			BinarySearchTree.Nodes obj=temp.root;	
			while(obj!=null)
			{
			//	System.out.println("hello");
				if(i.length()>obj.str.length())
				{
					obj=obj.right;
				}
				else if(i.length()<obj.str.length())
				{
					obj=obj.left;
				}
				else if(Objects.equals(i, obj.str))
				{
				//	System.out.println("tureeee");
					chck=true;
					break;
				}
				else 
					break;
			}
			if(chck==true)
			{
				boolean ch=false;
				Mwrds mw=new Mwrds();
				mw.wrd=i;
				for(Mwrds k : same)
				{
					if(Objects.equals(k.wrd,mw.wrd))
					{
						k.freq++;
						ch=true;
						break;
					}
				}
				if(!ch)
				{
					same.add(mw);
				}
			}
		/*	else
			{
				System.out.println("No such word exists");
				break;
			}*/
		}
		if(chck==false)
		{
			System.out.println("No such word exists");
		}
	}
	
	
}
