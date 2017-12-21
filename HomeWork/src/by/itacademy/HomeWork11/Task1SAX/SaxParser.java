package HomeWork11;

import HomeWork11.Entity.People;
import HomeWork11.Entity.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;


public class SaxParser extends DefaultHandler {
    private Root root;
    private boolean NameOfFileFlag;
    private boolean StartFlag;
    private People people;
    private String thisElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StartFlag = true;
        thisElement = qName;
        if (qName.equals("root")) {
            root = new Root();
            NameOfFileFlag = true;
        } else if (qName.equals("people")) {
            NameOfFileFlag = false;
            root.setPeopleList(new ArrayList<>());
        }
        if (qName.equals("element")) {
            people = new People();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        StartFlag = false;
        if (qName.equals("element")) {
            root.getPeopleList().add(people);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (StartFlag) {
            switch (thisElement) {
                case "name":
                    if (NameOfFileFlag) {
                        root.setName(new String(ch, start, length));
                    } else {
                        people.setName(new String(ch, start, length));
                    }
                    break;
                case "age":
                    people.setAge(Integer.parseInt(new String(ch, start, length)));
                    break;
                case "id":
                    people.setId(Integer.parseInt(new String(ch, start, length)));
                    break;
                case "isDegree":
                    people.setDegree(Boolean.parseBoolean(new String(ch, start, length)));
                    break;
                case "surname":
                    people.setSurname(new String(ch, start, length));
                    break;
            }
        }
    }

    Root getRoot() {
        return root;
    }
}
