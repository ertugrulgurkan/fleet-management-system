# Create new bag

**URL** : `/api/v1/bags`

**Method** : `POST`

**Sample Request Body**

```json
  {
    "barcode": "C725800",
    "deliveryPointForUnloading": 1
  }
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "barcode": "C725800",
  "deliveryPointForUnloading": 1
}
```

## Error Responses

**Code** : `400 BAD REQUEST`

**Sample Response Body** :
```json
{
  "status": "BAD_REQUEST",
  "errors": {
    "error": "Bag is already exist."
  }
}
```
