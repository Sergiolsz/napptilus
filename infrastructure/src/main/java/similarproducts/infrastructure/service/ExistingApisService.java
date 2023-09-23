package similarproducts.infrastructure.service;

import java.util.List;
import org.springframework.stereotype.Service;
import similarproducts.entity.model.ProductDetail;
import similarproducts.infrastructure.client.ExistingApiClient;
import similarproducts.infrastructure.interfaces.ExistingApisMethods;

@Service
public class ExistingApisService implements ExistingApisMethods {

	private final ExistingApiClient existingApiClient;

	public ExistingApisService(ExistingApiClient existingApiClient) {

		this.existingApiClient = existingApiClient;
	}

	@Override
	public ProductDetail getExistingProductDetail(String productId) {

		return existingApiClient.getExistingProductDetailClient(productId).orElseThrow();
	}

	@Override
	public List<String> getExistingIds(String productId) {

		return existingApiClient.getExistingProductsIdsClient(productId).orElseThrow();
	}
}
