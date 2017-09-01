/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author viki
 */
class Lasttransaction extends Bank {

     public  void lasttransaction() throws SQLException {
        try {
            getConnection();
            conn=Connection;
            System.out.println("Creating statement...");
            sqlQuery = ("select * from banking.transactiondetails where AccNum = ? order by balance limit 15 ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
            preparedSelect.setInt(1,  account.getAccNum());
            ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {

                int accountnumber1 = rs1.getInt("AccNum");
                int cashdeposit1=rs1.getInt("cahdeposit");
                int cashwithdraw1=rs1.getInt("cashwithdraw");
                int balance1=rs1.getInt("balance");
                Date date1=rs1.getDate("Date1");

                System.out.format("%s, %s, %s, %s %s\n", accountnumber1, cashdeposit1, cashwithdraw1, balance1, date1);

            }


        } catch (SQLException e) {
        System.out.println("sql error");
         e.printStackTrace();
        }



conn.close();
        }


}
