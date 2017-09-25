package com.dat17v2.loginopg.DataLayer;

import java.sql.*;

public class Verification {

    public boolean verify(String user, String password){

        String pass = findUsersPass(user);

        if (pass != null){

            return pass.equals(password);
        }

        return false;
    }

    private String findUsersPass(String user){

        final	String	DB_URL	=	"jdbc:mysql://localhost:3306/";
        final	String	USER	=	"root";
        final	String	PASS	=	"MyNewPass";

        Connection conn	=	null;
        Statement stmt	=	null;
        String password = null;

        try
        {
            conn	=	DriverManager.getConnection(DB_URL,USER,PASS);
            stmt	=	conn.createStatement();

            String	sql	=	"select password from loginopg.logininf where user=\"" + user + "\";";
            ResultSet rs	=	stmt.executeQuery(sql);
            if (rs.next()) {


                password = rs.getString("password");

            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
            //JDBC
            se.printStackTrace();
        }

        finally
        {
            //finally	block	used	to	close	resources
            try
            {
                if(stmt!=null)
                    stmt.close();
            }
            catch(SQLException	se)
            {
                se.printStackTrace();
            }//	nothing	we can	do, give up
            try
            {
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException	se)
            {
                se.printStackTrace();
            }
        }

        return password;
    }
}

