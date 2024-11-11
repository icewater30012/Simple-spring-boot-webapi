package ibm.com.ibmdemoapi.controller;

import org.jboss.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = "/api")
public class JsonDataController {

    private static final Logger logger = Logger.getLogger(JsonDataController.class);

    @RequestMapping(value = "/getJsonData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getJsonData() throws IOException {

        String fileName = "dataset.json";
        logger.info(String.format("Get all data from %s", fileName));
        String data = new String(Files.readAllBytes(Paths.get(new ClassPathResource(fileName).getURI())));
        return ResponseEntity.ok(data);
    }
}
