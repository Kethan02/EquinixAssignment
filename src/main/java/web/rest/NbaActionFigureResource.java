package web.rest;


import domain.NbaActionFigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import repository.NbaActionFigureRepository;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class NbaActionFigureResource {

    private static final String ENTITY_NAME = "nbaActionFigure";
    private final Logger log = LoggerFactory.getLogger(NbaActionFigureResource.class);
    private final NbaActionFigureRepository nbaActionFigureRepository;


    public NbaActionFigureResource(NbaActionFigureRepository nbaActionFigureRepository) {
        this.nbaActionFigureRepository = nbaActionFigureRepository;
    }

    @PostMapping("/nba-action-figure")
    public ResponseEntity<NbaActionFigure> createNbaActionFigure(@RequestBody NbaActionFigure nbaActionFigure) throws URISyntaxException {
        if(nbaActionFigure.getId() != null) {
            throw new RuntimeException("A new nba action figure cannot already have an ID" + ENTITY_NAME +
                    "id exists");
        }
        NbaActionFigure result = nbaActionFigureRepository.save(nbaActionFigure);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/nba-action-figures/{name}")
    public List<NbaActionFigure> getNbaActionFiguresAgeGreaterThanThirty(@PathVariable String name) {
        NbaActionFigure actionFigure = new NbaActionFigure();
        actionFigure.setPlayerName(name);
        Example<NbaActionFigure> example = Example.of(actionFigure);
        return nbaActionFigureRepository.findAll(example);
    }
}
