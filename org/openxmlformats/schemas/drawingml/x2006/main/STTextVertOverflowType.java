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

public interface STTextVertOverflowType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextVertOverflowType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextvertoverflowtype2725type");
  
  public static final Enum OVERFLOW = Enum.forString("overflow");
  
  public static final Enum ELLIPSIS = Enum.forString("ellipsis");
  
  public static final Enum CLIP = Enum.forString("clip");
  
  public static final int INT_OVERFLOW = 1;
  
  public static final int INT_ELLIPSIS = 2;
  
  public static final int INT_CLIP = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextVertOverflowType newValue(Object param1Object) {
      return (STTextVertOverflowType)STTextVertOverflowType.type.newValue(param1Object);
    }
    
    public static STTextVertOverflowType newInstance() {
      return (STTextVertOverflowType)POIXMLTypeLoader.newInstance(STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType newInstance(XmlOptions param1XmlOptions) {
      return (STTextVertOverflowType)POIXMLTypeLoader.newInstance(STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(String param1String) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1String, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1String, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(File param1File) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1File, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1File, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(URL param1URL) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1URL, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1URL, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1InputStream, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1InputStream, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1Reader, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1Reader, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(Node param1Node) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1Node, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1Node, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static STTextVertOverflowType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextVertOverflowType.type, null);
    }
    
    public static STTextVertOverflowType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextVertOverflowType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextVertOverflowType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextVertOverflowType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextVertOverflowType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_OVERFLOW = 1;
    
    static final int INT_ELLIPSIS = 2;
    
    static final int INT_CLIP = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("overflow", 1), new Enum("ellipsis", 2), new Enum("clip", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextVertOverflowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */