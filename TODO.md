#### Pending bugfixes

[] ADMIN MENU: when deleting an element from the table it won't be refreshed and 
the changes won't be reflected in the arraylist nor at the hashmap.

[] ADMIN MENU: when editing an element from the table the changes
are reflected in the table, but not in the arraylist.

[] OBJECT PERSISTENCE: objects writing won't function properly in Windows OS.

#### Pending features

[] CONTROLLER CLASS (refactor): change implementation of the stored objects.
Only the arraylist should be loaded and written. Then after loading the arraylist
from the .ser file, the hash map it's generated.

[] FILES TO STORE EMPLOYEES CREDENTIALS: in the current implementation
there's only one valid user and password for both the employee and admin menu.
When at either the employee or admin login, it should receive the credentials
and look at the file where the employees credentials are stored to check if 
the user and password inputted is valid.
This function comes with the necessity for a specific file to store the usernames
for employees and a hashmap to store the respective password for the key (username).

[] "ModelosApp" AND "ServiciosApp" CALLBACK IN FRONTEND: in the current implementation
both backend apps are called within the class definition. Every class in the
frontend package that needs to perform a backend operation needs to have
a "ModelosApp" or "ServiciosApp" class as an attibute in order to
perform the callback for the necessary methods.