package teedjay.restapi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class NameRepository {

    private List<String> names = new ArrayList<>();

    @PostConstruct
    private void addSomeInitialNames() {
        names.add("TeeDjay");
        names.add("Vicci");
    }

    public void addName(String name) {
        names.add(name);
    }

    public NameList getNameList(String user) {
        return new NameList(user, names);
    }

}
