package de.redooo.platform.service;

import de.redooo.platform.model.Palace;
import de.redooo.platform.repository.PalaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalaceService {

    private PalaceRepository palaceRepository;

    public PalaceService(PalaceRepository orderRepository) {
        this.palaceRepository = orderRepository;
    }

    public List<Palace> getPalacesByServiceLocation(String serviceLocationId) {
        return palaceRepository.getPalacesByLocationId(serviceLocationId);
    }

    public List<Palace> getPalacesByServiceLocation2(String serviceLocationId) {
        return palaceRepository.getPalacesByLocation2Id(serviceLocationId);
    }
}
