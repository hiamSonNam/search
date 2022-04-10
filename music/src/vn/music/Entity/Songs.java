package vn.music.Entity;

public class Songs {
	
	private int songId;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongThumbnail() {
		return songThumbnail;
	}

	public void setSongThumbnail(String songThumbnail) {
		this.songThumbnail = songThumbnail;
	}

	public String getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	private String songName;
	private String songThumbnail;
	private String songDuration;
	private int artistId;
	private int cateId;
	private String songPath;
	
	private String artistName;
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	
	private String cateName;
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public Songs() {
		super();
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (songId ^ (songId >>> 32));
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
        Songs other = (Songs) obj;
        if (songId != other.songId)
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "Songs {songId=" + songId + ", "
        		+ "songName=" + songName + ", "
        		+ "songThumbnail=" + songThumbnail
                + ", songDuration=" + songDuration + ", "
                + "artistId=" + artistId + ", "
                + "cateId=" + cateId + ", "
                + "artistName=" + artistName + ", "
                + "songPath=" + songPath + "}";
    }
}
