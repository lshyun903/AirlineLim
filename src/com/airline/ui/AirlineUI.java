package com.airline.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.airline.control.AdminManager;
import com.airline.control.ReservationManager;
import com.airline.control.UserManager;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;
import com.airline.vo.User;

public class AirlineUI {
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager = new UserManager();
	private AdminManager adminManager = new AdminManager();
	private ReservationManager reservationManager = new ReservationManager();
	
	public AirlineUI() {
		while(true) {
			mainUI();
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
	
	public void mainUI() {
		System.out.println("-------------------------");
		System.out.println("에어라인에 오신것을 환영 합니다.");
		System.out.println("-------------------------");
		if (!userManager.isLogin()) {
			System.out.println("1. 로그인/회원가입");
		} else {
			System.out.println("1. 로그아웃");
		}
		System.out.println("2. 예약하기");
		System.out.println("3. 예약내역");
		System.out.println("4. 관리자 모드");
		System.out.println("-------------------------");
		System.out.print("선택 : ");
	}
	
	public void userUI() {
		if (userManager.isLogin()) {
			userManager.logout();
			System.out.println("로그아웃 합니다.");
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
		System.out.println("비행번호\t출발지\t도착지\t가격\t출발날짜\t\t\t도착날짜\t\t\t소요시간");
		if (flightList != null && flightList.size() > 0) {
			for (Flight flight: flightList) {
				System.out.println(flight);
			}
		} else {
			System.out.println("현재 예정인 비행이 없습니다.");
		}
		System.out.println("-------------------------");
		reserFlightUI();
	}
	
	private void reserFlightUI() {
		System.out.println("비행번호와 수량을 입력해 주세요(NO에 exit 입력시 주문 취소)");
		System.out.print("운행 NO : ");
		String flight_no = scan.next();
		if (flight_no.equals("exit")) {
			System.out.println("주문을 취소합니다");
			return;
		}
		System.out.print("인원 : ");
		int reser_people = scan.nextInt();
		
		System.out.println("예약내역");
		System.out.println("NO : " + flight_no + " 인원 : " + reser_people );
		if (reservationManager.reserFlight(flight_no, reser_people, userManager.getLogin_id())) {
			System.out.println("예약에 성공했습니다.");
		} else {
			System.out.println("예약에 실패했습니다.");
		}
	}


	private void getReserListById() {
		if (!userManager.isLogin()) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		
		System.out.println("전체 주문내역");
		ArrayList<Reservation> reserList = reservationManager.selectReserListById(userManager.getLogin_id());
		
		if(reserList != null & reserList.size() > 0) {			
			System.out.print("예약번호\t비행번호\t예약자\t예약인원\t결제가격\t");
			System.out.println("출발지\t도착지\t출발날짜\t\t\t도착날짜");
			
			for (Reservation reser : reserList) {
				System.out.print(reser);
				Flight flight = reservationManager.selectFlightByFlightNo(reser.getFlight_no());
				System.out.println(flight.getDeparture() + "\t" + flight.getArrival() + "\t" + flight.getDeparture_date() + "\t" + flight.getDeparture_date());
			}	
			
			System.out.print("취소할 예약 번호 (0 입력시 메인화면 이동): ");
			int reser_no = scan.nextInt();
			if(reser_no == 0) return;
			if (reservationManager.deleteReservation(reser_no)) {
				System.out.println("취소에 성공했습니다.");
			} else {
				System.out.println("예약정보가 없거나 삭제에 실패 했습니다.");
			}
		}else {
			System.out.println("예약 내역이 없습니다.");
		}
		
	}
	
	public void adminUI() {
		System.out.print("관리자 패스워드 : ");
		String passwd = scan.next();
		
		if (adminManager.admin_login(passwd)) {
			System.out.println("전체 주문내역");
			System.out.println("-------------------------");
			ArrayList<Flight> flightList = adminManager.getFlightList();
			System.out.println("비행번호\t출발지\t도착지\t가격\t출발날짜\t\t\t도착날짜\t\t\t소요시간");
			if (flightList != null && flightList.size() > 0) {
				for (Flight flight: flightList) {
					System.out.println(flight);
				}
				System.out.print("일정추가(1) 메인화면(2) : ");
				int input = scan.nextInt();
				switch(input) {
				case 1:insertFlight(); break;
				case 2:return;
				default:System.out.println("번호를 잘못 입력했습니다.");
			}
			} else {
				System.out.println("현재 예정인 비행이 없습니다.");
			}
		} else {
			System.out.println("패스워드가 다릅니다.");
		}
		
	}


	
	private void insertFlight() {
		scan.nextLine();
		System.out.println("비행일정추가");
		System.out.println("-------------------------");
		System.out.print("비행번호 : ");
		String flight_no = scan.nextLine();
		System.out.print("출발지 : ");
		String departure = scan.nextLine();
		System.out.print("도착지 : ");
		String arrival = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.print("출발날짜 : ");
		String departure_date = scan.nextLine();
		System.out.print("도착날짜 : ");
		String arrival_date = scan.nextLine();
		System.out.print("도착소요시간 : ");
		String flight_time = scan.nextLine();
		
		Flight flight = new Flight(flight_no, departure, arrival, price, departure_date, arrival_date, flight_time);
		
		if(adminManager.insertFlight(flight)) {
			System.out.println("등록에 성공하였습니다.");
		}else {
			System.out.println("등록에 실패하였습니다.");			
		}
	}


	public static void main(String[] args) {
		new AirlineUI();
	} 
}
