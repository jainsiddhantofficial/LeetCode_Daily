class ProductOfNumbers
{
    // Step 1: Declare an ArrayList to store numbers.
    ArrayList<Integer> list; 

    public ProductOfNumbers()
    {   
        // Step 2: Initialize the ArrayList.
        list = new ArrayList<>(); 
    }

    public void add(int num)
    {
        // Step 3: Append the given number to the list.
        list.add(num); 
    }

    public int getProduct(int k)
    {
        // Step 4: Check if k is greater than the list size.
        if (k > list.size())
        { 
            // Step 5: Return 0 if not enough elements exist.
            return 0; 
        }

        // Step 6: Initialize product as 1.
        int product = 1; 
        
        // Step 7: Loop through last k elements.
        for (int i = list.size() - k; i < list.size(); i++)
        { 
            // Step 8: Multiply each element to product.
            product *= list.get(i); 
        }
        
        // Step 9: Return the final product.
        return product; 
    }
}