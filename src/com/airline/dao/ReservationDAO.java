package com.airline.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class ReservationDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insertReservation(Reservation reser) {
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			mapper.insertReservation(reser);		
			session.commit();
			return true;	
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Reservation> selectReserListById(String user_id) {
		ArrayList<Reservation> reserList = null;
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			
			reserList = mapper.selectReserListById(user_id);		
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return reserList;
	}

	public Flight selectFlightByFlightNo(String flight_no) {
		Flight flight = null;
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			
			flight = mapper.selectFlightByFlightNo(flight_no);
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return flight;
	}

	public boolean deleteReservation(int reser_no) {
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			
			mapper.deleteReservation(reser_no);		
			session.commit();
			return true;	
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Flight> getFlightListByPlace(Flight flight) {
		ArrayList<Flight> reserList = new ArrayList<>();
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			
			reserList.addAll(mapper.getFlightListByPlace(flight));
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return reserList;
	}

}
