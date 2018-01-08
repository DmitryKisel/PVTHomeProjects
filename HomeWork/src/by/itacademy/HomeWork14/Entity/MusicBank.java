package by.itacademy.HomeWork14.Entity;

import java.util.HashMap;
import java.util.Map;

public class MusicBank {
    private Map<String, Artist> musicBankMap;

    public Map<String, Artist> getMusicBankMap() {
        return musicBankMap;
    }

    public void setMusicBankMap(Map<String, Artist> musicBankMap) {
        this.musicBankMap = musicBankMap;
    }

    public MusicBank() {
        musicBankMap = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Artist> entry : musicBankMap.entrySet()){
            sb.append(entry.getKey()).append("\n");
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
