package de.redooo.platform.controller;

import de.redooo.platform.PalaceServiceApplication;
import de.redooo.platform.model.Location;
import de.redooo.platform.model.Location2;
import de.redooo.platform.model.Palace;
import de.redooo.platform.repository.PalaceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalaceServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PalaceControllerIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private PalaceRepository palaceRepository;

    @Before
    public void setup() {
        palaceRepository.deleteAll();
    }

    @Test
    public void getPalacesByServiceLocationSucessful() {
        // given
        String locationId = "59fcf347fbbb9d353f2d1615";
        palaceRepository.save(createTestPalace(locationId));

        HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());

        // when
        ResponseEntity<List<Palace>> result = restTemplate.exchange(createURLWithPort("/palaces") + "?locationId=" + locationId,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Palace>>() {
                });

        // then
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
    }

    @Test
    public void getPalacesByServiceLocation2Failing() {
        // given
        String locationId = "59fcf347fbbb9d353f2d1615";
        palaceRepository.save(createTestPalace(locationId));

        HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());

        // when
        ResponseEntity<List<Palace>> result = restTemplate.exchange(createURLWithPort("/palaces2") + "?locationId=" + locationId,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Palace>>() {
                });

        // then
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
    }

    private Palace createTestPalace(String locationId) {
        Palace palace = new Palace();
        palace.setName("palace 1");

        Location location1 = new Location();
        location1.setId(locationId);
        location1.setName("location 1");
        palace.setLocation(location1);

        Location2 location2 = new Location2();
        location2.setId(locationId);
        location2.setName("location 2");
        palace.setLocation2(location2);
        return palace;
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}