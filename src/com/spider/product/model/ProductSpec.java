package com.spider.product.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.spider.workorder.model.WorkOrderPropertyBo;

public class ProductSpec {
    private String specId;

    private String productId;

    private String specName;

    private String specDescription;

    private String status;

    private Date createDate;
    
    private Date releaseDate;
    
    private Date downDate;
    
    private Date quitDate;
    
    private Date updateDate;
	
    private String tag;
    
    private Set<ProductSpecValue> productSpecValues = new HashSet<ProductSpecValue>(0);
    
    
    
	public ProductSpec() {
		super();
	}

	public ProductSpec(String specId, String productId, String specName,
			String specDescription, String status, Date createDate,
			Date releaseDate, Date downDate, Date quitDate, Date updateDate,
			String tag, Set<ProductSpecValue> productSpecValues) {
		super();
		this.specId = specId;
		this.productId = productId;
		this.specName = specName;
		this.specDescription = specDescription;
		this.status = status;
		this.createDate = createDate;
		this.releaseDate = releaseDate;
		this.downDate = downDate;
		this.quitDate = quitDate;
		this.updateDate = updateDate;
		this.tag = tag;
		this.productSpecValues = productSpecValues;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecDescription() {
		return specDescription;
	}

	public void setSpecDescription(String specDescription) {
		this.specDescription = specDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getDownDate() {
		return downDate;
	}

	public void setDownDate(Date downDate) {
		this.downDate = downDate;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<ProductSpecValue> getProductSpecValues() {
		return productSpecValues;
	}

	public void setProductSpecValues(Set<ProductSpecValue> productSpecValues) {
		this.productSpecValues = productSpecValues;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    
}
