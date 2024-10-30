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

public interface STVerticalJc extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STVerticalJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stverticaljc3629type");
  
  public static final Enum TOP = Enum.forString("top");
  
  public static final Enum CENTER = Enum.forString("center");
  
  public static final Enum BOTH = Enum.forString("both");
  
  public static final Enum BOTTOM = Enum.forString("bottom");
  
  public static final int INT_TOP = 1;
  
  public static final int INT_CENTER = 2;
  
  public static final int INT_BOTH = 3;
  
  public static final int INT_BOTTOM = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STVerticalJc newValue(Object param1Object) {
      return (STVerticalJc)STVerticalJc.type.newValue(param1Object);
    }
    
    public static STVerticalJc newInstance() {
      return (STVerticalJc)POIXMLTypeLoader.newInstance(STVerticalJc.type, null);
    }
    
    public static STVerticalJc newInstance(XmlOptions param1XmlOptions) {
      return (STVerticalJc)POIXMLTypeLoader.newInstance(STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(String param1String) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1String, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1String, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(File param1File) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1File, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1File, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(URL param1URL) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1URL, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1URL, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1InputStream, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1InputStream, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(Reader param1Reader) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1Reader, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1Reader, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(Node param1Node) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1Node, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1Node, STVerticalJc.type, param1XmlOptions);
    }
    
    public static STVerticalJc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalJc.type, null);
    }
    
    public static STVerticalJc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STVerticalJc)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalJc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalJc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalJc.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TOP = 1;
    
    static final int INT_CENTER = 2;
    
    static final int INT_BOTH = 3;
    
    static final int INT_BOTTOM = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("top", 1), new Enum("center", 2), new Enum("both", 3), new Enum("bottom", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STVerticalJc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */