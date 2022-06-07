package de.thb.craftsquad.service.ticket.model;

import de.thb.craftsquad.service.common.model.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.List;

@Value
@Builder
public class Ticket {
    @Schema(example = "1")
    long id;

    @Schema(example = "Lorem ipsum")
    String title;

    @Schema(example = "Lorem ipsum ...")
    String description;

    @Schema(example = "OPEN")
    Status status;

    @Schema(example = "1")
    Long accountId;

    @Schema(example = "2")
    Long assignedTo;

    @Schema(example = "2021-04-23T18:30:45.882987+02:00")
    ZonedDateTime created;

    List<Tag> tags;
}
