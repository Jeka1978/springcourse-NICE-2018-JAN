package enums;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Evgeny Borisov
 */
public class PersonTest {
    Person person;
    @Before
    public void setUp() throws Exception {
       person = new Person("Jack", MaritalStatus.SINGLE);
    }

    @Test
    public void testThat2PersonsHaveTheSameMaritalStatus() throws Exception {

        Person person2 = new Person("Moshe", MaritalStatus.SINGLE);
        Assert.assertTrue(person.getMaritalStatus() == person2.getMaritalStatus());
    }

    @Test
    public void testThatPersonWhichIsSingeContainsMaritalStatusWithHebrewDescRavak() throws Exception {
      String hebrewDesc =  person.getMaritalStatus().getHebrewDesc();
      Assert.assertEquals("רווק",hebrewDesc);
        System.out.println(MaritalStatus.SINGLE);
    }

    @Test
    public void testDbCode1ContainsMaritalStatusWithHebrewDescRavak() throws Exception {
        MaritalStatus maritalStatus = MaritalStatus.findByDbCode(1);
        Assert.assertEquals("רווק",maritalStatus.getHebrewDesc());
    }

    @Test(expected = MaritalStatusNotSupportedException.class)
    public void testNotValidDbCode(){
        MaritalStatus.findByDbCode(17);
    }
}







