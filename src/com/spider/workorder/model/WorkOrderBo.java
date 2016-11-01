package com.spider.workorder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkOrderBo implements Serializable {
	private String workOrderNo;

    private String subOrderNo;
    
    private String orderNo;

	private String userId;

    private Integer type;

    private Integer state;

    private Integer retryNumber;

    private String resourcePoolId;

    private String resourceId;

    private String resourceType;

    private String lease;

    private String bizId;
    
    private String bizIdApprove;

	private String action;
    
    private String operationObject;

    private Date created;

    private Date updated;
    
    private Date auditDate;

    private Date finishDate;
    
    private Date startDate;
    
    private Set<WorkOrderPropertyBo> workOrderProperties = new HashSet<WorkOrderPropertyBo>(0);

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getSubOrderNo() {
		return subOrderNo;
	}

	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRetryNumber() {
		return retryNumber;
	}

	public void setRetryNumber(Integer retryNumber) {
		this.retryNumber = retryNumber;
	}

	public String getResourcePoolId() {
		return resourcePoolId;
	}

	public void setResourcePoolId(String resourcePoolId) {
		this.resourcePoolId = resourcePoolId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizIdApprove() {
		return bizIdApprove;
	}

	public void setBizIdApprove(String bizIdApprove) {
		this.bizIdApprove = bizIdApprove;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOperationObject() {
		return operationObject;
	}

	public void setOperationObject(String operationObject) {
		this.operationObject = operationObject;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<WorkOrderPropertyBo> getWorkOrderProperties() {
		return workOrderProperties;
	}

	public void setWorkOrderProperties(Set<WorkOrderPropertyBo> workOrderProperties) {
		this.workOrderProperties = workOrderProperties;
	}

    
}
