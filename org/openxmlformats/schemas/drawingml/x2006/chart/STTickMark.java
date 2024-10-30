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

public interface STTickMark extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTickMark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttickmark69e2type");
  
  public static final Enum CROSS = Enum.forString("cross");
  
  public static final Enum IN = Enum.forString("in");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum OUT = Enum.forString("out");
  
  public static final int INT_CROSS = 1;
  
  public static final int INT_IN = 2;
  
  public static final int INT_NONE = 3;
  
  public static final int INT_OUT = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTickMark newValue(Object param1Object) {
      return (STTickMark)STTickMark.type.newValue(param1Object);
    }
    
    public static STTickMark newInstance() {
      return (STTickMark)POIXMLTypeLoader.newInstance(STTickMark.type, null);
    }
    
    public static STTickMark newInstance(XmlOptions param1XmlOptions) {
      return (STTickMark)POIXMLTypeLoader.newInstance(STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(String param1String) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1String, STTickMark.type, null);
    }
    
    public static STTickMark parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1String, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(File param1File) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1File, STTickMark.type, null);
    }
    
    public static STTickMark parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1File, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(URL param1URL) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1URL, STTickMark.type, null);
    }
    
    public static STTickMark parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1URL, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1InputStream, STTickMark.type, null);
    }
    
    public static STTickMark parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1InputStream, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(Reader param1Reader) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1Reader, STTickMark.type, null);
    }
    
    public static STTickMark parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTickMark)POIXMLTypeLoader.parse(param1Reader, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1XMLStreamReader, STTickMark.type, null);
    }
    
    public static STTickMark parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1XMLStreamReader, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(Node param1Node) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1Node, STTickMark.type, null);
    }
    
    public static STTickMark parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTickMark)POIXMLTypeLoader.parse(param1Node, STTickMark.type, param1XmlOptions);
    }
    
    public static STTickMark parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTickMark)POIXMLTypeLoader.parse(param1XMLInputStream, STTickMark.type, null);
    }
    
    public static STTickMark parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTickMark)POIXMLTypeLoader.parse(param1XMLInputStream, STTickMark.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTickMark.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTickMark.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CROSS = 1;
    
    static final int INT_IN = 2;
    
    static final int INT_NONE = 3;
    
    static final int INT_OUT = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("cross", 1), new Enum("in", 2), new Enum("none", 3), new Enum("out", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STTickMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */