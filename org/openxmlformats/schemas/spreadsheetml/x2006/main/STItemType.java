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

public interface STItemType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STItemType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stitemtype6186type");
  
  public static final Enum DATA = Enum.forString("data");
  
  public static final Enum DEFAULT = Enum.forString("default");
  
  public static final Enum SUM = Enum.forString("sum");
  
  public static final Enum COUNT_A = Enum.forString("countA");
  
  public static final Enum AVG = Enum.forString("avg");
  
  public static final Enum MAX = Enum.forString("max");
  
  public static final Enum MIN = Enum.forString("min");
  
  public static final Enum PRODUCT = Enum.forString("product");
  
  public static final Enum COUNT = Enum.forString("count");
  
  public static final Enum STD_DEV = Enum.forString("stdDev");
  
  public static final Enum STD_DEV_P = Enum.forString("stdDevP");
  
  public static final Enum VAR = Enum.forString("var");
  
  public static final Enum VAR_P = Enum.forString("varP");
  
  public static final Enum GRAND = Enum.forString("grand");
  
  public static final Enum BLANK = Enum.forString("blank");
  
  public static final int INT_DATA = 1;
  
  public static final int INT_DEFAULT = 2;
  
  public static final int INT_SUM = 3;
  
  public static final int INT_COUNT_A = 4;
  
  public static final int INT_AVG = 5;
  
  public static final int INT_MAX = 6;
  
  public static final int INT_MIN = 7;
  
  public static final int INT_PRODUCT = 8;
  
  public static final int INT_COUNT = 9;
  
  public static final int INT_STD_DEV = 10;
  
  public static final int INT_STD_DEV_P = 11;
  
  public static final int INT_VAR = 12;
  
  public static final int INT_VAR_P = 13;
  
  public static final int INT_GRAND = 14;
  
  public static final int INT_BLANK = 15;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STItemType newValue(Object param1Object) {
      return (STItemType)STItemType.type.newValue(param1Object);
    }
    
    public static STItemType newInstance() {
      return (STItemType)POIXMLTypeLoader.newInstance(STItemType.type, null);
    }
    
    public static STItemType newInstance(XmlOptions param1XmlOptions) {
      return (STItemType)POIXMLTypeLoader.newInstance(STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(String param1String) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1String, STItemType.type, null);
    }
    
    public static STItemType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1String, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(File param1File) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1File, STItemType.type, null);
    }
    
    public static STItemType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1File, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(URL param1URL) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1URL, STItemType.type, null);
    }
    
    public static STItemType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1URL, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1InputStream, STItemType.type, null);
    }
    
    public static STItemType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1InputStream, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(Reader param1Reader) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1Reader, STItemType.type, null);
    }
    
    public static STItemType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STItemType)POIXMLTypeLoader.parse(param1Reader, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1XMLStreamReader, STItemType.type, null);
    }
    
    public static STItemType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1XMLStreamReader, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(Node param1Node) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1Node, STItemType.type, null);
    }
    
    public static STItemType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STItemType)POIXMLTypeLoader.parse(param1Node, STItemType.type, param1XmlOptions);
    }
    
    public static STItemType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STItemType)POIXMLTypeLoader.parse(param1XMLInputStream, STItemType.type, null);
    }
    
    public static STItemType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STItemType)POIXMLTypeLoader.parse(param1XMLInputStream, STItemType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STItemType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STItemType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_DATA = 1;
    
    static final int INT_DEFAULT = 2;
    
    static final int INT_SUM = 3;
    
    static final int INT_COUNT_A = 4;
    
    static final int INT_AVG = 5;
    
    static final int INT_MAX = 6;
    
    static final int INT_MIN = 7;
    
    static final int INT_PRODUCT = 8;
    
    static final int INT_COUNT = 9;
    
    static final int INT_STD_DEV = 10;
    
    static final int INT_STD_DEV_P = 11;
    
    static final int INT_VAR = 12;
    
    static final int INT_VAR_P = 13;
    
    static final int INT_GRAND = 14;
    
    static final int INT_BLANK = 15;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("data", 1), new Enum("default", 2), new Enum("sum", 3), new Enum("countA", 4), new Enum("avg", 5), new Enum("max", 6), new Enum("min", 7), new Enum("product", 8), new Enum("count", 9), new Enum("stdDev", 10), 
          new Enum("stdDevP", 11), new Enum("var", 12), new Enum("varP", 13), new Enum("grand", 14), new Enum("blank", 15) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STItemType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */