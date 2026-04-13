import java.util.*;

class main {

    //for the login page
    static String username = "rivith";
    static String password = "1234";

    //for the suppliers
    static String [][] suppliers=new String[100][2];
    static int supcount=0;

    //for the categories
    static String [] catogary= new String[100];
    static int catcount=0;

    //for the add item

    static String[][] addItem = new String[100][6];
    static int itemCount = 0;


    public static void main(String[] args) {
        loginPage();
         
    }

    private final static void clearConsole() { //command line eka clear wenna

        final String os = System.getProperty("os.name");
        try {
        if (os.equals("Linux")) {

            System.out.print("\033\143");
        } else if (os.equals("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();

            }
            } catch (final Exception e) {

                System.err.println(e.getMessage());
            }
}

    public static void loginPage() {
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("+==================================+");
        System.out.println("|           LOGIN  PAGE            |");
        System.out.println("+==================================+");

        while (true) {
            System.out.print("Enter the user name: ");
            String name = input.nextLine();

            if (username.equals(name)) {
                System.out.print("Enter the password: ");
                String pass = input.nextLine();

                if (password.equals(pass)) {
                    System.out.println("Login Successful..");
                     homepage(); //home page ekata
                    return;
                } else {
                    System.out.println("Wrong password! Try again.");
                }
            } else {
                System.out.println("Incorrect username. Try again!");

            }
        }
    }

    public static void homepage() {

        clearConsole();
        Scanner input=new Scanner(System.in);
        while (true) {
        
            System.out.println("+================================================================+");
            System.out.println("|     WELCOME TO THE Pigeon Service STOCK MANAGEMENT SYSTEM      |");
            System.out.println("+================================================================+");

            System.out.println("[1] Change the credentials");
            System.out.println("[2] Supplier manage");
            System.out.println("[3] Stock manage");
            System.out.println("[4] Log out");
            System.out.println("[5] Exit the system");
            System.out.print("Enter an option to continue: ");

            int option = input.nextInt();
            

            switch (option) {
                case 1:
                    changeCredentials();
                    break;
                case 2:
                    suppliermanage();
                    break;
                case 3:
                    stockmanage();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    loginPage();
                    break;
                case 5:
                    System.out.println("Goodbye rivith !");
                    System.exit(0);
            
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void changeCredentials() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("+======================================+");
        System.out.println("|          CHANGE CREDENTIALS          |");
        System.out.println("+======================================+");

        System.out.print("Enter the current username: ");
        String name = input.nextLine();
        if (name.equals(username)) {
            System.out.print("Enter the current password: ");
            String currentPass = input.nextLine();

            if (currentPass.equals(password)) {
                System.out.print("Enter the new password: ");
                password = input.nextLine();
                System.out.println("Password updated successfully.");
                System.out.println("dou you want go to home page (y/n)");
                String go =input.nextLine();
                String yes="y";
                String no="n";
                if (go.equals(yes)){
                    homepage();
                    
                }else{
                    System.out.println("ok...");
                    loginPage();
                }
            
            } else {
                System.out.println("Incorrect password! Try again.");

            }
        } else {
              System.out.println("Invalid username! Please try again.");
              
        }


        
        
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        

    public static void suppliermanage(){

        clearConsole();
        Scanner input=new Scanner(System.in);
        while (true){

        System.out.println("+====================================================+");
        System.out.println("|               SUPPLIER   MANAGEMENT                |");
        System.out.println("+====================================================+");

        System.out.println("[1] Add supplier            [2] Update supplier ");
        System.out.println("[3] Delete supplier         [4] View supplier   ");
        System.out.println("[5] Search supplier         [6] Home page       ");

        System.out.println("Enter an option to continue :");
        int select= input.nextInt();

        switch(select){
            case 1:
                addsupplier();
                break;
            case 2:
                updatesupplier();
                break;
            case 3:
                deletesupplier();
                break;
            case 4:
                viewsupplier();
                break;
            case 5:
                searchsupplier();
                break;
            case 6:
                homepage();
                break;
            default:
                System.out.println("invalid option plzz try again..");
        }


        }
    }

    public static void addsupplier(){
        clearConsole();

        Scanner input = new Scanner(System.in);
        System.out.println("+=================================+");
        System.out.println("|         ADD SUPPLIER            |");
        System.out.println("+=================================+");

        System.out.println(" enter the supplier Id : ");
        String supid=input.nextLine();

        for(int i=0 ;i<supcount ; i++){
            if (suppliers[i][0].equals(supid)){
                System.out.println("supplier id already used ! \n do you want add new supplier (y/n).");
                String add1=input.nextLine();

                if(add1.equals("y")){
                    addsupplier();
                }else{
                    homepage();
                }
            
                
            }

        }

        System.out.println("enter the supplier name : ");
        String supname=input.nextLine();
        while(true){

        suppliers[supcount][0] = supid;
        suppliers[supcount][1] = supname;
        supcount++;
        
        System.out.println("supplier added succesfully !  ");
        System.out.println("do you want add another supplier ? (y/n)");
        String another=input.nextLine();
        String yep="y";
        String nope="n";
        if(another.equals(yep)){
            addsupplier();
        }else{
            homepage();
        }    

    }    
    }

    public static void updatesupplier(){
        clearConsole();
        Scanner input=new Scanner(System.in);
        System.out.println("+======================================+");
        System.out.println("|            UPDATE  SUPPLIER          |");
        System.out.println("+======================================+");

        while(true){
        System.out.print("enter the supplier id :");
        String supplier_id=input.nextLine();
            for(int i = 0; i < supcount; i++){
            if(suppliers[i][0].equals(supplier_id)){
                System.out.println("Supplier Name: " + suppliers[i][1]);
                System.out.print("Enter new supplier name: ");
                String new_name = input.nextLine();
                suppliers[i][1] = new_name;
                System.out.println("Supplier updated successfully!");
                System.out.println("do you want update other supplier name (y/n)");
                String choice =input.nextLine();
                String yess="y";
                String noo="n";
                if (choice.equals(yess)){
                    updatesupplier();
                    return;
                }else{
                    homepage();
                    
                }
            }if(i==supcount){
                System.out.println("No ID found, please try again!");
            }
            
   
        }
     }

    }
        public static void deletesupplier(){
        
            clearConsole();
           
       
        Scanner input=new Scanner(System.in);

         System.out.println("+==============================================+");
         System.out.println("|              DELETE SUPPLIER                 |");
         System.out.println("+==============================================+");

         System.out.println("enter the id to delete :");
         String delid=input.nextLine();

         int indexremove= -1;
         for (int i = 0; i < supcount; i++) {

            if (suppliers[i][0].equals(delid)) {
            indexremove = i;
            break;
        }
    }
            if(indexremove == -1){
                System.out.println("supplier id not found");
            }else {
                 String [][] newsupplier=new String[supcount -1][2];
                 //
                 for (int i=0; i<indexremove;i++){
                    newsupplier[i][0]=suppliers[i][0];
                    newsupplier[i][1]=suppliers[i][1];
                 }

                 for(int i=indexremove +1;i<supcount;i++){
                    newsupplier[i - 1][0]=suppliers[i][0];
                    newsupplier[i - 1][1]=suppliers[i][1];
                 }

                 // aluth array eka assign
                 suppliers = new String[100][2]; 
                for (int i = 0; i < newsupplier.length; i++) {
                suppliers[i][0] = newsupplier[i][0];
                suppliers[i][1] = newsupplier[i][1];
                }
                supcount--;
                System.out.println("deletet succesfully!");
                
        }


            
            
            System.out.print("do you want delete another supplier(y/n)");

            String again=input.nextLine();
            String yes="y";
            String no="n";
            if(again.equals(yes)){
                deletesupplier();
            }else{
                suppliermanage();
            }
        
        }
    
        public static void viewsupplier(){
        clearConsole();
        Scanner input=new Scanner(System.in);
        System.out.println("+=======================================================+");
        System.out.println("|                   VIEW SUPPLIERS                      |");
        System.out.println("+=======================================================+");
        
       if (supcount == 0){
        System.out.println("|          supplier list is empty            |");
    } else {
        System.out.println("+--------------+----------------------------------------+");
        System.out.printf("| %-12s | %-38s |\n", "Supplier ID", "Supplier Name");
        System.out.println("+--------------+----------------------------------------+");

        for(int i = 0; i < supcount; i++){
            if(suppliers[i][0] != null && suppliers[i][1] != null){
                System.out.printf("| %-12s | %-38s |\n", suppliers[i][0], suppliers[i][1]);
            }
        }

        System.out.println("+--------------+----------------------------------------+");
    }

        System.out.println("do you want goto supplier manage page ? (y/n)");
        String gosup=input.nextLine();
        String yep="y";
        String nope="n";
        if(gosup.equals(yep)){
            suppliermanage();
        }else{
            viewsupplier();
        }

    }

    public static void searchsupplier(){
        clearConsole();
        Scanner input=new Scanner(System.in);
        System.out.println("+===========================================+");
        System.out.println("|              SEARCH SUPPLIER              |");
        System.out.println("+===========================================+");

        System.out.print("enter the supplier id :");
        String search =input.nextLine();

         for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i][0] != null && suppliers[i][0].equals(search)) {
            
            System.out.println(" supplier ID: " + suppliers[i][0]);
            System.out.println("supplier Name: " + suppliers[i][1]);
            System.out.println("do you want search another supplier ? (y/n :" );
            String want=input.nextLine();
            if (want.equals("y")){
                searchsupplier();
            }else{
                homepage();
            }

             
        }
    }
    
           System.out.println("Supplier not found!");
           
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static void stockmanage(){
    clearConsole();
    Scanner input=new Scanner(System.in);
    System.out.println("+=================================================+");
    System.out.println("|                 STOCK  MANAGE                   |");
    System.out.println("+=================================================+");

    System.out.println("[1] Manage Item Categories           [2] Add Item");
    System.out.println("[3] Get Items Suppliers Wise         [4] View Items");
    System.out.println("[5] Rank Items Per Unit Price        [6] Home Page");

    while(true){
    System.out.print("enter an option to continue : ");
    int option= input.nextInt();
    switch(option){
        case 1:
            manageitems();
            break;
        case 2:
            additem();
            break;
        case 3:
            searchitemsupplerwise();
            break;
        case 4:
            viewitems();
            break;
        case 5:
            rankItemsPerUnitPrice();
            break;
        case 6:
            homepage();
            break;
        default:
            System.out.println("invalid option !");

        }


    } 
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void manageitems(){
        clearConsole();
        Scanner input=new Scanner(System.in);
        while(true){
        System.out.println("+=================================================+");
        System.out.println("|            manage item categories               |");
        System.out.println("+=================================================+");

        System.out.println("[1] Add new item category        [2] Delete item category");
        System.out.println("[3] update item category         [4] stock management    ");
        System.out.println("");


        System.out.print("enter an option to continue :");
        int options=input.nextInt();

        switch(options){
        case 1:
            addcatogery();
            break;
        case 2:
            deletecat();
            break;
        case 3:
            updatecat();
            break;
        case 4:
            stockmanage();
            break;
        
        default:
            System.out.println("invalid option !");

        }



    }

    }

    public static void addcatogery() {
    clearConsole();
    Scanner input = new Scanner(System.in);

    System.out.println("+=========================================+");
    System.out.println("|               ADD CATEGORY              |");
    System.out.println("+=========================================+");

    System.out.print("Enter the category name: ");
    String cat = input.nextLine();


    for (int i = 0; i < catcount; i++) {
        if (catogary[i] != null && catogary[i].equals(cat)) {
            System.out.println("This category is already used!\nDo you want to add another category? (y/n)");
            String option = input.nextLine();
            if (option.equals("y")) {
                addcatogery();
            } else {
                manageitems();
            }
            return; 
        }
    }

    
    catogary[catcount++] = cat;
    System.out.println("Category added successfully!\nDo you want to add another category? (y/n)");
    String want = input.nextLine();

    if (want.equals("y")) {
        addcatogery();
    } else {
        manageitems();
    }

        
    }



    public static void deletecat(){
    clearConsole();
    Scanner input=new Scanner(System.in);

    System.out.println("+=======================================+");
    System.out.println("|           DELETE CATEGORY             |");
    System.out.println("+=======================================+");


    System.out.println("enter the cetegory to delete :");
    String delcat =input.nextLine();

    String[] newCat = new String[100];
    int newCount = 0;
        for (int i = 0; i < catcount; i++) {
        if (catogary[i] != null && !catogary[i].equals(delcat)) {
            newCat[newCount++] = catogary[i];
        }
    }

    if (newCount == catcount) {
        System.out.println("Category not found!");
    } else {
        catogary = newCat;
        catcount = newCount;
        System.out.println("Category deleted successfully!");
    }



    }

    public static void updatecat(){
        clearConsole();
        Scanner input=new Scanner(System.in);

        System.out.println("+===========================================+");
        System.out.println("|             UPDATE CATEGORY               |");
        System.out.println("+===========================================+");


        System.out.print("enter the category to update :");
        String upcat = input.nextLine();

        int index = -1;

        for (int i = 0; i < catcount; i++) {

            if (catogary[i] != null && catogary[i].equals(upcat)) {

                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Category not found!");

            } else { 

                System.out.print("Enter new category name: ");
                String newCat = input.nextLine();

        catogary[index] = newCat;
        System.out.println("Category updated successfully!");
        }




    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void additem() {
    Scanner input = new Scanner(System.in);

    System.out.println("+==========================================+");
    System.out.println("|                ADD ITEMS                 |");
    System.out.println("+==========================================+");

    if (catcount == 0) {
        System.out.print("No categories found. Please add a category first. Do you want add category?(y/n) :");
        String option=input.nextLine();
        if(option.equals("y")){
            addcatogery();
        }
        
    }

    if (supcount == 0) {
        System.out.print("No suppliers found. Please add a supplier first. do you want add suppliers?(y/n) :");
        String opt =input.nextLine();

        if(opt.equals("y")){
            addsupplier();
        }
    }


    System.out.print("Enter item code: ");
    String itemCode = input.next();

    // Check duplicate item code
    for (int i = 0; i < itemCount; i++) {
        if (addItem[i][0].equals(itemCode)) {
            System.out.println("Item already use!");
            return;
        }
    }

    System.out.println("Suppliers:");
    for (int i = 0; i < supcount; i++) {
        System.out.println((i + 1) + ". " + suppliers[i][1] + " (" + suppliers[i][0] + ")");
    }
    System.out.print("Enter supplier number: ");
    int supIndex = input.nextInt() - 1;

    System.out.println("Categories:");
    for (int i = 0; i < catcount; i++) {
        System.out.println((i + 1) + ". " + catogary[i]);
    }
    System.out.print("Enter category number: ");
    int catIndex = input.nextInt() - 1;

    input.nextLine(); 
    System.out.print("Enter description: ");
    String desc = input.nextLine();

    System.out.print("Enter unit price: ");
    String price = input.next();

    System.out.print("Enter quantity: ");
    String qty = input.next();

    
    addItem[itemCount][0] = itemCode;
    addItem[itemCount][1] = suppliers[supIndex][0];
    addItem[itemCount][2] = catogary[catIndex];
    addItem[itemCount][3] = desc;
    addItem[itemCount][4] = price;
    addItem[itemCount][5] = qty;

    itemCount++;

    System.out.println("Item added successfully!");
}

public static void searchitemsupplerwise() {
    Scanner input = new Scanner(System.in);
    String choice;

    clearConsole();
    System.out.println("+=====================================================================+");
    System.out.println("|                    SEARCH ITEMS SUPPLIER WISE                       |");
    System.out.println("+=====================================================================+");

    if (supcount == 0) {
        System.out.print("No suppliers found! Do you want to add suppliers? (y/n): ");
        choice = input.next();

        if (choice.equals("y")) {
            addsupplier();
        } else {
            stockmanage();
        }
        return;
    }

    do {
        System.out.print("Enter Supplier ID: ");
        String id = input.next();
        int index = -1;

        
        for (int i = 0; i < supcount; i++) {
            if (suppliers[i][0] != null && suppliers[i][0].equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Supplier not found. Try again.");
            choice = "y";
            continue;  
        }

        System.out.println("Supplier Name: " + suppliers[index][1] + "\n");

    
        int itemFoundCount = 0;

        System.out.printf("+---------------+---------------+-----------------+---------------+---------------+%n");
        System.out.printf("| %-13s | %-13s | %-15s | %-13s | %-13s |%n", "SUPPLIER ID", "ITEM CODE", "DESCRIPTION", "PRICE", "QTY");
        System.out.printf("+---------------+---------------+-----------------+---------------+---------------+%n");

        for (int i = 0; i < itemCount; i++) {
            if (addItem[i][1] != null && addItem[i][1].equals(id)) {
                System.out.printf("| %-13s | %-13s | %-15s | %-13s | %-13s |%n",
                        addItem[i][1], addItem[i][0], addItem[i][3], addItem[i][4], addItem[i][5]);
                itemFoundCount++;
            }
        }

        if (itemFoundCount == 0) {
            System.out.println("No items found for this supplier.");
        } else {
            System.out.printf("+---------------+---------------+-----------------+---------------+---------------+%n");
        }

        System.out.print("Do you want to search again? (y/n): ");
        choice = input.next();

    } while (choice.equals("n"));

    stockmanage();
}



public static void viewitems() {
    clearConsole();
    Scanner input = new Scanner(System.in);

    System.out.println("+==========================================================================+");
    System.out.println("|                             VIEW ALL ITEMS                               |");
    System.out.println("+==========================================================================+");

    if (itemCount == 0) {
        System.out.println("No items found in the system.");
        System.out.print("Do you want to go back to the main menu? (y/n): ");
        String choice = input.next();
        if (choice.equals("y")) {
            stockmanage();
            
        }
    }

    System.out.printf("+------------+------------+------------------+----------------+------------+------------+%n");
    System.out.printf("| %-10s | %-10s | %-16s | %-14s | %-10s | %-10s |%n", 
        "ITEM CODE", "SUPPLIER", "CATEGORY", "DESCRIPTION", "UNIT PRICE", "QTY");
    System.out.printf("+------------+------------+------------------+----------------+------------+------------+%n");

    for (int i = 0; i < itemCount; i++) {
        String code = addItem[i][0];
        String supplierId = addItem[i][1];
        String category = addItem[i][2];
        String desc = addItem[i][3];
        String price = addItem[i][4];
        String qty = addItem[i][5];

        System.out.printf("| %-10s | %-10s | %-16s | %-14s | %-10s | %-10s |%n", 
            code, supplierId, category, desc, price, qty);
    }

    System.out.printf("+------------+------------+------------------+----------------+------------+------------+%n");

    System.out.print("\nDo you want to go back to main menu? (y/n): ");
    String back = input.next();
    if (back.equals("y")) {
        stockmanage();
    }
}

public static void rankItemsPerUnitPrice() {
    clearConsole();
    Scanner input = new Scanner(System.in);

    System.out.println("+--------------------------------------------------------------------------+");
    System.out.println("|                       RANK ITEMS PER UNIT PRICE                          |");
    System.out.println("+--------------------------------------------------------------------------+");

    if (itemCount == 0) {
        System.out.println("No items found to rank!");
        System.out.print("Do you want to go back to main menu? (y/n): ");
        String back = input.next();
        if (back.equalsIgnoreCase("y")) {
            stockmanage();
            return;
        }
    }


    String[][] sortedItems = new String[itemCount][6];
    for (int i = 0; i < itemCount; i++) {
        for (int j = 0; j < 6; j++) {
            sortedItems[i][j] = addItem[i][j];
        }
    }


    for (int i = 0; i < itemCount - 1; i++) {
        for (int j = 0; j < itemCount - i - 1; j++) {
            double price1 = Double.parseDouble(sortedItems[j][4]);
            double price2 = Double.parseDouble(sortedItems[j + 1][4]);

            if (price1 < price2) {
                
                String[] temp = sortedItems[j];
                sortedItems[j] = sortedItems[j + 1];
                sortedItems[j + 1] = temp;
            }
        }
    }

    
    System.out.printf("+------------+----------------+------------------+----------------+------------+------------+%n");
    System.out.printf("| %-10s | %-14s | %-16s | %-14s | %-10s | %-10s |%n", 
        "ITEM CODE", "SUPPLIER ID", "CATEGORY", "DESCRIPTION", "UNIT PRICE", "QTY");
    System.out.printf("+------------+----------------+------------------+----------------+------------+------------+%n");

    for (int i = 0; i < itemCount; i++) {
        System.out.printf("| %-10s | %-14s | %-16s | %-14s | %-10s | %-10s |%n",
            sortedItems[i][0], sortedItems[i][1], sortedItems[i][2],
            sortedItems[i][3], sortedItems[i][4], sortedItems[i][5]);
    }

    System.out.printf("+------------+----------------+------------------+----------------+------------+------------+%n");

    System.out.print("\nRanking completed! Do you want to go back to main menu? (y/n): ");
    String choice = input.next();
    if (choice.equalsIgnoreCase("y")) {
        stockmanage();
    }
}









}

