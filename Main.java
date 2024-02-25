import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
*Ayesha Malik
*Software Development 1
*1/23/24
*class:Main
*It add(), delete() and display() books.
*Its a library management system that add, delete and display books
*/
public class Main {
	//static Library library = new Library();
	/**
	 * starts and run the program
	 * @param args
	 */
	public static void main(String[] args) {
		int choice=0;
		Scanner input = new Scanner(System.in);
		while(true) {	
			System.out.println("\n Enter your choice");
			System.out.println("1: add books");
			System.out.println("2: delete book by title number");
			System.out.println("3: delete book by barcode");
			System.out.println("4: check in book by title number");
			System.out.println("5: check out book by title number");
			System.out.println("6: display books");
			System.out.println("7: Exit");
			
			choice = input.nextInt();
			switch(choice) {
			case 1: Library.addBooks();
				break;
			case 2: Library.deleteBooks();
				break;
			case 3: Library.deleteBookByBarcode();
				break;
			case 4: Library.checkInBookByTitleNumber();
				break;
			case 5: Library.checkOutBookByTitleNumber();
				break;
			case 6: Library.displayBooks();
				break;
			case 7: System.exit(0);
				break;
			
			}
		}
		
	}

//	private static void displayBooks() {
//		System.out.println("Display books");
//		try {
//		Connection conn = null;
//	      Statement stmt = null;
//	      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
//	      PreparedStatement myStmt; 
//	      myStmt = conn.prepareStatement("Select * from mybooks;");
//	     ResultSet r = myStmt.executeQuery();
//	     while(r.next()) {
//	    	 int id = r.getInt(1);
//	    	 String title = r.getString(2);
//	    	 String author = r.getString(3);
//	    	 System.out.println(id+ " " + title+ " " + author);
//	     }
//	      conn.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	private static void deleteBooks() {
//		System.out.println("Delete books");
//		try {
//			Connection conn = null;
//		      Statement stmt = null;
//		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
//		      PreparedStatement myStmt; 
//		      myStmt = conn.prepareStatement("delete from mybooks where id = ?;");
//		      System.out.print("Enter the id of the book to delete: ");
//		      Scanner input = new Scanner(System.in);
//		      int id = input.nextInt();
//		      myStmt.setInt(1,id); 
//		      myStmt.executeUpdate();
//		      conn.close();
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		
//	}
//
//	private static void addBooks() {
//		System.out.println("Add books");
//		BufferedReader reader;
//
//		try {
//			reader = new BufferedReader(new FileReader("books.txt"));
//			String line = reader.readLine();
//
//			while (line != null) {
//				String []split = line.split(",");
//				int id = Integer.parseInt(split[0]);
//				String author = split[2];
//				String title = split[1];
//				//access database
//				Connection conn = null;
//			      Statement stmt = null;
//			      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
//			      PreparedStatement myStmt; 
//			      myStmt = conn.prepareStatement("INSERT INTO mybooks VALUES (  ? , ? , ? );");
//			      myStmt.setInt(1,id);     
//			      myStmt.setString(2,title);      
//			      myStmt.setString(3,author);
//			      myStmt.executeUpdate();
//			      conn.close();
//				// read next line
//				line = reader.readLine();
//			}
//
//			reader.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
