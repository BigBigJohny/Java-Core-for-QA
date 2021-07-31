package ru.geekbrains.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DailyForecasts {
    @JsonProperty(value = "Date")
    private String date;

    @JsonProperty(value = "EpochDate")
    private String epochDate;

    @JsonProperty(value = "Temperature")
    private Temperature temperature;

    @JsonProperty(value = "Day")
    private Day day;

    @JsonProperty(value = "Night")
    private Night night;

    @JsonProperty(value = "Sources")
    private String[] sources;

    @JsonProperty(value = "MobileLink")
    private String mobileLink;

    @JsonProperty(value = "Link")
    private String link;
}
