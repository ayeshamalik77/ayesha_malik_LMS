import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
*Ayesha Malik
*Software Development 1
*2/24/24
*class:Library
*It add(), delete() and display() books.
*Its a library management system that add, delete and display books
*/
public class Library {
	static void displayBooks() {
		System.out.println("Display books");
		System.out.println("id              title                       author         barcode      checkedOut");
		try {
		Connection conn = null;
	      Statement stmt = null;
	      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
	      PreparedStatement myStmt; 
	      myStmt = conn.prepareStatement("Select * from mybooks;");
	     ResultSet r = myStmt.executeQuery();
	     while(r.next()) {
	    	 int id = r.getInt(1);
	    	 String title = r.getString(2);
	    	 String author = r.getString(3);
	    	 int barcode = r.getInt(4);
	    	 int checkedIn = r.getInt(5);
	    	 String check = "";
	    	 if(checkedIn == 1) {
	    		 check = "checked out";
	    	 }
	    	 else {
	    		 check = "checked In";
	    	 }
	    	 //System.out.println(id+ " " + title+ " " + author + " " + barcode + " " + check);
	    	System.out.printf("%3d %25s %25s %8d %20s\n", id, title, author, barcode, check);
	     }
	      conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	static void deleteBooks() {
		System.out.println("Delete books");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("delete from mybooks where id = ?;");
		      System.out.print("Enter the id of the book to delete: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		      myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book deleted");
		      displayBooks();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}

	static void addBooks() {
		System.out.println("Add books");
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("books.txt"));
			String line = reader.readLine();

			while (line != null) {
				String []split = line.split(",");
				int id = Integer.parseInt(split[0]);
				String author = split[2];
				String title = split[1];
				int barcode = Integer.parseInt(split[3]);
				System.out.println("barcode = "+ barcode);
				//access database
				Connection conn = null;
			      Statement stmt = null;
			      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
			      PreparedStatement myStmt; 
			      myStmt = conn.prepareStatement("INSERT INTO mybooks VALUES ( ? , ? , ? , ? , null );");
			      myStmt.setInt(1,id);     
			      myStmt.setString(2,title);      
			      myStmt.setString(3,author);
			      myStmt.setInt(4, barcode);
			      myStmt.executeUpdate();
			      conn.close();
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void deleteBookByBarcode() {
		System.out.println("Delete book by barcode");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("delete from mybooks where barcode = ?;");
		      System.out.print("Enter the barcode of the book to delete: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		      myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book deleted");
		      displayBooks();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	static void checkOutBook() {
		System.out.println("Check out book");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("update mybooks where title number = ? set checkIn = 1;");
		      System.out.print("Enter the title number of the book to delete: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		      myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book checked out");
		      displayBooks();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
	static void checkInBook() {
		System.out.println("check in book");
	}

	public static void checkInBookByTitleNumber() {
		System.out.println("Check in book by title number");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("update mybooks set checkIn = 0 where id = ?;");
		      System.out.print("Enter the title number of the book to check in: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		      myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book checked in");
		      displayBooks();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	public static void checkOutBookByTitleNumber() {
		System.out.println("Check out book by title number");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("update mybooks set checkIn = 1 where id = ?;");
		      System.out.print("Enter the title number of the book to check out: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		      myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book checked out");
		      displayBooks();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}


