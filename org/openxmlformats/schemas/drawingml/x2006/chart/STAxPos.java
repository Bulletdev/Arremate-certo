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

public interface STAxPos extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAxPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("staxpos4379type");
  
  public static final Enum B = Enum.forString("b");
  
  public static final Enum L = Enum.forString("l");
  
  public static final Enum R = Enum.forString("r");
  
  public static final Enum T = Enum.forString("t");
  
  public static final int INT_B = 1;
  
  public static final int INT_L = 2;
  
  public static final int INT_R = 3;
  
  public static final int INT_T = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STAxPos newValue(Object param1Object) {
      return (STAxPos)STAxPos.type.newValue(param1Object);
    }
    
    public static STAxPos newInstance() {
      return (STAxPos)POIXMLTypeLoader.newInstance(STAxPos.type, null);
    }
    
    public static STAxPos newInstance(XmlOptions param1XmlOptions) {
      return (STAxPos)POIXMLTypeLoader.newInstance(STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(String param1String) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1String, STAxPos.type, null);
    }
    
    public static STAxPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1String, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(File param1File) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1File, STAxPos.type, null);
    }
    
    public static STAxPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1File, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(URL param1URL) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1URL, STAxPos.type, null);
    }
    
    public static STAxPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1URL, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1InputStream, STAxPos.type, null);
    }
    
    public static STAxPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1InputStream, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(Reader param1Reader) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1Reader, STAxPos.type, null);
    }
    
    public static STAxPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxPos)POIXMLTypeLoader.parse(param1Reader, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STAxPos.type, null);
    }
    
    public static STAxPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(Node param1Node) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1Node, STAxPos.type, null);
    }
    
    public static STAxPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxPos)POIXMLTypeLoader.parse(param1Node, STAxPos.type, param1XmlOptions);
    }
    
    public static STAxPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAxPos)POIXMLTypeLoader.parse(param1XMLInputStream, STAxPos.type, null);
    }
    
    public static STAxPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAxPos)POIXMLTypeLoader.parse(param1XMLInputStream, STAxPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAxPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAxPos.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_B = 1;
    
    static final int INT_L = 2;
    
    static final int INT_R = 3;
    
    static final int INT_T = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("b", 1), new Enum("l", 2), new Enum("r", 3), new Enum("t", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STAxPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */