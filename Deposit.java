/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;
import com.mysql.jdbc.Connection;
import com.smhack.Banking.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Deposit extends verification {
   
    public String sqlQuery;
  	public void deposit() throws SQLException {
        verify();
        try {
            System.out.println("enter your ammount to deposit::");
        float cashdepositamount1 = in.nextFloat();
            getConnection();
            sqlQuery = ("SELECT balance FROM logbook where accountnumber = ? ");
                PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
                preparedSelect.setInt(1, Accnum);
                ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
                while (rs1.next()) {
                    float Balance5 = rs1.getFloat("balance");
                    java.sql.PreparedStatement ps = conn.prepareStatement("update logbook set cashdeposit= ?,balance= ? where accountnumber= ?");
                        ps.setFloat(1, cashdepositamount1);
                        ps.setFloat(2,  Balance5+cashdepositamount1 );
                        ps.setInt(3, Accnum);
System.out.println(Balance5+cashdepositamount1);
                        ps.executeUpdate();
                        String insertTransacationTable = "INSERT INTO transactiondetails" + "(AccNum,  cahdeposit,cashwithdraw, balance,Date1) VALUES" + "(?,?,?,?,curdate())";
                        java.sql.PreparedStatement preparedStatement1 = conn.prepareStatement(insertTransacationTable);
                        preparedStatement1.setInt(1, Accnum);
                        preparedStatement1.setFloat(2, cashdepositamount1);
                        preparedStatement1.setFloat(3, 0);
                        preparedStatement1.setFloat(4,Balance5+cashdepositamount1);
                        preparedStatement1.executeUpdate();
                    }
                System.out.println("your cash had been deposit  Thank you !!!!!");
   conn.close();
        } catch (SQLException ex) {
              ex.printStackTrace();
        }


    }
}
