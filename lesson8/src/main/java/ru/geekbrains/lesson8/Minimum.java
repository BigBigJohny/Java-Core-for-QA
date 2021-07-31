package ru.geekbrains.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Minimum {

    @JsonProperty(value = "Value")
    private String value;

    @JsonProperty(value = "Unit")
    private String unit;

    @JsonProperty(value = "UnitType")
    private String unitType;
}