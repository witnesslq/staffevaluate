package com.app.entity;

import java.util.Date;

/**
 * ��¼���۵ı�
 * 
 * @author wyt
 *
 */
public class UserEvaluate {
	private Integer id;
	private Integer evaluate_id; // ��������id
	//private Integer staff_id;// ������Ա��id
	private String evaluateUserPhone;// �����˵绰
	private Date date;// ��������
	private char isReturn;// �Ƿ�ط�
	private char isValid;// �����Ƿ���Ч
	private String satisfaction;// ���������
	private String subindex_ids;
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
		return "UserEvaluate [id=" + id + ", evaluate_id=" + evaluate_id + ", staff_id=" 
				+ ", evaluateUserPhone=" + evaluateUserPhone + ", date=" + date + ", isReturn=" + isReturn
				+ ", isValid=" + isValid + ", satisfaction=" + satisfaction + "]";
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
