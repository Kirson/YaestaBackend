package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.integration.datil.json.bean.GuiaRemisionRespuesta;

public class GuideRemisionContainer implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private GuiaRemisionRespuesta guiaRemisionRespuesta;
	private List<GuideDetail> detailList;
	
	public GuideRemisionContainer(){
		detailList = new ArrayList<GuideDetail>();
	}

	public GuiaRemisionRespuesta getGuiaRemisionRespuesta() {
		return guiaRemisionRespuesta;
	}

	public void setGuiaRemisionRespuesta(GuiaRemisionRespuesta guiaRemisionRespuesta) {
		this.guiaRemisionRespuesta = guiaRemisionRespuesta;
	}

	public List<GuideDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<GuideDetail> detailList) {
		this.detailList = detailList;
	}
	
	
}
