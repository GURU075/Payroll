package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;
import dto.UserDTO;
import utility.Connectionutility;
import utility.Encryption_Decryption;

public class UserDAO implements DAO {

	public int insert(DTO dto) throws Exception {
		int result = 0;
		
		 try
         {
		   UserDTO adto = (UserDTO) dto;
			   
		   Connection con =null;
      	   con=Connectionutility.getconnection2();
      	   String strQuery = "insert into loginid values(?,?,?,?,?)";
      	   
      	 Encryption_Decryption ee=new Encryption_Decryption();
      	 String Encryped=ee.encrypt(adto.getUserPassword(),"Maddy");
      	   
      	   PreparedStatement stmt = con.prepareStatement(strQuery);
      	   stmt.setInt(1, adto.getUserid());
      	   stmt.setString(2, adto.getUser());
      	   stmt.setString(3, adto.getUserName());
      	   stmt.setString(4, Encryped);
      	   stmt.setString(5, adto.getUserPosition());
      	   
      	   result = stmt.executeUpdate();

      	  
         }
         catch(Exception e) {
 			e.printStackTrace();
 			
 		}	
		return result;
	}

	public int update(DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int pk) throws Exception {
		int result = 0;
		
		 try
      {  
		   Connection con =null;
   	   con=Connectionutility.getconnection2();
   	   String strQuery = "delete from loginid where userid="+pk;
   	   
   	   Statement stmt = con.createStatement();
   	   result = stmt.executeUpdate(strQuery);

   	  
      }
      catch(Exception e) {
			e.printStackTrace();
			
		}	
		return result;
		
	}

	

	
	public List<DTO> retrieveAll() throws Exception {
		List<DTO> dtolst = new ArrayList<DTO>();
		UserDTO dto = new UserDTO();
		
		 try {
			 
			 	Connection con = Connectionutility.getconnection2();
			 	Statement stmt = con.createStatement();
			 	String strQuery = "select * from loginid";
			 	
			 	ResultSet rs = stmt.executeQuery(strQuery);
			 	 
			 	
				    
				    while(rs.next()) {
				    	
				    	dto = new UserDTO();
				    	dto.setUserid(rs.getInt(1));
				    	dto.setUser(rs.getString(2));
				    	dto.setUserName(rs.getString(3));
				    	dto.setUserPassword(rs.getString(4));
				    	dto.setUserPosition(rs.getString(5));
				    	
				    	
				    	dtolst.add(dto);
				    	
				    }
				    
//				    rs.close();
//				    stmt.close();
//				    con.close();
			 	
			    
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				    
		return dtolst;
	}

	public DTO retrieve(int pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
