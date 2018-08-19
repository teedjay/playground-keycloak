package teedjay.backend;

import java.time.LocalDateTime;
import java.util.UUID;

public class InfoStructure {

    public String uuid;
    public String timestamp;
    public long milliseconds;
    public String username;

    public InfoStructure(String name) {
        uuid = UUID.randomUUID().toString();
        timestamp = LocalDateTime.now().toString();
        milliseconds = System.currentTimeMillis();
        username = name;
    }

}
