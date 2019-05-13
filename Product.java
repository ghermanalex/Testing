public class Product {

    private String name;
    private Integer price;
    private Integer quantity;

    public Product()
    {}

    public Product(String name,Integer price,Integer quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String string ="";
        string += name + ","+ price + "," + quantity;
        return string;
    }
}
