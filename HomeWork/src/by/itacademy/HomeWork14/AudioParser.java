package by.itacademy.HomeWork14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import by.itacademy.HomeWork14.Entity.Mp3File;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;

public class AudioParser {

    List<Mp3File> mp3Parser(File[] list) {
        List <Mp3File> mp3FileList = new ArrayList<>();
        try {
            for (int i = 0; i < list.length; i++) {
                InputStream input = new FileInputStream(new File(list[i].toString()));
                ContentHandler handler = new DefaultHandler();
                Metadata metadata = new Metadata();
                Parser parser = new Mp3Parser();
                ParseContext parseCtx = new ParseContext();
                parser.parse(input, handler, metadata, parseCtx);
                input.close();

                    String artistName;
                    String albumInFile;
                    String songInFile;
                    if (metadata.get("xmpDM:albumArtist") != null) {
                        artistName = metadata.get("xmpDM:albumArtist");
                    } else {
                        artistName = "Non Artist";
                    }

                    if (metadata.get("xmpDM:album") != null) {
                        albumInFile = metadata.get("xmpDM:album");
                    } else {
                        albumInFile = "Non Album";
                    }

                    if (metadata.get("dc:title") != null) {
                        songInFile = metadata.get("dc:title");
                    } else {
                        songInFile = "Non Title";
                    }


                Mp3File mp3File = new Mp3File(list[i].getName(), artistName,albumInFile
                        , songInFile, list[i].toString(),
                        Double.parseDouble(metadata.get("xmpDM:duration")));

                mp3FileList.add(mp3File);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        return mp3FileList;
    }
}

