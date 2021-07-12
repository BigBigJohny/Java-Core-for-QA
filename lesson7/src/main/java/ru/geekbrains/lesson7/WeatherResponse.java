package ru.geekbrains.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class WeatherResponse {

    @JsonProperty(value = "Headline")
    private Headline headline;

    @JsonProperty(value = "DailyForecasts")
    private DailyForecasts[] dailyForecasts;
}
