Partie 1 : Fonctions de base
🔹 Afficher les patients
Utilisation de Spring MVC avec Thymeleaf.

Liste des patients affichée depuis la base de données.
![Screenshot from 2025-05-17 19-35-41](https://github.com/user-attachments/assets/a4a9501e-9974-446a-a268-c821d4d87945)
![Screenshot from 2025-05-17 19-41-14](https://github.com/user-attachments/assets/1f69be84-a098-4bd8-b490-bb2ad338ff28)
![Screenshot from 2025-05-17 23-06-10](https://github.com/user-attachments/assets/26ff3c9a-1c48-4a6d-9dbe-a054da4b2eb5)

🔹 Pagination
Utilisation de Page<Patient> dans le contrôleur Spring pour paginer les résultats.

![Screenshot from 2025-05-17 23-35-10](https://github.com/user-attachments/assets/7e8793f8-acf3-422e-bb79-d47fbfe2c6a8)

🔹 Recherche de patients
Recherche par mot-clé (nom partiel).

Utilisation de la méthode findByNomContains(String keyword).
![Screenshot from 2025-05-18 00-09-22](https://github.com/user-attachments/assets/0a372dec-b89e-4bb4-91f8-ab8e9ba11483)

🔹 Suppression d’un patient
Bouton de suppression associé à chaque ligne dans le tableau.

Lien vers /delete?id=... qui appelle une méthode @GetMapping("/delete") dans le contrôleur.
![Screenshot from 2025-05-18 14-49-55](https://github.com/user-attachments/assets/4ccc6f75-3746-4447-be90-d7ec0971f460)



🎨 Partie 2 : Formulaires et validation

🔹 Création de page template
Utilisation de layout.html pour uniformiser les pages (header, menu, footer).

Intégration avec Thymeleaf Layout Dialect pour l’héritage de vues.
![Screenshot from 2025-05-19 16-26-28](https://github.com/user-attachments/assets/0ccb5155-af65-44bd-b5c2-4cbade2fab3e)

🔹 Validation des formulaires
![image](https://github.com/user-attachments/assets/5b311864-55d8-424b-bcfe-b898335e6f81)

Ajout de contraintes avec @NotEmpty, @Min, @Max, etc.

Affichage des messages d’erreur directement dans le formulaire.
![Screenshot from 2025-05-23 23-46-50](https://github.com/user-attachments/assets/56675bb7-ec71-4c94-a76f-ccb52f12dcca)
