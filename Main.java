public class Main{

    public static void main(String[] args){
        System.out.printf("Welcome to Little Farm!\n");

        //instantiation of a new object from the Cat class
        Animal olivia = new Cat("Olivia");
        Animal pineapple = new Cat("Pineapple");
        //instantiation of a new object from the Dog class
        Animal pluto = new Dog("Pluto");
        Radio kboing = new Radio("Kboing");

        Talker[] talkers = {olivia, pineapple, pluto, kboing};

        for(int i = 0; i < talkers.length; i++){
            talkers[i].talk();
            
            if(talkers[i] instanceof Dog){
                ((Dog) talkers[i]).playCatch();
            }
        }
    }
}