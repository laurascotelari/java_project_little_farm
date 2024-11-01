public class Radio implements Talker{
    private String name;

    public Radio(String name){
        if(name == null){
            IllegalArgumentException e = new IllegalArgumentException("The name can't be null!\n");
            throw e;
        }
        this.name = name;
    }


    public void talk(){
        System.out.printf("♪♫ %s plays songs ♪♫\n", this.name);
    }
}
