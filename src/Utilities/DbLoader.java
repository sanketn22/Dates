package Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;


public class DbLoader {
	
	public static Connection connect() {
		Connection con = null;
		 try {
			 String url = "jdbc:sqlite:C:\\Users\\Sanket_2022\\Documents\\Eclipse wkspce\\Sources\\laptopsdb.sqlite";
			 con = DriverManager.getConnection(url);
			 			 
		 }
		 catch(SQLException e ) {
			 System.out.println(e.getMessage());
		 }finally {
//			 try
//			 {
//				 if(con!=null) {
//					 con.close();
//				 }
//			 }catch(SQLException f) {
//				 System.out.println(f.getMessage());
//			 }
		 }
		 return con;
	}
	
	public void createTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS dates (\n"
				+ "	id integer PRIMARY KEY, \n"
                + "	date text NOT NULL\n"
                + " );";	  
		try{  
            Connection conn = this.connect();  
            Statement stmt = conn.createStatement();            
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
	
	public void addData(List<Date> a) {
		String sql1 = "INSERT INTO dates(id,date) VALUES(?,?)";

	    try (PreparedStatement pstmt = this.connect().prepareStatement(sql1)) {
	    	for(int i=0; i<a.size(); i++) {
	    		String d = a.get(i).toString();	
	    		pstmt.setInt(1,i);
	    		pstmt.setString(2,d);
	    		pstmt.executeUpdate();
	    	}
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
	}
	}
