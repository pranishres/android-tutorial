package com.example.pranishres.myapplication.parsers;

import com.example.pranishres.myapplication.model.Flower;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranishres on 11/9/16.
 */

public class FlowerXMLParser {

    /**
     * Gets the raw xml content feed and returns formatted data in FlowerList
     *
     * @param content - xml content to be parsed
     * @return List of Flower objects which are parsed from xml content
     */
    public static List<Flower> parseFeed(String content) {

        try {
            boolean inDataItemTag = false;
            String currentTagName = "";
            Flower flower = null;
            List<Flower> flowerList = new ArrayList<>();

            /* There are various third party tools to parse xml. But we are going to use the default
            * parser provided for android i.e XmlPullParser*/

            // To use XmlPullParser, we first need to XmlPullParserFactory object
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

            xmlPullParser.setInput(new StringReader(content));

            /* Get the xml event type. An XML file has many events. The events could be
            Document starts , Document ends, Tag start , Tag end and Text e.t.c */
            int eventType = xmlPullParser.getEventType();

            // Loop until the last of the content.
            // Check the event type and do the necessary processing
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTagName = xmlPullParser.getName();
                        // Checking if this is the parent tag of the xml data. All data elements are inside the "product" tag
                        if (currentTagName.equals("product")) {
                            inDataItemTag = true;
                            flower = new Flower();
                            flowerList.add(flower);
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (xmlPullParser.getName().equals("product")) {
                            inDataItemTag = false;
                        }
                        currentTagName = "";
                        break;

                    case XmlPullParser.TEXT:
                        if (inDataItemTag && flower != null) {
                            switch (currentTagName) {
                                case "productId":
                                    flower.setProductId(Integer.parseInt(xmlPullParser.getText()));
                                    break;

                                case "category":
                                    flower.setCategory(xmlPullParser.getText());
                                    break;

                                case "name":
                                    flower.setName(xmlPullParser.getText());
                                    break;

                                case "instructions":
                                    flower.setInstructions(xmlPullParser.getText());
                                    break;

                                case "price":
                                    flower.setPrice(Double.parseDouble(xmlPullParser.getText()));
                                    break;

                                case "photo":
                                    flower.setPhoto(xmlPullParser.getText());
                                    break;

                                default:
                                    break;
                            }  // END OF inner switch case
                        }
                } // END OF nested switch case

                // increment for while loop
                eventType = xmlPullParser.next();
            }

            return flowerList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
