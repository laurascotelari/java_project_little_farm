public class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void talk(){
        System.out.printf("%s says Meow!\n", this.name);
    }
}