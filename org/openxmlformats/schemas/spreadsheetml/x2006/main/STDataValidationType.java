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

public interface STDataValidationType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDataValidationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationtypeabf6type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum WHOLE = Enum.forString("whole");
  
  public static final Enum DECIMAL = Enum.forString("decimal");
  
  public static final Enum LIST = Enum.forString("list");
  
  public static final Enum DATE = Enum.forString("date");
  
  public static final Enum TIME = Enum.forString("time");
  
  public static final Enum TEXT_LENGTH = Enum.forString("textLength");
  
  public static final Enum CUSTOM = Enum.forString("custom");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_WHOLE = 2;
  
  public static final int INT_DECIMAL = 3;
  
  public static final int INT_LIST = 4;
  
  public static final int INT_DATE = 5;
  
  public static final int INT_TIME = 6;
  
  public static final int INT_TEXT_LENGTH = 7;
  
  public static final int INT_CUSTOM = 8;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STDataValidationType newValue(Object param1Object) {
      return (STDataValidationType)STDataValidationType.type.newValue(param1Object);
    }
    
    public static STDataValidationType newInstance() {
      return (STDataValidationType)POIXMLTypeLoader.newInstance(STDataValidationType.type, null);
    }
    
    public static STDataValidationType newInstance(XmlOptions param1XmlOptions) {
      return (STDataValidationType)POIXMLTypeLoader.newInstance(STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(String param1String) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1String, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1String, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(File param1File) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1File, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1File, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(URL param1URL) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1URL, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1URL, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1InputStream, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1InputStream, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(Reader param1Reader) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1Reader, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1Reader, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(Node param1Node) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1Node, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1Node, STDataValidationType.type, param1XmlOptions);
    }
    
    public static STDataValidationType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationType.type, null);
    }
    
    public static STDataValidationType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDataValidationType)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_WHOLE = 2;
    
    static final int INT_DECIMAL = 3;
    
    static final int INT_LIST = 4;
    
    static final int INT_DATE = 5;
    
    static final int INT_TIME = 6;
    
    static final int INT_TEXT_LENGTH = 7;
    
    static final int INT_CUSTOM = 8;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("whole", 2), new Enum("decimal", 3), new Enum("list", 4), new Enum("date", 5), new Enum("time", 6), new Enum("textLength", 7), new Enum("custom", 8) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STDataValidationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */