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

public interface STTextHorzOverflowType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextHorzOverflowType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttexthorzoverflowtype6003type");
  
  public static final Enum OVERFLOW = Enum.forString("overflow");
  
  public static final Enum CLIP = Enum.forString("clip");
  
  public static final int INT_OVERFLOW = 1;
  
  public static final int INT_CLIP = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextHorzOverflowType newValue(Object param1Object) {
      return (STTextHorzOverflowType)STTextHorzOverflowType.type.newValue(param1Object);
    }
    
    public static STTextHorzOverflowType newInstance() {
      return (STTextHorzOverflowType)POIXMLTypeLoader.newInstance(STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType newInstance(XmlOptions param1XmlOptions) {
      return (STTextHorzOverflowType)POIXMLTypeLoader.newInstance(STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(String param1String) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1String, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1String, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(File param1File) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1File, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1File, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(URL param1URL) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1URL, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1URL, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1InputStream, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1InputStream, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1Reader, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1Reader, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(Node param1Node) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1Node, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1Node, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static STTextHorzOverflowType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextHorzOverflowType.type, null);
    }
    
    public static STTextHorzOverflowType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextHorzOverflowType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextHorzOverflowType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextHorzOverflowType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextHorzOverflowType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_OVERFLOW = 1;
    
    static final int INT_CLIP = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("overflow", 1), new Enum("clip", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextHorzOverflowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */