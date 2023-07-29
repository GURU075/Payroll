package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;
import dto.EmpDeductionDTO;
import utility.Connectionutility;

public class EmpDeductionDAO implements DAO {

	
	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
        {
		   EmpDeductionDTO adto = (EmpDeductionDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "insert into empdeduction values(?,?,?,?)";
     	   
     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	   stmt.setInt(1, adto.getEmpid());
     	  stmt.setInt(2, adto.getDeductionid());
     	   stmt.setString(3, adto.getDeductionname());
     	  stmt.setInt(4, adto.getDeductionamt());
     	   
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
		   EmpDeductionDTO adto = (EmpDeductionDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "update empdeduction set deductionamt=? where empid=? and deductionid=?";
     	   
     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	   stmt.setInt(2, adto.getEmpid());
     	   stmt.setInt(3, adto.getDeductionid());
     	   stmt.setInt(1, adto.getDeductionamt());
     	   
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
   	   String strQuery = "delete from empdeduction where deductionid="+pk+" and empid="+lk;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}
	

	public DTO retrieve(int pk,int pk2) throws Exception {
		EmpDeductionDTO dto = new EmpDeductionDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery ="select * from empdeduction where empid="+pk+" and deductionid ="+pk2;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new EmpDeductionDTO();
				    	dto.setEmpid(rs.getInt(1));
				    	dto.setDeductionid(rs.getInt(2));
				    	dto.setDeductionname(rs.getString(3));
				    	dto.setDeductionamt(rs.getInt(4));
				 }
				    
				 
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll(int pk) throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		EmpDeductionDTO dto = new EmpDeductionDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from empdeduction where empid="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new EmpDeductionDTO();
				    	dto.setEmpid(rs.getInt(1));
				    	dto.setDeductionid(rs.getInt(2));
				    	dto.setDeductionname(rs.getString(3));
				    	dto.setDeductionamt(rs.getInt(4));
				    	
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


