package dao;

import java.util.List;

import dto.DTO;

public interface DAO {
	// CRUD operations 
	
	public int insert(DTO dto) throws Exception;
	public int update(DTO dto) throws Exception;
	public int delete(int pk) throws Exception;
	public DTO retrieve(int pk) throws Exception;
	public List<DTO> retrieveAll() throws Exception;
	
}