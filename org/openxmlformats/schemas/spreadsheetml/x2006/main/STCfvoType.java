package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface STCfvoType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCfvoType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcfvotypeeb0ftype");
  
  public static final Enum NUM = Enum.forString("num");
  
  public static final Enum PERCENT = Enum.forString("percent");
  
  public static final Enum MAX = Enum.forString("max");
  
  public static final Enum MIN = Enum.forString("min");
  
  public static final Enum FORMULA = Enum.forString("formula");
  
  public static final Enum PERCENTILE = Enum.forString("percentile");
  
  public static final int INT_NUM = 1;
  
  public static final int INT_PERCENT = 2;
  
  public static final int INT_MAX = 3;
  
  public static final int INT_MIN = 4;
  
  public static final int INT_FORMULA = 5;
  
  public static final int INT_PERCENTILE = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCfvoType newValue(Object param1Object) {
      return (STCfvoType)STCfvoType.type.newValue(param1Object);
    }
    
    public static STCfvoType newInstance() {
      return (STCfvoType)POIXMLTypeLoader.newInstance(STCfvoType.type, null);
    }
    
    public static STCfvoType newInstance(XmlOptions param1XmlOptions) {
      return (STCfvoType)POIXMLTypeLoader.newInstance(STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(String param1String) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1String, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1String, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(File param1File) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1File, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1File, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(URL param1URL) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1URL, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1URL, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1InputStream, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1InputStream, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(Reader param1Reader) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1Reader, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1Reader, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(Node param1Node) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1Node, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1Node, STCfvoType.type, param1XmlOptions);
    }
    
    public static STCfvoType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1XMLInputStream, STCfvoType.type, null);
    }
    
    public static STCfvoType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCfvoType)POIXMLTypeLoader.parse(param1XMLInputStream, STCfvoType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCfvoType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCfvoType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NUM = 1;
    
    static final int INT_PERCENT = 2;
    
    static final int INT_MAX = 3;
    
    static final int INT_MIN = 4;
    
    static final int INT_FORMULA = 5;
    
    static final int INT_PERCENTILE = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("num", 1), new Enum("percent", 2), new Enum("max", 3), new Enum("min", 4), new Enum("formula", 5), new Enum("percentile", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCfvoType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */