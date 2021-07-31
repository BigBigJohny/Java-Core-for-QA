package ru.geekbrains.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Day {

    @JsonProperty(value = "Icon")
    private int icon;

    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;

    @JsonProperty(value = "HasPrecipitation")
    private boolean hasPrecipitation;

    @JsonProperty(value = "PrecipitationType")
    private String precipitationType;

    @JsonProperty(value = "PrecipitationIntensity")
    private String precipitationIntensity;
}