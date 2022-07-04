package de.crafted.api.service.image.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Image {
    @Schema(example = "1")
    long id;

    @Schema(example = "https://www.example.com/image.jpg")
    String url;

    @Schema(example = "Lorem ipsum")
    String altText;
}
