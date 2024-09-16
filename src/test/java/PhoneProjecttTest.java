import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneProjectTest {

    @Test
    public void testPhoneNumberValidation() {
        // Assume you have a method validatePhoneNumber in a class called PhoneValidator
        PhoneValidator validator = new PhoneValidator();
        assertTrue(validator.validatePhoneNumber("1234567890"));
        assertFalse(validator.validatePhoneNumber("12345"));
        assertFalse(validator.validatePhoneNumber("abcdefghij"));
    }

    @Test
    public void testUserCreation() {
        // Assume you have a User class with name and phone number
        User user = new User("John Doe", "1234567890");
        assertEquals("John Doe", user.getName());
        assertEquals("1234567890", user.getPhoneNumber());
    }

    @Test
    public void testPhoneListSize() {
        // Assume you have a PhoneList class that manages a list of phone numbers
        PhoneList phoneList = new PhoneList();
        phoneList.addPhone("1111111111");
        phoneList.addPhone("2222222222");
        phoneList.addPhone("3333333333");
        assertEquals(3, phoneList.size());
    }

    @Test
    public void testPhoneRemoval() {
        // Using the same PhoneList class
        PhoneList phoneList = new PhoneList();
        phoneList.addPhone("1111111111");
        phoneList.addPhone("2222222222");
        phoneList.removePhone("1111111111");
        assertEquals(1, phoneList.size());
        assertFalse(phoneList.contains("1111111111"));
    }

    @Test
    public void testPhoneSearch() {
        // Assume you have a method to search for a phone number
        PhoneDirectory directory = new PhoneDirectory();
        directory.addEntry("John", "1111111111");
        directory.addEntry("Jane", "2222222222");
        assertEquals("John", directory.searchByPhone("1111111111"));
        assertNull(directory.searchByPhone("3333333333"));
    }
}
