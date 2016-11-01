package com.spider.resource.model;

public class AdapterTask {
    private String id;

    private String resourceObjectId;

    private String taskName;

    private String workOrderId;
    
    private String workOrderContent;

    private String flowId;

    private String flowTaskId;

    private String platformId;

    private String info;

    private StateEnum status;

    private String beanName;

    private String poolId;
    
    private String commandProtocol;

    private String commandInfo;
    
    private String result;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceObjectId() {
		return resourceObjectId;
	}

	public void setResourceObjectId(String resourceObjectId) {
		this.resourceObjectId = resourceObjectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getWorkOrderContent() {
		return workOrderContent;
	}

	public void setWorkOrderContent(String workOrderContent) {
		this.workOrderContent = workOrderContent;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowTaskId() {
		return flowTaskId;
	}

	public void setFlowTaskId(String flowTaskId) {
		this.flowTaskId = flowTaskId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public StateEnum getStatus() {
		return status;
	}

	public void setStatus(StateEnum status) {
		this.status = status;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getPoolId() {
		return poolId;
	}

	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	public String getCommandProtocol() {
		return commandProtocol;
	}

	public void setCommandProtocol(String commandProtocol) {
		this.commandProtocol = commandProtocol;
	}

	public String getCommandInfo() {
		return commandInfo;
	}

	public void setCommandInfo(String commandInfo) {
		this.commandInfo = commandInfo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
}
