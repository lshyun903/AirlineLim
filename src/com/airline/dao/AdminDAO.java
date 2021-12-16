package com.airline.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class AdminDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insertFlight(Flight flight) {
		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			mapper.insertFlight(flight);
			session.commit();
			return true;
		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Flight> getFlightList() {
		ArrayList<Flight> reserList = new ArrayList<>();
		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			
			reserList.addAll(mapper.getFlightList());
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return reserList;
	}
	

}
