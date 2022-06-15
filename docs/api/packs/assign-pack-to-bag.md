# Assign package to the bag

**URL** : `api/v1/packs/bag`

**Method** : `POST`

**Sample Request Body**

```json
{
  "barcode": "P7988000121",
  "bagBarcode": "C725799"
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "barcode": "P7988000121",
  "bagBarcode": "C725799"
}
```

## Error Responses

**Code** : `404 NOT FOUND`

**Sample Response Body** :
```json
{
  "status": "NOT_FOUND",
  "errors": {
    "Error": "Pack entity is not found"
  }
}
```
