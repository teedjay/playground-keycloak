package teedjay.restapi;

import java.util.List;
import java.util.UUID;

public class NameList {

    public String uuid;
    public String user;
    public List<String> names;

    public NameList(String user, List<String> names) {
        this.uuid =  UUID.randomUUID().toString();
        this.user = user;
        this.names = names;
    }

}
