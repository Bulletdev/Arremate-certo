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

public interface STCryptProv extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCryptProv.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcryptprov6ccbtype");
  
  public static final Enum RSA_AES = Enum.forString("rsaAES");
  
  public static final Enum RSA_FULL = Enum.forString("rsaFull");
  
  public static final int INT_RSA_AES = 1;
  
  public static final int INT_RSA_FULL = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCryptProv newValue(Object param1Object) {
      return (STCryptProv)STCryptProv.type.newValue(param1Object);
    }
    
    public static STCryptProv newInstance() {
      return (STCryptProv)POIXMLTypeLoader.newInstance(STCryptProv.type, null);
    }
    
    public static STCryptProv newInstance(XmlOptions param1XmlOptions) {
      return (STCryptProv)POIXMLTypeLoader.newInstance(STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(String param1String) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1String, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1String, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(File param1File) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1File, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1File, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(URL param1URL) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1URL, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1URL, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1InputStream, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1InputStream, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(Reader param1Reader) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1Reader, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1Reader, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1XMLStreamReader, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1XMLStreamReader, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(Node param1Node) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1Node, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1Node, STCryptProv.type, param1XmlOptions);
    }
    
    public static STCryptProv parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1XMLInputStream, STCryptProv.type, null);
    }
    
    public static STCryptProv parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCryptProv)POIXMLTypeLoader.parse(param1XMLInputStream, STCryptProv.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCryptProv.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCryptProv.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_RSA_AES = 1;
    
    static final int INT_RSA_FULL = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("rsaAES", 1), new Enum("rsaFull", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STCryptProv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */