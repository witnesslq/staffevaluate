package com.app.entity;

import java.util.Date;

/**
 * 用户评价实体类
 * 
 * @author 吴雨桐
 *
 */
public class UserEvaluate {
	private Integer id;// 主键
	private Integer evaluate_id; // 评价类型的id
	private String evaluateUserPhone;// 被评价用户的联系电话
	private Date date;// 评价时间
	private char isReturn;// 评价是否回访
	private char isValid;// 评价是否有效
	private String satisfaction;// 满意度
	private String subindex_ids;// 分项指标的id组合
	private Staff staff;

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getSubindex_ids() {
		return subindex_ids;
	}

	public void setSubindex_ids(String subindex_ids) {
		this.subindex_ids = subindex_ids;
	}

	@Override
	public String toString() {
		return "UserEvaluate [id=" + id + ", evaluate_id=" + evaluate_id + ", staff_id=" + ", evaluateUserPhone="
				+ evaluateUserPhone + ", date=" + date + ", isReturn=" + isReturn + ", isValid=" + isValid
				+ ", satisfaction=" + satisfaction + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEvaluate_id() {
		return evaluate_id;
	}

	public void setEvaluate_id(Integer evaluate_id) {
		this.evaluate_id = evaluate_id;
	}

	public String getEvaluateUserPhone() {
		return evaluateUserPhone;
	}

	public void setEvaluateUserPhone(String evaluateUserPhone) {
		this.evaluateUserPhone = evaluateUserPhone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(char isReturn) {
		this.isReturn = isReturn;
	}

	public char getIsValid() {
		return isValid;
	}

	public void setIsValid(char isValid) {
		this.isValid = isValid;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

}
