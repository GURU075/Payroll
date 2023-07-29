package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.Connectionutility;
import dto.AllowanceDTO;
import dto.DTO;

public class AllowanceDAO implements DAO {

	public AllowanceDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
          {
		   AllowanceDTO adto = (AllowanceDTO) dto;
			   
		   Connection con =null;
       	   con=Connectionutility.getconnection2();
       	   String strQuery = "insert into allowance values(?,?,?)";
       	   
       	   PreparedStatement stmt = con.prepareStatement(strQuery);
       	   stmt.setInt(1, adto.getAllowanceId());
       	   stmt.setString(2, adto.getAllowanceName());
       	   stmt.setString(3, adto.getAllowanceDesc());
       	   
       	   result = stmt.executeUpdate();

       	  
          }
          catch(Exception e) {
  			e.printStackTrace();
  			
  		}	
		return result;
	}

	

	public int update(DTO dto) throws Exception {
		int result = 0;
		
		 try
         {
		   AllowanceDTO adto = (AllowanceDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "update allowance set Allowance_Name=?, Allowance_Description=? where Allowance_Id=?";
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(3, adto.getAllowanceId());
      	   stmt.setString(1, adto.getAllowanceName());
      	   stmt.setString(2, adto.getAllowanceDesc());
      	   
      	   result = stmt.executeUpdate();   	 
      	  
         }
         catch(Exception e) {
 			e.printStackTrace();
 			
 		}	
		return result;
		
	}

	public int delete(int pk) throws Exception {
		int result = 0;
		
		 try
       {  
		   Connection con =null;
    	   con=Connectionutility.getconnection2();
    	   String strQuery = "delete from allowance where Allowance_id="+pk;
    	   
    	   Statement stmt = con.createStatement();
    	   result = stmt.executeUpdate(strQuery);

    	  
       }
       catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	public DTO retrieve(int pk) throws Exception {
		
		AllowanceDTO dto = new AllowanceDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from allowance where Allowance_id="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new AllowanceDTO();
				    	dto.setAllowanceId(rs.getInt(1));
				    	dto.setAllowanceName(rs.getString(2));
				    	dto.setAllowanceDesc(rs.getString(3));
				 }
				    
				    
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		
		List<DTO> dtolst = new ArrayList<DTO>();
		AllowanceDTO dto = new AllowanceDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from allowance";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new AllowanceDTO();
				    	dto.setAllowanceId(rs.getInt(1));
				    	dto.setAllowanceName(rs.getString(2));
				    	dto.setAllowanceDesc(rs.getString(3));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

}