package cart;

public class Apple extends Item {

    private String type;
    
    public Apple(){
        super("apple", "Apple");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
