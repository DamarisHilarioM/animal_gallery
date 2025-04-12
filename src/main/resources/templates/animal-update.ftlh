<!DOCTYPE html>
<html lang="en">
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

<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <form id="new-animal" action="/animals/update/${animal.animalId?c}" method="post">
        <!-- Animal ID (Read-only) -->
        <input type="text" id="animalId" name="animalId" value="${animal.animalId?c}" readonly/>

        <!-- Name Input -->
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${animal.name}" placeholder="Name"/>

        <!-- Species Input -->
        <label for="species">Species</label>
        <input type="text" id="species" name="species" value="${animal.species}" placeholder="Species"/>

        <!-- Description Input -->
        <label for="description">Description</label>
        <textarea id="description" name="description" placeholder="Description" rows="4" class="form-control">${animal.description}</textarea>

        <!-- Submit and Cancel Buttons -->
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/animals/all" class="btn btn-outline-danger">Cancel</a>
    </form>
</div>

</body>
</html>