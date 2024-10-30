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

public interface STHashAlgorithm extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHashAlgorithm.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("sthashalgorithm65e3type");
  
  public static final Enum SHA_1 = Enum.forString("SHA1");
  
  public static final Enum SHA_256 = Enum.forString("SHA256");
  
  public static final Enum SHA_384 = Enum.forString("SHA384");
  
  public static final Enum SHA_512 = Enum.forString("SHA512");
  
  public static final Enum MD_5 = Enum.forString("MD5");
  
  public static final Enum MD_4 = Enum.forString("MD4");
  
  public static final Enum MD_2 = Enum.forString("MD2");
  
  public static final Enum RIPEMD_128 = Enum.forString("RIPEMD-128");
  
  public static final Enum RIPEMD_160 = Enum.forString("RIPEMD-160");
  
  public static final Enum WHIRLPOOL = Enum.forString("WHIRLPOOL");
  
  public static final int INT_SHA_1 = 1;
  
  public static final int INT_SHA_256 = 2;
  
  public static final int INT_SHA_384 = 3;
  
  public static final int INT_SHA_512 = 4;
  
  public static final int INT_MD_5 = 5;
  
  public static final int INT_MD_4 = 6;
  
  public static final int INT_MD_2 = 7;
  
  public static final int INT_RIPEMD_128 = 8;
  
  public static final int INT_RIPEMD_160 = 9;
  
  public static final int INT_WHIRLPOOL = 10;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STHashAlgorithm newValue(Object param1Object) {
      return (STHashAlgorithm)STHashAlgorithm.type.newValue(param1Object);
    }
    
    public static STHashAlgorithm newInstance() {
      return (STHashAlgorithm)POIXMLTypeLoader.newInstance(STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm newInstance(XmlOptions param1XmlOptions) {
      return (STHashAlgorithm)POIXMLTypeLoader.newInstance(STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(String param1String) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1String, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1String, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(File param1File) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1File, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1File, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(URL param1URL) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1URL, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1URL, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1InputStream, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1InputStream, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(Reader param1Reader) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1Reader, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1Reader, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1XMLStreamReader, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1XMLStreamReader, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(Node param1Node) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1Node, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1Node, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static STHashAlgorithm parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1XMLInputStream, STHashAlgorithm.type, null);
    }
    
    public static STHashAlgorithm parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHashAlgorithm)POIXMLTypeLoader.parse(param1XMLInputStream, STHashAlgorithm.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHashAlgorithm.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHashAlgorithm.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SHA_1 = 1;
    
    static final int INT_SHA_256 = 2;
    
    static final int INT_SHA_384 = 3;
    
    static final int INT_SHA_512 = 4;
    
    static final int INT_MD_5 = 5;
    
    static final int INT_MD_4 = 6;
    
    static final int INT_MD_2 = 7;
    
    static final int INT_RIPEMD_128 = 8;
    
    static final int INT_RIPEMD_160 = 9;
    
    static final int INT_WHIRLPOOL = 10;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("SHA1", 1), new Enum("SHA256", 2), new Enum("SHA384", 3), new Enum("SHA512", 4), new Enum("MD5", 5), new Enum("MD4", 6), new Enum("MD2", 7), new Enum("RIPEMD-128", 8), new Enum("RIPEMD-160", 9), new Enum("WHIRLPOOL", 10) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STHashAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */