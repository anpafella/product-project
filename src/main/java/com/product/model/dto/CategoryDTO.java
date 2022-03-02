package com.product.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CategoryDTO implements Serializable {

	private int id;

	@NotBlank(message = "description no debe estar vac�o")
	@NotNull(message = "description no debe estar vac�o")
	@Size(max = 50, message = "No pasar las 50 letras")
	private String description;
//	asdasdasdfsdfsdfsd sd f
}
