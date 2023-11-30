package domain.project.name.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseStatus {
    FAILED(0),
    SUCCESS(1);

    private final Integer code;
}
