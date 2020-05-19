package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	Student inStateStudent = Student.createInStateStudent("Krishna", "Boston");
	Student outStateStudent = Student.createOutStateStudent("Frenil", "India", 7,"Gujarat");
	Student internationalStudent = Student.createIntlStudent("Naitik", "Canada", 00710, "India");

	@Test
	public void StudentStatus_Instate() throws Exception {
		assertEquals(StudentFactory.INSTATE, inStateStudent.getStatus());
	}
	
	@Test
	public void StudentStatus_OutState() throws Exception{
		assertEquals(StudentFactory.OUTSTATE, outStateStudent.getStatus());
	}
	
	@Test
	public void StudentStatus_InternationalStudent() throws Exception{
		assertEquals(StudentFactory.INTERNATIONAL, internationalStudent.getStatus());
	}
	
	@Test
	public void InstateStudent_tuitionFee() throws Exception{
		assertEquals(7000, inStateStudent.getTuition());
	}
	
	@Test
	public void InstateStudent_tuitionFee_is_not_17000() throws Exception{
		assertNotEquals(17000, inStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudent_tuitionFee() throws Exception{
		assertEquals(12000, outStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudent_tuitionFee_is_not_1500() throws Exception{
		assertNotEquals(1500, outStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudent_tuitionFee_is_not_50000() throws Exception{
		assertNotEquals(50000, outStateStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee() throws Exception{
		assertEquals(17000, internationalStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee_is_not_7000() throws Exception{
		assertNotEquals(7000, internationalStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee_is_not_12000() throws Exception{
		assertNotEquals(12000, internationalStudent.getTuition());
	}
	
	
	
	
}
