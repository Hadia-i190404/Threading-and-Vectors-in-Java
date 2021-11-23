import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Front {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("CHECK");
		Vocabulary vcth=new Vocabulary("vocabulary");
		Vector<InputFile> fthread=new Vector<InputFile>();
		String fname;
		System.out.println("Enter the file name with .txt");
		fname=sc.nextLine();
		Vector<String> diffiles=new Vector<String>();
		StringTokenizer tok=new StringTokenizer(fname," ");
		while(tok.hasMoreTokens())
		{
			diffiles.add(tok.nextToken());
		}
		for(String i : diffiles)
		{
			InputFile ipth=new InputFile(i);
			fthread.add(ipth);
			ipth.start();
		}
	vcth.start();
		
		
		
		Scanner scc=new Scanner(System.in);
		System.out.println("Enter 1 for Binary search\nEnter 2 for all vectors\nEnter 3 for Matching\nEnter 4 for Query\nEnter 5 for exit");
		int input=scc.nextInt();
		if(input==1)
		{
		vcth.bst.display(vcth.bst.root);
		}
		if(input==2)
		{
			for(InputFile i : fthread)
			{
				i.ALLVECTORS();
			}
		}
		if(input==3)
		{
			for(InputFile i : fthread)
			{
				i.match(vcth.bst);
				i.displayMatch();
			}
		}
		if(input==4)
		{
			System.out.println("Enter");
			String q;
			Scanner s=new Scanner(System.in);
			q=s.nextLine();
			BinarySearchTree query=new BinarySearchTree();
			StringTokenizer token=new StringTokenizer(q," ");
			while(token.hasMoreTokens())
			//while(token!=null)
			{
				query.setroot(token.nextToken());
			}
			for(InputFile i : fthread)
			{
				i.match(query);
				i.displayMatch();
			}
		}
		if(input==5)
		{
			System.out.println("THE END");
			return;
		}
	}

}
