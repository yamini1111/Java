// Java
//java programs
import java.util.Scanner;
class library
{
	private String sname,fname,bookname,authorname;
	private String sid,bookid,fid,id;
	private String sbranch,fbranch;
	private int maxbooks=2;

	Scanner s=new Scanner(System.in);
	
	void libraryAccount()
	{
	System.out.println("enter type of account,for students enter 1 and for faculty enter 2");
	int a;
	a=s.nextInt();
	switch(a)
	{
		case 1:
		
		System.out.println("enter Student details :");
	System.out.print("Enter sname: ");
	sname=s.next();
	System.out.print("Enter sid: ");
	sid=s.next();
	System.out.print("Enter SBranch: ");
	sbranch=s.next();
	//System.out.print("Enter maximum no of books: ");
	//maxbooks=s.nextInt();
	break;
	case 2:
	System.out.println("faculty details are:");
	System.out.print("Enter fname: ");
	fname=s.next();
	System.out.print("Enter fid: ");
	fid=s.next();
	System.out.print("Enter fBranch: ");
	fbranch=s.next();
	//System.out.print("Enter maximum no of books: ");
	//maxbooks=s.nextInt();
	break;
	default:
	System.out.println("invalid option");
	break;
}}
    
    void student()
    {
		System.out.println("Student Details are:"+sname+","+sid+","+sbranch+","+maxbooks);
	}
    void faculty()
    {
		System.out.println("faculty details are:"+fname+","+fid+","+fbranch+","+maxbooks);
    }
    void bookDetails()
    {
		System.out.print("Enter book id: ");
		bookid=s.next();
		System.out.print("Enter book name: ");
		bookname=s.next();
		System.out.print("Enter author name: ");
		authorname=s.next();
	}
	void showbookDetails()
	{
		System.out.println("book details are:"+bookid+","+bookname+","+authorname);
	}
	void issueBook()
	{
		String ibookid;
		int ibooks=1;
		System.out.print("enter book id to check the avaliability: ");
		ibookid=s.next();
		
		if(ibookid.equals(bookid))
		{
			System.out.println("book is available");
			maxbooks=maxbooks-ibooks;
			System.out.println("available no of books to take: "+maxbooks);
		} 
		else
	     {
			System.out.println("book is  not available");
		}	
	 }
	 void returnBook()
	 {
		 String rbookid;
		 int validity,fine,daysExceed,rbooks=1;
		 System.out.print("enter validity i.e., no of days you have taken the book, to return the book: ");
		 validity=s.nextInt();
		 System.out.print("enter returning book id: ");
		 rbookid=s.next();
		 if(rbookid.equals(bookid))
		 {
		 if(validity<=30)
		 {
			 System.out.print("return the book: ");
			 maxbooks=maxbooks+rbooks;
			System.out.println("available no of books to take:"+maxbooks);
		 }
		 else
		 {
			 daysExceed=validity-30;
			 fine=daysExceed*1;
			 System.out.println("fine amount is:"+fine);
		 }
	 }	 
	 }
	 boolean search(String lid)
	{ 
		if(sid.equals(lid))
		{ 
			return(true);
		}
		else
		{
		return(false);
        }
    }
	 boolean searchb(String bid)
	{ 
		if(bookid.equals(bid))
		{ 
			return(true);
		}
		return(false);
	}
}

public class library1 {	
	public static void main (String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("enter the number of members : ");
		int n=s.nextInt();
		library  C[]=new library[n];
		for(int i=0;i<C.length;i++)
		{   
			C[i]=new library();
			C[i].libraryAccount();
			C[i].bookDetails();
		}
		
		//run loop until menu 6 is not pressed
		int ch;
		do
		{
			System.out.println("Main Menu\n1.Display All\n2.Search By Account\n3.Search By Book\n4.Book issue\n5.Book return\n6.Exit");
			System.out.println("Ur Choice :");
			ch=s.nextInt();
			switch(ch)
			{ 
				case 1:
					for(int i=0;i<C.length;i++)
					{
					System.out.println("enter the value for student 1, faculty 2" );
					int b=s.nextInt();
					if(b==1)
					{
						C[i].student();
						C[i].showbookDetails();
						}
						else {
						C[i].faculty();
						C[i].showbookDetails();
					}}
					break;

				case 2:
					System.out.print("Enter Account No U Want to Search...: ");
					String lid=s.next();
					boolean found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(lid);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{	
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;
					case 3:
					System.out.print("Enter Book No U Want to Search...: ");
					String bid=s.next();
					boolean find=false;
					for(int i=0;i<C.length;i++)
					{  
						find=C[i].searchb(bid);
						if(find)
						{
							break;
						}
					}
					if(!find)
					{
						System.out.println("Search Failed..book Not Exist..");
					}
					break;
					case 4:
					System.out.print("Enter library account No : ");
					lid=s.next();
					System.out.print("Enter book No : ");
					bid=s.next();
					found=false;
					find=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(lid);
						find=C[i].searchb(bid);
						if(found&&find)
						{
							C[i].issueBook();
							break;
						}
					}
					if(!(found&&found))
					{
						System.out.println("Search Failed..Account and book Not Exist..");
					}
					break;
					case 5:
					System.out.print("Enter library account No : ");
					lid=s.next();
					System.out.print("Enter book No : ");
					bid=s.next();
					found=false;
					find=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(lid);
						find=C[i].searchb(bid);
						if(found&&find)
						{
							C[i].returnBook();
							break;
						}
					}
					if(!(found&&found))
					{
						System.out.println("Search Failed..Account and book Not Exist..");
					}
					break;
					case 6:
					System.out.println("Good Bye..");
					break;
			}
		}
		while(ch!=6);
	}
}

