package test.didia.monlift.service;

import static org.junit.Assert.*;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import me.didia.monlift.entities.User;
import me.didia.monlift.inputValidator.InputValidator;
import me.didia.monlift.services.Service;


public class ServiceTest extends AbstractTest {

	private static Service myService = Service.getInstance();
	private InputValidator inputValidator = InputValidator.getInstance();

	/**
	 * test of firstnameValidator function
	 */
	@Test
	public void testFirstnameValidator() {
		
		assertTrue(inputValidator.firstnameValidator("Marie-Rose"));
		assertTrue(inputValidator.firstnameValidator("Jérôme"));
		assertTrue(inputValidator.firstnameValidator("Trispa"));
		assertFalse(inputValidator.firstnameValidator("/Trispa"));
		assertFalse(inputValidator.firstnameValidator("1Trispa"));
		assertTrue(inputValidator.firstnameValidator("Marie Rose"));

	}

	/**
	 * test of LastnameValidator function
	 */
	@Test
	public void testLasttnameValidator() {
		assertTrue(inputValidator.firstnameValidator("Diasonama"));
		assertTrue(inputValidator.firstnameValidator("diemé"));
		assertTrue(inputValidator.firstnameValidator("St-hanne"));
		assertTrue(inputValidator.firstnameValidator("St.hanne"));
		assertFalse(inputValidator.firstnameValidator("1Trispa"));
		assertFalse(inputValidator.firstnameValidator("/Gagnon"));
		

		

	}

	/**
	 * test of EmailValidator function
	 */
	@Test
	public void testEmailValidator() {
		
		assertTrue(inputValidator.emailValidator("monlift@gmail.ca"));
		assertFalse(inputValidator.emailValidator(".12322@test.com"));
	}

	/**
	 * test of PhoneValidator function
	 */
	@Test
	public void testPhoneValidator() {
		String validePhone = "+1-309-798-4235";
		String unValidePhone = "001-309-798-4234";
		assertTrue(inputValidator.phoneValidator(validePhone));
		assertFalse(inputValidator.phoneValidator(unValidePhone));

	}

	/**
	 * test of doRegister() function
	 */
	@Test
	public void tesDoRegister() {
		User p;

		p = myService.doRegister("Patrice", "Diouf", "trispa88@gmail.com",
				"+1-309-798-4235", "motdepasee");

		assertEquals(p.getFirstname(), "Patrice");
		assertEquals(p.getLastname(), "Diouf");
		assertEquals(p.getEmail(), "trispa88@gmail.com");
		assertEquals(p.getPhone(), "+1-309-798-4235");

	}
	
}
