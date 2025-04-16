<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Animal Details</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

<!-- Begin Nav Bar -->
<nav class="navbar navbar-expand-lg custom-navbar">
    <a class="navbar-brand" href="/animals/all" style="margin: 10px;">Perfect Pet Match</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link active" href="/animals/all">Home</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h1 class="mb-4">Animal Details</h1>

    <div class="card p-3">
        <#if animal.image?has_content>
        <img src="${animal.image}" class="img-fluid mb-3" alt="${animal.name}">
        <#else>
        <img src="/images/default.jpg" class="img-fluid mb-3" alt="No image available">
    </#if>

    <p><strong>Name:</strong> ${animal.name}</p>
    <p><strong>Description:</strong> ${animal.description}</p>
    <p><strong>Species:</strong> ${animal.species}</p>
    <p><strong>Age:</strong> ${animal.age}</p>
    <p><strong>Active Date:</strong> ${animal.activeDate?string("yyyy-MM-dd")}</p>

    <div class="mt-3">
        <a href="/animals/all" class="btn btn-secondary">Back</a>
        <a href="/animals/update/${animal.animalId}" class="btn btn-warning">Edit</a>
        <a href="/animals/delete/${animal.animalId}" class="btn btn-danger">Delete</a>
    </div>
</div>
</body>
</html>