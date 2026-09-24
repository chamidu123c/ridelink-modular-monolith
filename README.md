
# RideLink – Ride Booking System

A simple ride-booking REST API built using Java and Spring Boot. RideLink allows passengers to request rides, automatically assigns available drivers, and manages ride status and driver availability.

## 🚀 Features

- Create and manage drivers
- View available drivers
- Update driver availability
- Request rides with pickup and destination locations
- Automatically assign available drivers to rides
- Retrieve ride details by ID
- Complete rides and release drivers for new requests

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Backend application framework |
| Spring Web | Building REST APIs |
| Maven | Dependency management and build tool |
| Postman | API testing |
| Git & GitHub | Version control |

## 📁 Project Structure

```text
src/main/java/com/example/ridelink/
│
├── driver/
│   ├── model/
│   │   └── Driver.java
│   ├── repository/
│   │   └── DriverRepository.java
│   └── service/
│       └── DriverService.java
│
├── ride/
│   ├── model/
│   │   ├── Ride.java
│   │   └── RideStatus.java
│   ├── repository/
│   │   └── RideRepository.java
│   ├── service/
│   │   └── RideService.java
│   └── controller/
│       └── RideController.java
│
└── RidelinkApplication.java
```

## ⚙️ Getting Started

### Prerequisites

Make sure you have installed:

- Java JDK 21 or later
- Maven
- Git
- Postman (for API testing)

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Navigate to the Project

```bash
cd RideLink
```

### 3. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or, on Windows using the Maven wrapper:

```bash
mvnw.cmd spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## 📡 REST API Endpoints

### Ride Management

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/rides` | Request a new ride |
| GET | `/api/rides/{id}` | Get ride details by ID |
| PATCH | `/api/rides/{id}/complete` | Complete a ride |

### Driver Management

Driver endpoints depend on the mappings implemented in your DriverController.

## 🧪 API Testing with Postman

### 1. Request a Ride

**POST** `/api/rides`

Request body:

```json
{
  "passengerName": "Chamidu",
  "pickup": "Kandy",
  "destination": "Peradeniya"
}
```

The system assigns an available driver and returns the created ride details.

### 2. Get Ride Details

**GET** `/api/rides/1`

Replace `1` with the actual ride ID.

### 3. Complete a Ride

**PATCH** `/api/rides/1/complete`

Completing a ride updates its status to `COMPLETED` and makes the assigned driver available again.

## 🔄 Ride Status

| Status | Description |
|---|---|
| `REQUESTED` | A ride has been requested |
| `ASSIGNED` | A driver has been assigned |
| `COMPLETED` | The ride has been completed |

## 🧠 Key Concepts

This project demonstrates practical implementation of:

- Object-Oriented Programming (OOP)
- RESTful API development
- Spring Boot dependency injection
- Controller-Service-Repository architecture
- CRUD operations and HTTP methods
- Driver assignment and availability management
- Exception handling

## 💾 Data Storage

The current implementation uses in-memory storage with Java collections. Data is not permanently stored and will be lost when the application restarts.

## 👨‍💻 Author

**Chamidu Manthilaka**

IT Undergraduate | SLIIT Kandy

GitHub: [Your GitHub Profile](YOUR_GITHUB_PROFILE_URL)

---

⭐ If you find this project useful, feel free to star the repository!
