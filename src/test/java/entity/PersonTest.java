package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PersonTest {

    private Person cut;

    @Test
    public void can_create_valid_person() {
        this.cut = new Person("Stephen", "Boyd");
        Assertions.assertTrue(cut.isValid());
    }
    
}
