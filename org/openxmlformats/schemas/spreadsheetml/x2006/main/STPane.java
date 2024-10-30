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

public interface STPane extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPane.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpane2ac1type");
  
  public static final Enum BOTTOM_RIGHT = Enum.forString("bottomRight");
  
  public static final Enum TOP_RIGHT = Enum.forString("topRight");
  
  public static final Enum BOTTOM_LEFT = Enum.forString("bottomLeft");
  
  public static final Enum TOP_LEFT = Enum.forString("topLeft");
  
  public static final int INT_BOTTOM_RIGHT = 1;
  
  public static final int INT_TOP_RIGHT = 2;
  
  public static final int INT_BOTTOM_LEFT = 3;
  
  public static final int INT_TOP_LEFT = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPane newValue(Object param1Object) {
      return (STPane)STPane.type.newValue(param1Object);
    }
    
    public static STPane newInstance() {
      return (STPane)POIXMLTypeLoader.newInstance(STPane.type, null);
    }
    
    public static STPane newInstance(XmlOptions param1XmlOptions) {
      return (STPane)POIXMLTypeLoader.newInstance(STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(String param1String) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1String, STPane.type, null);
    }
    
    public static STPane parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1String, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(File param1File) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1File, STPane.type, null);
    }
    
    public static STPane parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1File, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(URL param1URL) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1URL, STPane.type, null);
    }
    
    public static STPane parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1URL, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1InputStream, STPane.type, null);
    }
    
    public static STPane parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1InputStream, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(Reader param1Reader) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1Reader, STPane.type, null);
    }
    
    public static STPane parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPane)POIXMLTypeLoader.parse(param1Reader, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1XMLStreamReader, STPane.type, null);
    }
    
    public static STPane parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1XMLStreamReader, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(Node param1Node) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1Node, STPane.type, null);
    }
    
    public static STPane parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPane)POIXMLTypeLoader.parse(param1Node, STPane.type, param1XmlOptions);
    }
    
    public static STPane parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPane)POIXMLTypeLoader.parse(param1XMLInputStream, STPane.type, null);
    }
    
    public static STPane parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPane)POIXMLTypeLoader.parse(param1XMLInputStream, STPane.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPane.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPane.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BOTTOM_RIGHT = 1;
    
    static final int INT_TOP_RIGHT = 2;
    
    static final int INT_BOTTOM_LEFT = 3;
    
    static final int INT_TOP_LEFT = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("bottomRight", 1), new Enum("topRight", 2), new Enum("bottomLeft", 3), new Enum("topLeft", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STPane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */