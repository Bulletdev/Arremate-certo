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

public interface STFldCharType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFldCharType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfldchartype1eb4type");
  
  public static final Enum BEGIN = Enum.forString("begin");
  
  public static final Enum SEPARATE = Enum.forString("separate");
  
  public static final Enum END = Enum.forString("end");
  
  public static final int INT_BEGIN = 1;
  
  public static final int INT_SEPARATE = 2;
  
  public static final int INT_END = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STFldCharType newValue(Object param1Object) {
      return (STFldCharType)STFldCharType.type.newValue(param1Object);
    }
    
    public static STFldCharType newInstance() {
      return (STFldCharType)POIXMLTypeLoader.newInstance(STFldCharType.type, null);
    }
    
    public static STFldCharType newInstance(XmlOptions param1XmlOptions) {
      return (STFldCharType)POIXMLTypeLoader.newInstance(STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(String param1String) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1String, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1String, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(File param1File) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1File, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1File, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(URL param1URL) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1URL, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1URL, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1InputStream, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1InputStream, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(Reader param1Reader) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1Reader, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1Reader, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1XMLStreamReader, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1XMLStreamReader, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(Node param1Node) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1Node, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1Node, STFldCharType.type, param1XmlOptions);
    }
    
    public static STFldCharType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1XMLInputStream, STFldCharType.type, null);
    }
    
    public static STFldCharType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFldCharType)POIXMLTypeLoader.parse(param1XMLInputStream, STFldCharType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFldCharType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFldCharType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BEGIN = 1;
    
    static final int INT_SEPARATE = 2;
    
    static final int INT_END = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("begin", 1), new Enum("separate", 2), new Enum("end", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STFldCharType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */