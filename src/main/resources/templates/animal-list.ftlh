<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Animal List</title>

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
<!--            <li class="nav-item">-->
<!--                <a class="nav-link" href="#">Details</a>-->
<!--            </li>-->
<!--            <li class="nav-item">-->
<!--                <a class="nav-link" href="#">Third</a>-->
<!--            </li>-->
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h1 class="mb-4">Animal Gallery</h1>
    <a href="/animals/createForm" class="btn btn-primary mb-4">Add New Animal</a>

    <form action="/animals/name" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="search" class="form-control" placeholder="Search by name" required>
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
    </form>
    <#if animalList?size == 0>
    <div class="alert alert-danger" role="alert">
        No animals match your search criteria. Please try again!
    </div>
    <#else>
    <div class="row">
        <#list animalList as animal>
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <#if animal.image?has_content>
                <img src="${animal.image}" class="card-img-top" alt="${animal.name}">
                <#else>
                <img src="/images/default.jpg" class="card-img-top" alt="No image available">
            </#if>
            <div class="card-body">
                <h5 class="card-title">${animal.name}</h5>
                <p class="card-text">${animal.description}</p>
            </div>
            <div class="card-footer text-center">
                <a href="/animals/details/${animal.animalId}" class="btn btn-info btn-sm">View</a>
                <a href="/animals/update/${animal.animalId}" class="btn btn-warning btn-sm">Edit</a>
                <a href="/animals/delete/${animal.animalId}" class="btn btn-danger btn-sm">Delete</a>
            </div>
        </div>
    </div>
    </#list>
</body>

</#if>

</body>
</html>
