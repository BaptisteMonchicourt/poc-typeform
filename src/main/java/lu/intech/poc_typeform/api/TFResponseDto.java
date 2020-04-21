package lu.intech.poc_typeform.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TFResponseDto {

    private Integer totalItems;
    private List<ItemDto> items = null;

}
