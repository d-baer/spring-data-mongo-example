package de.redooo.platform.repository;

import de.redooo.platform.model.Palace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PalaceRepository extends MongoRepository<Palace, String> {
    List<Palace> getPalacesByLocationId(String serviceLocationId);
    List<Palace> getPalacesByLocation2Id(String serviceLocationId);
}