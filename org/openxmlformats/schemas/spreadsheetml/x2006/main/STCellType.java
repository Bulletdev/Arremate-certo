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

public interface STCellType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCellType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcelltypebf95type");
  
  public static final Enum B = Enum.forString("b");
  
  public static final Enum N = Enum.forString("n");
  
  public static final Enum E = Enum.forString("e");
  
  public static final Enum S = Enum.forString("s");
  
  public static final Enum STR = Enum.forString("str");
  
  public static final Enum INLINE_STR = Enum.forString("inlineStr");
  
  public static final int INT_B = 1;
  
  public static final int INT_N = 2;
  
  public static final int INT_E = 3;
  
  public static final int INT_S = 4;
  
  public static final int INT_STR = 5;
  
  public static final int INT_INLINE_STR = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCellType newValue(Object param1Object) {
      return (STCellType)STCellType.type.newValue(param1Object);
    }
    
    public static STCellType newInstance() {
      return (STCellType)POIXMLTypeLoader.newInstance(STCellType.type, null);
    }
    
    public static STCellType newInstance(XmlOptions param1XmlOptions) {
      return (STCellType)POIXMLTypeLoader.newInstance(STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(String param1String) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1String, STCellType.type, null);
    }
    
    public static STCellType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1String, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(File param1File) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1File, STCellType.type, null);
    }
    
    public static STCellType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1File, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(URL param1URL) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1URL, STCellType.type, null);
    }
    
    public static STCellType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1URL, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1InputStream, STCellType.type, null);
    }
    
    public static STCellType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1InputStream, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(Reader param1Reader) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1Reader, STCellType.type, null);
    }
    
    public static STCellType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellType)POIXMLTypeLoader.parse(param1Reader, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellType.type, null);
    }
    
    public static STCellType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(Node param1Node) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1Node, STCellType.type, null);
    }
    
    public static STCellType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellType)POIXMLTypeLoader.parse(param1Node, STCellType.type, param1XmlOptions);
    }
    
    public static STCellType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCellType)POIXMLTypeLoader.parse(param1XMLInputStream, STCellType.type, null);
    }
    
    public static STCellType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCellType)POIXMLTypeLoader.parse(param1XMLInputStream, STCellType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_B = 1;
    
    static final int INT_N = 2;
    
    static final int INT_E = 3;
    
    static final int INT_S = 4;
    
    static final int INT_STR = 5;
    
    static final int INT_INLINE_STR = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("b", 1), new Enum("n", 2), new Enum("e", 3), new Enum("s", 4), new Enum("str", 5), new Enum("inlineStr", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCellType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */