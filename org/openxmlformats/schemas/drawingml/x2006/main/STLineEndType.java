package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STLineEndType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLineEndType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlineendtype8902type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum TRIANGLE = Enum.forString("triangle");
  
  public static final Enum STEALTH = Enum.forString("stealth");
  
  public static final Enum DIAMOND = Enum.forString("diamond");
  
  public static final Enum OVAL = Enum.forString("oval");
  
  public static final Enum ARROW = Enum.forString("arrow");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_TRIANGLE = 2;
  
  public static final int INT_STEALTH = 3;
  
  public static final int INT_DIAMOND = 4;
  
  public static final int INT_OVAL = 5;
  
  public static final int INT_ARROW = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLineEndType newValue(Object param1Object) {
      return (STLineEndType)STLineEndType.type.newValue(param1Object);
    }
    
    public static STLineEndType newInstance() {
      return (STLineEndType)POIXMLTypeLoader.newInstance(STLineEndType.type, null);
    }
    
    public static STLineEndType newInstance(XmlOptions param1XmlOptions) {
      return (STLineEndType)POIXMLTypeLoader.newInstance(STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(String param1String) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1String, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1String, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(File param1File) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1File, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1File, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(URL param1URL) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1URL, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1URL, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1InputStream, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1InputStream, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(Reader param1Reader) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1Reader, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1Reader, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(Node param1Node) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1Node, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1Node, STLineEndType.type, param1XmlOptions);
    }
    
    public static STLineEndType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1XMLInputStream, STLineEndType.type, null);
    }
    
    public static STLineEndType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLineEndType)POIXMLTypeLoader.parse(param1XMLInputStream, STLineEndType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineEndType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineEndType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_TRIANGLE = 2;
    
    static final int INT_STEALTH = 3;
    
    static final int INT_DIAMOND = 4;
    
    static final int INT_OVAL = 5;
    
    static final int INT_ARROW = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("triangle", 2), new Enum("stealth", 3), new Enum("diamond", 4), new Enum("oval", 5), new Enum("arrow", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STLineEndType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */