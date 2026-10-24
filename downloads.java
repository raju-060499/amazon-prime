```java
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class VideoDownloader {

    public static void main(String[] args) {

        // Replace this with a direct video URL you can download
        String videoURL = "https://example.com/video.mp4";

        // Save the video in your Downloads folder
        String downloadsFolder =
                System.getProperty("user.home") + "/Downloads";

        Path destination = Paths.get(downloadsFolder, "myvideo.mp4");

        try {
            URL url = URI.create(videoURL).toURL();

            System.out.println("Downloading video...");

            try (var inputStream = url.openStream()) {
                Files.copy(
                    inputStream,
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
                );
            }

            System.out.println("Download completed!");
            System.out.println("Saved to: " + destination);

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Download failed: " + e.getMessage());
        }
    }
}
```
