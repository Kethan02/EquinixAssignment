package repository;

import domain.PersonalDetails;
import org.springframework.data.jpa.repository.*;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {

}
