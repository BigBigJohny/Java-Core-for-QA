package ru.geekbrains.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Temperature {
    @JsonProperty(value = "Minimum")
    private Minimum minimum;

    @JsonProperty(value = "Maximum")
    private Maximum maximum;
}
