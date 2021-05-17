package wooteco.subway.section.dao;

import wooteco.subway.section.domain.Section;

import java.util.List;
import java.util.Optional;

public interface SectionDao {
    Section save(Long lineId, Section section);

    Optional<Section> findByUpOrDownId(Long lineId, Section newSection);

    void updateUpStation(Long id, Long upStationId, int distance);

    void updateDownStation(Long id, Long downStationId, int distance);

    List<Section> findByLineAndStationId(Long lineId, Long stationId);

    void delete(Long id);

    void deleteByLine(Long id);

    List<Section> findByLineId(Long lineId);

    boolean isIncluded(Long stationId);
}
