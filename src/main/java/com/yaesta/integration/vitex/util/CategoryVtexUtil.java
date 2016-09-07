package com.yaesta.integration.vitex.util;

import java.io.Serializable;

import com.yaesta.integration.vitex.json.bean.CategoryVtex;
import com.yaesta.integration.vitex.wsdl.dto.CategoryDTO;

public class CategoryVtexUtil implements Serializable{

	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8810381095993719517L;

	public static CategoryVtex fromCategoryDTOtoCategoryVext(CategoryDTO cdto){
		CategoryVtex cv = new CategoryVtex();
		cv.setId(cdto.getId().getValue());
		cv.setName(cdto.getName().getValue());
		return cv;
	}
}
