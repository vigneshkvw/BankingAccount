/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;

import com.mysql.jdbc.PreparedStatement;
import com.smhack.Banking.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viki
 */
class Existingaccount extends Bank {

    void existingaccount() {
    try {
            System.out.println("Enter your accont number");
            account.setAccNum(in.nextInt());
            System.out.print("Enter your  Pin Number: ");
			 account.setPinNum(in.next());
            getConnection();
           conn=Connection;
            sqlQuery = ("SELECT * FROM banking.logbook where pinNum = ? AND accountnumber = ?");
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlQuery);
            ps.setString(1, account.getPinNum() );
            ps.setInt(2,  account.getAccNum());


            ResultSet rs2 = (ResultSet) ps.executeQuery();
         if(rs2.next()) {
              System.out.println("The user is valid");


                sql = ("SELECT * FROM logbook where accountnumber = ? ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sql);
            preparedSelect.setInt(1, account.getAccNum());
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
            {
                System.out.println("\n\n\tmenu option");
                try {
                    while (true) {
                        System.out.println("1.CashDepost\t2.CashWithdraw\t3.checkbalance\t4.transactionDetails.");
                        int ch = in.nextInt();
                        switch (ch) {
                            case 1:
                                Deposit Q=new Deposit();
                                Q.deposit();
                                break;
                            case 2:
                                Withdraw W=new Withdraw();
                                W.withdraw();
                                break;
                            case 3:
                                Checkbalance C=new Checkbalance();
                                C.checkBalance();
                                break;
                         case 4:
                                Lasttransaction L=new Lasttransaction();
                                L.lasttransaction();
                                break;

                        }
                    }
                } catch (Exception e) {
e.printStackTrace();
                } finally {
                    in.close();
                }
            }
            conn.close();

        } else {
               System.out.println("You are not valid");
             }
 }      catch (SQLException ex) {
            Logger.getLogger(Existingaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
