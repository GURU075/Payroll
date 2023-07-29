package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;
import dto.EmpallowanceDTO;
import dto.EmployeeBankDTO;
import utility.Connectionutility;

public class EmployeeBankDAO implements DAO {

	public EmployeeBankDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
       {
		   EmployeeBankDTO adto = (EmployeeBankDTO) dto;
			   
		   Connection con =null;
    	   con=Connectionutility.getconnection2();
    	   String strQuery = "insert into employeebank values(?,?,?,?,?)";
    	   
    	   PreparedStatement stmt = con.prepareStatement(strQuery);
    	   stmt.setInt(1, adto.getEmpid());
    	   stmt.setInt(2, adto.getBankid());
    	  
    	  stmt.setString(3, adto.getBankName());
    	  stmt.setString(4, adto.getBankBranch());
    	  stmt.setLong(5,adto.getBankAcc());
    	   
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
			 EmployeeBankDTO adto = (EmployeeBankDTO) dto;
			   
		   Connection con =null;
    	   con=Connectionutility.getconnection2();
    	   String strQuery = "update employeebank set Bank_Name=?,Bank_Branch=?,account_no=?,Bankid=? where empid=?";
    	   
    	   PreparedStatement stmt = con.prepareStatement(strQuery);
    	   
    	   stmt.setString(1, adto.getBankName());
    	   stmt.setString(2, adto.getBankBranch());
    	   stmt.setLong(3, adto.getBankAcc());
    	   
    	   stmt.setInt(5, adto.getEmpid());
    	   stmt.setInt(4, adto.getBankid());
    	   
    	   
    	   
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
			 String strQuery = "delete from employeebank where Bankid="+pk+" and empid="+lk;
  	   
  	   Statement stmt = con.createStatement();
  	   result = stmt.executeUpdate(strQuery);

  	  
     }
     catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	public DTO retrieve(int pk,int pk2) throws Exception {
		EmployeeBankDTO dto = new EmployeeBankDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery ="select * from employeebank where empid="+pk+" and Bankid ="+pk2;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new EmployeeBankDTO();
				    	
				    	dto.setEmpid(rs.getInt(1));
				    	dto.setBankid(rs.getInt(2));
				    	dto.setBankName(rs.getString(3));
				    	dto.setBankBranch(rs.getString(4));
				    	dto.setBankAcc(rs.getLong(5));
				 }
				    
				 
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll(int pk) throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		EmployeeBankDTO dto = new EmployeeBankDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from employeebank where empid="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new EmployeeBankDTO();
				    	dto.setEmpid(rs.getInt(1));
				    	
				    	dto.setBankid(rs.getInt(2));
				    	dto.setBankName(rs.getString(3));
				    	dto.setBankBranch(rs.getString(4));
				    	dto.setBankAcc(rs.getLong(5));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				  
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

	public int delete(int pk) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public DTO retrieve(int pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
