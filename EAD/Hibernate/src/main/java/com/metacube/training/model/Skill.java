package com.metacube.training.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Rahul Sharma
 * Pojo for skills in database
 */
@Entity
@Table(name = "Skills")
public class Skill {
	
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "skill_name")
    private String name;
    
	@ManyToMany(mappedBy = "skills")
    private Set<Employee> employees = new HashSet<>();
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
