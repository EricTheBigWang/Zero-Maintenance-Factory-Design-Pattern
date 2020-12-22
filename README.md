# Zero-Maintenance-Factory-Design-Pattern

The factory design pattern creates objects.  
The exact class of the object is unspecified.  

# How this works

The factory searches the project directory and gathers each product name.  
The factory stores each product name inside a table.  

If the user creates a product, the user enters the product name.  
The factory creates the product from the name with reflection.  

# Why is this practical?

If the user creates many different product types, the factory accomodates.  
The user does not evaluate each name case-by-case.  
