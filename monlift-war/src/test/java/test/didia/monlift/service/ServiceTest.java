package test.didia.monlift.service;
import static org.junit.Assert.*;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.service.Service;

public class ServiceTest  extends AbstractTest{

	Service myService = new Service();
	InputValidator inputValidator = InputValidator.getInstance();
	
	
	/**
	 * test of firstnameValidator function
	 */
	@test
	public void testFirstnameValidator()
	{
		try{
			String validefistname = "jo";
			String unValidefistnameValide = "/NoUser...4";
			assertTrue(inputValidator.firstnameValidator(validefirstname));
			assertFalse(inputValidator.firstnameValidator(unValidefirstname));
			
		}catch (DuplicateValueException e) {
			
			fail(e.getMessage());
		}
		
		
	} 
	/**
	 * test of LastnameValidator function
	 */
	@test
	public void testLasttnameValidator()
	{
		try{
			String valideLastname = "jo";
			String unValideLastnameValide = "/NoUser...4";
			assertTrue( inputValidator.firstnameValidator(valideLarstname));
			assertFalse(inputValidator.firstnameValidator(unValideLarstname));
			
		}catch (DuplicateValueException e) {
			
			fail(e.getMessage());
		}
		
		
	}
	/**
	 * test of EmailValidator function
	 */
	@test
	public void testEmailValidator(){
		String valideEmail = "monlift@gmail.ca";
		String unValideEmail = "2@test.com";
		assertTrue(inputValidator.emailValidator(valideEmail));
		assertFalse(inputValidator.emailValidator(unValideEmail));
	}catch(DuplicateValueException e)
	{
		fail(e.getMessage());
	}
	
	/**
	 * test of PhoneValidator function
	 */
	@test
	public void testPhoneValidator()
	{
		String validePhone = "+1-309-798-4235";
		String unValidePhone = "001-309-798-4234";
		assertTrue(inputValidator.phoneValidator(validePhone));
		assertFalse(inputValidator.validePhone(unValidePhone));
	}catch(DuplicateValueException e)
	{
		fail(e.getMessage());
	}
	
	@test
	public void tesDoRegister()
	{	UserManager userManager = UserManager.getInstance();
		User p;
		Long id;
		try{
			id  = myService.doRegister("Patrice", "Diouf", "trispa88@gmail.com", "+1-309-798-4235", "87654321");
			p = userManager.getUser(id);
			assertEquals(p.getFirstname(), "Patrice");
			assertEquals(p.getLastname() , "Diouf");
			assertEquals(p.getEmail(), "trispa88@gmail.com"");
			assertEquals(p.getPhone(), "+1-309-798-4235");
			assertEquals(p.getPassword(), "87654321");
		}catch(DuplicateValueException e)
		{
			fail(e.getMessage());
		}
	}
	}
			
			

