# Show All Delivery Points

Returns Delivery Point List

**URL** : `/api/v1/delivery-points`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
[
  {
    "deliveryPointType": 3,
    "name": "Transfer Center"
  },
  {
    "deliveryPointType": 2,
    "name": "Distribution Center"
  },
  {
    "deliveryPointType": 1,
    "name": "Branch"
  }
]
```