package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STIconSetType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STIconSetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sticonsettype6112type");
  
  public static final Enum X_3_ARROWS = Enum.forString("3Arrows");
  
  public static final Enum X_3_ARROWS_GRAY = Enum.forString("3ArrowsGray");
  
  public static final Enum X_3_FLAGS = Enum.forString("3Flags");
  
  public static final Enum X_3_TRAFFIC_LIGHTS_1 = Enum.forString("3TrafficLights1");
  
  public static final Enum X_3_TRAFFIC_LIGHTS_2 = Enum.forString("3TrafficLights2");
  
  public static final Enum X_3_SIGNS = Enum.forString("3Signs");
  
  public static final Enum X_3_SYMBOLS = Enum.forString("3Symbols");
  
  public static final Enum X_3_SYMBOLS_2 = Enum.forString("3Symbols2");
  
  public static final Enum X_4_ARROWS = Enum.forString("4Arrows");
  
  public static final Enum X_4_ARROWS_GRAY = Enum.forString("4ArrowsGray");
  
  public static final Enum X_4_RED_TO_BLACK = Enum.forString("4RedToBlack");
  
  public static final Enum X_4_RATING = Enum.forString("4Rating");
  
  public static final Enum X_4_TRAFFIC_LIGHTS = Enum.forString("4TrafficLights");
  
  public static final Enum X_5_ARROWS = Enum.forString("5Arrows");
  
  public static final Enum X_5_ARROWS_GRAY = Enum.forString("5ArrowsGray");
  
  public static final Enum X_5_RATING = Enum.forString("5Rating");
  
  public static final Enum X_5_QUARTERS = Enum.forString("5Quarters");
  
  public static final int INT_X_3_ARROWS = 1;
  
  public static final int INT_X_3_ARROWS_GRAY = 2;
  
  public static final int INT_X_3_FLAGS = 3;
  
  public static final int INT_X_3_TRAFFIC_LIGHTS_1 = 4;
  
  public static final int INT_X_3_TRAFFIC_LIGHTS_2 = 5;
  
  public static final int INT_X_3_SIGNS = 6;
  
  public static final int INT_X_3_SYMBOLS = 7;
  
  public static final int INT_X_3_SYMBOLS_2 = 8;
  
  public static final int INT_X_4_ARROWS = 9;
  
  public static final int INT_X_4_ARROWS_GRAY = 10;
  
  public static final int INT_X_4_RED_TO_BLACK = 11;
  
  public static final int INT_X_4_RATING = 12;
  
  public static final int INT_X_4_TRAFFIC_LIGHTS = 13;
  
  public static final int INT_X_5_ARROWS = 14;
  
  public static final int INT_X_5_ARROWS_GRAY = 15;
  
  public static final int INT_X_5_RATING = 16;
  
  public static final int INT_X_5_QUARTERS = 17;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STIconSetType newValue(Object param1Object) {
      return (STIconSetType)STIconSetType.type.newValue(param1Object);
    }
    
    public static STIconSetType newInstance() {
      return (STIconSetType)POIXMLTypeLoader.newInstance(STIconSetType.type, null);
    }
    
    public static STIconSetType newInstance(XmlOptions param1XmlOptions) {
      return (STIconSetType)POIXMLTypeLoader.newInstance(STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(String param1String) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1String, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1String, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(File param1File) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1File, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1File, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(URL param1URL) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1URL, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1URL, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1InputStream, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1InputStream, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(Reader param1Reader) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1Reader, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1Reader, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1XMLStreamReader, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1XMLStreamReader, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(Node param1Node) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1Node, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1Node, STIconSetType.type, param1XmlOptions);
    }
    
    public static STIconSetType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1XMLInputStream, STIconSetType.type, null);
    }
    
    public static STIconSetType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STIconSetType)POIXMLTypeLoader.parse(param1XMLInputStream, STIconSetType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STIconSetType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STIconSetType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_X_3_ARROWS = 1;
    
    static final int INT_X_3_ARROWS_GRAY = 2;
    
    static final int INT_X_3_FLAGS = 3;
    
    static final int INT_X_3_TRAFFIC_LIGHTS_1 = 4;
    
    static final int INT_X_3_TRAFFIC_LIGHTS_2 = 5;
    
    static final int INT_X_3_SIGNS = 6;
    
    static final int INT_X_3_SYMBOLS = 7;
    
    static final int INT_X_3_SYMBOLS_2 = 8;
    
    static final int INT_X_4_ARROWS = 9;
    
    static final int INT_X_4_ARROWS_GRAY = 10;
    
    static final int INT_X_4_RED_TO_BLACK = 11;
    
    static final int INT_X_4_RATING = 12;
    
    static final int INT_X_4_TRAFFIC_LIGHTS = 13;
    
    static final int INT_X_5_ARROWS = 14;
    
    static final int INT_X_5_ARROWS_GRAY = 15;
    
    static final int INT_X_5_RATING = 16;
    
    static final int INT_X_5_QUARTERS = 17;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("3Arrows", 1), new Enum("3ArrowsGray", 2), new Enum("3Flags", 3), new Enum("3TrafficLights1", 4), new Enum("3TrafficLights2", 5), new Enum("3Signs", 6), new Enum("3Symbols", 7), new Enum("3Symbols2", 8), new Enum("4Arrows", 9), new Enum("4ArrowsGray", 10), 
          new Enum("4RedToBlack", 11), new Enum("4Rating", 12), new Enum("4TrafficLights", 13), new Enum("5Arrows", 14), new Enum("5ArrowsGray", 15), new Enum("5Rating", 16), new Enum("5Quarters", 17) });
    
    private static final long serialVersionUID = 1L;
    
    public static Enum forString(String param1String) {
      return (Enum)table.forString(param1String);
    }
    
    public static Enum forInt(int param1Int) {
      return (Enum)table.forInt(param1Int);
    }
    
    private Enum(String param1String, int param1Int) {
      super(param1String, param1Int);
    }
    
    private Object readResolve() {
      return forInt(intValue());
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STIconSetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */