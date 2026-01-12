Bonjour.
Ce README sert à titre d'aide pour résumer et donner quelques indication sur l'utilisation de l'API que j'ai développer pour le TP2 de R505.

Cette API est une API CRUD basique centrée autour du type 'User' construit comme suit :

User {
    id:int
    name:string
    email:string
}

L'adresse de l'API est : "/api/users" (l'adresse complète étant http://localhost:8080/api/users sur le Postman de mon PC).
Cette adresse nous permet d'utiliser une requête de type GET pour obtenir la liste complete des User.
Ou une requête de type POST, avec un User en JSON dans le corps de la requête, pour créer un nouvel User.

Ensuite, avec l'adresse "/api/users/{id}" nous pouvons, en specifiant l'id d'un User, effectuer des actions spécifique à un seul utilisateur.
Avec une requête de type GET, nous pouvons obtenir les informations de cet User.
Avec une requête de type UPDATE et un type User en JSON dans le corps de la requête, nous pouvons modifier les informations de cet User.
Avec une requête de type DELETE, nous pouvons supprimer cet User.