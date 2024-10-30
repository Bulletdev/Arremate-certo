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

public interface STOnOff extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stonofffcd2type");
  
  public static final Enum TRUE = Enum.forString("true");
  
  public static final Enum FALSE = Enum.forString("false");
  
  public static final Enum ON = Enum.forString("on");
  
  public static final Enum OFF = Enum.forString("off");
  
  public static final Enum X_0 = Enum.forString("0");
  
  public static final Enum X_1 = Enum.forString("1");
  
  public static final int INT_TRUE = 1;
  
  public static final int INT_FALSE = 2;
  
  public static final int INT_ON = 3;
  
  public static final int INT_OFF = 4;
  
  public static final int INT_X_0 = 5;
  
  public static final int INT_X_1 = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STOnOff newValue(Object param1Object) {
      return (STOnOff)STOnOff.type.newValue(param1Object);
    }
    
    public static STOnOff newInstance() {
      return (STOnOff)POIXMLTypeLoader.newInstance(STOnOff.type, null);
    }
    
    public static STOnOff newInstance(XmlOptions param1XmlOptions) {
      return (STOnOff)POIXMLTypeLoader.newInstance(STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(String param1String) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1String, STOnOff.type, null);
    }
    
    public static STOnOff parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1String, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(File param1File) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1File, STOnOff.type, null);
    }
    
    public static STOnOff parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1File, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(URL param1URL) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1URL, STOnOff.type, null);
    }
    
    public static STOnOff parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1URL, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1InputStream, STOnOff.type, null);
    }
    
    public static STOnOff parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1InputStream, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(Reader param1Reader) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1Reader, STOnOff.type, null);
    }
    
    public static STOnOff parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOnOff)POIXMLTypeLoader.parse(param1Reader, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1XMLStreamReader, STOnOff.type, null);
    }
    
    public static STOnOff parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1XMLStreamReader, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(Node param1Node) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1Node, STOnOff.type, null);
    }
    
    public static STOnOff parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STOnOff)POIXMLTypeLoader.parse(param1Node, STOnOff.type, param1XmlOptions);
    }
    
    public static STOnOff parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STOnOff)POIXMLTypeLoader.parse(param1XMLInputStream, STOnOff.type, null);
    }
    
    public static STOnOff parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STOnOff)POIXMLTypeLoader.parse(param1XMLInputStream, STOnOff.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOnOff.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOnOff.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TRUE = 1;
    
    static final int INT_FALSE = 2;
    
    static final int INT_ON = 3;
    
    static final int INT_OFF = 4;
    
    static final int INT_X_0 = 5;
    
    static final int INT_X_1 = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("true", 1), new Enum("false", 2), new Enum("on", 3), new Enum("off", 4), new Enum("0", 5), new Enum("1", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STOnOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */