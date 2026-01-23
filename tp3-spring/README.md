Bonjour.

Ce README sert à titre d'aide pour résumer et donner quelques indications sur l'utilisation de l'API développée dans le cadre du TP2 de R505.

Cette API est une API CRUD simple, construite avec Spring Boot et connectée à une base de données MySQL.

---

## Utilisateurs

L'API permet de gérer des utilisateurs définis comme suit :

User {
    id: int
    username: string
    password: string
    role: string
}

### Endpoints

Base URL : http://localhost:8080/api/users

- GET /api/users  
  → Récupère la liste complète des utilisateurs

- POST /api/users  
  → Crée un nouvel utilisateur  
  (le corps de la requête doit contenir un User en JSON)

Base URL avec identifiant : http://localhost:8080/api/users/{id}

- GET /api/users/{id}  
  → Récupère les informations d’un utilisateur

- PUT /api/users/{id}  
  → Modifie les informations d’un utilisateur  
  (User en JSON dans le corps de la requête)

- DELETE /api/users/{id}  
  → Supprime l’utilisateur

---

## Articles

L'API permet également de gérer des articles de blog définis comme suit :

Article {
    id: int
    content: string
    author: string
    publicationDate: datetime
}

### Endpoints

Base URL : http://localhost:8080/api/articles

- GET /api/articles  
  → Récupère la liste des articles

- POST /api/articles  
  → Crée un nouvel article  
  (Article en JSON dans le corps de la requête)

Base URL avec identifiant : http://localhost:8080/api/articles/{id}

- GET /api/articles/{id}  
  → Récupère un article

- PUT /api/articles/{id}  
  → Modifie le contenu d’un article

- DELETE /api/articles/{id}  
  → Supprime un article

---

## Remarques

- Les autorisations et l’authentification (JWT, rôles) ne sont pas gérées dans le cadre du TP2
- La base de données est automatiquement générée par Hibernate à partir des entités Java
- Les tests de l’API peuvent être réalisés via Postman