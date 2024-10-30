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

public interface STTickLblPos extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTickLblPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stticklblposc551type");
  
  public static final Enum HIGH = Enum.forString("high");
  
  public static final Enum LOW = Enum.forString("low");
  
  public static final Enum NEXT_TO = Enum.forString("nextTo");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final int INT_HIGH = 1;
  
  public static final int INT_LOW = 2;
  
  public static final int INT_NEXT_TO = 3;
  
  public static final int INT_NONE = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTickLblPos newValue(Object param1Object) {
      return (STTickLblPos)STTickLblPos.type.newValue(param1Object);
    }
    
    public static STTickLblPos newInstance() {
      return (STTickLblPos)POIXMLTypeLoader.newInstance(STTickLblPos.type, null);
    }
    
    public static STTickLblPos newInstance(XmlOptions param1XmlOptions) {
      return (STTickLblPos)POIXMLTypeLoader.newInstance(STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(String param1String) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1String, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1String, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(File param1File) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1File, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1File, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(URL param1URL) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1URL, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1URL, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1InputStream, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1InputStream, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(Reader param1Reader) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1Reader, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1Reader, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1XMLStreamReader, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(Node param1Node) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1Node, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1Node, STTickLblPos.type, param1XmlOptions);
    }
    
    public static STTickLblPos parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1XMLInputStream, STTickLblPos.type, null);
    }
    
    public static STTickLblPos parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTickLblPos)POIXMLTypeLoader.parse(param1XMLInputStream, STTickLblPos.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTickLblPos.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTickLblPos.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_HIGH = 1;
    
    static final int INT_LOW = 2;
    
    static final int INT_NEXT_TO = 3;
    
    static final int INT_NONE = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("high", 1), new Enum("low", 2), new Enum("nextTo", 3), new Enum("none", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STTickLblPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */