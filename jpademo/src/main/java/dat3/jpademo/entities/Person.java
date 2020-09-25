package dat3.jpademo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author josef
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    private String name;
    private int year;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address adr;

    @OneToMany(mappedBy ="person", cascade = CascadeType.PERSIST)
    List<Fee> fees;

    @ManyToMany(mappedBy ="persons", cascade = CascadeType.PERSIST)
    List<SwimStyle> styles;
    
    public Person() {
    }

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
        this.fees = new ArrayList<>();
        this.styles = new ArrayList<>();
    }

    public Address getAdr() {
        return adr;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void AddFees(Fee fee) {
        this.fees.add(fee);
        if(fee != null){
            fee.setPerson(this);
        }
    }
    
    public void AddSwimStyle(SwimStyle style) {
        this.styles.add(style);
        if(style != null){
            this.styles.add(style);
            style.getPersons().add(this);
        }
    }
    
    
    public void removeSwimStyle(SwimStyle swimStyle){
        if(swimStyle != null){
            styles.remove(swimStyle);
            swimStyle.getPersons().remove(this);
        }
    }
    
    // (this)
    public void setAdr(Address adr) {
        this.adr = adr;
        if(adr != null){
            adr.setPerson(this);
        }
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
