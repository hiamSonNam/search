package vn.music.Entity;

public class Artists {
	private int artistId;
	private String artistName;
	private String artistDoB;
	private String artistAvatar;
	private String artistCountry;
	public Artists() {
		super();
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistDoB() {
		return artistDoB;
	}
	public void setArtistDoB(String artistDoB) {
		this.artistDoB = artistDoB;
	}
	public String getArtistAvatar() {
		return artistAvatar;
	}
	public void setArtistAvatar(String artistAvatar) {
		this.artistAvatar = artistAvatar;
	}
	public String getArtistCountry() {
		return artistCountry;
	}
	public void setArtistCountry(String artistCountry) {
		this.artistCountry = artistCountry;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (artistId ^ (artistId >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artists other = (Artists) obj;
        if (artistId != other.artistId)
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "Artists {artistId=" + artistId + ", "
        		+ "artistName=" + artistName + ", "
        		+ "artistAvatar=" + artistAvatar
                + ", artistDoB=" + artistDoB + ", "
                + "artistCountry=" + artistCountry + "}";
    }
}
