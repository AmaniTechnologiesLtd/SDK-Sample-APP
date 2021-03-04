# Amani Web SDK

## Authentication

On server side you need to login with your credentials and get a token for next steps. This token should be used only on server side requests not used on Web SDK link.

```
curl --location --request POST 'https://tr.amani.ai/api/v1/user/login/' \
--form 'email="user@account.com"' \
--form 'password="password"'
```

Get or Create a customer using the request below. If there is no customer new one is created if there is a customer already created with this ID Card Number it will be returned.

This request will return a customer token which has a short life span and valid for only for this customer. Use this token to initialize Web SDK.

```
curl --location --request POST 'https://tr.amani.ai/api/v1/customer' \
--header 'Authorization: TOKEN use_your_token_here' \
--form 'id_card_number="Customer_ID_Card_Number"'\ (Required)
--form 'name="Customer Name"' \ (Optional)
--form 'email="Customer Email"' \ (Optional)
--form 'phone="Customer Phone"' (Optional)
```

## Redirect User to Web SDK

After you created the customer token. You can redirect the user to Amani Web SDK using this token with the parameters below.

```
https://client.amani.ai/?tk={CustomerToken}&id={CustomerIDCardNumber}&rl={returnLink}&bu={baseUrl}&ln={languageCode}
​
tk: fyJ0eXAiOiJKV1QiLCJhb........4ZEe3p2bEiYlRXM (Customer Token)
rl: https://company.com (Your application link. User will redirected to this page after completing verification steps)
bu: https://tr.amani.ai/api/v1 (Server URL that will be used as a backend server)
ln: en (Language code. Valid values: en for English and tr for Turkish)
​
Sample Link
https://client.amani.ai/?tk=fyJ0eXAiOiJKV1QiLCJhbGci....J9.FsENkMTjQ&rl=https://amani.ai&bu=https://tr.amani.ai/api/v1&ln=en
```

## Uploading document

User will follow steps on the screen and upload the necessary documents. When all required documents uploaded, user will be redirected to return link you provided with status and error parameters.

## Redirecting Customer to Return Link

```
status : incomplete, complete
customer_id: Amani Customer ID
errors : 401,3002 (see the possible error codes below)

Sapmle Redirect Link
https://company.com/?status=incomplete&customer_id=123456789&errors=401,3002
```

## Possible Error Codes

- 401: Token is not valid
- 404: User not found
- 500: Server error
- 1001: Couldnt find face in photo
- 1002: Blur detected in photo
- 1003: Glare detected in photo
- 1004: Auto crop failure
- 1005: Not supported document
- 1008: This ID is not belong to this profile
- 2001: Selfie did not match with ID
- 2002: Selfie failed on liveness detection
- 2003: Selfie failed on eye gaze detection
- 3001: Document failed on liveness detection
- 3002: Expired ID
- 4001: Expired Document
- 4002: Name on address document does not match with name on ID
- 5001: Signature does not match with the signature on ID
- 6001: Signature on the contract does not match with the signature on the ID
