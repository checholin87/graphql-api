package me.secosme.graphql.api.model;

import java.util.UUID;
import lombok.Data;

@Data
public class ScamperDTO {
    private String id = UUID.randomUUID().toString();
    private int total;
    private String description;
}
