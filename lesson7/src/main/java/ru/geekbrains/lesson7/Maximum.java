package ru.geekbrains.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Maximum {

    @JsonProperty(value = "Value")
    private String value;

    @JsonProperty(value = "Unit")
    private String unit;

    @JsonProperty(value = "UnitType")
    private String unitType;
}
