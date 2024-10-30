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

public interface STPathShadeType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPathShadeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpathshadetype93c3type");
  
  public static final Enum SHAPE = Enum.forString("shape");
  
  public static final Enum CIRCLE = Enum.forString("circle");
  
  public static final Enum RECT = Enum.forString("rect");
  
  public static final int INT_SHAPE = 1;
  
  public static final int INT_CIRCLE = 2;
  
  public static final int INT_RECT = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPathShadeType newValue(Object param1Object) {
      return (STPathShadeType)STPathShadeType.type.newValue(param1Object);
    }
    
    public static STPathShadeType newInstance() {
      return (STPathShadeType)POIXMLTypeLoader.newInstance(STPathShadeType.type, null);
    }
    
    public static STPathShadeType newInstance(XmlOptions param1XmlOptions) {
      return (STPathShadeType)POIXMLTypeLoader.newInstance(STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(String param1String) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1String, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1String, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(File param1File) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1File, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1File, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(URL param1URL) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1URL, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1URL, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1InputStream, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1InputStream, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(Reader param1Reader) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1Reader, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1Reader, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1XMLStreamReader, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1XMLStreamReader, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(Node param1Node) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1Node, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1Node, STPathShadeType.type, param1XmlOptions);
    }
    
    public static STPathShadeType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1XMLInputStream, STPathShadeType.type, null);
    }
    
    public static STPathShadeType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPathShadeType)POIXMLTypeLoader.parse(param1XMLInputStream, STPathShadeType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPathShadeType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPathShadeType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SHAPE = 1;
    
    static final int INT_CIRCLE = 2;
    
    static final int INT_RECT = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("shape", 1), new Enum("circle", 2), new Enum("rect", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPathShadeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */