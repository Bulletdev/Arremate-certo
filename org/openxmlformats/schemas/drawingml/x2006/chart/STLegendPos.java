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

public interface STLegendPos extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLegendPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlegendposc14ftype");
  
  public static final Enum B = Enum.forString("b");
  
  public static final Enum TR = Enum.forString("tr");
  
  public static final Enum L = Enum.forString("l");
  
  public static final Enum R = Enum.forString("r");
  
  public static final Enum T = Enum.forString("t");
  
  public static final int INT_B = 1;
  
  public static final int INT_TR = 2;
  
  public static final int INT_L = 3;
  
  public static final int INT_R = 4;
  
  public static final int INT_T = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLegendPos newValue(Object param1Object) {
      return (STLegendPos)STLegendPos.type.newValue(param1Object);
    }
    
    public static STLegendPos newInstance() {
      return (STLegendPos)POIXMLTypeLoader.newInstance(STLegendPos.type, null);
    }
    
    public static STLegendPos newInstance(XmlOptions param1XmlOptions) {
      return (STLegendPos)POIXMLTypeLoader.newInstance(STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(String param1String) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1String, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1String, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(File param1File) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1File, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1File, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(URL param1URL) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1URL, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1URL, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1InputStream, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1InputStream, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(Reader param1Reader) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1Reader, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1Reader, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(Node param1Node) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1Node, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1Node, STLegendPos.type, param1XmlOptions);
    }
    
    public static STLegendPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1XMLInputStream, STLegendPos.type, null);
    }
    
    public static STLegendPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLegendPos)POIXMLTypeLoader.parse(param1XMLInputStream, STLegendPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLegendPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLegendPos.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_B = 1;
    
    static final int INT_TR = 2;
    
    static final int INT_L = 3;
    
    static final int INT_R = 4;
    
    static final int INT_T = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("b", 1), new Enum("tr", 2), new Enum("l", 3), new Enum("r", 4), new Enum("t", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STLegendPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */