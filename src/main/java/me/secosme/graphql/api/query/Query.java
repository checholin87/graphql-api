package me.secosme.graphql.api.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import me.secosme.graphql.api.business.ScamperBusiness;
import me.secosme.graphql.api.model.ScamperDTO;

@ApplicationScoped
public class Query implements GraphQLQueryResolver {

    private ScamperBusiness business;

    Query() {
        /* only for cdi */ }

    @Inject
    public Query(ScamperBusiness business) {
        this.business = business;
    }

    public List<ScamperDTO> findScamper() {
        return business.getAll();
    }
}
