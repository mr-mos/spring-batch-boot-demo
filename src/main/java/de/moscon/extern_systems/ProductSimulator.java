package de.moscon.extern_systems;

import de.moscon.etl.beans.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductSimulator {

	private List<Product> CACHE;

	private static List<String> TOP_20 = Arrays.asList(new String[]{
			"Novak Djokovic",
			"Daniil Medvedev",
			"Rafael Nadal",
			"Stefanos Tsitsipas",
			"Dominic Thiem",
			"Alexander Zverev",
			"Andrey Rublev",
			"Roger Federer",
			"Matteo Berrettini",
			"Roberto Bautista Agut",
			"Diego Schwartzman",
			"Denis Shapovalov",
			"Pablo Carreño Busta",
			"Casper Ruud",
			"David Goffin",
			"Gaël Monfils",
			"Hubert Hurkacz",
			"Alex de Minaur",
			"Félix Auger-Aliassime",
			"Cristian Garín"
	});


	private static List<String> PRODUCTS = Arrays.asList(new String[]{
			"Tennischläger",
			"Schuhe",
			"Tasche",
			"T-Shirt",
			"Schweissband"
	});


	private List<Product> catchProductList() {
		if (CACHE != null) {
			return CACHE;
		}
		ArrayList<Product> products = new ArrayList<>();
		long primaryKey = 1;
		for (int playerIndex = 0; playerIndex < TOP_20.size(); playerIndex++) {
			for (int productIndex = 0; productIndex < PRODUCTS.size(); productIndex++) {
				Product product = new Product();
				product.setId(primaryKey++);
				product.setCategory(PRODUCTS.get(productIndex));
				product.setPlayerBrand(TOP_20.get(playerIndex));
				product.setNetPrice((20 - playerIndex) * (10 - productIndex) * 1.23);
				products.add(product);
			}
		}
		CACHE = products;
		return products;
	}

	public Product readProductPos(int index) {
		List<Product> products = catchProductList();
		if (index >= products.size()) {
			return null;
		}
		return catchProductList().get(index);
	}


}
