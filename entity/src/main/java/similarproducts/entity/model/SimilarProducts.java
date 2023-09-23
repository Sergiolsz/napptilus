package similarproducts.entity.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimilarProducts {

	List<ProductDetail> productDetail;

	public static SimilarProducts buildSimilarProducts(List<ProductDetail> productDetails) {

		return SimilarProducts.builder().productDetail(productDetails).build();
	}
}
