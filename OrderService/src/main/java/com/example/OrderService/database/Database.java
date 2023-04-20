package com.example.OrderService.database;

import com.example.OrderService.RESTApi.model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

        private static final String url = "jdbc:h2:D:\\Scala Labs\\list3_db\\order";
        private static final String user ="user";
        private static final String password="user";

        private static Connection con;
        private static Statement stmt;
        private static ResultSet rs;

        public List<Orders> orders = new ArrayList<>();

        public List<Orders> getInfo(Integer id){
            try {
                Class.forName("org.h2.Driver");

                con = DriverManager.getConnection(url,user,password);
                stmt = con.createStatement();

                rs = stmt.executeQuery("SELECT * FROM ORDERS WHERE ID ="+id);
                while(rs.next()){
//                    Order order = new Order(rs.getInt("ID"),rs.getString("CUSTOMER_NAME"),rs.getString("DELIVERY"));
//                    orders.add(order);
                }


            }catch (SQLException sqlEx){
                sqlEx.printStackTrace();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }finally{
                try{ con.close(); }catch(SQLException se){}
                try{ stmt.close(); }catch(SQLException se){}
                try {rs.close();} catch(SQLException se){}
                return orders;
            }


        }

    public String setInfo(long id,String customer_name,String items,String delivery){
        try {
            Class.forName("org.h2.Driver");

            con = DriverManager.getConnection(url,user,password);
            stmt = con.createStatement();

            rs = stmt.executeQuery("INSERT INTO ORDERS VALUES("+id+","+customer_name+","+items+","+delivery+","+")");


        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
            return "Not added";
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return "Not added";
        }finally{
            try{ con.close(); }catch(SQLException se){}
            try{ stmt.close(); }catch(SQLException se){}
            try {rs.close();} catch(SQLException se){}
            return "Added";
        }


    }

}
