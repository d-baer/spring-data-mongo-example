package de.redooo.platform.controller;

import de.redooo.platform.model.Palace;
import de.redooo.platform.service.PalaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class PalaceController {

    private PalaceService palaceService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public PalaceController(PalaceService orderService) {
        this.palaceService = orderService;
    }

    @GetMapping("/palaces")
    public ResponseEntity<List<Palace>> getPalacesByLocation(@RequestParam String locationId) {
        List<Palace> result = palaceService.getPalacesByServiceLocation(locationId);
        return new ResponseEntity<>(result, OK);
    }

    @GetMapping("/palaces2")
    public ResponseEntity<List<Palace>> getPalacesByLocation2(@RequestParam String locationId) {
        List<Palace> result = palaceService.getPalacesByServiceLocation2(locationId);
        return new ResponseEntity<>(result, OK);
    }
}
