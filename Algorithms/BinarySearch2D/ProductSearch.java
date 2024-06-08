package BinarySearch2D;

import java.util.Arrays;

public class ProductSearch {

  // Product class to store product details
  static class Product {
    String name;
    int price;
    
    Product(String name, int price) {
      this.name = name;
      this.price = price;
    }
  }

  // Method to search for a product by price in a 2D array of products
  public static Product searchProductByPrice(Product[][] inventory, int targetPrice) {
    int rows = inventory.length - 1;
    int cols = inventory[0].length - 1;

    if (rows == 1) {
      return binarySearch(inventory, targetPrice, 0, 0, cols);
    }

    int rstart = 0;
    int rend = rows;
    int cmid = cols / 2;

    while (rstart < rend - 1) {
      int rmid = rstart + (rend - rstart) / 2;
      if (inventory[rmid][cmid].price > targetPrice) {
        rend = rmid;
      } else if (inventory[rmid][cmid].price < targetPrice) {
        rstart = rmid;
      } else {
        return inventory[rmid][cmid];
      }
    }
    if (inventory[rstart][cmid].price == targetPrice) {
      return inventory[rstart][cmid];
    }
    if (inventory[rend][cmid].price == targetPrice) {
      return inventory[rend][cmid];
    }
    if (targetPrice <= inventory[rstart][cmid - 1].price) {
      return binarySearch(inventory, targetPrice, rstart, 0, cmid - 1);
    }
    if (targetPrice >= inventory[rstart][cmid + 1].price) {
      return binarySearch(inventory, targetPrice, rstart, cmid + 1, cols);
    }
    if (targetPrice <= inventory[rend][cmid - 1].price) {
      return binarySearch(inventory, targetPrice, rend, 0, cmid - 1);
    }
    if (targetPrice <= inventory[rend][cmid + 1].price) {
      return binarySearch(inventory, targetPrice, rend, cmid + 1, cols);
    }
    return null;
  }

  // Binary search helper method
  static Product binarySearch(Product[][] inventory, int targetPrice, int row, int cstart, int cend) {
    while (cstart <= cend) {
      int cmid = cstart + (cend - cstart) / 2;
      if (inventory[row][cmid].price > targetPrice) {
        cend = cmid - 1;
      } else if (inventory[row][cmid].price < targetPrice) {
        cstart = cmid + 1;
      } else {
        return inventory[row][cmid];
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Product[][] inventory = {
      { new Product("ProductA1", 10), new Product("ProductA2", 20), new Product("ProductA3", 30) },
      { new Product("ProductB1", 15), new Product("ProductB2", 25), new Product("ProductB3", 35) },
      { new Product("ProductC1", 50), new Product("ProductC2", 60), new Product("ProductC3", 70) }
    };
    
    int targetPrice = 25;
    Product result = searchProductByPrice(inventory, targetPrice);
    if (result != null) {
      System.out.println("Found: " + result.name + " with price " + result.price);
    } else {
      System.out.println("Product not found");
    }
  }
}
