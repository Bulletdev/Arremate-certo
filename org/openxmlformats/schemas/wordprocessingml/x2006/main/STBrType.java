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

public interface STBrType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STBrType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stbrtypeb52etype");
  
  public static final Enum PAGE = Enum.forString("page");
  
  public static final Enum COLUMN = Enum.forString("column");
  
  public static final Enum TEXT_WRAPPING = Enum.forString("textWrapping");
  
  public static final int INT_PAGE = 1;
  
  public static final int INT_COLUMN = 2;
  
  public static final int INT_TEXT_WRAPPING = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STBrType newValue(Object param1Object) {
      return (STBrType)STBrType.type.newValue(param1Object);
    }
    
    public static STBrType newInstance() {
      return (STBrType)POIXMLTypeLoader.newInstance(STBrType.type, null);
    }
    
    public static STBrType newInstance(XmlOptions param1XmlOptions) {
      return (STBrType)POIXMLTypeLoader.newInstance(STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(String param1String) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1String, STBrType.type, null);
    }
    
    public static STBrType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1String, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(File param1File) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1File, STBrType.type, null);
    }
    
    public static STBrType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1File, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(URL param1URL) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1URL, STBrType.type, null);
    }
    
    public static STBrType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1URL, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1InputStream, STBrType.type, null);
    }
    
    public static STBrType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1InputStream, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(Reader param1Reader) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1Reader, STBrType.type, null);
    }
    
    public static STBrType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrType)POIXMLTypeLoader.parse(param1Reader, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1XMLStreamReader, STBrType.type, null);
    }
    
    public static STBrType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1XMLStreamReader, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(Node param1Node) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1Node, STBrType.type, null);
    }
    
    public static STBrType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrType)POIXMLTypeLoader.parse(param1Node, STBrType.type, param1XmlOptions);
    }
    
    public static STBrType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STBrType)POIXMLTypeLoader.parse(param1XMLInputStream, STBrType.type, null);
    }
    
    public static STBrType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STBrType)POIXMLTypeLoader.parse(param1XMLInputStream, STBrType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBrType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBrType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_PAGE = 1;
    
    static final int INT_COLUMN = 2;
    
    static final int INT_TEXT_WRAPPING = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("page", 1), new Enum("column", 2), new Enum("textWrapping", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STBrType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */