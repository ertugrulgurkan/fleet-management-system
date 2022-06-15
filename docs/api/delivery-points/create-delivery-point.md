# Create new delivery point

**URL** : `/api/v1/delivery-points`

**Method** : `POST`

**Sample Request Body**

```json
{
  "deliveryPointType": 3,
  "name": "Transfer Center"
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "deliveryPointType": 3,
  "name": "Transfer Center"
}
```

## Error Responses

**Code** : `400 BAD REQUEST`

**Sample Response Body** :
```json
{
  "status": "BAD_REQUEST",
  "errors": {
    "error": "Delivery Point is already exist."
  }
}
```
