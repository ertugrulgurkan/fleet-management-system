#Fleet Management System
___
# Backend Application
___
### Spring Boot Application

In this application, I designed a small-scale fleet management system where vehicles make deliveries to predetermined locations along a certain route.
* [More Info About the Fleet Management System](docs/api/info.md) 


## Requirements

* [JDK 17](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Apache Maven](https://maven.apache.org/download.cgi) for terminal
* [Docker](https://www.docker.com/) for dockerized run

## Installing
Can be installed and run as:
### Maven
**1. Clone the application**

```bash
git clone https://github.com/ertugrulgurkan/fleet-management-system.git
```
**2. Go to the project directory**
```bash
cd fleet-management-system
```
**3. Run**
```bash
mvn spring-boot:run
```
### Docker
**1. Clone the application**

```bash
git clone https://github.com/ertugrulgurkan/fleet-management-system.git
```
**2. Go to the project directory**
```bash
cd fleet-management-system
```
**3. Create Docker Image**
```bash
mvn clean install
docker-compose -f docker-compose.yml up -d
```
**4. Run**
```bash
docker-compose up
```
**5. Close**
```bash
docker-compose down
```

## API ENDPOINTS

### For Vehicles

* [Show All Vehicles](docs/api/vehicles/list-vehicles.md) : `GET /api/v1/vehicles`
* [Create Vehicle](docs/api/vehicles/create-vehicle.md) : `POST /api/v1/vehicles`

### For Packs

* [Show All Packs](docs/api/packs/list-packs.md) : `GET /api/v1/packs`
* [Create Pack](docs/api/packs/create-pack.md) : `POST /api/v1/packs`
* [Assign Package into Bag](docs/api/packs/create-pack.md) : `POST /api/v1/packs/bag`


### For Bags

* [Show All Bags](docs/api/bags/list-bags.md) : `GET /api/v1/bags`
* [Create Bag](docs/api/bags/create-bag.md) : `POST /api/v1/bags`


### For Deliveries

* [Show All Vehicles](docs/api/vehicles/list-vehicles.md) : `GET /api/v1/vehicles`
* [Create Vehicle](docs/api/vehicles/create-vehicle.md) : `POST /api/v1/vehicles`


#### Other Links
* [Swagger UI](http://localhost:8080/swagger-ui/index.html) `http://localhost:8080/swagger-ui/index.html`
* [API DOCS JSON](http://localhost:8080/api-docs) `http://localhost:8080/api-docs`


## Author
**Ertuğrul Ayvaz Gürkan**
[github/ertugrulgurkan](https://github.com/ertugrulgurkan)
