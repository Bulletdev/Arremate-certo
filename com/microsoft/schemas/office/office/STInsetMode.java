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

public interface STInsetMode extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STInsetMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stinsetmode3b89type");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final Enum CUSTOM = Enum.forString("custom");
  
  public static final int INT_AUTO = 1;
  
  public static final int INT_CUSTOM = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STInsetMode newValue(Object param1Object) {
      return (STInsetMode)STInsetMode.type.newValue(param1Object);
    }
    
    public static STInsetMode newInstance() {
      return (STInsetMode)POIXMLTypeLoader.newInstance(STInsetMode.type, null);
    }
    
    public static STInsetMode newInstance(XmlOptions param1XmlOptions) {
      return (STInsetMode)POIXMLTypeLoader.newInstance(STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(String param1String) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1String, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1String, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(File param1File) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1File, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1File, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(URL param1URL) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1URL, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1URL, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1InputStream, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1InputStream, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(Reader param1Reader) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1Reader, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1Reader, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(Node param1Node) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1Node, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1Node, STInsetMode.type, param1XmlOptions);
    }
    
    public static STInsetMode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1XMLInputStream, STInsetMode.type, null);
    }
    
    public static STInsetMode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STInsetMode)POIXMLTypeLoader.parse(param1XMLInputStream, STInsetMode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STInsetMode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STInsetMode.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AUTO = 1;
    
    static final int INT_CUSTOM = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("auto", 1), new Enum("custom", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\STInsetMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */