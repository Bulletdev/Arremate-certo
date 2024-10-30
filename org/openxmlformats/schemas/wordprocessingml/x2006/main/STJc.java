package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface STJc extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stjc977ftype");
  
  public static final Enum LEFT = Enum.forString("left");
  
  public static final Enum CENTER = Enum.forString("center");
  
  public static final Enum RIGHT = Enum.forString("right");
  
  public static final Enum BOTH = Enum.forString("both");
  
  public static final Enum MEDIUM_KASHIDA = Enum.forString("mediumKashida");
  
  public static final Enum DISTRIBUTE = Enum.forString("distribute");
  
  public static final Enum NUM_TAB = Enum.forString("numTab");
  
  public static final Enum HIGH_KASHIDA = Enum.forString("highKashida");
  
  public static final Enum LOW_KASHIDA = Enum.forString("lowKashida");
  
  public static final Enum THAI_DISTRIBUTE = Enum.forString("thaiDistribute");
  
  public static final int INT_LEFT = 1;
  
  public static final int INT_CENTER = 2;
  
  public static final int INT_RIGHT = 3;
  
  public static final int INT_BOTH = 4;
  
  public static final int INT_MEDIUM_KASHIDA = 5;
  
  public static final int INT_DISTRIBUTE = 6;
  
  public static final int INT_NUM_TAB = 7;
  
  public static final int INT_HIGH_KASHIDA = 8;
  
  public static final int INT_LOW_KASHIDA = 9;
  
  public static final int INT_THAI_DISTRIBUTE = 10;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STJc newValue(Object param1Object) {
      return (STJc)STJc.type.newValue(param1Object);
    }
    
    public static STJc newInstance() {
      return (STJc)POIXMLTypeLoader.newInstance(STJc.type, null);
    }
    
    public static STJc newInstance(XmlOptions param1XmlOptions) {
      return (STJc)POIXMLTypeLoader.newInstance(STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(String param1String) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1String, STJc.type, null);
    }
    
    public static STJc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1String, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(File param1File) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1File, STJc.type, null);
    }
    
    public static STJc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1File, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(URL param1URL) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1URL, STJc.type, null);
    }
    
    public static STJc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1URL, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1InputStream, STJc.type, null);
    }
    
    public static STJc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1InputStream, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(Reader param1Reader) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1Reader, STJc.type, null);
    }
    
    public static STJc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STJc)POIXMLTypeLoader.parse(param1Reader, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STJc.type, null);
    }
    
    public static STJc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(Node param1Node) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1Node, STJc.type, null);
    }
    
    public static STJc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STJc)POIXMLTypeLoader.parse(param1Node, STJc.type, param1XmlOptions);
    }
    
    public static STJc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STJc)POIXMLTypeLoader.parse(param1XMLInputStream, STJc.type, null);
    }
    
    public static STJc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STJc)POIXMLTypeLoader.parse(param1XMLInputStream, STJc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STJc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STJc.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_LEFT = 1;
    
    static final int INT_CENTER = 2;
    
    static final int INT_RIGHT = 3;
    
    static final int INT_BOTH = 4;
    
    static final int INT_MEDIUM_KASHIDA = 5;
    
    static final int INT_DISTRIBUTE = 6;
    
    static final int INT_NUM_TAB = 7;
    
    static final int INT_HIGH_KASHIDA = 8;
    
    static final int INT_LOW_KASHIDA = 9;
    
    static final int INT_THAI_DISTRIBUTE = 10;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("left", 1), new Enum("center", 2), new Enum("right", 3), new Enum("both", 4), new Enum("mediumKashida", 5), new Enum("distribute", 6), new Enum("numTab", 7), new Enum("highKashida", 8), new Enum("lowKashida", 9), new Enum("thaiDistribute", 10) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STJc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */