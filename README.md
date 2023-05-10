*ARTICOLO IN COSTANTE AGGIORNAMENTO*


# Backend per la gestione del portfolio di un Discografico
Questo progetto è un Backend sviluppato in Java Spring Boot per un gestionale di un portfolio di un discografico.

## API REST

L'API REST (Application Programming Interface Representational State Transfer) è un'interfaccia che permette al frontend di comunicare con il backend attraverso una serie di richieste HTTP.

In questo caso, l'API REST permette di effettuare operazioni di lettura e scrittura sulle entità gestite dal sistema.

## Entità gestite tramite API REST

Il sistema di gestione gestisce le seguenti entità:
Eventi:
gli eventi sono composti da Titolo, Descrizione, Luogo, Artisti, Locandina e data; verranno poi inviati al front end tramite API per la stampa di esse a schermo.
UserNewsletters:
le UserNewsLetters sono composte da: nome, cognome, e-mail e consenso privacy, verrà generata una API disponibile all'admin per poter inviare email di comunicazione.



## Documentazione API

La documentazione dell'API è disponibile all'indirizzo "localhost:8080/v3/api-docs".

Richiede l'autenticazione tramite Token JWT, vedi la sezione LOGIN/REGISTER.

La documentazione è in formato JSON e può essere facilmente visualizzata su Postman.

# LOGIN/REGISTER


## Endpoint Login: POST /api/auth/signin



Accetta un body in formato JSON con username e password.
- da postman fare una chiamata di tipo POST all'endpoint http://localhost:8080/api/auth/register seguendo questo template:

 *{*
 
 *"username":"admin",*
 
 *"email":"example@example.com",*
 
 *"password":"123456789",*
 
 *"roles":["ROLE_ADMIN"]*
 
 *}*

### Cancellando la riga "roles", verrete registrati con il ruolo di User, non avendo accesso ad alcune funzionalità relative ai get delle newsletter ed ai post degli eventi. 
- sempre da postman fare una chiamata di tipo POST all'endpoint http://localhost:8080/api/auth/login seguendo questo template:

*{*

*"username":"admin",**

*"password":"123456789"*

*}*

 
 ### La chiamata ignorerà gli altri campi inseriti in fase di register.



Endpoing Register: POST /api/auth/register

Accetta un body in formato JSON con username, password, email.

Tutti i campi sono in formato String, ad eccezione dei ROLES che sono un array di stringhe.

I ruoli disponibili sono "ROLE_ADMIN" e "ROLE_USER".


Installazione Manuale:
Eseguire in ordine i seguenti passaggi:

CREARE UN DB su Postgres o MySql

- Settare il file application.properties in base alle necessità, a partire da application.properties.template
- Eseguire una volta la funzione 'setRoleDefault();' dal Runner (scommentare e riavviare e successivamente ricommentare)
- Eseguire una volta la funzione 'startedDB();' dal Runner per popolare il database (scommentare e riavviare e successivamente ricommentare).
- tramite PostMan eseguire il login (vedi sopra)


