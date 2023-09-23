package similarproducts.entity.exception;

import static similarproducts.entity.exception.CodesException.ERROR_NOT_FOUND;
import static similarproducts.entity.exception.CodesException.MESSAGE_PRODUCT_NOT_FOUND;
import static similarproducts.entity.exception.CodesException.VALUE_ERROR;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import similarproducts.entity.dto.ErrorResponse;

@RestControllerAdvice
public class HandlerProductsExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorResponse> handleFeignException(FeignException feignException) {

		return ResponseEntity.status(feignException.status())
			.body(new ErrorResponse(ERROR_NOT_FOUND, MESSAGE_PRODUCT_NOT_FOUND, VALUE_ERROR));
	}
}
