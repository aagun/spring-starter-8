package domain.project.name.helper;

import domain.project.name.dto.ResponsePageableDto;
import domain.project.name.enums.ResponseStatus;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class ResponsePageableDtoHelper {

    public static ResponsePageableDto ok() {
        return ok(new PageImpl<>(Collections.emptyList()));
    }

    public static ResponsePageableDto ok(Page<?> data) {
        var response = new ResponsePageableDto();
        response.setMessage("success");
        response.setStatus(ResponseStatus.SUCCESS.getCode());
        response.setData(data.getContent());
        response.setTotalPages(data.getTotalPages());
        response.setTotalItems(data.getTotalElements());
        return response;
    }

    public static ResponsePageableDto fail() {
        return fail(Collections.emptyList(), 0);
    }

    public static ResponsePageableDto fail(List<?> data, Integer limit) {
        var response = new ResponsePageableDto();
        response.setMessage("failed");
        response.setStatus(ResponseStatus.FAILED.getCode());
        response.setData(data);
        response.setTotalPages((int) (Math.ceil(data.size())/limit));
        response.setTotalItems((long) data.size());
        return response;
    }
}
