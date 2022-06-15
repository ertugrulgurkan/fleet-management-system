The system includes two different types of shipments that can be transported in vehicles and unloaded at delivery points. Delivery points, barcode numbers and volumetric weight are specified on the shipments.

~~~~
Shipment Types:
* Package: Refers to shipments with a single item.
* Bag: Refers to shipments with multiple items.
~~~~
Vehicles must have license plates to be registered in the system.

~~~~
The system includes three different delivery points.
* Branch: Only package-type shipments can be unloaded. Bags and packages in bags may not be unloaded.
* Distribution Center: Bags, packages in bags and packages not assigned to any bags may be unloaded.
* Transfer Center: Only bags and packages in bags may be unloaded.
~~~~

Shipments with delivery points that do not meet the aforementioned criteria may not be unloaded. In such cases, these particular shipments must be skipped and the remaining shipments should be checked if they meet the criteria for unloading.

The status of a shipment is **“created”** when it is first created, **“loaded into bag”** when loaded into the bag, and **“unloaded”** when unloaded at the delivery point.

The packages loaded into a bag must have the same delivery point as the bag.

When a shipment is loaded into the bag, the shipment’s status is updated to **“loaded into bag”**, while the bag’s status remains **“created”**.

If the bag itself is unloaded with the packages still inside, the status of the bag and all the packages inside is updated to **“unloaded”**.

Vehicles must go to their assigned delivery points and ensure that the relevant shipments are unloaded at the relevant delivery points.

### Status Table

| Package Status | Value |
|----------------|-------|
| Created | 1 |
| Loaded into Bag | 2 |
| Loaded | 3 |
| Unloaded | 4 |

| Bag Status | Value |
|----------------|-------|
| Created | 1 | 
| Loaded | 3 |
| Unloaded | 4 |
