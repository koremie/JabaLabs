package ua.lviv.iot.labs.seventh;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class RegExTest {

    @Test
    void getGithubUserInfoTest() {
        RegEx regex = new RegEx(
                new File(Paths.get("").toAbsolutePath().toString() + "\\src\\test\\resources", "ProjectReport.txt"));
        List<String> expected = Arrays.asList("RybOlya", "IgorBrat", "Buypir", "maxi4ek23");
        assertEquals(expected, regex.getGithubUsersInfo());
    }

    @Test
    void emptyFileTest() {
        RegEx regex = new RegEx(new File(Paths.get("").toAbsolutePath().toString() + "\\src\\test\\resources",
                "EmptyProjectReport.txt"));
        assertTrue(regex.getGithubUsersInfo().isEmpty());
    }

    @Test
    void noGithubRepositoryLinksFileTest() {
        RegEx regex = new RegEx(new File(Paths.get("").toAbsolutePath().toString() + "\\src\\test\\resources",
                "NoGithubLinksText.txt"));
        assertTrue(regex.getGithubUsersInfo().isEmpty());
    }
}
