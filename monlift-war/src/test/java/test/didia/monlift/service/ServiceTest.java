package test.didia.monlift.service;
import static org.junit.Assert.*;

import org.junit.Test;

import me.didia.monlift.entities.User;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.inputValidator.InputValidator;
import me.didia.monlift.managers.UserManager;
import me.didia.monlift.service.Service;




public class ServiceTest {

	private static Service myService = Service.getInstance();
	private InputValidator inputValidator = InputValidator.getInstance();
	
	
	/**
	 * test of firstnameValidator function
	 */
	@Test
	public void testFirstnameValidator() throws DuplicateValueException
	{
		String validefirstname = "Trispa";
		String unValidefirstname = "/NoUser...4";
		assertTrue(inputValidator.firstnameValidator(validefirstname));
		assertFalse(inputValidator.firstnameValidator(unValidefirstname));
		
		
	} 
	/**
	 * test of LastnameValidator function
	 */
	@Test
	public void testLasttnameValidator() throws DuplicateValueException
	{
		String valideLastname = "joSephee";
		String unValideLastname= "/NoUser...4";
		assertTrue( inputValidator.firstnameValidator(valideLastname));
		assertFalse(inputValidator.firstnameValidator(unValideLastname));
		
		
	}
	/**
	 * test of EmailValidator function
	 */
	@Test
	public void testEmailValidator() throws DuplicateValueException{
		String valideEmail = "monlift@gmail.ca";
		String unValideEmail = ".12322@test.com";
		assertTrue(inputValidator.emailValidator(valideEmail));
		assertFalse(inputValidator.emailValidator(unValideEmail));
	}
	
	/**
	 * test of PhoneValidator function
	 */
	@Test
	public void testPhoneValidator() throws DuplicateValueException
	{
		String validePhone = "+1-309-798-4235";
		String unValidePhone = "001-309-798-4234";
		assertTrue(inputValidator.phoneValidator(validePhone));
		assertFalse(inputValidator.phoneValidator(unValidePhone));
	}
	
	@Test
	public void tesDoRegister() throws DuplicateValueException
	{	UserManager userManager = UserManager.getInstance();
		User p;
		
		Long id  = myService.doRegister("Patrice", "Diouf", "trispa88@gmail.com", "+1-309-798-4235", "876a54321");
		p = userManager.getUser(id);
		assertEquals(p.getFirstname(), "Patrice");
		assertEquals(p.getLastname() , "Diouf");
		assertEquals(p.getEmail(), "trispa88@gmail.com");
		assertEquals(p.getPhone(), "+1-309-798-4235");
		
	}
	}
			
			

