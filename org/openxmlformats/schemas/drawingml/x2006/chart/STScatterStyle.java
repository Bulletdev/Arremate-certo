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

public interface STScatterStyle extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STScatterStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stscatterstyle9eb9type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum LINE = Enum.forString("line");
  
  public static final Enum LINE_MARKER = Enum.forString("lineMarker");
  
  public static final Enum MARKER = Enum.forString("marker");
  
  public static final Enum SMOOTH = Enum.forString("smooth");
  
  public static final Enum SMOOTH_MARKER = Enum.forString("smoothMarker");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_LINE = 2;
  
  public static final int INT_LINE_MARKER = 3;
  
  public static final int INT_MARKER = 4;
  
  public static final int INT_SMOOTH = 5;
  
  public static final int INT_SMOOTH_MARKER = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STScatterStyle newValue(Object param1Object) {
      return (STScatterStyle)STScatterStyle.type.newValue(param1Object);
    }
    
    public static STScatterStyle newInstance() {
      return (STScatterStyle)POIXMLTypeLoader.newInstance(STScatterStyle.type, null);
    }
    
    public static STScatterStyle newInstance(XmlOptions param1XmlOptions) {
      return (STScatterStyle)POIXMLTypeLoader.newInstance(STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(String param1String) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1String, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1String, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(File param1File) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1File, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1File, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(URL param1URL) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1URL, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1URL, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1InputStream, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1InputStream, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1Reader, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1Reader, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(Node param1Node) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1Node, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1Node, STScatterStyle.type, param1XmlOptions);
    }
    
    public static STScatterStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STScatterStyle.type, null);
    }
    
    public static STScatterStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STScatterStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STScatterStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STScatterStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STScatterStyle.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_LINE = 2;
    
    static final int INT_LINE_MARKER = 3;
    
    static final int INT_MARKER = 4;
    
    static final int INT_SMOOTH = 5;
    
    static final int INT_SMOOTH_MARKER = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("line", 2), new Enum("lineMarker", 3), new Enum("marker", 4), new Enum("smooth", 5), new Enum("smoothMarker", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STScatterStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */