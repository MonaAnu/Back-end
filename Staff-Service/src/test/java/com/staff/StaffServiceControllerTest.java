package com.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.staff.controller.StaffController;
import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;
import com.staff.service.StaffAuthService;
import com.staff.service.StaffServiceImpl;

@SpringBootTest
class StaffServiceControllerTest {

	@Autowired
	private StaffController controller;

	@MockBean
	private StaffServiceImpl staffService;

	@MockBean
	private StaffAuthService authService;
	List<Staff> staff = new ArrayList<>();

	String token = "token";

	@Test
	public void ShowAllStaffTestController() throws StaffNotFoundException {
		List<Staff> staff = new ArrayList<>();

		Staff s = new Staff();

		s.setId(1);
		;
		s.setDepartmentId(10);
		s.setEmployeeName("Vasavi");
		s.setPhoneNo("765432189");
		s.setEmail("vasavi@16");
		s.setAge(21);
		s.setEmployeeAddress("Perungudi, Chennai");
		s.setSalary(40000.0);

		staff.add(s);
		when(staffService.showAllStaffDetails()).thenReturn(staff);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(1, controller.showAllStaffDetails(token).getBody().size());
	}

	@Test
	public void ShowStaffByIdControllerTest() throws StaffNotFoundException {

		List<Staff> staff = new ArrayList<>();

		Staff s = new Staff();
		s.setId(1);
		
		;
		s.setDepartmentId(10);
		s.setEmployeeName("Vasavi");
		s.setPhoneNo("765432189");
		s.setEmail("vasavi@16");
		s.setAge(21);
		s.setEmployeeAddress("Perungudi, Chennai");
		s.setSalary(40000.0);

		staff.add(s);

		when(staffService.showStaffById(1)).thenReturn(s);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(s, controller.showStaffDetailsById(1, token).getBody());
	}

	@Test
	public void addStaffControllerTest() throws StaffNotFoundException {

		Staff s = new Staff();

		s.setId(1);
		;
		s.setDepartmentId(10);
		s.setEmployeeName("Vasavi");
		s.setPhoneNo("765432189");
		s.setEmail("vasavi@16");
		s.setAge(21);
		s.setEmployeeAddress("Perungudi, Chennai");
		s.setSalary(40000.0);

		when(staffService.addStaffDetails(s)).thenReturn(s);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(s, controller.addStaffDetails(s, token).getBody());
	}

	@Test
	public void updateStaffControllerTest() throws StaffNotFoundException {

		Staff s = new Staff();

		s.setId(1);
		;
		s.setDepartmentId(10);
		s.setEmployeeName("Vasavi");
		s.setPhoneNo("765432189");
		s.setEmail("vasavi@16");
		s.setAge(21);
		s.setEmployeeAddress("Perungudi, Chennai");
		s.setSalary(40000.0);

		when(staffService.updateStaffDetails(s)).thenReturn(s);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(s, controller.updateStaffDetails(s, token).getBody());
	}

	@Test
	public void deleteStaffControllerTest() throws StaffNotFoundException {

		Staff s = new Staff();

		s.setId(1);
		;
		s.setDepartmentId(10);
		s.setEmployeeName("Vasavi");
		s.setPhoneNo("765432189");
		s.setEmail("vasavi@16");
		s.setAge(21);
		s.setEmployeeAddress("Perungudi, Chennai");
		s.setSalary(40000.0);

		when(staffService.deleteStaffDetails(1)).thenReturn("Deleted Successfully");
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals("Deleted Successfully", controller.deleteStaffDetails(1, token).getBody());
	}
}
