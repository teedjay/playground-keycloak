package teedjay.backend;

import java.time.LocalDateTime;
import java.util.UUID;

public class InfoStructure {

    public String uuid = UUID.randomUUID().toString();
    public String timestamp = LocalDateTime.now().toString();
    public long milliseconds = System.currentTimeMillis();

}
