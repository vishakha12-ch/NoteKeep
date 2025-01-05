# || Notes app ||

  1- In this Project we use Angular(frontend), spring boot(backend),JWT authentication:-
    * Users can add notes
    * After succesfull login user can see only recent 10 notes
    * User can delete notes(delete only form recent 10 notes which display on screen)
    * System automatically delete all notes other than most recent 10 notes on hourly basis

    For Automatically deletion 
     - first fetch recent 10 notes 
     - then fetch all notes for a user
     - then remove recentnotes from all notes
     - lastly delete notes 

  2- Setup Guide
     (Backend)
      * -In properties.application file replace your database name, username and password of mysql(change  database other than mysql if you want)

      (Frontend)
       * npm install 
       * ng serve
       * open Brower - http:localhost:4200
