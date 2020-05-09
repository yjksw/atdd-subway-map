package wooteco.subway.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wooteco.subway.admin.domain.Station;
import wooteco.subway.admin.dto.StationCreateRequest;
import wooteco.subway.admin.dto.StationResponse;
import wooteco.subway.admin.repository.StationRepository;

import java.net.URI;

@RestController
public class StationController {
    private final StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @PostMapping("/stations")
    public ResponseEntity createStation(@RequestBody StationCreateRequest view) {
        Station station = view.toStation();
        stationRepository.save(station);
        return ResponseEntity
                .created(URI.create("/stations/" + 1))
                .body(StationResponse.of(station));
    }

    @GetMapping("/stations")
    public ResponseEntity showStations() {
        return ResponseEntity.ok().body(
                stationRepository.findAll());
    }

    @DeleteMapping("/stations/{id}")
    public ResponseEntity deleteStation(@PathVariable Long id) {
        Station station = stationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        stationRepository.delete(station);
        return ResponseEntity.noContent().build();
    }
}
