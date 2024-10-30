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

public interface STCfType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCfType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcftype8016type");
  
  public static final Enum EXPRESSION = Enum.forString("expression");
  
  public static final Enum CELL_IS = Enum.forString("cellIs");
  
  public static final Enum COLOR_SCALE = Enum.forString("colorScale");
  
  public static final Enum DATA_BAR = Enum.forString("dataBar");
  
  public static final Enum ICON_SET = Enum.forString("iconSet");
  
  public static final Enum TOP_10 = Enum.forString("top10");
  
  public static final Enum UNIQUE_VALUES = Enum.forString("uniqueValues");
  
  public static final Enum DUPLICATE_VALUES = Enum.forString("duplicateValues");
  
  public static final Enum CONTAINS_TEXT = Enum.forString("containsText");
  
  public static final Enum NOT_CONTAINS_TEXT = Enum.forString("notContainsText");
  
  public static final Enum BEGINS_WITH = Enum.forString("beginsWith");
  
  public static final Enum ENDS_WITH = Enum.forString("endsWith");
  
  public static final Enum CONTAINS_BLANKS = Enum.forString("containsBlanks");
  
  public static final Enum NOT_CONTAINS_BLANKS = Enum.forString("notContainsBlanks");
  
  public static final Enum CONTAINS_ERRORS = Enum.forString("containsErrors");
  
  public static final Enum NOT_CONTAINS_ERRORS = Enum.forString("notContainsErrors");
  
  public static final Enum TIME_PERIOD = Enum.forString("timePeriod");
  
  public static final Enum ABOVE_AVERAGE = Enum.forString("aboveAverage");
  
  public static final int INT_EXPRESSION = 1;
  
  public static final int INT_CELL_IS = 2;
  
  public static final int INT_COLOR_SCALE = 3;
  
  public static final int INT_DATA_BAR = 4;
  
  public static final int INT_ICON_SET = 5;
  
  public static final int INT_TOP_10 = 6;
  
  public static final int INT_UNIQUE_VALUES = 7;
  
  public static final int INT_DUPLICATE_VALUES = 8;
  
  public static final int INT_CONTAINS_TEXT = 9;
  
  public static final int INT_NOT_CONTAINS_TEXT = 10;
  
  public static final int INT_BEGINS_WITH = 11;
  
  public static final int INT_ENDS_WITH = 12;
  
  public static final int INT_CONTAINS_BLANKS = 13;
  
  public static final int INT_NOT_CONTAINS_BLANKS = 14;
  
  public static final int INT_CONTAINS_ERRORS = 15;
  
  public static final int INT_NOT_CONTAINS_ERRORS = 16;
  
  public static final int INT_TIME_PERIOD = 17;
  
  public static final int INT_ABOVE_AVERAGE = 18;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCfType newValue(Object param1Object) {
      return (STCfType)STCfType.type.newValue(param1Object);
    }
    
    public static STCfType newInstance() {
      return (STCfType)POIXMLTypeLoader.newInstance(STCfType.type, null);
    }
    
    public static STCfType newInstance(XmlOptions param1XmlOptions) {
      return (STCfType)POIXMLTypeLoader.newInstance(STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(String param1String) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1String, STCfType.type, null);
    }
    
    public static STCfType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1String, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(File param1File) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1File, STCfType.type, null);
    }
    
    public static STCfType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1File, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(URL param1URL) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1URL, STCfType.type, null);
    }
    
    public static STCfType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1URL, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1InputStream, STCfType.type, null);
    }
    
    public static STCfType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1InputStream, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(Reader param1Reader) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1Reader, STCfType.type, null);
    }
    
    public static STCfType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfType)POIXMLTypeLoader.parse(param1Reader, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCfType.type, null);
    }
    
    public static STCfType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(Node param1Node) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1Node, STCfType.type, null);
    }
    
    public static STCfType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfType)POIXMLTypeLoader.parse(param1Node, STCfType.type, param1XmlOptions);
    }
    
    public static STCfType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCfType)POIXMLTypeLoader.parse(param1XMLInputStream, STCfType.type, null);
    }
    
    public static STCfType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCfType)POIXMLTypeLoader.parse(param1XMLInputStream, STCfType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCfType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCfType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_EXPRESSION = 1;
    
    static final int INT_CELL_IS = 2;
    
    static final int INT_COLOR_SCALE = 3;
    
    static final int INT_DATA_BAR = 4;
    
    static final int INT_ICON_SET = 5;
    
    static final int INT_TOP_10 = 6;
    
    static final int INT_UNIQUE_VALUES = 7;
    
    static final int INT_DUPLICATE_VALUES = 8;
    
    static final int INT_CONTAINS_TEXT = 9;
    
    static final int INT_NOT_CONTAINS_TEXT = 10;
    
    static final int INT_BEGINS_WITH = 11;
    
    static final int INT_ENDS_WITH = 12;
    
    static final int INT_CONTAINS_BLANKS = 13;
    
    static final int INT_NOT_CONTAINS_BLANKS = 14;
    
    static final int INT_CONTAINS_ERRORS = 15;
    
    static final int INT_NOT_CONTAINS_ERRORS = 16;
    
    static final int INT_TIME_PERIOD = 17;
    
    static final int INT_ABOVE_AVERAGE = 18;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("expression", 1), new Enum("cellIs", 2), new Enum("colorScale", 3), new Enum("dataBar", 4), new Enum("iconSet", 5), new Enum("top10", 6), new Enum("uniqueValues", 7), new Enum("duplicateValues", 8), new Enum("containsText", 9), new Enum("notContainsText", 10), 
          new Enum("beginsWith", 11), new Enum("endsWith", 12), new Enum("containsBlanks", 13), new Enum("notContainsBlanks", 14), new Enum("containsErrors", 15), new Enum("notContainsErrors", 16), new Enum("timePeriod", 17), new Enum("aboveAverage", 18) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCfType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */