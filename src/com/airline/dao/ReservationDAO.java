package com.airline.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.airline.vo.Airplane;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class ReservationDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// 해당ID 예약리스트 검색
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
	
	// 비행번호로 비행일정 검색
	public Flight selectFlightByFlightNo(int flight_no) {
		Flight flight = null;
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			
			flight = mapper.selectFlightByFlightNo(flight_no);
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return flight;
	}
	
	// 해당 출발지 도착지에 해당하는 비행일정 리스트 검색
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

		
	// 비행예약
	public boolean insertReservation(Reservation reser) {
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			mapper.updateMinusSeat(reser);
			mapper.insertReservation(reser);		
			session.commit();
			return true;	
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}
	
	// 비행예약삭제
	public boolean deleteReservation(int reser_no) {
		try(SqlSession session = factory.openSession()){
			ReservationMapper mapper = session.getMapper(ReservationMapper.class);
			Reservation reser = mapper.selectReserByReserNo(reser_no);
			mapper.updatePlusSeat(reser);
			mapper.deleteReservation(reser_no);		
			session.commit();
			return true;	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	//예약 수정
	public int UpdateReservation(Reservation reservation) {
		int result = 0;
		try(SqlSession sqlsession = factory.openSession()) {
			ReservationMapper mapper = sqlsession.getMapper(ReservationMapper.class);
			result = mapper.UpdateReservation(reservation);
			sqlsession.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
