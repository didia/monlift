package test.didia.monlift.service;

import static org.junit.Assert.*;

import org.junit.Test;
import test.didia.monlift.AbstractTest;
import me.didia.monlift.entities.User;

import me.didia.monlift.inputValidator.InputValidator;

import me.didia.monlift.service.Service;

public class ServiceTest extends AbstractTest {

	private static Service myService = Service.getInstance();
	private InputValidator inputValidator = InputValidator.getInstance();

	/**
	 * test of firstnameValidator function
	 */
	@Test
	public void testFirstnameValidator() {
		String validefirstname = "Trispa";
		String unValidefirstname = "/NoUser...4";
		assertTrue(inputValidator.firstnameValidator(validefirstname));
		assertFalse(inputValidator.firstnameValidator(unValidefirstname));

	}

	/**
	 * test of LastnameValidator function
	 */
	@Test
	public void testLasttnameValidator() {
		String valideLastname = "joSephee";
		String unValideLastname = "/NoUser...4";
		assertTrue(inputValidator.firstnameValidator(valideLastname));
		assertFalse(inputValidator.firstnameValidator(unValideLastname));

	}

	/**
	 * test of EmailValidator function
	 */
	@Test
	public void testEmailValidator() {
		String valideEmail = "monlift@gmail.ca";
		String unValideEmail = ".12322@test.com";
		assertTrue(inputValidator.emailValidator(valideEmail));
		assertFalse(inputValidator.emailValidator(unValideEmail));
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
