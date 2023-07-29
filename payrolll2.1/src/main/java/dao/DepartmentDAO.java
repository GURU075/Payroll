package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.Connectionutility;
import dto.DepartmentDTO;
import dto.DTO;

public class DepartmentDAO implements DAO {

	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
          {
		   DepartmentDTO adto = (DepartmentDTO) dto;
			   
		   Connection con =null;
       	   con=Connectionutility.getconnection2();
       	   String strQuery = "insert into department values(?,?,?,?)";
       	   
       	   PreparedStatement stmt = con.prepareStatement(strQuery);
       	   stmt.setInt(1, adto.getDepartmentId());
       	   stmt.setString(2, adto.getDepartmentName());
       	   stmt.setString(3, adto.getDepartmentLocation());
       	   stmt.setString(4, adto.getDepartmentDesc());
       	   
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
		   DepartmentDTO adto = (DepartmentDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "update department set Dep_Name=?, Dep_Location=?, Dep_Description=? where Dep_Id=?";
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(4, adto.getDepartmentId());
      	   stmt.setString(1, adto.getDepartmentName());
      	   stmt.setString(2, adto.getDepartmentLocation());
      	   stmt.setString(3, adto.getDepartmentDesc());
      	   
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
    	   String strQuery = "delete from department where Dep_id="+pk;
    	   
    	   Statement stmt = con.createStatement();
    	   result = stmt.executeUpdate(strQuery);

    	  
       }
       catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	public DTO retrieve(int pk) throws Exception {
		
		DepartmentDTO dto = new DepartmentDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from department where Dep_id="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new DepartmentDTO();
				    	dto.setDepartmentId(rs.getInt(1));
				    	dto.setDepartmentName(rs.getString(2));
				    	dto.setDepartmentLocation(rs.getString(3));
				    	dto.setDepartmentDesc(rs.getString(4));
				 }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		
		List<DTO> dtolst = new ArrayList<DTO>();
		DepartmentDTO dto = new DepartmentDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from department";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new DepartmentDTO();
				    	dto.setDepartmentId(rs.getInt(1));
				    	dto.setDepartmentName(rs.getString(2));
				    	dto.setDepartmentLocation(rs.getString(3));
				    	dto.setDepartmentDesc(rs.getString(4));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

}