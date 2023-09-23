package similarproducts.infrastructure.client;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import similarproducts.entity.model.ProductDetail;

@FeignClient(name = "${existing-apis.name}", url = "${existing-apis.url.base}")
public interface ExistingApiClient {

	@GetMapping("${existing-apis.url.product}")
	Optional<ProductDetail> getExistingProductDetailClient(@PathVariable() String productId);

	@GetMapping("${existing-apis.url.similarIds}")
	Optional<List<String>> getExistingProductsIdsClient(@PathVariable() String productId);
}
