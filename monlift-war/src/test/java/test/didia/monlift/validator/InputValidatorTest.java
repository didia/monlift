package test.didia.monlift.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import me.didia.monlift.visitor.RequestValidatorVisitor;

import org.junit.Test;

import test.didia.monlift.AbstractTest;


public class InputValidatorTest extends AbstractTest {
	private RequestValidatorVisitor inputValidator = RequestValidatorVisitor.getInstance();

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
	
}
