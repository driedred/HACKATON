package kz.ada.app2;

public class OilPriceResponse {
    private String date;  // Дата
    private double price; // Цена

    // Геттеры и сеттеры
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

