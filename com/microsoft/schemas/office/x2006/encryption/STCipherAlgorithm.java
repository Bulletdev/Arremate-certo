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

public interface STCipherAlgorithm extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCipherAlgorithm.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stcipheralgorithme346type");
  
  public static final Enum AES = Enum.forString("AES");
  
  public static final Enum RC_2 = Enum.forString("RC2");
  
  public static final Enum RC_4 = Enum.forString("RC4");
  
  public static final Enum DES = Enum.forString("DES");
  
  public static final Enum DESX = Enum.forString("DESX");
  
  public static final Enum X_3_DES = Enum.forString("3DES");
  
  public static final Enum X_3_DES_112 = Enum.forString("3DES_112");
  
  public static final int INT_AES = 1;
  
  public static final int INT_RC_2 = 2;
  
  public static final int INT_RC_4 = 3;
  
  public static final int INT_DES = 4;
  
  public static final int INT_DESX = 5;
  
  public static final int INT_X_3_DES = 6;
  
  public static final int INT_X_3_DES_112 = 7;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCipherAlgorithm newValue(Object param1Object) {
      return (STCipherAlgorithm)STCipherAlgorithm.type.newValue(param1Object);
    }
    
    public static STCipherAlgorithm newInstance() {
      return (STCipherAlgorithm)POIXMLTypeLoader.newInstance(STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm newInstance(XmlOptions param1XmlOptions) {
      return (STCipherAlgorithm)POIXMLTypeLoader.newInstance(STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(String param1String) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1String, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1String, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(File param1File) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1File, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1File, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(URL param1URL) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1URL, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1URL, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1InputStream, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1InputStream, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(Reader param1Reader) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1Reader, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1Reader, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1XMLStreamReader, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1XMLStreamReader, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(Node param1Node) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1Node, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1Node, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static STCipherAlgorithm parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1XMLInputStream, STCipherAlgorithm.type, null);
    }
    
    public static STCipherAlgorithm parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCipherAlgorithm)POIXMLTypeLoader.parse(param1XMLInputStream, STCipherAlgorithm.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCipherAlgorithm.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCipherAlgorithm.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AES = 1;
    
    static final int INT_RC_2 = 2;
    
    static final int INT_RC_4 = 3;
    
    static final int INT_DES = 4;
    
    static final int INT_DESX = 5;
    
    static final int INT_X_3_DES = 6;
    
    static final int INT_X_3_DES_112 = 7;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("AES", 1), new Enum("RC2", 2), new Enum("RC4", 3), new Enum("DES", 4), new Enum("DESX", 5), new Enum("3DES", 6), new Enum("3DES_112", 7) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STCipherAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */