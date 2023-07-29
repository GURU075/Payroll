package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.BankDTO;
import dto.DTO;
import utility.Connectionutility;

public class BankDAO implements DAO {

	public BankDAO() {
		// TODO Auto-generated constructor stub
	}

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
          {
		   BankDTO adto = (BankDTO) dto;
			   
		   Connection con =null;
       	   con=Connectionutility.getconnection2();
       	   String strQuery = "insert into bank values(?,?,?,?)";
       	   
       	   PreparedStatement stmt = con.prepareStatement(strQuery);
       	   stmt.setInt(1, adto.getBankId());
       	   stmt.setString(2, adto.getBankName());
       	   stmt.setString(3, adto.getBankBranch());
       	   stmt.setString(4, adto.getBankDesc());
       	   
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
		   BankDTO adto = (BankDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "update bank set Bank_Name=?, Bank_Branch=?, Bank_Description=? where Bank_Id=?";
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(4, adto.getBankId());
      	   stmt.setString(1, adto.getBankName());
      	   stmt.setString(2, adto.getBankBranch());
      	   stmt.setString(3, adto.getBankDesc());
      	   
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
    	   String strQuery = "delete from bank where Bank_id="+pk;
    	   
    	   Statement stmt = con.createStatement();
    	   result = stmt.executeUpdate(strQuery);

    	  
       }
       catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	public DTO retrieve(int pk) throws Exception {
		
		BankDTO dto = new BankDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from bank where Bank_id="+pk;
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	
			 	if(rs.next()) {
				    	
				    	dto = new BankDTO();
				    	dto.setBankId(rs.getInt(1));
				    	dto.setBankName(rs.getString(2));
				    	dto.setBankBranch(rs.getString(3));
				    	dto.setBankDesc(rs.getString(4));
				 }
				    
				    
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dto;
	}

	public List<DTO> retrieveAll() throws Exception {
		
		List<DTO> dtolst = new ArrayList<DTO>();
		BankDTO dto = new BankDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from bank";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new BankDTO();
				    	dto.setBankId(rs.getInt(1));
				    	dto.setBankName(rs.getString(2));
				    	dto.setBankBranch(rs.getString(3));
				    	dto.setBankDesc(rs.getString(4));
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
				    rs.close();
				    stmt.close();
				    
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

}