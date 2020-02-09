# Dress rental

## Purpose
  WEB-Application for working with the catalog of dresses with the possibility of accounting for rented dresses.
  The application should release the following functions:
  * viewing and editing the catalog of dresses;
  * displaying the total number of dresses, the number of rents for each dress and the total number of rents;
  * viewing and editing the catalog of rented dresses;
  * displaying of rented dresses for a given date range;
  * displaying the total number of rents;
  
  
## 1. Dresses

### 1.1 Viewing the list of dresses
  This program mode is designed to view the list of dresses, the total number of dresses, the number of rents for each dress and the total number of rents.
  
  Main scenario:
  * the user selects the menu item "Dresses";
  * the list view of all dresses is displayed.
  
  ![Pic 1.1](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.1%20View%20list%20of%20dresses.png)
Pic. 1.1 Viewing the list of dresses

The following columns are displayed in the list:
* Dress - dress name;
* Number of orders - the number of rents for dress;
* Actions - available actions (edit and delete).

the total number of dresses and the total number of rents is displayed at the end of the list.

## 1.2 Adding dress
  This program mode is designed to add a new dress in list.
  
  Main scenario:
  * the user is in the dress list view mode and clicks the "Add" button;
  * the form for adding a new dress is displayed;
  * the user enters data and clicks the "Save" button;
  * if the data was entered incorrectly, then the warning about incorrect data would be displayed;
  * if the data was correct, then the dress would be added to the database;
  * if an error occurred while saving data, an error message is displayed: "Error saving data";
  * if the dress was added successfully, the form for viewing the list of dresses with updated data would open. 
  
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
  * if the dress was added successfully, the form for viewing the list of dresses with updated data would open. 
  
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
  
  ## Dress removal
  This program mode is designed to remove a dress.
 
  Main scenario:
  * the user is in the dress list view mode and clicks the "Remove" button in the column "Action" for the selected dress;
  * there is a check for the possibility of removing the dress, i.e. whether this dress is on the list of rented dresses;
  * if the dress is on the list of rented dresses, the warning dialog "This dress cannot be remove because it is on the list of rented dresses";
  * if the dress can be removed, the confirmation dialog for removal is displayed "Are you sure you want to remove the dress <dress name>?";
  * the user clicks the "Yes" button;
  * the dress is deleted in the database;
  * if an error occured while deleting data, an error message is displayed "Error data deletion";
  * if the dress has been removed successfully, the form for viewing the list of dresses with updated data would open.
  
  Discard removal:
  * the user is in the dress list view mode and clicks the "Remove" button in the column "Action" for the selected dress;
  * the confirmation dialog for removal is displayed "Are you sure you want to remove the dress <dress name>?";
  * the user clicks the "No" button;
  * the form for viewing the list of dresses with updated data would be open.
  
   ![Pic 1.4](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/raw/dev/documentation/pictures/Pic.%201.4%20Confirmation%20of%20dress%20removal.png)
   Pic. 1.4 Confitmation of dress removal

  
