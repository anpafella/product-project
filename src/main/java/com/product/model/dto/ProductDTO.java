package com.product.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {

	private int id;

	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	@NotBlank(message = "Nombre no debe estar vacío")
	@NotNull(message = "Nombre no debe estar vacío")
	@Size(max = 20, message = "no superar 20 letras")
	private String name;

	@NotBlank(message = "description no debe estar vacío")
	@NotNull(message = "description no debe estar vacío")
	@Size(max = 50, message = "No pasar las 50 letras")
	private String description;
//	
//	@DecimalMin("1.00", message = "monto minimo")
//	@DecimalMax("50.00", message = "monto maximo") 
//	@Digits(integer = 4, fraction = 2, message = "El precio debe tener 4 enteros y 2 decimales")
	private Double precio;

	@NotNull
	private Integer categoryId;
	
	

}
