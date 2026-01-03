# 📚 Kata Java Cabinet Médical – API

## 🛠️ Description
Ce projet est une implémentation **API REST** du kata « Cabinet Médical » en **Java 21** avec **Spring Boot**.  
Il couvre la partie **MVP** décrite dans l’énoncé, permettant la gestion des médecins et des créneaux de rendez-vous.

---

## ✅ Fonctionnalités Implémentées (MVP)
- **Lister les médecins** avec leur spécialité.
- **Afficher les créneaux disponibles** pour un médecin donné.
- **Réserver un créneau** (chaque créneau ne peut être réservé qu’une seule fois).

---

## 📂 Structure du projet
```
src/
 └── main/
     └── java/
         └── com.medical.cabinet/
             ├── config/        # Configuration Spring
             ├── domain/        # Entités (Doctor, Slot, Appointment)
             ├── dto/           # Objets de transfert
             ├── exception/     # Exceptions personnalisées
             ├── handler/       # Gestion des erreurs globales
             ├── mapper/        # Mappers DTO ↔ Domain
             ├── repository/    # Interfaces JPA
             ├── service/       # Logique métier
             ├── util/          # Utilitaires
             ├── web/           # Contrôleurs REST
             └── MedicalCabinetApiApplication.java  # Classe principale
     └── resources/
         └── application.properties
```

⚙️ Prérequis

- Java 21
- Maven
- Spring Boot 3.x
- Base de données : H2 (en mémoire pour simplifier)

🚀 Lancer le projet :

1- Cloner le repo :
```
git clone <URL_DU_REPO>
cd cabinet-medical-api
```
2- Compiler et exécuter :
```
mvn spring-boot:run
```

## 🧪 Tester l'API
Accédez à la documentation de l’API via Swagger UI : `http://localhost:8080/swagger-ui/index.html
