# Dress rental
## Purpose

  WEB-Application for working with the catalog of dresses with the possibility of accounting for rented dresses.
  The application should release the following functions:
  * viewing and editing the catalog of dresses;
  * display of the cost and payback of each individual dress and the quantity, total cost and profitability of all dresses;
  * viewing and editing the catalog of rented dresses;
  * display of rented dresses for a given date range
  
## 1. Dresses
### 1.1 Viewing the list of dresses
  This program mode is designed to view the list of dresses, the cost and profitability of each dress and the quantity, total cost and rofitability of all dresses.
  
  
  Main script:
  * the user selects the menu item "Dresses";
  * a list view of all dresses is displayed.

Pic. 1.1 Viewing the list of dresses

The following columns are displayed in the list:
* Dress - dress name;
* Price - dress price;
* Profitability - dress profitability

Number of dresses, total cost and profitability is displayed at the end of the list.

## 1.2 Adding dress
  
  Main script:
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
  * the user enters data and clicks the "Return" button;
  * data is not saved to the database, the form for viewing the list of dresses with updated data would open. 
  