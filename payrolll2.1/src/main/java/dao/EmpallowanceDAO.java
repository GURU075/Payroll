package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;
import dto.EmpallowanceDTO;
import utility.Connectionutility;

public class EmpallowanceDAO implements DAO {

	
	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
        {
		   EmpallowanceDTO adto = (EmpallowanceDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "insert into empallowance values(?,?,?,?)";
     	   
     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	   stmt.setInt(1, adto.getEmpid());
     	  stmt.setInt(2, adto.getAllowanceid());
     	   stmt.setString(3, adto.getAllowancename());
     	  stmt.setInt(4, adto.getAllowanceamt());
     	   
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
		   EmpallowanceDTO adto = (EmpallowanceDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "update empallowance set allowance_amt=? where empid=? and allowance_id=?";
     	   
     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	   stmt.setInt(2, adto.getEmpid());
     	   stmt.setInt(3, adto.getAllowanceid());
     	   stmt.setInt(1, adto.getAllowanceamt());
     	   
     	   result = stmt.executeUpdate();   	 
     	  
        }
        catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}
	
	public int delete(int pk,int lk) throws Exception {
		int result = 0;
		
		 try
      {  
		   Connection con =null;
   	   con=Connectionutility.getconnection2();
   	   String strQuery = "delete from empallowance where allowance_id="+pk+" and empid="+lk;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}
	

	public DTO retrieve(int pk,int pk2) throws Exception {
		EmpallowanceDTO dto = new EmpallowanceDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery ="select * from empallowance where empid="+pk+" and allowance_id ="+pk2;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new EmpallowanceDTO();
				    	dto.setEmpid(rs.getInt(1));
				    	dto.setAllowanceid(rs.getInt(2));
				    	dto.setAllowancename(rs.getString(3));
				    	dto.setAllowanceamt(rs.getInt(4));
				 }
				    
				 
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll(int pk) throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		EmpallowanceDTO dto = new EmpallowanceDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from empallowance where empid="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new EmpallowanceDTO();
				    	dto.setEmpid(rs.getInt(1));
				    	dto.setAllowanceid(rs.getInt(2));
				    	dto.setAllowancename(rs.getString(3));
				    	dto.setAllowanceamt(rs.getInt(4));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				  
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

	public List<DTO> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(int pk) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public DTO retrieve(int pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}


