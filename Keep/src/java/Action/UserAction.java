/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import ConnetionUtil.ConnectionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author Rishabh
 */
public class UserAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONArray array=new JSONArray();
        JSONArray array1=new JSONArray();
        JSONObject object1=new JSONObject();
        JSONArray array2=new JSONArray();
        JSONObject object2=new JSONObject();
        PrintWriter out=response.getWriter();
       // String action=request.getParameter("action");
        String text=request.getParameter("value");
        String action=request.getParameter("action");
       // String idhtml=request.getParameter("idhtml");
       
        String id=request.getParameter("id");
        Connection conn=ConnectionUtil.getConnection();
      if(action.equals("save")){
       try {
            PreparedStatement smnt=conn.prepareStatement("insert into keep (id,texts) values(?,?)");
            smnt.setString(1, id);
            smnt.setString(2,text);
            smnt.executeUpdate();
            PreparedStatement smnt1=conn.prepareStatement("select id,texts from keep where id=?");
            smnt1.setString(1, id);
            ResultSet rs=smnt1.executeQuery();
            rs.next();
            String idOfBox=rs.getString(1);
            String mainText= rs.getString(2);
           try{
               object1.put("idOfBox",idOfBox);
               object1.put("mainText",mainText);
               array1.put(object1);
           }
           catch(JSONException e){
               System.out.println("JSON ERROR IN SAVING BLOCK");
           }
           out.print(array1);
        }catch (SQLException ex) {
         System.out.println(ex.getMessage());
         String nestedId="";
         try{
         PreparedStatement smnt2=conn.prepareStatement("select id from keep");
         ResultSet rh=smnt2.executeQuery();
         while(rh.next()){
         if(rh.isLast())
         {
          nestedId=rh.getString(1);   
         }
         }
         System.out.println("Value of id"+nestedId);
         int typecastid=Integer.parseInt(nestedId);
         typecastid=typecastid+1;
         PreparedStatement smnt=conn.prepareStatement("insert into keep (id,texts) values(?,?)");
         smnt.setInt(1,typecastid);
         smnt.setString(2,text);
         smnt.executeUpdate();
         PreparedStatement smnt3=conn.prepareStatement("select id,texts from keep where id=?");
         smnt3.setInt(1,typecastid);
         ResultSet rs=smnt3.executeQuery();
         rs.next();
         String ids=rs.getString(1);
         String texts=rs.getString(2);
         try{
         object2.put("idOfBox",ids);
         object2.put("mainText",texts);
         array2.put(object2);
         out.print(array2);
         }
         catch(JSONException e){
             System.out.println("NESTED JSON ERROR");
         }
         }
         catch(SQLException e){
             System.out.println("SQL ERROR IN NESTED");
         }
         }
       
     }
      else if(action.equals("get")){       
          PreparedStatement smnt1;
            try {
            smnt1 = conn.prepareStatement("select texts,id from keep");
        
            ResultSet rd=smnt1.executeQuery();
            String texts="";
            String iddiv="";
            while(rd.next()){
                try{
            JSONObject object=new JSONObject();
            texts=rd.getString(1);
            iddiv=rd.getString(2);
            object.put("text",texts);
            object.put("iddiv",iddiv);
            array.put(object);
                }
                catch(JSONException e)
                {
            System.out.println("JSON OBJECT ERROR");
                }
            }
            out.print(array);
            }
           catch (SQLException ex) {
                Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(NullPointerException e){
                out.print("NOT");
            }
          
    }
      else if(action.equals("update")){
          PreparedStatement smnt1;
            try {
            smnt1 = conn.prepareStatement("update  keep set texts=? where id=?");
            smnt1.setString(1, text);
            smnt1.setString(2,id);
            smnt1.executeUpdate();
            }
           catch (SQLException ex) {
                Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(NullPointerException e){
                out.print("NOT");
            }
           out.println("UPDATED");
      }
      else if(action.equals("delete")){
      
              PreparedStatement smnt1;
            try {
            smnt1 = conn.prepareStatement("delete from keep where id=?");
            smnt1.setString(1, id);
            smnt1.executeUpdate();
            }
           catch (SQLException ex) {
                Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(NullPointerException e){
                out.print("NOT");
            }
      }
    }

}
