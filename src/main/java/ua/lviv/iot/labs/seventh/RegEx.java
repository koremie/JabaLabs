package ua.lviv.iot.labs.seventh;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegEx {
    public static final String GITHUB_USER_INFO_REGEX = "((?<=github.com/)[^/]+(?=/))";
    private File file;

    private String fileToString() {
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public List<String> getGithubUsersInfo() {
        String text = fileToString();
        Set<String> githubUsersInfo = new HashSet<>();

        Pattern githubUserPattern = Pattern.compile(GITHUB_USER_INFO_REGEX);
        Matcher githubUserMatcher = githubUserPattern.matcher(text);
        
        while (githubUserMatcher.find()) {
            githubUsersInfo.add(githubUserMatcher.group());
        }
        
        return List.copyOf(githubUsersInfo);
    }
}
