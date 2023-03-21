# Exemple de spring security Bearer

## Prérequis

* Java 17
* Un IDE (IntelliJ, Eclipse, VSCode, ...)

## Installation

Lancer la classe `SecurityApplication` dans votre IDE.

Pour vous authentifier:
```http request
POST http://localhost:8080/auth/login
{
  "username": "user",
  "password": "azerty"
}
```

Pour vous enregistrer:
```http request
POST http://localhost:8080/auth/register
{
  "username": "user",
  "password": "azerty"
}
```

Le CRUD des utilisateurs est disponible sur `/utilisateurs` (GET, DELETE)
