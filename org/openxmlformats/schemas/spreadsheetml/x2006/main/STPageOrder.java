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

public interface STPageOrder extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPageOrder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpageorderd2cetype");
  
  public static final Enum DOWN_THEN_OVER = Enum.forString("downThenOver");
  
  public static final Enum OVER_THEN_DOWN = Enum.forString("overThenDown");
  
  public static final int INT_DOWN_THEN_OVER = 1;
  
  public static final int INT_OVER_THEN_DOWN = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPageOrder newValue(Object param1Object) {
      return (STPageOrder)STPageOrder.type.newValue(param1Object);
    }
    
    public static STPageOrder newInstance() {
      return (STPageOrder)POIXMLTypeLoader.newInstance(STPageOrder.type, null);
    }
    
    public static STPageOrder newInstance(XmlOptions param1XmlOptions) {
      return (STPageOrder)POIXMLTypeLoader.newInstance(STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(String param1String) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1String, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1String, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(File param1File) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1File, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1File, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(URL param1URL) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1URL, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1URL, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1InputStream, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1InputStream, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(Reader param1Reader) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1Reader, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1Reader, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1XMLStreamReader, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1XMLStreamReader, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(Node param1Node) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1Node, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1Node, STPageOrder.type, param1XmlOptions);
    }
    
    public static STPageOrder parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1XMLInputStream, STPageOrder.type, null);
    }
    
    public static STPageOrder parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPageOrder)POIXMLTypeLoader.parse(param1XMLInputStream, STPageOrder.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPageOrder.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPageOrder.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_DOWN_THEN_OVER = 1;
    
    static final int INT_OVER_THEN_DOWN = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("downThenOver", 1), new Enum("overThenDown", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STPageOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */