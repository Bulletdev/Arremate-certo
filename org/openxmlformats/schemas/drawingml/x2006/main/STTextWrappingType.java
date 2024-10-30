package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextWrappingType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextWrappingType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextwrappingtype4b4etype");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum SQUARE = Enum.forString("square");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_SQUARE = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextWrappingType newValue(Object param1Object) {
      return (STTextWrappingType)STTextWrappingType.type.newValue(param1Object);
    }
    
    public static STTextWrappingType newInstance() {
      return (STTextWrappingType)POIXMLTypeLoader.newInstance(STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType newInstance(XmlOptions param1XmlOptions) {
      return (STTextWrappingType)POIXMLTypeLoader.newInstance(STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(String param1String) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1String, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1String, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(File param1File) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1File, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1File, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(URL param1URL) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1URL, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1URL, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1InputStream, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1InputStream, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1Reader, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1Reader, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(Node param1Node) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1Node, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1Node, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static STTextWrappingType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextWrappingType.type, null);
    }
    
    public static STTextWrappingType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextWrappingType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextWrappingType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextWrappingType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextWrappingType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_SQUARE = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("square", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextWrappingType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */