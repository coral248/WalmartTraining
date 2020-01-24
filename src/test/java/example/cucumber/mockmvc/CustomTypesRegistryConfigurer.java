package example.cucumber.mockmvc;

import java.util.Locale;
import java.util.Map;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

public class CustomTypesRegistryConfigurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(ProductInventoryInfo.class, (Map<String, String> row) -> {
			ProductInventoryInfo item = new ProductInventoryInfo();
			item.setId(row.get("product id"));
			item.setInventory(Integer.parseInt(row.get("inventory")));
			item.setMinInventory(Integer.parseInt(row.get("min inventory")));
			return item;
		}));
	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

}
