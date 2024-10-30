package com.microsoft.schemas.office.office;

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

public interface STConnectType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STConnectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stconnecttype97adtype");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum RECT = Enum.forString("rect");
  
  public static final Enum SEGMENTS = Enum.forString("segments");
  
  public static final Enum CUSTOM = Enum.forString("custom");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_RECT = 2;
  
  public static final int INT_SEGMENTS = 3;
  
  public static final int INT_CUSTOM = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STConnectType newValue(Object param1Object) {
      return (STConnectType)STConnectType.type.newValue(param1Object);
    }
    
    public static STConnectType newInstance() {
      return (STConnectType)POIXMLTypeLoader.newInstance(STConnectType.type, null);
    }
    
    public static STConnectType newInstance(XmlOptions param1XmlOptions) {
      return (STConnectType)POIXMLTypeLoader.newInstance(STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(String param1String) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1String, STConnectType.type, null);
    }
    
    public static STConnectType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1String, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(File param1File) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1File, STConnectType.type, null);
    }
    
    public static STConnectType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1File, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(URL param1URL) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1URL, STConnectType.type, null);
    }
    
    public static STConnectType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1URL, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1InputStream, STConnectType.type, null);
    }
    
    public static STConnectType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1InputStream, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(Reader param1Reader) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1Reader, STConnectType.type, null);
    }
    
    public static STConnectType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConnectType)POIXMLTypeLoader.parse(param1Reader, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1XMLStreamReader, STConnectType.type, null);
    }
    
    public static STConnectType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1XMLStreamReader, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(Node param1Node) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1Node, STConnectType.type, null);
    }
    
    public static STConnectType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STConnectType)POIXMLTypeLoader.parse(param1Node, STConnectType.type, param1XmlOptions);
    }
    
    public static STConnectType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STConnectType)POIXMLTypeLoader.parse(param1XMLInputStream, STConnectType.type, null);
    }
    
    public static STConnectType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STConnectType)POIXMLTypeLoader.parse(param1XMLInputStream, STConnectType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STConnectType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STConnectType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_RECT = 2;
    
    static final int INT_SEGMENTS = 3;
    
    static final int INT_CUSTOM = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("rect", 2), new Enum("segments", 3), new Enum("custom", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\STConnectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */