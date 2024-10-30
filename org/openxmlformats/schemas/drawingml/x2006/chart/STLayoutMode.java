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

public interface STLayoutMode extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlayoutmode19dftype");
  
  public static final Enum EDGE = Enum.forString("edge");
  
  public static final Enum FACTOR = Enum.forString("factor");
  
  public static final int INT_EDGE = 1;
  
  public static final int INT_FACTOR = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLayoutMode newValue(Object param1Object) {
      return (STLayoutMode)STLayoutMode.type.newValue(param1Object);
    }
    
    public static STLayoutMode newInstance() {
      return (STLayoutMode)POIXMLTypeLoader.newInstance(STLayoutMode.type, null);
    }
    
    public static STLayoutMode newInstance(XmlOptions param1XmlOptions) {
      return (STLayoutMode)POIXMLTypeLoader.newInstance(STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(String param1String) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1String, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1String, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(File param1File) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1File, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1File, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(URL param1URL) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1URL, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1URL, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1InputStream, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1InputStream, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(Reader param1Reader) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1Reader, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1Reader, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(Node param1Node) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1Node, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1Node, STLayoutMode.type, param1XmlOptions);
    }
    
    public static STLayoutMode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1XMLInputStream, STLayoutMode.type, null);
    }
    
    public static STLayoutMode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLayoutMode)POIXMLTypeLoader.parse(param1XMLInputStream, STLayoutMode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLayoutMode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLayoutMode.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_EDGE = 1;
    
    static final int INT_FACTOR = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("edge", 1), new Enum("factor", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STLayoutMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */