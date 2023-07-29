package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;
import dto.LeaveDTO;
import utility.Connectionutility;

public class LeaveDAO implements DAO {

	public LeaveDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
         {
		   LeaveDTO adto = (LeaveDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "insert into leaves (empid,Leave_From,Leave_To,Leave_Type,Leave_Description) values(?,?,?,?,?)";
      	   
      	   
      	 PreparedStatement stmt = con.prepareStatement(strQuery);
      	 stmt.setInt(1, adto.getEmpid());
      	 stmt.setDate(2, adto.getLeaveFrom());
      	 stmt.setDate(3, adto.getLeaveTo());
      	 stmt.setString(4,adto.getLeaveType());
      	 stmt.setString(5,adto.getLeaveDesc());
      	   
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
		   LeaveDTO adto = (LeaveDTO) dto;
			   
		   Connection con =null;
     	   con=Connectionutility.getconnection2();
      	   String strQuery = "update leaves set Leave_From=?, Leave_To=?,Leave_Type=?,Leave_Description=? where empid=? and Leave_id=?";
      	   
     	
     	   PreparedStatement stmt = con.prepareStatement(strQuery);
     	 stmt.setInt(5, adto.getEmpid());
       	 stmt.setInt(6, adto.getLeaveId());
       	 stmt.setDate(1, adto.getLeaveFrom());
       	 stmt.setDate(2, adto.getLeaveTo());
       	 stmt.setString(3,adto.getLeaveType());
       	 stmt.setString(4,adto.getLeaveDesc());
     	   
     	   result = stmt.executeUpdate();   	 
     	  
        }
        catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
	}

	public int delete(int pk,int empid) throws Exception {
		int result = 0;
		
		 try
      {  
		   Connection con =null;
   	   con=Connectionutility.getconnection2();
   	   String strQuery = "delete from leaves where Leave_id="+pk+" and empid="+empid;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
	}

	public DTO retrieve(int pk,int empid) throws Exception {
		LeaveDTO dto = new LeaveDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from leaves where Leave_id="+pk+" and empid="+empid;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new LeaveDTO();
				    	dto.setLeaveId(rs.getInt(1));
				    	dto.setEmpid(rs.getInt(2));
				    	dto.setLeaveFrom(rs.getDate(3));
				    	dto.setLeaveTo(rs.getDate(4));
				    	dto.setLeaveType(rs.getString(5));
				    	dto.setLeaveDesc(rs.getString(6));
				 }
				    
				   
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll(int empid) throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		LeaveDTO dto = new LeaveDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from leaves where empid="+empid;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new LeaveDTO();
				    	dto.setLeaveId(rs.getInt(1));
				    	dto.setEmpid(rs.getInt(2));
				    	dto.setLeaveFrom(rs.getDate(3));
				    	dto.setLeaveTo(rs.getDate(4));
				    	dto.setLeaveType(rs.getString(5));
				    	dto.setLeaveDesc(rs.getString(6));
				    	
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
