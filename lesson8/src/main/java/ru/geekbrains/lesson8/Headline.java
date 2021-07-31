package ru.geekbrains.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Headline {
    @JsonProperty(value = "EffectiveDate")
    private String effectiveDate;

    @JsonProperty(value = "EffectiveEpochDate")
    private String effectiveEpochDate;

    @JsonProperty(value = "Severity")
    private int severity;

    @JsonProperty(value = "Text")
    private String text;

    @JsonProperty(value = "Category")
    private String category;

    @JsonProperty(value = "EndDate")
    private String endDate;

    @JsonProperty(value = "EndEpochDate")
    private String endEpochDate;

    @JsonProperty(value = "MobileLink")
    private String mobileLink;

    @JsonProperty(value = "Link")
    private String link;
}
