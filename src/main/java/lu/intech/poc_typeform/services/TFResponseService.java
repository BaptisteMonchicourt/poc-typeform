package lu.intech.poc_typeform.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.java.Log;
import lu.intech.poc_typeform.api.TFResponseDto;
import lu.intech.poc_typeform.converters.TFResponseConverter;
import lu.intech.poc_typeform.models.TFResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;

@Log
@Service
@ConfigurationProperties(prefix = "app.typeform")
@Data
public class TFResponseService {

    private String TYPEFORM_API_BASE_URL = "https://api.typeform.com/";
    private String FORMS_URI = "forms/";
    private String RESPONSES_ENDPOINT = "/responses";
    @NotEmpty
    private String FORM_ID;
    @NotEmpty
    private String TOKEN;

    @Autowired
    private TFResponseConverter tfResponseConverter;

    public TFResponseDto retrieveAllResponses(Instant date) throws IOException, URISyntaxException {

        String uri = TYPEFORM_API_BASE_URL + FORMS_URI + FORM_ID + RESPONSES_ENDPOINT;

        URIBuilder builder = new URIBuilder(uri);
        if (date != null) builder.setParameter("since", String.valueOf(date));

        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.setHeader("Authorization", "Bearer " + TOKEN);

        String result;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            result = EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }

        ObjectMapper mapper = new ObjectMapper();
        TFResponse mapResult = mapper.readValue(result, TFResponse.class);

        return tfResponseConverter.convert(mapResult);
    }

}
