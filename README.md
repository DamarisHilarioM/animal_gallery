# Animal Gallery API
## Description
Simple CRUD API for managing Animal objects in the Animal Gallery.

### Technologies Used
- **Java** (Spring Boot)
- **MySQL** (for data persistence)
- **Postman** (for API testing)
- **Git & GitHub** (for version control)

## API Endpoints
Base URL: [`http://localhost:8080/animals`](http://localhost:8080/animals)

### [`/all`](http://localhost:8080/animals/all) (GET)
Gets a list of all Animals in the database.

#### Response - A JSON array of Animals objects.
```
[
    {
        "animalId": 1,
        "name": "Luna",
        "description": "A small, fluffy dog with light brown fur.",
        "species": "dog",
        "age": 4.0,
        "activeDate": "2022-12-01"
    },
    {
        "animalId": 2,
        "name": "Lily",
        "description": "A fluffy white and gray cat with round eyes.",
        "species": "cat",
        "age": 2.5,
        "activeDate": "2023-10-10"
    },
    {
        "animalId": 3,
        "name": "Dusty",
        "description": "A soft gray chinchilla with large ears and soft gray fur.",
        "species": "chinchilla",
        "age": 1.2,
        "activeDate": "2024-01-15"
    },
    {
        "animalId": 4,
        "name": "Clover",
        "description": "A fluffy, light brown bunny with long ears.",
        "species": "bunny",
        "age": 3.0,
        "activeDate": "2024-02-10"
    },
    {
        "animalId": 5,
        "name": "Ava",
        "description": "A small, fluffy bird with grey feathers, a pink beak, and rosy cheeks.",
        "species": "bird",
        "age": 1.5,
        "activeDate": "2024-03-01"
    },
    {
        "animalId": 6,
        "name": "Bella",
        "description": "A white baby cow with soft, fluffy fur.",
        "species": "cow",
        "age": 0.5,
        "activeDate": "2024-08-20"
    }
]
```
### [`/{animalId}`](http://localhost:8080/animals/1) (GET)
Gets an individual Animal in the system. Each Animal is identified by a numeric `animalId`

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Response -  A single Animal
```
{
    "animalId": 1,
    "name": "Luna",
    "description": "A small, fluffy dog with light brown fur.",
    "species": "dog",
    "age": 4.0,
    "activeDate": "2022-12-01"
}
```

### [`/species/{species}`](http://localhost:8080/animals/species/cat) (GET)
Get a list of Animals based on their species.

#### Parameters
- path variable: `species` &lt;String&gt; - REQUIRED
  
#### Response -A JSON array of Animals objects matching the search key.
```
[
    {
        "animalId": 2,
        "name": "Lily",
        "description": "A fluffy white and gray cat with round eyes.",
        "species": "cat",
        "age": 2.5,
        "activeDate": "2023-10-10"
    }
]
```

### [`/name`](http://localhost:8080/animals/name?search=A) (GET)
Get a list of animals with a name that contains the given string.

#### Parameters
- query parameter: `search` lt;String&gt; - REQUIRED

#### Response - A JSON array of Animals objects matching the search key.
```
[
    {
        "animalId": 1,
        "name": "Luna",
        "description": "A small, fluffy dog with light brown fur.",
        "species": "dog",
        "age": 4.0,
        "activeDate": "2022-12-01"
    },
    {
        "animalId": 5,
        "name": "Ava",
        "description": "A small, fluffy bird with grey feathers, a pink beak, and rosy cheeks.",
        "species": "bird",
        "age": 1.5,
        "activeDate": "2024-03-01"
    },
    {
        "animalId": 6,
        "name": "Bella",
        "description": "A white baby cow with soft, fluffy fur.",
        "species": "cow",
        "age": 0.5,
        "activeDate": "2024-08-20"
    }
]
```

### [`/new`](http://localhost:8080/animals/new) (POST)
Create a new Animal entry.

#### Request Body
A animals object.
```
{
  "name": "Max",
  "description": "A small, playful dog with white fur and floppy ears.",
  "species": "dog",
  "age": 4,
  "activeDate": "2025-03-19"
}
```
#### Response - The updated list of Animals.
```
[
    {
        "animalId": 1,
        "name": "Luna",
        "description": "A small, fluffy dog with light brown fur.",
        "species": "dog",
        "age": 4.0,
        "activeDate": "2022-12-01"
    },
    {
        "animalId": 2,
        "name": "Lily",
        "description": "A fluffy white and gray cat with round eyes.",
        "species": "cat",
        "age": 2.5,
        "activeDate": "2023-10-10"
    },
    {
        "animalId": 3,
        "name": "Dusty",
        "description": "A soft gray chinchilla with large ears and soft gray fur.",
        "species": "chinchilla",
        "age": 1.2,
        "activeDate": "2024-01-15"
    },
    {
        "animalId": 4,
        "name": "Clover",
        "description": "A fluffy, light brown bunny with long ears.",
        "species": "bunny",
        "age": 3.0,
        "activeDate": "2024-02-10"
    },
    {
        "animalId": 5,
        "name": "Ava",
        "description": "A small, fluffy bird with grey feathers, a pink beak, and rosy cheeks.",
        "species": "bird",
        "age": 1.5,
        "activeDate": "2024-03-01"
    },
    {
        "animalId": 6,
        "name": "Bella",
        "description": "A white baby cow with soft, fluffy fur.",
        "species": "cow",
        "age": 0.5,
        "activeDate": "2024-08-20"
    },
    {
        "animalId": 7,
        "name": "MAx",
        "description": "A small, playful dog with white fur and floppy ears.",
        "species": null,
        "age": 4.0,
        "activeDate": "2025-03-19"
    }
]
```

### [`/update/{animalId}`](http://localhost:8080/animals/update/7) (PUT)
Update an existing Animal Object.

#### Parameters
- Path Variable: `studentId` &lt;integer&gt; - REQUIRED

#### Request Body
An Animal object with the updates.
```
{
  "name": "Max",
  "description": "A small, playful dog with white fur and floppy ears.",
  "species": "dog",
  "age": 5,
  "activeDate": "2025-03-19"
}
```
#### Response - the updated Animal object.
```
{
    "animalId": 7,
    "name": "Max",
    "description": "A small, playful dog with white fur and floppy ears.",
    "species": "dog",
    "age": 5.0,
    "activeDate": "2025-03-19"
}
```
### [`/delete/{animalId}`](http://localhost:8080/animals/delete/7) (DELETE)
Delete an existing Animal.

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Animals.
```
[
    {
        "animalId": 1,
        "name": "Luna",
        "description": "A small, fluffy dog with light brown fur.",
        "species": "dog",
        "age": 4.0,
        "activeDate": "2022-12-01"
    },
    {
        "animalId": 2,
        "name": "Lily",
        "description": "A fluffy white and gray cat with round eyes.",
        "species": "cat",
        "age": 2.5,
        "activeDate": "2023-10-10"
    },
    {
        "animalId": 3,
        "name": "Dusty",
        "description": "A soft gray chinchilla with large ears and soft gray fur.",
        "species": "chinchilla",
        "age": 1.2,
        "activeDate": "2024-01-15"
    },
    {
        "animalId": 4,
        "name": "Clover",
        "description": "A fluffy, light brown bunny with long ears.",
        "species": "bunny",
        "age": 3.0,
        "activeDate": "2024-02-10"
    },
    {
        "animalId": 5,
        "name": "Ava",
        "description": "A small, fluffy bird with grey feathers, a pink beak, and rosy cheeks.",
        "species": "bird",
        "age": 1.5,
        "activeDate": "2024-03-01"
    },
    {
        "animalId": 6,
        "name": "Bella",
        "description": "A white baby cow with soft, fluffy fur.",
        "species": "cow",
        "age": 0.5,
        "activeDate": "2024-08-20"
    }
]
```
