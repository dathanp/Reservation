package grazioso;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();

        // Menu options with input validation
        while(true)
          {
              displayMenu();
              int choice = input.nextInt();
              input.nextLine();
              
              if(choice == 1)
                  intakeNewDog(input);
              
              else if(choice == 2)
                   intakeNewMonkey(input);
              
              else if(choice == 3)
                  reserveAnimal(input);
              
              else if(choice == 4)
                  printAnimals("dog");
              
              else if(choice == 5)
                  printAnimals("monkey");
              
              else if(choice == 6)
                  printAnimals("available");
              
              else if(choice == 'q')
                  System.exit(0);
              
              else
                  System.out.println("Enter number 1-6 or q to quit only.");
          }
    }
    // This method displays Menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", 
        "25.6", "05-12-2019", "United States", 
        "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", 
        "35.2", "02-03-2020", "United States",
        "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4",
         "25.6", "12-12-2019", "Canada", 
         "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Jake", "male", "4", 
        "52", "06-02-2019", "Africa", 
        "In Service", false, "USA", 
        "11", "45", "20", "Lemur");

        monkeyList.add(monkey1);
    }

    // added helper method for number validation
    public static boolean isNum(String string) {
        int intVal;
                    
        if(string == null || string.equals("")) {
            System.out.println("Entry cannot be empty.");
            return false;
        }
        
        try {
            intVal = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
        }
        return false;
    }

    // The input validation is to check that the dog is not already in the list
    public static void intakeNewDog(Scanner scanner) {
        
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            } else {
                try{
                    // Questions to be answered for intake of new dog.
                    System.out.println("What is the breed?");
                    String breed = scanner.nextLine();

                    System.out.println("What is the gender? male/female");
                    String gender = scanner.nextLine();

                    System.out.println("What is the age in years?");
                    String age = scanner.nextLine();
                    while(true){
                        if(!isNum(age)){
                            System.out.println("Enter only a number value");
                            age = scanner.nextLine();
                        } else if(isNum(age)) {
                            break;
                        }
                   }
                    System.out.println("What is the weight in pounds?");
                    String weight = scanner.nextLine();
                    while(true){
                        if(!isNum(weight)){
                            System.out.println("Enter only a number value");
                            weight = scanner.nextLine();
                        } else if(isNum(weight)) {
                            break;
                        }
                   }
                    System.out.println("What is the date of acquistion (MM-dd-yyyy)?");
                    String intakeDate = scanner.nextLine();

                    System.out.println("What is the acquistion country of origin?");
                    String originCountry = scanner.nextLine();

                    System.out.println("What is the dog's training status?");
                    String status = scanner.nextLine();

                    System.out.println("Is the dog reserved? (1 true or 0 false)");
                    String reservedString = scanner.nextLine();
                    boolean reserved;
                    if (reservedString.equals("1")){
                        reserved = true;
                    } else {
                        reserved = false;
                    }

                    System.out.println("What is the country in service?");
                    String inServiceCountry = scanner.nextLine();
                    
                    Dog newDog = new Dog(name, breed, gender, age, weight, intakeDate, originCountry, status, reserved, inServiceCountry);
                    dogList.add(newDog);
                    System.out.println("\n\nDog created\n\n");
                    return;
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please try again.");
                        return;
                }
            }
        }   
    }
        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.print("What is the monkey's name?");
        String name= scanner.nextLine();
        
        for(Monkey monkey: monkeyList) 
        {
       
            if(monkey.getName().equalsIgnoreCase(name))
            {
                System.out.println("\n\nThis Monkey is already in our system\n\n");
                return; //returns to menu
            } else {
                try{
                    // Questions to be answered for intake of new monkey.
                    System.out.println("What is the gender?");
                    String gender = scanner.nextLine();

                    System.out.println("What is the age in years?");
                    String age = scanner.nextLine();
                    while(true){
                        if(!isNum(age)){
                            System.out.println("What is the age in years?\n\nEnter only numbers");
                            age = scanner.nextLine();
                        } else{
                            break;
                        }
                    }

                    System.out.println("What is the weight in pounds?");
                    String weight = scanner.nextLine();

                     while(true){
                        if(!isNum(weight)){
                            System.out.println("What is the weight in pounds?\n\nEnter only numbers");
                            weight = scanner.nextLine();
                        } else{
                            break;
                        }
                    }

                    System.out.println("What is the date of acquistion (MM-dd-yyyy)?");
                    String intakeDate = scanner.nextLine();

                    System.out.println("What is the acquistion country of origin?");
                    String originCountry = scanner.nextLine();

                    System.out.println("What is the monkey's training status?");
                    String status = scanner.nextLine();

                    System.out.println("Is the monkey reserved? (1 true or 0 false)");
                    String reservedString = scanner.nextLine();
                    boolean reserved;
                    if (reservedString.equals("1")){
                        reserved = true;
                    } else {
                        reserved = false;
                    } 

                    System.out.println("What is the country in service?");
                    String inServiceCountry = scanner.nextLine();
                    
                    Monkey newMonkey = new Monkey(name, gender, age, weight, 
                    intakeDate, originCountry, status, reserved, inServiceCountry,
                    status, weight, reservedString, inServiceCountry);
                    monkeyList.add(newMonkey);

                    System.out.println("\n\nMonkey created\n\n");
                    return;
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please try again.");
                        return;
                }
            }
        }
    }
        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Dog or Monkey: ");
            String input = scanner.nextLine();
        
        System.out.println("Service country: ");
        String serviceCountry = scanner.nextLine();
        
        if(input.equalsIgnoreCase("dog"))
        {
            int flag = 0;
            
            for(Dog dog: dogList)
            {
                if(dog.getInServiceLocation().equalsIgnoreCase(serviceCountry))
                {
                    if(!dog.getReserved())
                    {
                        dog.setReserved(true);
                        System.out.println("Dog " + dog.getName() + " is now reserved");
                        flag = 1;
                    }
                }
            }
            
            if(flag ==0)
                System.out.println("No Dogs found to reserve");
        }
        else if (input.equalsIgnoreCase("monkey"))
        {
            int flag = 0;
            
            for(Monkey monkey : monkeyList)
            {
                if(monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry))
                {
                    if(! monkey.getReserved())
                    {
                        monkey.setReserved(true);
                        System.out.println("Monkey " + monkey.getName() + " is now reserved");
                        flag = 1;
                    }
                }
            }
            
            if(flag ==0)
                System.out.println("No Monkey found to reserve");
        }
        else
        {
            System.out.println("Wrong animal type");
        }

        }
      // prints the list of animals in the database based on your selection
        public static void printAnimals(String listType) {
            //for list of dogs
            if(listType.equalsIgnoreCase("dog"))
            {
                for(Dog dog: dogList)
                {
                    System.out.println("\nDog: " + dog.getName() + "\nGender: " + dog.getGender() 
                            + "\nAge: " + dog.getAge() + "\nWeight: " + dog.getWeight()
                            + "\nAcquisition Date: " + dog.getAcquisitionDate() 
                            + "\nAcquisition Country: " + dog.getAcquisitionLocation() 
                            + "\nReserved: " + dog.getReserved() + "\nTraining Status: " 
                            + dog.getTrainingStatus() + "\nService country: " + dog.getInServiceLocation());
                }
            }
            // for list of monkeys
            else if(listType.equalsIgnoreCase("monkey"))
            {
                for(Monkey monkey: monkeyList)
                {
                    System.out.println("\nMonkey: " + monkey.getName() + "\nGender: " + monkey.getGender() 
                            + "\nAge: " + monkey.getAge() + "\nWeight: " + monkey.getWeight()
                            + "\nSpecies: " + monkey.getSpecies() + "\nTails Length: " + monkey.getTailLength()
                            + "\nHeight: "+ monkey.getHeight() + "\nBody Length: " + monkey.getBodyLength()
                            + "\nAcquisition Date: " + monkey.getAcquisitionDate() 
                            + "\nAcquisition Country: " + monkey.getAcquisitionLocation() 
                            + "\nReserved: " + monkey.getReserved() + "\nTraining Status: " 
                            + monkey.getTrainingStatus() + "\nService country: " + monkey.getInServiceLocation());
                }
            }
            //for list of animals available
            else if(listType.equalsIgnoreCase("available"))
            {
                for(Dog dog: dogList)
                {
                    if( dog.getTrainingStatus().equalsIgnoreCase("in service") && (! dog.getReserved()))
                    {
                        System.out.println("\nDog: " + dog.getName() + "\nGender: " + dog.getGender() 
                            + "\nAge: " + dog.getAge() + "\nWeight: " + dog.getWeight()
                            + "\nAcquisition Date: " + dog.getAcquisitionDate() 
                            + "\nAcquisition Country: " + dog.getAcquisitionLocation() 
                            + "\nReserved: " + dog.getReserved() + "\nTraining Status: " 
                            + dog.getTrainingStatus() + "\nService country: " + dog.getInServiceLocation());
                    }
                }
                // for list of monkeys in service
                for(Monkey monkey : monkeyList)
                {
                    if(monkey.getTrainingStatus().equalsIgnoreCase("in service") && (! monkey.getReserved()))
                    {
                        System.out.println("\nMonkey: " + monkey.getName() + "\nGender: " + monkey.getGender() 
                        + "\nAge: " + monkey.getAge() + "\nWeight: " + monkey.getWeight()
                        + "\nSpecies: " + monkey.getSpecies() + "\nTails Length: " + monkey.getTailLength()
                        + "\nHeight: "+ monkey.getHeight() + "\nBody Length: " + monkey.getBodyLength()
                        + "\nAcquisition Date: " + monkey.getAcquisitionDate() 
                        + "\nAcquisition Country: " + monkey.getAcquisitionLocation() 
                        + "\nReserved: " + monkey.getReserved() + "\nTraining Status: " 
                        + monkey.getTrainingStatus() + "\nService country: " + monkey.getInServiceLocation());
                    }
                }
            } else
                {
                    System.out.println("Wrong list type");
                }    
    }
}

