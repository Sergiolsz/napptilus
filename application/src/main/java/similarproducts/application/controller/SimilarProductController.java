package similarproducts.application.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import similarproducts.domain.service.SimilarProductsService;
import similarproducts.entity.model.SimilarProducts;

@Tag(name = "Similar Product", description = "Similar Product Microservice")
@RestController
@RequestMapping("/product")
public class SimilarProductController {

	private final SimilarProductsService similarProductsService;

	public SimilarProductController(SimilarProductsService similarProductsService) {

		this.similarProductsService = similarProductsService;
	}

	@GetMapping("/{productId}/similar")
	@Operation(description = "List of similar products to a given one ordered by similarity")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "400", description = "Product Not found")
	})
	@ResponseBody
	public ResponseEntity<SimilarProducts> getProductSimilar(@PathVariable("productId") String productId) {

		return ResponseEntity.ok(similarProductsService.getSimilaProducts(productId));
	}

}
