package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.Connectionutility;
import dto.deductionDTO;
import dto.DTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeductionDAO implements DAO {

	public DeductionDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
          {
		   deductionDTO adto = (deductionDTO) dto;
			   
		   Connection con =null;
       	   con=Connectionutility.getconnection2();
       	   String strQuery = "insert into deduction values(?,?,?)";
       	   
       	   PreparedStatement stmt = con.prepareStatement(strQuery);
       	   stmt.setInt(1, adto.getdeductionId());
       	   stmt.setString(2, adto.getdeductionName());
       	   stmt.setString(3, adto.getdeductionDesc());
       	   
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
		   deductionDTO adto = (deductionDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "update deduction set Ded_Name=?, Ded_Description=? where Ded_id=?";
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(3, adto.getdeductionId());
      	   stmt.setString(1, adto.getdeductionName());
      	   stmt.setString(2, adto.getdeductionDesc());
      	   
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
    	   String strQuery = "delete from deduction where ded_id="+pk;
    	   
    	   Statement stmt = con.createStatement();
    	   result = stmt.executeUpdate(strQuery);

    	  
       }
       catch(Exception e) {
			e.printStackTrace();
			
		}	
			 
		return result;
		
}

	public DTO retrieve(int pk) throws Exception {
		
		deductionDTO dto = new deductionDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from deduction where ded_id="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new deductionDTO();
				    	dto.setdeductionId(rs.getInt(1));
				    	dto.setdeductionName(rs.getString(2));
				    	dto.setdeductionDesc(rs.getString(3));
				 }
				    
				    rs.close();
				    stmt.close();
				    con.close();
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		
		List<DTO> dtolst = new ArrayList<DTO>();
		deductionDTO dto = new deductionDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from deduction";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new deductionDTO();
				    	dto.setdeductionId(rs.getInt(1));
				    	dto.setdeductionName(rs.getString(2));
				    	dto.setdeductionDesc(rs.getString(3));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

}