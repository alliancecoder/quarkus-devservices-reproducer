package entity;

import java.io.Serializable;
import java.util.UUID;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import globals.validations.ValidEntity;

@Entity
@Table(name = "people")
@NamedQueries({
    @NamedQuery(name = Person.findByLastName, query = "SELECT p FROM Person p WHERE p.lastName = :name"),
    @NamedQuery(name = Person.getAll, query = "SELECT p FROM Person p")
})
public class Person implements Serializable, ValidEntity {

    private static final long serialVersionUID = 1L;

    private static final String PREFIX = "worksheets.entity.";
    public static final String findByLastName = PREFIX + "findByLastName";
    public static final String getAll = PREFIX + "getAll";

    @Id
    @Column(name = "person_id", nullable = false)
    protected UUID personId;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    public Person() {
        this.personId = UUID.randomUUID();
    }

    public Person(String firstName, String lastName) {
        this.personId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((personId == null) ? 0 : personId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (personId == null) {
            if (other.personId != null)
                return false;
        } else if (!personId.equals(other.personId))
            return false;
        return true;
    }

    @JsonIgnore
    @JsonbTransient
    @Override
    @Transient
    public boolean isValid() {
        // Implement Entity business rules for Validity Checks
        // last name is required
        if (this.lastName == null || this.lastName.isEmpty() || this.lastName.isBlank()) return false;
        // first name is required
        if (this.firstName == null || this.firstName.isEmpty() || this.firstName.isBlank()) return false;
        // is valid
        return true;
    }
    
}
