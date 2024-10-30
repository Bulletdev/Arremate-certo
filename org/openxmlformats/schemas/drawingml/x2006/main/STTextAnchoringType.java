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

public interface STTextAnchoringType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextAnchoringType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextanchoringtyped99btype");
  
  public static final Enum T = Enum.forString("t");
  
  public static final Enum CTR = Enum.forString("ctr");
  
  public static final Enum B = Enum.forString("b");
  
  public static final Enum JUST = Enum.forString("just");
  
  public static final Enum DIST = Enum.forString("dist");
  
  public static final int INT_T = 1;
  
  public static final int INT_CTR = 2;
  
  public static final int INT_B = 3;
  
  public static final int INT_JUST = 4;
  
  public static final int INT_DIST = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextAnchoringType newValue(Object param1Object) {
      return (STTextAnchoringType)STTextAnchoringType.type.newValue(param1Object);
    }
    
    public static STTextAnchoringType newInstance() {
      return (STTextAnchoringType)POIXMLTypeLoader.newInstance(STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType newInstance(XmlOptions param1XmlOptions) {
      return (STTextAnchoringType)POIXMLTypeLoader.newInstance(STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(String param1String) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1String, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1String, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(File param1File) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1File, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1File, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(URL param1URL) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1URL, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1URL, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1InputStream, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1InputStream, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1Reader, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1Reader, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(Node param1Node) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1Node, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1Node, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static STTextAnchoringType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextAnchoringType.type, null);
    }
    
    public static STTextAnchoringType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextAnchoringType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextAnchoringType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextAnchoringType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextAnchoringType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_T = 1;
    
    static final int INT_CTR = 2;
    
    static final int INT_B = 3;
    
    static final int INT_JUST = 4;
    
    static final int INT_DIST = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("t", 1), new Enum("ctr", 2), new Enum("b", 3), new Enum("just", 4), new Enum("dist", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextAnchoringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */