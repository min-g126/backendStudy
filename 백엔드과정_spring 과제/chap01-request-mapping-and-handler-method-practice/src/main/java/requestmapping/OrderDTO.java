package requestmapping;

public class OrderDTO {
    private String product;
    private int quantity;
    private String name;
    private String address;
    private String phoneNumber;

    public OrderDTO() {
    }

    public OrderDTO(String product, int quantity, String name, String address, String phoneNumber) {
        this.product = product;
        this.quantity = quantity;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNumber + '\'' +
                '}';
    }
}
