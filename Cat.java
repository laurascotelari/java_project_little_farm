public class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void talk(){
        System.out.printf("%s says Meow!\n", this.name);
    }

    public void eat(){
        System.out.printf("%s is eating Whiskas now...\n", this.name);
    }

    public void playWithLaser(){
        System.out.printf("%s is running around trying to catch the laser!\n", this.name);
    }
}