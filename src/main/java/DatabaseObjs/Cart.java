package DatabaseObjs;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Prodotto> listaProdotti;
    private int totaleCarrello;
    
    
    public Cart (){
        listaProdotti = new ArrayList<Prodotto>();
    }
    
    public void addprodotto(Prodotto prodotto){
        listaProdotti.add(prodotto);
    }
    
    public void removeprodotto(Prodotto prodotto){
        for(Prodotto prodotto1 : listaProdotti){
            if(prodotto1.equals(prodotto)){
                listaProdotti.remove(prodotto1);
            }
        }
    }
    
    public double getTotalPrize(){
        double total = 0;
        for(Prodotto prodotto: listaProdotti){
            total += prodotto.getPrezzo();
        }
        return total;
    }
    
}
