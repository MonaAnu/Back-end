package com.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;
import com.staff.repository.StaffRepository;
import com.staff.service.StaffService;

@SpringBootTest
class StaffServiceApplicationTests {

	@Autowired
	private StaffService staffService;

	@MockBean
	private StaffRepository staffRepository;

	@Test
	public void ShowAllStaffTest() throws StaffNotFoundException {
		List<Staff> staff = new ArrayList<>();

		Staff s = new Staff();

		s.setId(1);
		s.setDepartmentId(3);
		s.setEmployeeName("Sharath");
		s.setPhoneNo("9099774537");
		s.setEmail("sharath@gmail.com");
		s.setAge(22);
		s.setEmployeeAddress("Chennai");
		s.setSalary(50000.0);

		staff.add(s);

		when(staffRepository.findAll()).thenReturn(staff);
		assertEquals(1, staffService.showAllStaffDetails().size());
	}

	@Test
	public void ShowStaffByIdTest() throws StaffNotFoundException {
		Staff s = new Staff();

		s.setId(1);
		s.setDepartmentId(3);
		s.setEmployeeName("Sharath");
		s.setPhoneNo("264537");
		s.setEmail("sharath@gmail.com");
		s.setAge(22);
		s.setEmployeeAddress("Chennai");
		s.setSalary(50000.0);

		Optional<Staff> staff = Optional.of(s);

		when(staffRepository.findById(1)).thenReturn(staff);
		assertEquals(s, staffService.showStaffById(1));
	}

	@Test
	public void addStaffTest() throws StaffNotFoundException {

		Staff s = new Staff();

		s.setId(1);
		s.setDepartmentId(3);
		s.setEmployeeName("Sharath");
		s.setPhoneNo("264537");
		s.setEmail("sharath@gmail.com");
		s.setAge(22);
		s.setEmployeeAddress("Chennai");
		s.setSalary(50000.0);

		when(staffRepository.insert(s)).thenReturn(s);
		assertEquals(s, staffService.addStaffDetails(s));
	}

	@Test
	public void updateStaffTest() throws StaffNotFoundException {
		Staff s1 = new Staff();
		Staff s2 = new Staff();

		s1.setId(1);
		s1.setDepartmentId(3);
		s1.setEmployeeName("Sharath");
		s1.setPhoneNo("264537");
		s1.setEmail("sharath@gmail.com");
		s1.setAge(22);
		s1.setEmployeeAddress("Chennai");
		s1.setSalary(50000.0);

		s2.setId(1);
		s2.setDepartmentId(3);
		s2.setEmployeeName("Sharath");
		s2.setPhoneNo("264537");
		s2.setEmail("sharath@gmail.com");
		s2.setAge(25);
		s2.setEmployeeAddress("Chennai");
		s2.setSalary(50000.0);

		Optional<Staff> staff = Optional.of(s1);

		when(staffRepository.findById(1)).thenReturn(staff);
		when(staffRepository.save(s2)).thenReturn(s2);
		assertEquals(s2, staffService.updateStaffDetails(s2));
	}

	@Test
	public void deleteStaffTest() throws StaffNotFoundException {
		Staff s = new Staff();

		s.setId(1);
		s.setDepartmentId(3);
		s.setEmployeeName("Sharath");
		s.setPhoneNo("264537");
		s.setEmail("sharath@gmail.com");
		s.setAge(22);
		s.setEmployeeAddress("Chennai");
		s.setSalary(50000.0);

		Optional<Staff> staff = Optional.of(s);
		when(staffRepository.findById(1)).thenReturn(staff);
		assertEquals("Staff with the id 1 Deleted Successfully!", staffService.deleteStaffDetails(1));
	}
}
