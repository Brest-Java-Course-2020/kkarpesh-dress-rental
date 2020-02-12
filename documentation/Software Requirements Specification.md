# Dress rental
 
## Purpose
  WEB-Application for working with the catalog of dresses with the possibility of accounting for rented dresses.
  The application should release the following functions:
  * viewing and editing the catalog of dresses;
  * displaying the total number of dresses, the number of rents for each dress and the total number of rents;
  * viewing and editing the catalog of rented dresses;
  * displaying of rented dresses for a given date range;
  * displaying the total number of rents;
  
---  
## 1. Dresses

### 1.1 Viewing the list of dresses
  This program mode is designed to view the list of dresses, the total number of dresses, the number of rents for each dress and the total number of rents.
  
  Main scenario:
  * the user selects the menu item "Dresses";
  * the list of all dresses is displayed.
  
  ![Pic 1.1](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.1%20View%20list%20of%20dresses.png)
  
  Pic. 1.1 Viewing the list of dresses

  The following columns are displayed in the list:
  * Dress - dress name;
  * Number of orders - the number of rents for dress;
  * Actions - available actions (edit and delete).

  The total number of dresses and the total number of rents is displayed at the end of the list.

## 1.2 Adding dress
  This program mode is designed to add a new dress in list.
  
  Main scenario:
  * the user is in the dress list view mode and clicks the "Add" button;
  * the form for adding a new dress is displayed;
  * the user enters data and clicks the "Save" button;
  * if the data was entered incorrectly, then the warning about incorrect data would be displayed;
  * if the data was correct, then the dress would be added to the database;
  * if an error occurred while saving data, an error message is displayed: "Error saving data";
  * if the dress was added successfully, the form for viewing the list of dresses with updated data would be open. 
  
  Discard changes:
  * the user is in the dress list view mode and clicks the "Add" button;
  * the form for adding a new dress is displayed;
  * the user enters data and clicks the "Cancel" button;
  * data is not saved to the database, the form for viewing the list of dresses with updated data would be open.
  
  ![Pic 1.2](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.2%20Dress%20adding.png)
  
  Pic. 1.2 Dress adding
   
  When adding a dress, the following details are entered:
  * Dress - dress name.
  
  Limitations for data validation:
  * Dress - maximum 70 characters. The value must be unique in the database.
   
## 1.3 Editing dress
  This program mode is designed to edit a dress.
 
  Main scenario:
  * the user is in the dress list view mode and clicks the "Edit" button in the column "Action" for the selected dress;
  * the form for editing a dress is displayed;
  * the user edits data and clicks the "Save" button;
  * if the data was entered incorrectly, then the warning about incorrect data would be displayed;
  * if the data was correct, then the dress would be added to the database;
  * if an error occurred while saving data, an error message is displayed: "Error saving data";
  * if the dress was added successfully, the form for viewing the list of dresses with updated data would be open. 
  
  Discard changes:
  * the user is in the dress list view mode and clicks the "Edit" button in the column "Action" for the selected dress;
  * the form for editing a dress is displayed;
  * the user edits data and clicks the "Cancel" button;
  * data is not saved to the database, the form for viewing the list of dresses with updated data would be open.
  
  ![Pic 1.3](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.3%20Dress%20editing.png)
  
  Pic. 1.3 Dress editing
   
  When editing a dress, the following details are entered:
  * Dress - dress name.
  
  Limitations for data validation:
  * Dress - maximum 70 characters. The value must be unique in the database.
  
## 1.4 Dress removal
  This program mode is designed to remove a dress.
 
  Main scenario:
  * the user is in the dress list view mode and clicks the "Remove" button in the column "Action" for the selected dress;
  * there is a check for the possibility of removing the dress, i.e. whether this dress is on the list of rented dresses;
  * if the dress is on the list of rented dresses, the warning dialog "This dress cannot be remove because it is on the list of rented dresses";
  * if the dress can be removed, the confirmation dialog for removal is displayed "Are you sure you want to remove the dress "dress name"?";
  * the user clicks the "Yes" button;
  * the dress is deleted in the database;
  * if an error occurred while deleting data, an error message is displayed "Error data deletion";
  * if the dress has been removed successfully, the form for viewing the list of dresses with updated data would be open.
  
  Discard removal:
  * the user is in the dress list view mode and clicks the "Remove" button in the column "Action" for the selected dress;
  * the confirmation dialog for removal is displayed "Are you sure you want to remove the dress "dress name"?";
  * the user clicks the "Cancel" button;
  * the form for viewing the list of dresses with updated data would be open.
  
  ![Pic 1.4](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.4%20Confirmation%20of%20dress%20removal.png)
  
  Pic. 1.4 Confirmation of dress removal
  
  ---
   
## 2. Rented dresses

### 2.1 Viewing the list of rented dresses
  This program mode is designed to view the list of rented dresses and the total number of rents.
   
  Main scenario:
  * the user selects the menu item "Rented dresses";
  * the list of rented dresses is displayed.
  
  ![Pic 2.1](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%202.1%20View%20list%20of%20rented%20dresses.png)
  
  Pic. 2.1 Viewing the list of rented dresses

  The following columns are displayed in the list:
  * Dress - dress name;
  * Client - the person who rents the dress;
  * Rental date - the date on which the dress is rented;
  * Actions - available actions (edit and delete).

  The total number of rented dresses is displayed at the end of the list.

###### Filter data by date:
  * To view the list of rented dresses for certain periods selecting a filter for the sampling period from and to.
  * The start date of the filter should not be greater than the end date.
  * If no data is entered, then filtering is not performed.
  * If the start date is not entered, then filter by end date only.
  * If the end date is not entered, then filter by start date only.
  * The default filter is set from the 1st of the current month to the current date.
  * Data is updated after selecting filtering data and clicking the "Update" button.
   
### 2.2 Adding dress for rent
  This program mode is designed to add a new rented dress in list.
  
  Main scenario:
  * the user is in the rented dresses list view mode and clicks the "Add" button;
  * the form for adding a new rented dress is displayed;
  * the user enters data and clicks the "Save" button;
  * if the data was entered incorrectly, then the warning about incorrect data would be displayed;
  * if the data was correct, then the rented dress would be added to the database;
  * if an error occurred while saving data, an error message is displayed: "Error saving data";
  * if the rented dress was added successfully, the form for viewing the list of rented dresses with updated data would be open. 
  
  Discard changes:
  * the user is in the rented dresses list view mode and clicks the "Add" button;
  * the form for adding a new rented dress is displayed;
  * the user enters data and clicks the "Cancel" button;
  * data is not saved to the database, the form for viewing the list of rented dresses with updated data would be open.
  
  ![Pic 2.2](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%202.2%20Adding%20dress%20for%20rent.png)
  
  Pic. 2.2 Adding dress for rent
   
  When adding a rented dress, the following details are entered:
  * Dress - dress name;
  * Client - the person who rents the dress;
  * Rental date - the date on which the dress is rented;
  
  Limitations for data validation:
  * Dress - one value is selected from the list of available dresses. If there is no dress in system, you cannot add a new rented dress.
  * Client - maximum 50 characters.
  
### 2.3 Editing rented dress
  This program mode is designed to edit a dress.
  
  Main scenario:
  * the user is in the rented dresses list view mode and clicks the "Edit" button in the column "Action" for the selected rented dress;
  * the form for editing a rented dress is displayed;
  * the user edits data and clicks the "Save" button;
  * if the data was entered incorrectly, then the warning about incorrect data would be displayed;
  * if the data was correct, then the rented dress would be added to the database;
  * if an error occurred while saving data, an error message is displayed: "Error saving data";
  * if the rented dress was added successfully, the form for viewing the list of rented dresses with updated data would be open. 
  
  Discard changes:
  * the user is in the rented dresses list view mode and clicks the "Edit" button in the column "Action" for the selected rented dress;
  * the form for editing a rented dress is displayed;
  * the user edits data and clicks the "Cancel" button;
  * data is not saved to the database, the form for viewing the list of rented dresses with updated data would be open.
  
  ![Pic 2.3](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%202.3%20Editing%20rented%20dress.png)
 
  Pic. 2.3 Editing rented dress 
   
  When editing a rented dress, the following details are entered:
  * Dress - dress name;
  * Client - the person who rents the dress;
  * Rental date - the date on which the dress is rented;
  
  Limitations for data validation: 
  * Dress - one value is selected from the list of available dresses. If there is no dress in system, you cannot add a new rented dress.
  * Client - maximum 50 characters.
  
## 2.4 Rented dress removal
  This program mode is designed to remove a rented dress.
 
  Main scenario:
  * the user is in the rented dresses list view mode and clicks the "Remove" button in the column "Action" for the selected rented dress;
  * the confirmation dialog for removal is displayed "Are you sure you want to remove the dress "dress name" rented by "client" on "rental date"?";
  * the user clicks the "Yes" button;
  * the rented dress is deleted in the database;
  * if an error occurred while deleting data, an error message is displayed "Error data deletion";
  * if the rented dress has been removed successfully, the form for viewing the list of rented dresses with updated data would be open.
  
  Discard removal:
  * the user is in the rented dresses list view mode and clicks the "Remove" button in the column "Action" for the selected rented dress;
  * the confirmation dialog for removal is displayed "Are you sure you want to remove the dress "dress name" rented by "client" on "rental date"?";
  * the user clicks the "Cancel" button;
  * the form for viewing the list of rented dresses with updated data would be open.
  
  ![Pic 2.4](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%202.4%20Confirmation%20of%20rented%20dress%20removal.png)
  
  Pic. 2.4 Confirmation of rented dress removal
  
  
  
  
