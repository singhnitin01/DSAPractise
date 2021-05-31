package designPatterns;

public class Singelton {

    private final Singelton instance;

    private Singelton(){
        instance = new Singelton();
    }
}
