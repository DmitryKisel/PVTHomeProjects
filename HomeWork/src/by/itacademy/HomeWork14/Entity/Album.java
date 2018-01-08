package by.itacademy.HomeWork14.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
    Map<String, List<Song>> albumMap;

    public Map<String, List<Song>> getAlbumMap() {
        return albumMap;
    }

    public void setAlbumMap(Map<String, List<Song>> albumMap) {
        this.albumMap = albumMap;
    }

    public Album() {
       albumMap = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Song>> entry : albumMap.entrySet()) {
            for (Song song : entry.getValue()) {
               sb.append(song.toString());
            }
        }
        return sb.toString();
    }
}
