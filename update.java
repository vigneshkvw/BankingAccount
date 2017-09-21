class update extends verification{


    void updatedata() {
 try {
                    while (true) {
                        System.out.println("1.update Password\t2.Name\t3.address\t4.state.\t5.pincode");
                        int ch = in.nextInt();
                        switch (ch) {
                            case 1:
                                password UP =new password();
                                UP.updatepassword();
                                break;
                            case 2:
                                UserName N=new UserName();
                                N.updateName();
                                break;
                            case 3:
                                address A=new address();
                                A.updateAddress();
                                break;
                         case 4:
                            state S=new state();
                            S.updatestate();
                             break;
                            case 5:
                               pincode P=new pincode();
                               P.updatepincode();
                                break;
                        }
                    }
                } catch (Exception e) {
e.printStackTrace();
                } finally {
                    in.close();
                }

    }

}
