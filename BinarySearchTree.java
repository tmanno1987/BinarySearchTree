import java.util.regex.*;
import java.util.*;
import java.io.*;

public class BinarySearchTree
{
   private class Node
   {
      private Node lLink;
      private Node rLink;
      private boolean lTag;
      private boolean rTag;
      private Customer info;
      
      public Node()
      {
         lLink = null;
         info = null;
         rLink = null;
         lTag = false;
         rTag = false;
      }
      
      public Node(Customer info)
      {
         lLink = null;
         this.info = info;
         rLink = null;
         lTag = false;
         rTag = false;
      }
      
      public Node(Customer info, Node ll, Node rl)
      {
         lLink = ll;
         this.info = info;
         rLink = rl;
         determineTags();
      }
      
      public void determineTags()
      {
         if ( lLink != null )
         {
            // set the left tag to true
            lTag = true;
         }
         else
         {
            // set the left tag to false
            lTag = false;
         }
         
         if ( rLink != null )
         {
            // set the right tag to true
            rTag = true;
         }
         else
         {
            // set the right tag to false
            rTag = false;
         }
      }
   }
   
   private Node root;
   private Customer c;
   
   public BinarySearchTree()
   {
      root = null;
   }
   
   public void insertBST(String s1, String s2)
   {
      c = new Customer(s1, s2);
      Node p, q;
      boolean flag = true;
      
      if (root == null)
      { 
         // create root node and and data to it
         root = new Node(c);
      }
      else
      {
         p = root;
         while (flag) // adjust later
         {
            if ( c.lessThan(c, p.info) )
            {
               // check to see if left link is empty
               if ( p.lLink != null )
               {
                  // get next left link field
                  p = p.lLink;
               }
               else
               {
                  // add node to tree and break loop
                  q = new Node(c);
                  addNode(p, q, c);
                  flag = false;
               }
            }
            else if ( c.greaterThan(c, p.info) )
            {
               if ( p.rLink != null )
               {
                  // search right link for next node
                  p = p.rLink;
               }
               else
               {
                  // add node to tree and break loop
                  q = new Node(c);
                  addNode(p, q, c);
                  flag = false;
               }
            }
            else
            {
               // data fields match
               flag = false;
            }
         }
      }
   }
   
   private void addNode(Node p, Node q, Customer c)
   {
      if ( c.lessThan(q.info, p.info) )
      {
         p.lLink = q;
      }
      else
      {
         p.rLink = q;
      }
   }
   
   public Customer findInterative(Node r, Customer c)
   {
      boolean flag = true;
      Customer x = null;
      
      while (flag || (r.rLink == null && r.lLink == null) )
      {
         // check each node to look for a match
         if (c.isLessThan(c, r.info) )
         {
            findRecursive(r.lLink, c);
         }
         else if ( c.isGreaterThan(c, r.info) )
         {
            findRecursive(r.rLink, c);
         }
         else
         {
            flag = false;
            x = r.info;
         }
      }
      
      return x;
   }
   
   public Customer findRecursive(Node r, Customer c)
   {
      if ((!c.equals(r.info)) && r.rLink == null && r.lLink == null)
      {
         // data not found exit function
         return null;
      }
      if (c.isLessThan(c, r.info) )
      {
         findRecursive(r.lLink, c);
      }
      else if ( c.isGreaterThan(c, r.info) )
      {
         findRecursive(r.rLink, c);
      }
      else
      {
         return r.info;
      }
   }
   
   public void inOrderSuccessor()
   {
      // set node p to root node and node q to 
      Node p = root;
      Node q = p.rLink;
      
      
   }
}

/*class Node
{
   private Node lLink;
   private Node rLink;
   private boolean lTag;
   private boolean rTag;
   private Customer info;
   
   public Node()
   {
      lLink = null;
      info = null;
      rLink = null;
      lTag = false;
      rTag = false;
   }
   
   public Node(Customer info)
   {
      lLink = null;
      this.info = info;
      rLink = null;
      lTag = false;
      rTag = false;
   }
   
   public Node(Customer info, Node ll, Node rl)
   {
      lLink = ll;
      this.info = info;
      rLink = rl;
      determineTags();
   }
   
   // accessor methods for Node class
   public Node getRightLink()
   {
      return rLink;
   }
   
   public Node getLeftLink()
   {
      return lLink;
   }
   
   public Customer getInfo()
   {
      return info;
   }
   
   public boolean getRightTag()
   {
      return rTag;
   }
   
   public boolean getLeftTag()
   {
      return lTag;
   }
   
   // mutator methods for Node class
   public void setRightLink(Node rl)
   {
      rLink = rl;
      determineTags();
   }
   
   public void setLeftLink(Node ll)
   {
      lLink = ll;
      determineTags();
   }
   
   public void setInfo(Customer i)
   {
      info = i;
   }
   
   private void determineTags()
   {
      if ( lLink != null )
      {
         // set the left tag to true
         lTag = true;
      }
      else
      {
         // set the left tag to false
         lTag = false;
      }
      
      if ( rLink != null )
      {
         // set the right tag to true
         rTag = true;
      }
      else
      {
         // set the right tag to false
         rTag = false;
      }
   }
}*/

class Customer
{
   private String name;
   private String number;
   
   public Customer()
   {
      name = null;
      number = null;
   }
   
   public Customer(String name, String num)
   {
      this.name = name;
      number = num;
   }
   
   // Customer class Accessor methods
   public String getName()
   {
      return name;
   }
   
   public String getNumber()
   {
      return number;
   }
   
   // Customer class Mutator methods
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setNumber(String num)
   {
      number = num;
   }
   
   // Customer class special methods
   public boolean lessThan(Customer a, Customer b)
   {
      if ( a.name.compareTo(b.name) < 0 )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public boolean greaterThan(Customer a, Customer b)
   {
      if ( a.name.compareTo(b.name) > 0 )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // Customer class toString method
   public String toString()
   {
      String s1 = "Name: " + name;
      String s2 = "Phone: " + number;
      
      return s1 + "\n" + s2;
   }
}

class Driver
{
   public static void main(String [] args) throws FileNotFoundException
   {
      BinarySearchTree bst = new BinarySearchTree();
      Scanner sc = new Scanner(System.in);
      /*System.out.println("Enter file name: ");
      String fName = sc.next();
      String [][] data = processFileData(fName);*/
      Customer person = new Customer();
      String name;
      String number;
      String again = "yes";
      
      // insert into Binary Search Tree
      while ( again.charAt(0) == 'y' )
      {
         do
         {
            // prompt user for name and phone number for new customer
            System.out.print("Enter the customers name: ");
            name = sc.next();
            System.out.print("Enter the customers phone number: ");
            number = sc.next();
            // check to see if name/number are valid entries
            System.out.println(validateName(name) + " " + validatePhoneNumber(number));
         }
         while ( validateName(name) && validatePhoneNumber(number) );
         // using the insert method each data entry is added to tree
         //bst.insertBST(name, number);
         
         // prompt user to enter more data or not
         System.out.print("Enter yes to add more or anything else to quit: ");
         again = sc.next();
         again = again.toLowerCase();
      }
      
      // search for "Ortiz" using both recursive/iterative find methods
      
      
      // search for "Penton" using both recursive/iterative find methods
      
      
      // search for "Ikerd" then traverse tree inorder printing names
      
      
      // insert 3 more people into binary tree
      
      
      // traverse tree inorder starting at root with inorderSuccessor
      // method printing both name and phone number fields
      
      
      // traverse the tree from root using pre-order iterative traversal
      
      
      // traverse the tree from root using post-order iterative traversal
      
   }
   
   public static boolean validateName(String name)
   {
      // create the pattern that will be matched with name field
      //String pattern = "\\D+";
      String pattern = "[a-zA-Z]+";
      
      // use regular expression to match check name
      if ( pattern.matches(name) )
      {
         // return true
         return true;
      }
      else
      {
         // tell user the name field is wrong and return false
         System.out.println("Name entered is Not valid");
         
         return false;
      }
   }
   
   public static boolean validateName(String name)
   {
      return namw.matches();
   }
   
   public static boolean validatePhoneNumber(String phone)
   {
      return phone.matches("[0-9]{3}-[0-9]{4}");
   }
   
   /*public static boolean validatePhoneNumber(String phone)
   {
      // create the pattern that will be matched with phone number field
      String pattern = "\\d{3}[-]*\\d{4}";
      
      // use regular expression to match check phone number
      if ( pattern.matches(phone) )
      {
         return true;
      }
      else
      {
         // tell user the phone numer field is wrong and return false
         System.out.println("Phone number entered is Not valid");
         
         return false;
      }
   }*/
   
   public static String [][] processFileData(String s) throws FileNotFoundException
   {
      ArrayList<String> als = new ArrayList<>();
      Scanner file = new Scanner(new File(s));
      String [][] temp;
      String [] oTemp;
      
      // extract data held in file
      while (file.hasNext())
      {
         // add data to array list
         als.add(file.nextLine());
      }
      // initialize string array and close file
      temp = new String[als.size()][2];
      file.close();
      
      // insert data from array list into a String array
      for (int i = 0; i < als.size(); i++)
      {
         // seperate strings and apply them to temp 2d array
         oTemp = splitPoints(als.get(i));
         temp[i][0] = oTemp[0];
         temp[i][1] = oTemp[1];
      }
      
      // return string array
      return temp;
   }
   
   public static String [] splitPoints(String s)
   {
      char [] c = s.toCharArray();
      int [] nums = new int[2];
      int count = 0;
      
      for (int i = 0; i < c.length; i++)
      {
         if (c[i] == ',')
         {
            // set up position in array
            nums[count++] = i;
         }
         else if (c[i] == ' ')
         {
            i++;
            nums[count] = i;
            break;
         }
      }
      
      String [] lets = {
         new String(c, 0, nums[0]), 
         new String(c, nums[1], (c.length-nums[1]))
      };
      
      return lets;
   }
}