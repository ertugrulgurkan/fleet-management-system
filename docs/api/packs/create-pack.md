# Create new pack

**URL** : `/api/v1/packs`

**Method** : `POST`

**Sample Request Body**

```json
  {
    "barcode": "P1988000121",
    "deliveryPointForUnloading": 1,
    "volumetricWeight": 5
  }
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "barcode": "P1988000121",
  "deliveryPointForUnloading": 1,
  "volumetricWeight": 5
}
```

## Error Responses

**Code** : `400 BAD REQUEST`

**Sample Response Body** :
```json
{
  "status": "BAD_REQUEST",
  "errors": {
    "error": "Pack is already exist."
  }
}
```
