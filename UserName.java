package smhack.banking;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class UserName extends verification{

	public void updateName() {
		 try {
			 System.out.println("Enter your accont number");
	         Accnum=in.nextInt();
	         System.out.println("Enter your  Pin Number: ");
	         String pinNum =in.next();
	         getConnection();
	         conn=(Connection) Connection;
	         String sqlQuery = ("SELECT * FROM banking.logbook where pinNum = ? AND accountnumber = ?");
	         PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlQuery);
	         ps.setString(1, pinNum );
	         ps.setInt(2,  Accnum);
	         ResultSet rs2 = (ResultSet) ps.executeQuery();
	         if(rs2.next()) {
	             System.out.println("The user is valid");
	       System.out.println("Enter Your New Name :");
	       String Newname=in.next();
	       java.sql.PreparedStatement ps1 = conn.prepareStatement("update logbook set name= ? where accountnumber= ?");
		ps1.setString(1, Newname);
		ps1.setInt(2,Accnum);
		ps1.executeUpdate();
		System.out.println("your Name had changed!!!!!");
	         }else {
	        System.out.println("password inVaild : ");
		   }
		}    catch (SQLException ex) {
		        ex.printStackTrace();     }
	}

}
