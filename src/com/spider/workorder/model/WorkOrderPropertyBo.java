package com.spider.workorder.model;

public class WorkOrderPropertyBo {
	private String id;

//    private String workOrderNo;
	private WorkOrderBo workOrderBo;

    private String propertyId;

    private String propertyName;

    private String propertyType;

    private String propertyDisplay;

    private String propertyValue;

    private String isnull;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WorkOrderBo getWorkOrderBo() {
		return workOrderBo;
	}

	public void setWorkOrderBo(WorkOrderBo workOrderBo) {
		this.workOrderBo = workOrderBo;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyDisplay() {
		return propertyDisplay;
	}

	public void setPropertyDisplay(String propertyDisplay) {
		this.propertyDisplay = propertyDisplay;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getIsnull() {
		return isnull;
	}

	public void setIsnull(String isnull) {
		this.isnull = isnull;
	}
    
}
