package domain.project.name.helper;


import domain.project.name.dto.ResponseDto;
import domain.project.name.enums.ResponseStatus;

import java.util.Collections;
import java.util.List;

public class ResponseDtoHelper {

    public static ResponseDto ok() {
        return ok(Collections.emptyList());
    }


    public static ResponseDto ok(List<?> list) {
        return ok("success", list);
    }

    public static ResponseDto ok(String message, List<?> list) {
        return ResponseDto.builder()
                .status(ResponseStatus.SUCCESS.getCode())
                .message(message)
                .data(list)
                .build();
    }

    public static ResponseDto fail(String message, List<?> errorMessages) {
        return ResponseDto.builder()
                .status(ResponseStatus.FAILED.getCode())
                .message(message)
                .data(errorMessages)
                .build();
    }

    public static ResponseDto fail() {
        return fail("failed", Collections.emptyList());
    }

    public static ResponseDto fail(List<?> errorMessages) { return fail("failed", errorMessages); }
}
