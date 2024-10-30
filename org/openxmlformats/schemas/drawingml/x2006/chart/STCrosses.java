package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface STCrosses extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCrosses.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcrosses3cc8type");
  
  public static final Enum AUTO_ZERO = Enum.forString("autoZero");
  
  public static final Enum MAX = Enum.forString("max");
  
  public static final Enum MIN = Enum.forString("min");
  
  public static final int INT_AUTO_ZERO = 1;
  
  public static final int INT_MAX = 2;
  
  public static final int INT_MIN = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCrosses newValue(Object param1Object) {
      return (STCrosses)STCrosses.type.newValue(param1Object);
    }
    
    public static STCrosses newInstance() {
      return (STCrosses)POIXMLTypeLoader.newInstance(STCrosses.type, null);
    }
    
    public static STCrosses newInstance(XmlOptions param1XmlOptions) {
      return (STCrosses)POIXMLTypeLoader.newInstance(STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(String param1String) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1String, STCrosses.type, null);
    }
    
    public static STCrosses parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1String, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(File param1File) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1File, STCrosses.type, null);
    }
    
    public static STCrosses parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1File, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(URL param1URL) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1URL, STCrosses.type, null);
    }
    
    public static STCrosses parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1URL, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1InputStream, STCrosses.type, null);
    }
    
    public static STCrosses parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1InputStream, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(Reader param1Reader) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1Reader, STCrosses.type, null);
    }
    
    public static STCrosses parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrosses)POIXMLTypeLoader.parse(param1Reader, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1XMLStreamReader, STCrosses.type, null);
    }
    
    public static STCrosses parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1XMLStreamReader, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(Node param1Node) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1Node, STCrosses.type, null);
    }
    
    public static STCrosses parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrosses)POIXMLTypeLoader.parse(param1Node, STCrosses.type, param1XmlOptions);
    }
    
    public static STCrosses parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCrosses)POIXMLTypeLoader.parse(param1XMLInputStream, STCrosses.type, null);
    }
    
    public static STCrosses parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCrosses)POIXMLTypeLoader.parse(param1XMLInputStream, STCrosses.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCrosses.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCrosses.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AUTO_ZERO = 1;
    
    static final int INT_MAX = 2;
    
    static final int INT_MIN = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("autoZero", 1), new Enum("max", 2), new Enum("min", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STCrosses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */