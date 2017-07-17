package nl.quintor.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@SuppressWarnings("unused | WeakerAccess")
@XmlRootElement
@Entity
@Table(name = "albums")
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
})
public class Album extends Model{

    @NotNull(message = "Album name is required")
    @Size(max = 192, message = "Album names can only be 192 characters long.")
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of appearance is required")
    private Date appearance;

    private Integer highestRanked;
    private Integer highestRankedDurationWeeks;

    @ManyToOne(targetEntity = Artist.class, optional = false, fetch = FetchType.EAGER)
    private Artist artist;

    public Album() {
    }

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public Album(String name, Artist artist, Date appearance) {
        this(name, artist);
        this.appearance = appearance;
    }

    public Album(String name, Artist artist, Date appearance, Integer highestRanked, Integer highestRankedDurationWeeks) {
        this(name, artist, appearance);
        this.highestRanked = highestRanked;
        this.highestRankedDurationWeeks = highestRankedDurationWeeks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAppearance() {
        return appearance;
    }

    public void setAppearance(Date appearance) {
        this.appearance = appearance;
    }

    public Integer getHighestRanked() {
        return highestRanked;
    }

    public void setHighestRanked(Integer highestRanked) {
        this.highestRanked = highestRanked;
    }

    public Integer getHighestRankedDurationWeeks() {
        return highestRankedDurationWeeks;
    }

    public void setHighestRankedDurationWeeks(Integer highestRankedDurationWeeks) {
        this.highestRankedDurationWeeks = highestRankedDurationWeeks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        if (!super.equals(o)) return false;

        Album album = (Album) o;

        if (!getName().equals(album.getName())) return false;
        if (!getAppearance().equals(album.getAppearance())) return false;
        if (getHighestRanked() != null ? !getHighestRanked().equals(album.getHighestRanked()) : album.getHighestRanked() != null)
            return false;
        if (getHighestRankedDurationWeeks() != null ? !getHighestRankedDurationWeeks().equals(album.getHighestRankedDurationWeeks()) : album.getHighestRankedDurationWeeks() != null)
            return false;
        return getArtist() != null ? getArtist().equals(album.getArtist()) : album.getArtist() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAppearance().hashCode();
        result = 31 * result + (getHighestRanked() != null ? getHighestRanked().hashCode() : 0);
        result = 31 * result + (getHighestRankedDurationWeeks() != null ? getHighestRankedDurationWeeks().hashCode() : 0);
        result = 31 * result + (getArtist() != null ? getArtist().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", appearance=" + appearance +
                ", highestRanked=" + highestRanked +
                ", highestRankedDurationWeeks=" + highestRankedDurationWeeks +
                ", artist=" + artist +
                "} " + super.toString();
    }
}
