public class Produkt {
    int id;
    double price;
    int tage;

    public Produkt(int id, double price, int tage) {
        this.id = id;
        this.price = Math.ceil(price);
        this.tage = tage;
    }
    public Produkt() {
        this.id = 0;
        this.price = 0.0;
        this.tage = 0;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getTage() {
        return tage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = Math.ceil(price);
    }

    public void setTage(int tage) {
        this.tage = tage;
    }
    public void printProd()
    {
        System.out.println(" Product( " + this.getId() + " , " + this.getPrice() + " , " + this.getTage() + ")");
    }
}
