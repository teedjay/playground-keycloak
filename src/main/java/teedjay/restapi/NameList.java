package teedjay.restapi;

import java.util.List;
import java.util.UUID;

public class NameList {

    public String uuid = UUID.randomUUID().toString();
    public List<String> names;

    public NameList(List<String> names) {
        this.names = names;
    }

}
