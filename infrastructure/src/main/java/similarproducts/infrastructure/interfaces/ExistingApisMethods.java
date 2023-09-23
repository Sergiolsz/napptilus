package similarproducts.infrastructure.interfaces;

import java.util.List;
import similarproducts.entity.model.ProductDetail;

public interface ExistingApisMethods {

	ProductDetail getExistingProductDetail(String productId);

	List<String> getExistingIds(String productId);
}
