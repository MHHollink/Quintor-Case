package nl.quintor.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class Model implements Serializable, Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    public Long getID(){
        return id;
    }

    protected void setID(Long id){
        this.id = id;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;

        Model model = (Model) o;

        return version == model.version && id.equals(model.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", version=" + version +
                '}';
    }
}
