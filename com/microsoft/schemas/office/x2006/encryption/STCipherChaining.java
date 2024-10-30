package com.microsoft.schemas.office.x2006.encryption;

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

public interface STCipherChaining extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCipherChaining.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stcipherchaining1e98type");
  
  public static final Enum CHAINING_MODE_CBC = Enum.forString("ChainingModeCBC");
  
  public static final Enum CHAINING_MODE_CFB = Enum.forString("ChainingModeCFB");
  
  public static final int INT_CHAINING_MODE_CBC = 1;
  
  public static final int INT_CHAINING_MODE_CFB = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCipherChaining newValue(Object param1Object) {
      return (STCipherChaining)STCipherChaining.type.newValue(param1Object);
    }
    
    public static STCipherChaining newInstance() {
      return (STCipherChaining)POIXMLTypeLoader.newInstance(STCipherChaining.type, null);
    }
    
    public static STCipherChaining newInstance(XmlOptions param1XmlOptions) {
      return (STCipherChaining)POIXMLTypeLoader.newInstance(STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(String param1String) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1String, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1String, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(File param1File) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1File, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1File, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(URL param1URL) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1URL, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1URL, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1InputStream, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1InputStream, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(Reader param1Reader) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1Reader, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1Reader, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1XMLStreamReader, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1XMLStreamReader, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(Node param1Node) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1Node, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1Node, STCipherChaining.type, param1XmlOptions);
    }
    
    public static STCipherChaining parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1XMLInputStream, STCipherChaining.type, null);
    }
    
    public static STCipherChaining parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCipherChaining)POIXMLTypeLoader.parse(param1XMLInputStream, STCipherChaining.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCipherChaining.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCipherChaining.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CHAINING_MODE_CBC = 1;
    
    static final int INT_CHAINING_MODE_CFB = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("ChainingModeCBC", 1), new Enum("ChainingModeCFB", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STCipherChaining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */