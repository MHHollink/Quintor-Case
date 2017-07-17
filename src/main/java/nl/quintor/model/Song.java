package nl.quintor.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@SuppressWarnings("unused | WeakerAccess")
@Table(name = "songs")
@NamedQueries({
        @NamedQuery( name = "Song.findAll", query = "SELECT s FROM Song s")
})
public class Song extends Model {


    @Basic(optional = false)
    private String name;

    public Song() {
    }

    public Song(String name, Album album) {
        this.name = name;
        this.album = album;
    }

    @ManyToOne(targetEntity = Album.class, optional = false)
    private Album album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        if (!super.equals(o)) return false;

        Song song = (Song) o;

        if (!getName().equals(song.getName())) return false;
        return getAlbum() != null ? getAlbum().equals(song.getAlbum()) : song.getAlbum() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getAlbum() != null ? getAlbum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", album=" + album +
                "} " + super.toString();
    }
}
