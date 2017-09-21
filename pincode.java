import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class pincode extends verification{

	public void updatepincode() {
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
	       System.out.println("Enter Your New PinCode :");
	       int newpincode=in.nextInt();
	       java.sql.PreparedStatement ps1 = conn.prepareStatement("update logbook set pincode= ? where accountnumber= ?");
		ps1.setInt(1, newpincode);
		ps1.setInt(2,Accnum);
		ps1.executeUpdate();
		System.out.println("your Pincode had changed!!!!!");
	         }else {
	        System.out.println("password inVaild : ");
		   }
		}    catch (SQLException ex) {
		        ex.printStackTrace();     }
	}

}
