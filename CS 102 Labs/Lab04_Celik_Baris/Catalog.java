import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Catalog {
	private ArrayList<Product> prodList;
	
	public Catalog(){
		prodList = new ArrayList<Product>();
		prodList.add(new Product(12345, "BEKO BREAD MAKER\n White in color\n700 gram capacity\n 600 watts power"+
												"\n12 programs with 3 different settings",
												"BEKO EKMEK YAPMA MAKINESI \nBeyaz renk"+
												"\n700 gr kapasiteli tek hazne"+
												"\n600 W güç"+
												"\n12 farkli program ve \n3 farkli piþirme seçimi",120.0));
		prodList.add(new Product(12346, "BRAUN BLOOD PRESSURE MONITOR\nExtra comfortable\nHigh-Low pressure warning\nAs accurate as clinic tests"+
												"\nSMALL/MEDIUM 23 - 33 cm",
												"BRAUN ÜST KOL MANSETLi \nTANSIYON ALETi\nEkstra konforlu hassas manþet "+
												"\nKüçük- Büyük tansiyon ölçümü "+
												"\nKlinik olarak test edilmis dogruluk"+
												"\nKüçük/Orta 23 - 33 cm", 125.0));
		prodList.add(new Product(76345, "PHILIPS HAIR STRAIGHTENER\nAutomatic shutoff after 1 hour\nHeats up quickly\nMatte Chrome Plates"+
												"\nDual Voltage",
												"PHILIPS SAÇ DÜZLESTiRiCi\n1 saat sonrasinda otomatik \nkapanma "+
												"\nKisa sürede isinma"+
												"\nMat krom yüzey"+
												"\nDünya çapinda kullanim için çift voltaj", 101.48));
	
	}
	public Product getProductByPosition(int position){
		return prodList.get(position);
	}
	public int getCatalogSize(){
		return prodList.size();
	}
}

