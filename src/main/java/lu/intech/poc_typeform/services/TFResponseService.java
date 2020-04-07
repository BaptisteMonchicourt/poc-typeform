package lu.intech.poc_typeform.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Log
@Service
public class TFResponseService implements CommandLineRunner {

    private String TYPEFORM_API_BASE_URL;
    private String FORM_ID;
    private String TOKEN;

    private DateValidator dateValidator;

    @Autowired
    private Environment env;


    public Map<String, Object> retrieveAllResponses(String date) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = null;

        dateValidator = new DateValidator();

        if (date == null || !dateValidator.isValid(date, "yyyy-MM-dd'T'hh:mm:ss'Z'")) {
            httpGet = new HttpGet(TYPEFORM_API_BASE_URL + "forms/" + FORM_ID + "/responses");
        } else {
            httpGet = new HttpGet(TYPEFORM_API_BASE_URL + "forms/" + FORM_ID + "/responses?since=" + date);
        }

        httpGet.setHeader("Authorization", TOKEN);

        String result = "";

        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            result = EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapResult = mapper.readValue(result, Map.class);

        return mapResult;
    }

    @Override
    public void run(String... args) throws Exception {
        TYPEFORM_API_BASE_URL = env.getProperty("app.typeform.api-base-url");
        FORM_ID = env.getProperty("app.typeform.form-id");
        TOKEN = "Bearer " + env.getProperty("app.typeform.token");
    }
}
