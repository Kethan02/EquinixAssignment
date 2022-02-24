package web.rest;

import domain.NbaActionFigure;
import domain.PersonalDetails;
import enumeration.Country;
import org.apache.taglibs.standard.lang.jpath.example.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import repository.PersonalDetailsRepository;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class PersonalDetailsResource {
    private static final String ENTITY_NAME = "personalDetails";
    private final Logger log = LoggerFactory.getLogger(PersonalDetailsResource.class);
    private final PersonalDetailsRepository personalDetailsRepository;

    public PersonalDetailsResource(PersonalDetailsRepository personalDetailsRepository) {
        this.personalDetailsRepository = personalDetailsRepository;
    }

    @PostMapping("/personal-details")
    public ResponseEntity<PersonalDetails> createPersonalDetails(@RequestBody PersonalDetails personalDetails) throws URISyntaxException {
        if (personalDetails.getId() != null) {
            throw new RuntimeException("A new personalDetails cannot already hava an ID"+ ENTITY_NAME +"id exists");
        }
        PersonalDetails result = personalDetailsRepository.save(personalDetails);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/personal-details")
    public List<PersonalDetails> getAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    @GetMapping("/personal-details/{home-country}")
    public List<PersonalDetails> getAllPersonalDetailsWithHomeCountry(@PathVariable Country homeCountry) {
        PersonalDetails actionFigure = new PersonalDetails();
        actionFigure.setHomeCountry(homeCountry);
        Example<PersonalDetails> example = Example.of(actionFigure);
        return personalDetailsRepository.findAll(example);
    }
}
