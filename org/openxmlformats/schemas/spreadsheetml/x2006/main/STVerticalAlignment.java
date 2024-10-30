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

public interface STVerticalAlignment extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STVerticalAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stverticalalignmentd35ctype");
  
  public static final Enum TOP = Enum.forString("top");
  
  public static final Enum CENTER = Enum.forString("center");
  
  public static final Enum BOTTOM = Enum.forString("bottom");
  
  public static final Enum JUSTIFY = Enum.forString("justify");
  
  public static final Enum DISTRIBUTED = Enum.forString("distributed");
  
  public static final int INT_TOP = 1;
  
  public static final int INT_CENTER = 2;
  
  public static final int INT_BOTTOM = 3;
  
  public static final int INT_JUSTIFY = 4;
  
  public static final int INT_DISTRIBUTED = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STVerticalAlignment newValue(Object param1Object) {
      return (STVerticalAlignment)STVerticalAlignment.type.newValue(param1Object);
    }
    
    public static STVerticalAlignment newInstance() {
      return (STVerticalAlignment)POIXMLTypeLoader.newInstance(STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment newInstance(XmlOptions param1XmlOptions) {
      return (STVerticalAlignment)POIXMLTypeLoader.newInstance(STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(String param1String) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1String, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1String, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(File param1File) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1File, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1File, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(URL param1URL) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1URL, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1URL, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1InputStream, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1InputStream, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(Reader param1Reader) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1Reader, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1Reader, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(Node param1Node) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1Node, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1Node, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static STVerticalAlignment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalAlignment.type, null);
    }
    
    public static STVerticalAlignment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STVerticalAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalAlignment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalAlignment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalAlignment.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TOP = 1;
    
    static final int INT_CENTER = 2;
    
    static final int INT_BOTTOM = 3;
    
    static final int INT_JUSTIFY = 4;
    
    static final int INT_DISTRIBUTED = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("top", 1), new Enum("center", 2), new Enum("bottom", 3), new Enum("justify", 4), new Enum("distributed", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STVerticalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */