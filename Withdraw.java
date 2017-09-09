/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viki
 */
class Withdraw extends verification {
public String sqlQuery;
public void withdraw() throws SQLException {
        
        verify();
        try {
            System.out.println("enter your ammount to withdraw  :");
        float cashwithdraw1=in.nextFloat();
            sqlQuery = ("SELECT balance FROM banking.logbook where accountnumber = ? ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
            preparedSelect.setInt(1,  Accnum);
            ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {
                float Balance6 = rs1.getFloat("balance");
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update logbook set cashwithdraw = ?, balance = ? where accountnumber = ?");
                ps.setFloat(1, cashwithdraw1);
                ps.setFloat(2, cashwithdraw1 - Balance6 );
                ps.setInt(3,  Accnum);
                ps.executeUpdate();
                String insertTransacationTable = "INSERT INTO banking.transactiondetails" + "(AccNum,cahdeposit,cashwithdraw, balance,Date1) VALUES" + "(?,?,?,?,curdate())";
                PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement(insertTransacationTable);
                preparedStatement1.setInt(1,  Accnum);
                preparedStatement1.setFloat(2, Cashdeposit);
                preparedStatement1.setFloat(3, cashwithdraw1);
                preparedStatement1.setFloat(4,  cashwithdraw1 - Balance6  );
                preparedStatement1.executeUpdate();
                System.out.println("please collect your cash Thank you !!!! ");
            }
            conn.close();
        } catch (SQLException e) {
      e.printStackTrace();
        }
}
}
