package de.crafted.api.service.account.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@Builder
public class Account {
    @Schema(example = "1")
    long id;

    @Schema(example = "julia.kreidler@example.com")
    String email;

    @Schema(example = "123456")
    String password;

    @Schema(example = "Julia")
    String firstname;

    @Schema(example = "Kreidler")
    String lastname;

    @Schema(example = "Lorem ipsum ...")
    String description;

    @Schema(example = "FALSE")
    Boolean verified;

    @Schema(example = "2021-04-23T18:30:45.882987+02:00")
    ZonedDateTime created;

    @Schema(example = "1")
    long imageId;
}
