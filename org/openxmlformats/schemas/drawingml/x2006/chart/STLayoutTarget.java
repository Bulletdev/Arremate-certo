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

public interface STLayoutTarget extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLayoutTarget.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlayouttarget19f1type");
  
  public static final Enum INNER = Enum.forString("inner");
  
  public static final Enum OUTER = Enum.forString("outer");
  
  public static final int INT_INNER = 1;
  
  public static final int INT_OUTER = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLayoutTarget newValue(Object param1Object) {
      return (STLayoutTarget)STLayoutTarget.type.newValue(param1Object);
    }
    
    public static STLayoutTarget newInstance() {
      return (STLayoutTarget)POIXMLTypeLoader.newInstance(STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget newInstance(XmlOptions param1XmlOptions) {
      return (STLayoutTarget)POIXMLTypeLoader.newInstance(STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(String param1String) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1String, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1String, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(File param1File) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1File, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1File, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(URL param1URL) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1URL, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1URL, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1InputStream, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1InputStream, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(Reader param1Reader) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1Reader, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1Reader, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1XMLStreamReader, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1XMLStreamReader, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(Node param1Node) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1Node, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1Node, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static STLayoutTarget parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1XMLInputStream, STLayoutTarget.type, null);
    }
    
    public static STLayoutTarget parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLayoutTarget)POIXMLTypeLoader.parse(param1XMLInputStream, STLayoutTarget.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLayoutTarget.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLayoutTarget.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_INNER = 1;
    
    static final int INT_OUTER = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("inner", 1), new Enum("outer", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STLayoutTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */