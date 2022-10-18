import java.util.ArrayList;

public class Main {
    public static ArrayList<Produkt> nachRabatt (ArrayList<Produkt> products)
    {
        ArrayList<Produkt> newProducts = new ArrayList<Produkt>();
        for (Produkt prod : products)
        {
            newProducts.add(prod);
        }
        for (Produkt prod : newProducts)
        {

            if (prod.getTage() >= 10  &&  prod.getTage() < 20)
            {
                prod.setPrice(prod.getPrice() * 0.9 );
            }
            else if (prod.getTage() >= 20)
            {
                prod.setPrice(prod.getPrice() * 0.8 );
            }

        }
        return newProducts;
    }
    public static ArrayList<Produkt> grosserAls100 (ArrayList<Produkt> products)
    {
        ArrayList<Produkt> newProducts = new ArrayList<Produkt>();
        for (Produkt prod : products)
        {
            if (prod.getPrice() > 100)
            {
                newProducts.add(prod);
            }
        }
        return newProducts;
    }
    public static ArrayList<Produkt> sortNachRabatt (ArrayList<Produkt> products)
    {
        ArrayList<Produkt> newProducts = nachRabatt(products);


            for ( int i = 1 ; i< newProducts.size() -1 ; i++   )
                for ( int j = i + 1 ; j< newProducts.size()  ; j++   )
                {
                    if (newProducts.get(i).getPrice() > newProducts.get(j).getPrice())
                    {
                        Produkt newprod = newProducts.get(i);
                        newProducts.get(i).setId(newProducts.get(j).getId())  ;
                        newProducts.get(i).setPrice(newProducts.get(j).getPrice());
                        newProducts.get(i).setTage(newProducts.get(j).getTage());
                        newProducts.get(j).setPrice(newprod.getPrice());  ;
                        newProducts.get(j).setTage(newprod.getTage());  ;


                    }
                }
            return newProducts;


    }
    public static Produkt teuerste(ArrayList<Produkt> products )
    {
        Produkt newProd = new Produkt();
        for (Produkt prod : products)
        {
            if (prod.getPrice() > newProd.getPrice())
            {
                newProd.setPrice(prod.getPrice());
                newProd.setId(prod.getId());
                newProd.setTage(prod.getTage());
            }
        }
        return newProd;
    }
    public static Produkt billigste(ArrayList<Produkt> products )
    {
        Produkt newProd = new Produkt(1000,1000000, 10);
        for (Produkt prod : products)
        {
            if (prod.getPrice() < newProd.getPrice() && newProd.getPrice() != 0.0)
            {
                newProd.setPrice(prod.getPrice());
                newProd.setId(prod.getId());
                newProd.setTage(prod.getTage());
            }
        }
        return newProd;
    }
    public static void main(String[] args) {
      ArrayList<Produkt> prodcts = new ArrayList<Produkt>();
      Produkt prod = new Produkt(1,2.3, 4);
        Produkt prod2 = new Produkt(2,5.6, 9);
        Produkt prod3 = new Produkt(3,100.7, 20);
        Produkt prod4 = new Produkt(4,123.6, 5);
        prodcts.add( prod);

        prodcts.add( prod2);
        prodcts.add( prod3);
        prodcts.add( prod4);
        System.out.println("Billigste ");
        billigste(prodcts).printProd();
        System.out.println("Teuerste ");
        teuerste(prodcts).printProd();
        System.out.println("Sortierte Produkte ");
        for (Produkt produs : sortNachRabatt(prodcts))
        {
            produs.printProd();
        }
        System.out.println("Grosser als 100");
        for (Produkt produs : grosserAls100(prodcts))
        {
            produs.printProd();
        }
        System.out.println("Produkts nach dem Rabatt");
        for (Produkt produs : nachRabatt(prodcts))
        {
            produs.printProd();
        }

    }
}