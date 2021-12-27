package com.airline.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.airline.vo.Airplane;
import com.airline.vo.Flight;

public class AdminDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// 비행일정 추가
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
	
	// 모든 비행일정 리스트 검색
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

	// 비행기ID 로 비행기 검색
	public Airplane getAirplane(String airplaen_id) {

		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			
			Airplane airplane = mapper.getAirPlane(airplaen_id);
			return airplane;
		}catch(Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	// 비행기 flight_no으로 일정 삭제
	
	public int deleteFlight(int flight_no) {
		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			int result = mapper.deleteFlight(flight_no);
			session.commit();
			return result;
		} catch(Exception e) {
		e.printStackTrace();
		}
		return 0;
	}
	
	// 비행번호 확인
	public Flight findAirplaneId(int flight_no) {
		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			Flight flight = mapper.findAirplaneId(flight_no);
			return flight;	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 회원들의 비행 예약 삭제
	public int deleteReservation(int flight_no) {
		try(SqlSession session = factory.openSession()){
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			int result = mapper.deleteReservation(flight_no);
			session.commit();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
