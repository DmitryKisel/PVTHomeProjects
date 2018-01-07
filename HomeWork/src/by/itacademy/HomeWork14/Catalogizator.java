package by.itacademy.HomeWork14;

import by.itacademy.HomeWork14.Entity.Mp3File;


import by.itacademy.HomeWork14.Entity.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogizator {
    void mp3DataConverter(List<Mp3File> mp3FileList){

        Map<String, Map<String, List<Song>>> artistMap = new HashMap<>();

        for (Mp3File file: mp3FileList){


             if(artistMap.containsKey(file.getArtistName())){
               if(artistMap.get(file.getArtistName()).containsKey(file.getAlbumInFile())){
                   for(Song song: artistMap.get(file.getArtistName()).get(file.getAlbumInFile())){
                       if(song.getSongName().equals(file.getSongInFile())){
                           System.out.println("Песня с такими данными уже есть в каталоге");
                           System.out.println("Исполнитель : " + file.getArtistName() + " Альбом: "
                                   + file.getAlbumInFile() + " Композиция: " + file.getSongInFile());
                           System.out.println("Файл внесенный в каталог: " + song.getPathToFile());
                           System.out.println("Дубликат: " + file.getPathToFile());
                           System.out.println();

                       }
                       else{
                           Map<String, List<Song>> albumMap = artistMap.get(file.getArtistName());
                           List<Song> songList = albumMap.get(file.getAlbumInFile());
                           Song newSong = new Song(file.getSongInFile(), file.getFileDuration(), file.getPathToFile());
                           songList.add(newSong);

                           artistMap.put(file.getArtistName(), albumMap);
                       }
                   }
               }
               else {
                   Song newSong = new Song(file.getSongInFile(), file.getFileDuration(), file.getPathToFile());
                   List<Song> songList = new ArrayList<>();
                   songList.add(newSong);
                   Map<String, List<Song>> albumMap = new HashMap<>();
                   albumMap.put(file.getAlbumInFile(), songList);
                   artistMap.put(file.getArtistName(), albumMap);
               }
           }
           else {
                 Song newSong = new Song(file.getSongInFile(), file.getFileDuration(), file.getPathToFile());
                 List<Song> songList = new ArrayList<>();
                 songList.add(newSong);
                 Map<String, List<Song>> albumMap = new HashMap<>();
                 albumMap.put(file.getAlbumInFile(), songList);
                 artistMap.put(file.getArtistName(), albumMap);
           }
        }
        for (Map.Entry<String, Map<String, List<Song>>> set: artistMap.entrySet()){
            System.out.println(set.getKey());
            for (Map.Entry<String, List<Song>> pair: set.getValue().entrySet()){
                System.out.println(pair.getKey());
                for (Song song : pair.getValue()){
                    System.out.println(song.getSongName() + " - " + song.getDuration() + " (" +
                            song.getPathToFile() + ")");
                    System.out.println();
                }
            }
        }
    }
}
