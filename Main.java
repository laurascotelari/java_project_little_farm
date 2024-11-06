import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static ArrayList<Animal> initializeAnimals(){
        //instantiation of a new object from the Cat class
        Animal olivia = new Cat("Olivia");
        Animal pineapple = new Cat("Pineapple");
        //instantiation of a new object from the Dog class
        Animal pluto = new Dog("Pluto");
        
        Animal[] animals = {olivia, pineapple, pluto};
        
        //creating a dynamic list of animal objects with array list
        ArrayList<Animal> animalList = new ArrayList<>();
        
        //adding every animal to the list
        for(Animal animal : animals){
            animalList.add(animal);
        }
        return animalList;
    }

    //function that exhibits the menu on the screen
    public static void showMenu(String[] options){
        System.out.println("Menu:");
        for(int i = 0; i < options.length; i++){
            System.out.printf("\t(%d) %s\n", i+1, options[i]);
        }
    }

    public static Animal readNewAnimal(String[] animalTypes, Scanner scan){

        System.out.println("Enter an animal type: ");
        for(String animalType : animalTypes){
            System.out.printf("\t%s\n", animalType);
        }

        String type = scan.nextLine();
        type = type.toLowerCase();

        System.out.println("Enter a name: ");
        String name = scan.nextLine();

        Animal newAnimal = null;

        switch (type) {
            case "cat":
                newAnimal = new Cat(name);
                break;

            case "dog":
                newAnimal = new Dog(name);
                break;
        }

        return newAnimal;
    }

    public static boolean menu(int option, String[] options, ArrayList<Animal> animals, String[] animalTypes, Scanner scan){
        System.out.printf("%s\n", options[option - 1]);

        switch(option){
            case 1:                
                for(Animal animal : animals){
                    System.out.printf("\t");
                    animal.talk();
                }
                break; 
            case 2:
                for(Animal animal : animals){
                    System.out.printf("\t");
                    if(animal instanceof Dog){
                        ((Dog) animal).playCatch();
                    }else if (animal instanceof Cat){
                        ((Cat) animal).playWithLaser();
                    }
                }
                break;
            case 3:
                Animal newAnimal = readNewAnimal(animalTypes, scan);

                if(newAnimal != null){
                    animals.add(newAnimal);
                }else{
                    System.out.println("It was not possible to create a new animal.");
                }
                
                break;
            case 6:
                //Exit option - end menu loop
                return true;
                
        }

        //the menu loop should continue
        return false;

    }

    public static void main(String[] args){

        System.out.printf("Welcome to Little Farm!\n");
        
        ArrayList<Animal> animals = initializeAnimals();
        Radio kboing = new Radio("Kboing");

        //creating a dynamic list of Talker objects with array list
        ArrayList<Talker> talkers = new ArrayList<>();
        
        //adding every animal to the list
        for(Animal animal : animals){
            talkers.add(animal);
        }
        //adding the radio
        talkers.add(kboing);

        boolean exit = false;

        String[] options = {"Animal Tour", "Play With Animal", "Add New Animal", "Show Types of Animals", "Donate Animal", "Exit"};
        String[] animalTypes = {"cat", "dog"};

        int option = 0;

        //Menu
        Scanner scan = new Scanner(System.in);
        do{
            showMenu(options);

            //reading the option and converting to integer
            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.printf("Select a number from 1 to %d\n", options.length);
            }

            exit = menu(option, options, animals, animalTypes, scan);
            
            do{
                System.out.println("\n\nPress Enter to continue.");
            }while(!(scan.nextLine()).isEmpty());

        }while(!exit);
        scan.close();
    }
}