/**
 * 
 */
package com.model.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.model.vo.CarVO;

/**
 * @author Kritik Garg
 *
 */
@Repository
public interface CarDaoInterface {
	/**
	 * return all cars data
	 * @return
	 */
	@Bean
	public List<CarVO> getAllCars() ;
	
	/**
	 * find car by id
	 * @param id
	 * @return
	 */
	@Bean
	public List<CarVO> findCarbyId(int id);
	
	/**
	 * insert carvo in database 
	 * @param carvo
	 * @return
	 */
	@Bean
	public int insert(CarVO carvo);
	
	/**
	 * delete by id
	 * @param id
	 * @return
	 */
	@Bean
	public boolean deleteById(int id);
	
	/**
	 * update carvo data
	 * @param carvo
	 * @return
	 */
	@Bean
	public boolean update(CarVO carvo);

	

}
