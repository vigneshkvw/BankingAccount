/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Checkbalance extends verification{

public String sqlbalance;
     public  void checkBalance() throws SQLException {
         verify();
         try {
         sqlbalance = ("SELECT balance FROM logbook where accountnumber = ? ");
         PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlbalance);
         preparedSelect.setInt(1,Accnum );
         ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
         while (rs1.next()) {
             float Balance1 = rs1.getFloat("balance");
             System.out.println("your current balance is" +Balance1);
            }
        } catch (SQLException e) {
e.printStackTrace();                                 }
conn.close();
    }

}
