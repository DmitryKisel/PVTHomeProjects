package by.itacademy.HomeWork14.Entity;

public class Song {
    String songName;
    Double duration;
    String pathToFile;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Song(String songName, Double duration, String pathToFile) {
        this.songName = songName;
        this.duration = duration;
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (songName != null ? !songName.equals(song.songName) : song.songName != null) return false;
        return duration.equals(song.duration);
    }

    @Override
    public int hashCode() {
        int result = songName != null ? songName.hashCode() : 0;
        result = 31 * result + duration.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
          sb.append("\t").append("\t")
                        .append("song name: ").append(songName)
                        .append(", duration: ").append(duration).append(" seconds")
                        .append(", path: ").append(pathToFile)
                        .append("\n");
    return sb.toString();
    }



}
