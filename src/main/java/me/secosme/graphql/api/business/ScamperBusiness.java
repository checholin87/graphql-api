package me.secosme.graphql.api.business;

import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import me.secosme.graphql.api.model.ScamperDTO;

@ApplicationScoped
public class ScamperBusiness {

    public ScamperDTO getById(String id) {
        return new ScamperDTO();
    }

    public List<ScamperDTO> getAll() {
        return Arrays.asList(new ScamperDTO());
    }
}
