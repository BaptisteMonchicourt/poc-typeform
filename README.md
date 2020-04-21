# poc-typeform

## Settings

You need to update the `application.properties` file, in `src/main/resources`, by giving your TypeForm form id and your personal token :

* app.typeform.form-id={your_form_id}
* app.typeform.token={your_personal_token}

You can also change the server port in this file. If you do so, you need to change the port in your API calls accordingly.
## API calls

To retrieve all responses from the form :

```
http://localhost:8080/responses
```

To retrieve all responses received since {some_date} :

```
http://localhost:8080/responses?since={some_date}
```

Date format should be "yyyy-MM-dd'T'hh-mm-ss'Z'" (ISO_INSTANT format). If format is invalid, `since` parameter will be ignored and all responses from the form will be retrieved.

## API responses

You will receive a JSON with the following fields :

```JSON
{
  "totalItems": 3,
  "items": [
    {
      "responseId": "someResponseId",
      "submittedAt": "2020-01-01T12:00:00Z",
      "answers": [
        {
          "type": "text",
          "text": "someText"
        },
        {
          "type": "email",
          "email": "some@email.com"
        },
        {
          "type": "choice",
          "choice": {
            "label": "Some Label"
          }
        }
      ]
    },
    { ... },
    { ... }
  ]
}
```

The value of the `"submittedAt"` field is a date in the ISO_INSTANT format. Anwers have two fields. The first is `"type"` and the second one is either `"text"`, `"email"`, or `"choice"`. The name of the second field is given by the value of `"type"`. Warning : they don't all have the same structure.

TypeForm API responses are filtered so we keep only what we need. You can change the DTO models if you want to get more fields, or less fields.
