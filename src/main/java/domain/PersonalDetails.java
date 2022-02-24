package domain;

import enumeration.Country;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "personal_details")
public class PersonalDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "home_country")
    private Country homeCountry;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Country getHomeCountry() {
        return this.homeCountry;
    }

    public void setHomeCountry(Country homeCountry) {
        this.homeCountry = homeCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalDetails)) return false;
        PersonalDetails that = (PersonalDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "domain.PersonalDetails{" +
                "id=" + getId() +
                ", age=" + getAge() +
                ", birthdate=" + getBirthdate() +
                ", homeCountry=" + getHomeCountry() +
                '}';
    }
}
