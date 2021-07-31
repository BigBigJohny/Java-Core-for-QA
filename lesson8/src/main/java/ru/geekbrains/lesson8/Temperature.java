package ru.geekbrains.lesson8;

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