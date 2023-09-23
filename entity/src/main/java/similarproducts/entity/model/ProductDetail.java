package similarproducts.entity.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductDetail {

	String id;
	String name;
	double price;
	boolean availability;

}
