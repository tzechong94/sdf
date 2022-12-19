package cart; 

public class Item {
    //members
    private String name = "";
    private String code = "";
    private Float price = 1.0f;
    private Integer quantity = 0;
    
    //constructor
    public Item(String code, String name){
        this.code = code;
        this.name = name;
    }

    //Access methods to members 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    //Method

    public Float totalCost() {
        return this.quantity * this.price;
    }

}