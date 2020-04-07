# poc-typeform

## Settings

You need to create an `application.properties` file, in `src/main/resources` that contains the following values :

* app.typeform.api-base-url=https://api.typeform.com/
* app.typeform.form-id={your_form_id}
* app.typeform.token={your_personal_token}

## API calls

To retrieve all responses from the form :

```
http://localhost:8080/responses
```

To retrieve all responses received since {some_date} :

```
http://localhost:8080/responses?since={some_date}
```

Date format should be "yyyy-MM-dd'T'hh-mm-ss'Z'". If format is invalid, `since` parameter will be ignored and all responses from the form will be retrieved.
