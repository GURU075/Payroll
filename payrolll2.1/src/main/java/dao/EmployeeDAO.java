package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.AllowanceDTO;
import dto.DTO;
import dto.EmployeeDTO;
import utility.Connectionutility;

public class EmployeeDAO implements DAO {

	public EmployeeDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(DTO dto) throws Exception {
		int result = 0;
		
		 try
        {
		   EmployeeDTO adto = (EmployeeDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
     	   String strQuery = "update employee set employeename=?,employeeaddress=?,employeestate=?,employeeemail=?,employeemobno=?,employeegender=?,employeelang=? where employeeid=?";
     	   
     	  PreparedStatement stmt=con.prepareStatement(strQuery);
			stmt.setString(1,adto.getEmpName());
			stmt.setString(2,adto.getEmpAddress());
			stmt.setString(3,adto.getEmpState());
			stmt.setString(4,adto.getEmpEmail());
			stmt.setString(5,adto.getEmpMobileno());
			stmt.setString(6,adto.getEmpGender());
//			stmt.setString(7,adto.getEmpLang());
//			for(int i=0;i<adto.getEmpLang().length;i++)
//			{
//			stmt.setString(7,adto.getEmpLang()[i]);
//			}
			stmt.setInt(8,adto.getEmpId());
     	   
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
   	   String strQuery = "delete from employee where employeeid="+pk;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}
	public DTO retrieve(int pk) throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from employee where employeeid="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
			 		dto = new EmployeeDTO();
			    	dto.setEmpId(rs.getInt(1));
			    	dto.setEmpName(rs.getString(2));
			    	dto.setEmpAddress(rs.getString(3));
			    	dto.setEmpState(rs.getString(4));
			    	dto.setEmpEmail(rs.getString(5));
			    	dto.setEmpMobileno(rs.getString(6));
			    	dto.setEmpGender(rs.getString(7));
			    	dto.setEmppan(rs.getString(8));
			    	dto.setEmpDOJ(rs.getDate(9));
			    	dto.setEmpdepartment(rs.getString(10));
			    	dto.setEmpdesignation(rs.getString(11));
			    	dto.setEmpbankaccno(rs.getString(12));
			    	dto.setEmpbankname(rs.getString(13));
				 }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		EmployeeDTO dto = new EmployeeDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from employee";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new EmployeeDTO();
				    	dto.setEmpId(rs.getInt(1));
				    	dto.setEmpName(rs.getString(2));
				    	dto.setEmpAddress(rs.getString(3));
				    	dto.setEmpState(rs.getString(4));
				    	dto.setEmpEmail(rs.getString(5));
				    	dto.setEmpMobileno(rs.getString(6));
				    	dto.setEmpGender(rs.getString(7));
				    	dto.setEmppan(rs.getString(8));
				    	dto.setEmpDOJ(rs.getDate(9));
				    	dto.setEmpdepartment(rs.getString(10));
				    	dto.setEmpdesignation(rs.getString(11));
				    	dto.setEmpbankaccno(rs.getString(12));
				    	dto.setEmpbankname(rs.getString(13));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}
	

}
