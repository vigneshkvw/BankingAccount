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
class Withdraw extends Bank {
public void withdraw() throws SQLException {
        try {

            System.out.println("Enter the amount to be withdrawn :");
            float cashwithdraw1 =in.nextFloat();
            getConnection();
            conn=Connection;

            sqlQuery = ("SELECT balance FROM banking.logbook where accountnumber = ? ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
            preparedSelect.setInt(1,  account.getAccNum());
            ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {
                int Balance6 = rs1.getInt("balance");

                PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update logbook set cashwithdraw = ?, balance = ? where accountnumber = ?");
                    ps.setFloat(1, cashwithdraw1);
                    ps.setFloat(2, Balance6-cashwithdraw1);
                    System.out.print(Balance6-cashwithdraw1);
                    ps.setInt(3,  account.getAccNum());
                    ps.executeUpdate();
                    String insertTransacationTable = "INSERT INTO banking.transactiondetails" + "(AccNum,cahdeposit,cashwithdraw, balance,Date1) VALUES" + "(?,?,?,?,curdate())";
                PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement(insertTransacationTable);
                preparedStatement1.setInt(1,  account.getAccNum());
                preparedStatement1.setFloat(2, Cashdeposit      );
                preparedStatement1.setFloat(3, cashwithdraw1);
                preparedStatement1.setFloat(4,   Balance6-cashwithdraw1);
                preparedStatement1.executeUpdate();

               System.out.println("collect your cash");
            }
conn.close();
        } catch (SQLException e) {
      e.printStackTrace();
        }

                        }


}
