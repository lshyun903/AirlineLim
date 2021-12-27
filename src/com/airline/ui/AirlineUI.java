package com.airline.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.airline.control.AdminManager;
import com.airline.control.ReservationManager;
import com.airline.control.UserManager;
import com.airline.vo.Airplane;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;
import com.airline.vo.User;

public class AirlineUI {
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager = new UserManager();
	private AdminManager adminManager = new AdminManager();
	private ReservationManager reservationManager = new ReservationManager();
	
	/*
	------------------------------------- 
	메인화면
 	-------------------------------------
 	*/
	public AirlineUI() {
		while(true) {
			System.out.println("-------------------------");
			System.out.println("에어라인에 오신것을 환영 합니다.");
			System.out.println("-------------------------");
			if (!userManager.isLogin()) {
				System.out.println("1. 로그인/회원가입");
			} else {
				System.out.println("1. 로그아웃/회원정보수정");
			}
			System.out.println("2. 예약하기");
			System.out.println("3. 예약내역");
			System.out.println("4. 관리자 모드");
			System.out.println("-------------------------");
			System.out.print("선택 : ");
			int input = scan.nextInt();
			
			switch(input) {
				case 1:userUI(); break;
				case 2:reservationUI(); break;
				case 3:getReserListById(); break;
				case 4:adminUI();break;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
		}
	}
	
	
	
	
	/*
	------------------------------------- 
	로그인 로그아웃 회원가입
 	-------------------------------------
 	*/
	
	// 회원UI
	public void userUI() {
		if (userManager.isLogin()) {
			System.out.println("1. 로그아웃");
			System.out.println("2. 회원정보수정");
			System.out.println("-------------------------");
			System.out.print("선택 : ");
			
			int input = scan.nextInt();
			
			switch(input) {
				case 1:userManager.logout();break;
				case 2:updateUser(); break;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
		} else {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("-------------------------");
			System.out.print("선택 : ");
			
			int input = scan.nextInt();
			
			switch(input) {
				case 1:loginUI(); break;
				case 2:joinUserUI(); break;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
		}
	}
	
	// 로그인
	public void loginUI() {
		System.out.print("아이디 : ");
		String user_id = scan.next();
		System.out.print("패스워드 : ");
		String passwd = scan.next();
		if (userManager.login(user_id, passwd)) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("아이디/패스워드가 일치하지 않습니다.");
		}
	}
	
	// 회원가입
	public void joinUserUI() {
		scan.nextLine();
		System.out.println("회원가입");
		System.out.println("-------------------------");
		System.out.print("아이디 : ");
		String user_id = scan.nextLine();
		System.out.print("패스워드 : ");
		String passwd = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = scan.nextLine();
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		User user = new User(user_id, passwd, name, email, phone, address);
		
		if (userManager.joinUser(user)) {
			System.out.println("회원가입에 성공 했습니다.");
		} else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}
	
	// 회원정보수정
	private void updateUser() {
		
	}

	
	
	
	
	/*
	------------------------------------- 
	예약하기
 	-------------------------------------
 	*/
	
	// 비행일정출력
	private void reservationUI() {
		if (!userManager.isLogin()) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		scan.nextLine();
		System.out.println("비행일정");
		System.out.println("-------------------------");
		System.out.print("출발지:");
		String departure = scan.nextLine();
		System.out.print("도착지:");
		String arrival = scan.nextLine();
		ArrayList<Flight> flightList = reservationManager.getFlightListByPlace(departure, arrival);
		System.out.println("비행번호\t출발지\t도착지\t가격\t출발날짜\t\t\t도착날짜\t\t\t소요시간\t잔여좌석");
		
		if (flightList == null || flightList.size() < 1) {
			System.out.println("현재 예정인 비행이 없습니다.");
			return;
		}
		
		for (Flight flight: flightList) {
			System.out.println(flight);
		}
		
		reserFlightUI();
	}
	
	// 비행예약입력
	private void reserFlightUI() {
		System.out.println("-------------------------");
		System.out.println("비행번호와 수량을 입력해 주세요");
		System.out.print("운행 NO : ");
		int flight_no = scan.nextInt();
		System.out.print("인원 : ");
		int reser_people = scan.nextInt();
		
		System.out.println("예약내역");
		System.out.println("NO : " + flight_no + " 인원 : " + reser_people );
		if (reservationManager.reserFlight(flight_no, reser_people, userManager.getLogin_id())) {
			System.out.println("예약에 성공했습니다.");
		} else {
			System.out.println("잔여좌석을 초과했거나 인원이 1명 미만입니다.");
		}
	}

	
	
	
	
	/*
	------------------------------------- 
	회원예약내역
 	-------------------------------------
 	*/
	
	private void getReserListById() {
		if (!userManager.isLogin()) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		
		ArrayList<Reservation> reserList = reservationManager.selectReserListById(userManager.getLogin_id());
		
		if(reserList == null || reserList.size() < 1) {
			System.out.println("예약 내역이 없습니다.");
			return;
		}
		
		System.out.println("전체 주문내역");
		System.out.print("예약번호\t예약자\t예약인원\t결제가격\t");
		System.out.println("출발지\t도착지\t출발날짜\t\t\t도착날짜");
	
		for (Reservation reser : reserList) {
			System.out.print(reser);
			Flight flight = reservationManager.selectFlightByFlightNo(reser.getFlight_no());
			System.out.println(flight.getDeparture() + "\t" + flight.getArrival() + "\t" + flight.getDeparture_date() + "\t" + flight.getDeparture_date());
		}	
		
		System.out.print("예약수정(1) 예약취소(2) 메인화면(3) : ");
		int input = scan.nextInt();
		switch(input) {
			case 1:updateReservation(); break;
			case 2:deleteReservation(); break;
			case 3:return;
			default:System.out.println("번호를 잘못 입력했습니다.");
		}
	}
	
	// 비행예약수정
	private void updateReservation() {
		
	}


	
	
	
	/*
	------------------------------------- 
	관리자 모드
 	-------------------------------------
 	*/
	
	// 관리자UI
	public void adminUI() {
		System.out.print("관리자 패스워드 : ");
		String passwd = scan.next();
		
		if (!adminManager.admin_login(passwd)) {
			System.out.println("패스워드가 다릅니다.");			
		}
		
		System.out.print("일정추가(1) 일정삭제(2) 예약취소(3) 메인화면(4) : ");
		int input = scan.nextInt();
		switch(input) {
			case 1:insertFlight(); break;
			case 2:deleteFlight(); break;
			case 3:deleteReservation(); break;
			case 4:return;
			default:System.out.println("번호를 잘못 입력했습니다.");
		}
	}
	
	// 비행일정입력
	private void insertFlight() {
		
		System.out.println("비행일정");
		System.out.println("-------------------------");
		ArrayList<Flight> flightList = adminManager.getFlightList();
		System.out.println("비행번호\t출발지\t도착지\t가격\t출발날짜\t\t\t도착날짜\t\t\t소요시간\t남은좌석");
		if (flightList != null && flightList.size() > 0) {
			for (Flight flight: flightList) {
				System.out.println(flight);
			}
			
		} else {
			System.out.println("현재 예정인 비행이 없습니다.");
		}
		scan.nextLine();
		System.out.println("비행일정추가");
		System.out.println("-------------------------");
		System.out.print("비행기ID : ");
		String airplane_id = scan.nextLine();
		System.out.print("출발지 : ");
		String departure = scan.nextLine();
		System.out.print("도착지 : ");
		String arrival = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		System.out.print("출발날짜 : ");
		String departure_date = scan.nextLine();
		System.out.print("도착날짜 : ");
		String arrival_date = scan.nextLine();
		System.out.print("도착소요시간 : ");
		String flight_time = scan.nextLine();
		
		Airplane airplane = adminManager.getAirplane(airplane_id);
		if(airplane == null) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
				
		Flight flight = new Flight(airplane_id, departure, arrival, price, departure_date, arrival_date, flight_time, airplane.getAirplane_seat());
		
		if(adminManager.insertFlight(flight)) {
			System.out.println("등록에 성공하였습니다.");
		}else {
			System.out.println("등록에 실패하였습니다.");			
		}
	}
	
	// 연동확인123

	// 비행일정삭제
	private void deleteFlight() {
		ArrayList<Flight> flightList = adminManager.getFlightList();
		System.out.println("비행번호\t출발지\t도착지\t가격\t출발날짜\t\t\t도착날짜\t\t\t소요시간\t남은좌석");
		for(Flight f : flightList) {
			System.out.println(f);
		}
		System.out.print("삭제할 비행번호를 입력해주세요.");
		int flight_no = scan.nextInt();
		if (reservationManager.selectFlightByFlightNo(flight_no) == null) {
			System.out.println("삭제할 비행번호와 연동된 항공편이 없습니다.");		return;
		}
		
		if (adminManager.deleteFlight(flight_no) == 0) {
			System.out.println("일정 삭제에 실패하였습니다.");
		} else {
			System.out.println("일정 삭제 성공!");
		}
		
		
	}
	
	
	// 비행예약삭제
	private void deleteReservation() {
		System.out.print("취소할 예약 번호 : ");
		int reser_no = scan.nextInt();
		if(reser_no == 0) return;
		if (reservationManager.deleteReservation(reser_no)) {
			System.out.println("취소에 성공했습니다.");
		} else {
			System.out.println("예약정보가 없거나 삭제에 실패 했습니다.");
		}
	}

	public static void main(String[] args) {
		new AirlineUI();
	} 
}
