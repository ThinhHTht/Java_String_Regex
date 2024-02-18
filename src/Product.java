import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    // Khai báo thuộc tính
   private String productId;
   private String productName;
   private float importPrice;
   private float exportPrice;
   private float profit;
   private int quantity;
   private String descriptions;
   private boolean status;

   // Khoi tao constructor
    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    // Method

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(){

    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct){
        this.productId = inputProductId(scanner, arrProduct, indexProduct);
        this.productName = inputProductName(scanner, arrProduct, indexProduct);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.status = inputStatus(scanner);

    }
    public String inputProductId(Scanner scanner, Product[] arrProduct, int indexProduct ){
        do {
            System.out.println("Hãy nhập ID sản phẩm:");
            String idInput = scanner.nextLine();
            if(Pattern.matches("P...", idInput)){
                boolean isExist = true;
                for (int i = 0; i < indexProduct; i++) {
                    if(arrProduct[i].getProductId().equals(idInput)){
                        System.err.println("ID đã tồn tại, vui lòng nhập lại!");
                        isExist = false;
                        break;
                    }
                }
                if(isExist){
                    return idInput;
                }
            } else {
                System.err.println("ID phải bắt đầu bằng chữ P và có 4 ký tự");
            }

        }while(true);

    }
    public String inputProductName(Scanner scanner, Product[] arrProduct, int indexProduct){
        System.out.println("Hãy nhập tên sản phẩm");
        do {
            String inputName = scanner.nextLine();
            if(inputName.length() >= 6 && inputName.length() <=50){
                boolean isExist = true;
                for (int i = 0; i < indexProduct; i++) {
                    if(arrProduct[i].getProductName().equals(inputName)){
                        isExist = false;
                        System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại!");
                        break;
                    }

                }
                if(isExist){
                    return inputName;
                }
            } else{
                System.err.println("Tên sản phẩm phải chứa từ 6-50 ký tự, vui lòng nhập lại!");
            }
        }while(true);
    }
    public float inputImportPrice(Scanner scanner){
        System.out.println("Hãy nhập giá nhập sản phẩm:");
        do {
            float inputImportPrice = Float.parseFloat(scanner.nextLine());
            if(inputImportPrice > 0){
                return inputImportPrice;
            } else {
                System.err.println("Giá nhập phải > 0, vui lòng nhập lại!");
            }
        }while(true);
    }
    public float inputExportPrice(Scanner scanner){
        System.out.println("Hãy nhập giá bán sản phẩm:");
        do {
            float inputExportPrice = Float.parseFloat(scanner.nextLine());
            if(inputExportPrice >= 1.2*this.importPrice){
                return inputExportPrice;
            } else {
                System.err.println("Giá bán phải lớn hơn ít nhất 20% so với giá nhập.");
            }
        }while(true);
    }
    public int inputQuantity(Scanner scanner){
        System.out.println("Hãy nhập số lượng sản phẩm:");
        do {
            int inputQuantity = Integer.parseInt(scanner.nextLine());
            if(inputQuantity > 0){
                return inputQuantity;
            } else {
                System.err.println("Số lượng sản phẩm phải lớn hơn 0");
            }

        }while(true);
    }
    public String inputDescriptions(Scanner scanner){
        System.out.println("Hãy nhập mô tả cho sản phẩm:");
        String inputDescriptions = scanner.nextLine();
        return inputDescriptions;
    }
    public boolean inputStatus(Scanner scanner){
        System.out.println("Hãy nhập trạng thái của sản phẩm:");
        do {
            String inputStatus = scanner.nextLine();
            if(Pattern.matches("(true|false)", inputStatus)){
                return Boolean.parseBoolean(inputStatus);
            } else {
                System.err.println("Chỉ được nhập true hoặc false");
            }
        }while(true);
    }

    public void displayData(){
        System.out.printf("ID: %s; Product name: %s; Giá nhập: %.2f; Giá xuất: %.2f; Lợi nhuận: %.2f\n", this.productId, this.productName, this.importPrice, this.exportPrice, calProfit());
        System.out.printf("Số lượng: %d; Mô tả: %s; Trạng thái: %s\n", this.quantity, this.descriptions, this.status? "Đang bán": "Không bán");
    }

    public float calProfit(){
        this.profit = this.exportPrice - this.importPrice;
        return profit;
    }
}
