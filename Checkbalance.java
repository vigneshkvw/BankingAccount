/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;
import com.smhack.Banking.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viki
 */
class Checkbalance extends Bank{

   public  void checkBalance() throws SQLException {
        String sqlbalance;
     try {

            getConnection();
           conn=Connection;
System.out.println("your current balance is");
           sqlbalance = ("SELECT balance FROM banking.logbook where accountnumber = ? ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlbalance);
            preparedSelect.setInt(1, account.getAccNum());
            ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {

                int Balance1 = rs1.getInt("balance");
System.out.println("your current balance is");
               System.out.println(Balance1);
            }
        } catch (Exception e) {
e.printStackTrace();                                 }
conn.close();
    }

}
