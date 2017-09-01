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
class Deposit extends Bank {
float cashdepositamount1;
    private float cashwithdraw;
  	public void deposit() {
        try {

            System.out.println("enter your ammount to deposit::");
             cashdepositamount1 = in.nextFloat();
            getConnection();
            conn=Connection;
                sqlQuery = ("SELECT balance FROM banking.logbook where accountnumber = ? ");
                PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
                preparedSelect.setInt(1, account.getAccNum());
                ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
                while (rs1.next()) {
                    int Balance5 = rs1.getInt("balance");
                    java.sql.PreparedStatement ps = conn.prepareStatement("update banking.logbook set cashdeposit= ?,balance=? where accountnumber=?");
                    while (true) {

                        ps.setFloat(1, cashdepositamount1);
                        ps.setFloat(2, cashdepositamount1 + Balance5);
                        ps.setInt(3, account.getAccNum());
                        ps.executeUpdate();
                    String insertTransacationTable = "INSERT INTO transactiondetails" + "(AccNum,  cahdeposit,cashwithdraw, balance,Date1) VALUES" + "(?,?,?,?,curdate())";
                    java.sql.PreparedStatement preparedStatement1 = conn.prepareStatement(insertTransacationTable);
                    preparedStatement1.setInt(1, account.getAccNum());
                    preparedStatement1.setFloat(2, cashdepositamount1);
                    preparedStatement1.setFloat(3, cashwithdraw);
                    preparedStatement1.setFloat(4, cashdepositamount1 + Balance5);
                    preparedStatement1.executeUpdate();
                }
                }
            conn.close();
 System.out.println("your cah had been deposit");
        } catch (SQLException ex) {
              ex.printStackTrace();
        }

    }
}
