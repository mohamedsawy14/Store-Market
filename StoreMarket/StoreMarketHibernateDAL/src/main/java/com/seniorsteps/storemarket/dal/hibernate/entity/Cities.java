package com.seniorsteps.storemarket.dal.hibernate.entity;
// Generated Feb 6, 2023 1:14:50 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Cities generated by hbm2java
 */
@Entity
@Table(name="cities"
    ,catalog="store_market"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Cities  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Zones> zoneses = new HashSet<Zones>(0);

    public Cities() {
    }

	
    public Cities(String name) {
        this.name = name;
    }
    public Cities(String name, Set<Zones> zoneses) {
       this.name = name;
       this.zoneses = zoneses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cities")
    public Set<Zones> getZoneses() {
        return this.zoneses;
    }
    
    public void setZoneses(Set<Zones> zoneses) {
        this.zoneses = zoneses;
    }




}

