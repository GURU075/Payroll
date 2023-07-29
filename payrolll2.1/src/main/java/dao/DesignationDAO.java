package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DesignationDTO;
import dto.AllowanceDTO;
import dto.DTO;
import utility.Connectionutility;

public class DesignationDAO implements DAO {

	public DesignationDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
         {
			 DesignationDTO adto = (DesignationDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "insert into designation values(?,?,?)";
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(1, adto.getDesignationId());
      	   stmt.setString(2, adto.getDesignationName());
      	   stmt.setString(3, adto.getDesignationDesc());
      	   
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
			 DesignationDTO adto = (DesignationDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "update designation set Designation_Name=?, Designation_Description=? where Designation_Id=?";

     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	   stmt.setInt(3, adto.getDesignationId());
     	   stmt.setString(1, adto.getDesignationName());
     	   stmt.setString(2, adto.getDesignationDesc());
     	   
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
   	   String strQuery = "delete from designation where Designation_Id="+pk;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	public DTO retrieve(int pk) throws Exception {
		DesignationDTO dto = new DesignationDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from designation where Designation_Id="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new DesignationDTO();
				    	dto.setDesignationId(rs.getInt(1));
				    	dto.setDesignationName(rs.getString(2));
				    	dto.setDesignationDesc(rs.getString(3));
				 }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		DesignationDTO dto = new DesignationDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from designation";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new DesignationDTO();
				    	dto.setDesignationId(rs.getInt(1));
				    	dto.setDesignationName(rs.getString(2));
				    	dto.setDesignationDesc(rs.getString(3));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
			    
		return dtolst;
	}

}
