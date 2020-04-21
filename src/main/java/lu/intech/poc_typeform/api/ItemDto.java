package lu.intech.poc_typeform.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ItemDto {

    private String responseId;
    private String submittedAt;
    private List<AnswerDto> answers = null;

}
