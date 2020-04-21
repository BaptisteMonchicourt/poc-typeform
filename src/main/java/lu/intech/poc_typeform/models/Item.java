package lu.intech.poc_typeform.models;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response_id",
        "submitted_at",
        "answers"
})
public class Item {

    @JsonProperty("response_id")
    private String responseId;
    @JsonProperty("submitted_at")
    private String submittedAt;
    @JsonProperty("answers")
    private List<Answer> answers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("response_id")
    public String getResponseId() {
        return responseId;
    }

    @JsonProperty("response_id")
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    @JsonProperty("submitted_at")
    public String getSubmittedAt() {
        return submittedAt;
    }

    @JsonProperty("submitted_at")
    public void setSubmittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
    }

    @JsonProperty("answers")
    public List<Answer> getAnswers() {
        return answers;
    }

    @JsonProperty("answers")
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
