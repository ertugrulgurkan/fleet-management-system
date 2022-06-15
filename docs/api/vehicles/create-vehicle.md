# Creates new vehicle

**URL** : `/api/v1/vehicles`

**Method** : `POST`

**Sample Request Body**

```json
{
  "licencePlate": "34 TL 34"
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "licencePlate": "34 TL 34"
}
```

## Error Responses

**Code** : `400 BAD REQUEST`

**Sample Response Body** :
```json
{
  "status": "BAD_REQUEST",
  "errors": {
    "error": "Vehicle is already exist."
  }
}
```
