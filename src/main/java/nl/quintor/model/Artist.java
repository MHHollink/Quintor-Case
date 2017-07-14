package nl.quintor.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@SuppressWarnings("unused")
@XmlRootElement
@Entity
@Table(name = "artists")
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a")
})
public class Artist extends Model{

    @NotNull(message = "First name is required")
    @Size(min = 3, max = 64, message = "First name must have length between 3 and 64 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 3, max = 64, message = "Last name must have length between 3 and 64 characters")
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date born;

    @Temporal(TemporalType.DATE)
    private Date died;

    private String nationality;
    private Integer yearsActiveStart;
    private Integer yearsActiveEnd;
    private String instrument;

    public Artist(){
        // Empty constructor
    }

    @SuppressWarnings("WeakerAccess")
    public Artist(String firstName, String lastName, Date born, String nationality, int yearsActiveStart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.nationality = nationality;
        this.yearsActiveStart = yearsActiveStart;
    }

    @SuppressWarnings("WeakerAccess")
    public Artist(String firstName, String lastName, Date born, String nationality, int yearsActiveStart, int yearsActiveEnd) {
        this(firstName, lastName, born, nationality, yearsActiveStart);
        this.yearsActiveEnd = yearsActiveEnd;
    }

    public Artist(String firstName, String lastName, Date born, Date died, String nationality, int yearsActiveStart, int yearsActiveEnd) {
        this(firstName, lastName, born, nationality, yearsActiveStart, yearsActiveEnd);
        this.died = died;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Date getDied() {
        return died;
    }

    public void setDied(Date died) {
        this.died = died;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getYearsActiveStart() {
        return yearsActiveStart;
    }

    public void setYearsActiveStart(int yearsActiveStart) {
        this.yearsActiveStart = yearsActiveStart;
    }

    public Integer getYearsActiveEnd() {
        return yearsActiveEnd;
    }

    public void setYearsActiveEnd(int yearsActiveEnd) {
        this.yearsActiveEnd = yearsActiveEnd;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstruments(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        if (!super.equals(o)) return false;

        Artist artist = (Artist) o;

        if (!getFirstName().equals(artist.getFirstName())) return false;
        if (!getLastName().equals(artist.getLastName())) return false;
        if (getBorn() != null ? !getBorn().equals(artist.getBorn()) : artist.getBorn() != null) return false;
        if (getDied() != null ? !getDied().equals(artist.getDied()) : artist.getDied() != null) return false;
        if (getNationality() != null ? !getNationality().equals(artist.getNationality()) : artist.getNationality() != null)
            return false;
        if (getYearsActiveStart() != null ? !getYearsActiveStart().equals(artist.getYearsActiveStart()) : artist.getYearsActiveStart() != null)
            return false;
        if (getYearsActiveEnd() != null ? !getYearsActiveEnd().equals(artist.getYearsActiveEnd()) : artist.getYearsActiveEnd() != null)
            return false;
        return getInstrument() != null ? getInstrument().equals(artist.getInstrument()) : artist.getInstrument() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (getBorn() != null ? getBorn().hashCode() : 0);
        result = 31 * result + (getDied() != null ? getDied().hashCode() : 0);
        result = 31 * result + (getNationality() != null ? getNationality().hashCode() : 0);
        result = 31 * result + (getYearsActiveStart() != null ? getYearsActiveStart().hashCode() : 0);
        result = 31 * result + (getYearsActiveEnd() != null ? getYearsActiveEnd().hashCode() : 0);
        result = 31 * result + (getInstrument() != null ? getInstrument().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", born=" + born +
                ", died=" + died +
                ", nationality='" + nationality + '\'' +
                ", yearsActiveStart=" + yearsActiveStart +
                ", yearsActiveEnd=" + yearsActiveEnd +
                ", instrument='" + instrument + '\'' +
                "} " + super.toString();
    }
}
