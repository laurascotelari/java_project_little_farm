public abstract class Animal implements Talker{
    protected String name; //the attributes must be protected so the subclasses can access them

    public Animal(String name){
        super();
        this.name = name;
    }

    public Animal(){
        this("Unknown animal");
    }

    public String getName(){
        return this.name;
    }

    public void talk(){
        System.out.printf("%s says ...\n", this.name);
    }
}