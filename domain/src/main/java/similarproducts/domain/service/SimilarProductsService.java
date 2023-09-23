package similarproducts.domain.service;

import org.springframework.stereotype.Service;
import similarproducts.domain.interfaces.ProductDetailMethods;
import similarproducts.entity.model.SimilarProducts;
import similarproducts.infrastructure.service.ExistingApisService;

@Service
public class SimilarProductsService implements ProductDetailMethods {

	private final ExistingApisService existingApisService;

	public SimilarProductsService(ExistingApisService existingApisService) {

		this.existingApisService = existingApisService;
	}

	@Override
	public SimilarProducts getSimilaProducts(String productId) {

		var existingIds = existingApisService.getExistingIds(productId);

		var similarProducts = existingIds.stream()
			.map(existingApisService::getExistingProductDetail)
			.toList();

		return SimilarProducts.buildSimilarProducts(similarProducts);
	}
}
