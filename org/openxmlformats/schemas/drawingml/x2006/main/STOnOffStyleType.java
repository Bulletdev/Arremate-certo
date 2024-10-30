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

public interface STOnOffStyleType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STOnOffStyleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stonoffstyletype4606type");
  
  public static final Enum ON = Enum.forString("on");
  
  public static final Enum OFF = Enum.forString("off");
  
  public static final Enum DEF = Enum.forString("def");
  
  public static final int INT_ON = 1;
  
  public static final int INT_OFF = 2;
  
  public static final int INT_DEF = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STOnOffStyleType newValue(Object param1Object) {
      return (STOnOffStyleType)STOnOffStyleType.type.newValue(param1Object);
    }
    
    public static STOnOffStyleType newInstance() {
      return (STOnOffStyleType)POIXMLTypeLoader.newInstance(STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType newInstance(XmlOptions param1XmlOptions) {
      return (STOnOffStyleType)POIXMLTypeLoader.newInstance(STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(String param1String) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1String, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1String, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(File param1File) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1File, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1File, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(URL param1URL) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1URL, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1URL, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1InputStream, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1InputStream, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(Reader param1Reader) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1Reader, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1Reader, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1XMLStreamReader, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1XMLStreamReader, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(Node param1Node) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1Node, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1Node, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static STOnOffStyleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1XMLInputStream, STOnOffStyleType.type, null);
    }
    
    public static STOnOffStyleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STOnOffStyleType)POIXMLTypeLoader.parse(param1XMLInputStream, STOnOffStyleType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOnOffStyleType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOnOffStyleType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_ON = 1;
    
    static final int INT_OFF = 2;
    
    static final int INT_DEF = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("on", 1), new Enum("off", 2), new Enum("def", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STOnOffStyleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */