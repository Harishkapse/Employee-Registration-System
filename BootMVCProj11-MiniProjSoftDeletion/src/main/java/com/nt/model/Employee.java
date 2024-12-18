package com.nt.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="emp1")
@Entity
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql="update emp1 set status='inactive' where empno=?")
@Where(clause="status <> 'inactive'")
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="emp_empno_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length=30)
	//@NonNull
	private String ename;
	@Column(length=30)
	//@NonNull
	private String job;
	//@NonNull
	private Double sal;
	//@NonNull
	private Integer deptno;
	private String status="active";
}
