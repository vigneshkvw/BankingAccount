/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author viki
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class verification extends Bank{
    private String sqlQuery;
    private String sql;
    public int Accnum=0;
    
public  void verify() throws SQLException{
        try {
            System.out.println("Enter your accont number");
            Accnum=in.nextInt();
            System.out.println("Enter your  Pin Number: ");
            String pinNum =in.next();
            getConnection();
            conn=(Connection) Connection;
            sqlQuery = ("SELECT * FROM banking.logbook where pinNum = ? AND accountnumber = ?");
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlQuery);
            ps.setString(1, pinNum );
            ps.setInt(2,  Accnum);
            ResultSet rs2 = (ResultSet) ps.executeQuery();
            if(rs2.next()) {
                System.out.println("The user is valid");
                sql = ("SELECT * FROM logbook where accountnumber = ? ");
                PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sql);
                preparedSelect.setInt(1, Accnum);
                ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
                while (rs1.next()) {
                int accountnumber1 = rs1.getInt("accountnumber");
                String name1 = rs1.getString("name");
                String address1 = rs1.getString("address");
                String state1 = rs1.getString("state");
                String city1 = rs1.getString("city");
                int pincode1 = rs1.getInt("pincode");
                System.out.format("%s, %s, %s, %s, %s, %s\n", accountnumber1, name1, address1, state1, city1, pincode1);
            }

} else {
                System.out.println("password inVaild : ");
              verify();
             }
}    catch (SQLException ex) {
        ex.printStackTrace();     }
    }
 }
