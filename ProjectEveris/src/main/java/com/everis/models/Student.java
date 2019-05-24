package com.everis.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Proyecto: Clase para almacenar funciones útiles y variables necesarias. Esta
 * clase define las variables en el Student Table
 * 
 * @author Llanos_Canahuire_Waldo
 * @version 15/05/2019
 * @since V 1.0
 */
@Entity
@Table(name = "STUDENTS")
@Data
public class Student {

  /**
   * Lista de las variables utilizadas para generar el Student table. Use la
   * anotación ManyToMany para relacionar dos tablas (Student to Parent). Generar
   * la tabla Student_Parent a través de la persistencia JoinTable.
   */
  @Id
  @Column(name = "STUDENT_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long studentId;

  @Column(name = "GENDER", length = 1)
  private String gender;

  @Column(name = "FIRST_NAME", length = 50)
  private String firstName;

  @Column(name = "MIDDLE_NAME", length = 50)
  private String middleName;

  @Column(name = "LAST_NAME", length = 50)
  private String lastName;

  @Column(name = "DATE_OF_BIRTH", length = 50)
  private String dateOfBirth;

  @Column(name = "OTHER_STUDENT_DETAIL", length = 50)
  private String otherStudentDetail;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "STUDENT_PARENTS", joinColumns = @JoinColumn(name = "STUDENT_ID",
      referencedColumnName = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "PARENT_ID", 
      referencedColumnName = "PARENT_ID"))
  private Set<Parent> parents;

}
