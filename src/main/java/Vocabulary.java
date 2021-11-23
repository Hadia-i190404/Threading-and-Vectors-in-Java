import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Vocabulary extends Thread{

	public BinarySearchTree bst;
	String name;
	
	//Constrcutor
	Vocabulary(String str)
	{
		name=str;
		bst = new BinarySearchTree();
		
	}
	@Override
	public void run()  {
		
		
		System.out.println(name+"thread");String s;
		try {
			File info=new File("Vocabulary.txt");
			FileReader fr=new FileReader(info);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				while((s=br.readLine())!=null)
				{
					StringTokenizer tok=new StringTokenizer(s," ");
					String inf=" ";
					inf=tok.nextToken();
				//	System.out.println(inf);
					bst.setroot(inf);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileError");
	
		}
		
		//bst.display(bst.root);
		
		
	}
	
}
