public class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void talk(){
        System.out.printf("%s says Woof Woof!\n", this.name);
    }

    public void playCatch(){
        System.out.printf("Throwing the ball...\n\t...\n\t... \n\t%s caught it!\n", this.name);
    }
}