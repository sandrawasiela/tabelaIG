
-	Team

Paweł Sobociński
Sandra Wasiela

-	Description of application

The application is used to display the glycemic index and nutritional values of the product. 
We can find there a product that interests us and check if it is good for our health.
We classify the glycemic index into 3 groups:
- <55 products with a low glycemic index
- <56; 69> products with a medium glycemic index (allowed in small quantities)
- >70 products with a high glycemic index.
The color of the number for the glycemic index changes depending on the group it belongs to (green – low, orange – medium, red – high).  
This solution helps us avoid a sharp rise in blood glucose levels.
In addition to the glycemic index, we also have information about the content of fat, sugars, carbohydrate, protein, fibre, salt, 
cholesterol and whether the product is gluten-free. Then, if we often use specific products, we can add them to favorites and use them at a later time. When a product is no longer necessary, we can also remove it from the list of favorites.
The target group of users of our application are people who struggle with blood 
sugar / insulin disorders and want to change their eating habits.


-	Class description

DataDownload - class used to download data about product from the https://www.nutritics.com/  API.
MainActivity - class used to display the welcome screen and launch the main screen.
SecondActivity - displays the main screen on which we can take two actions (by clicking the appropriate button): search for a 
product or display products added to favorites.
DescriptionView – displays the glycemic index and product nutrition values in the list and what effect this product has on our 
glucose level (by means of color).
Favourites - displays a list of products that we have previously added as favorites and allows you to check them again.
SQLHelper - it is a database that stores product information and enables simple operations - adding a new item, deleting an existing one.
