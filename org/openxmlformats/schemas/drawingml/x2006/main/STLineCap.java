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

public interface STLineCap extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLineCap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlinecapcddftype");
  
  public static final Enum RND = Enum.forString("rnd");
  
  public static final Enum SQ = Enum.forString("sq");
  
  public static final Enum FLAT = Enum.forString("flat");
  
  public static final int INT_RND = 1;
  
  public static final int INT_SQ = 2;
  
  public static final int INT_FLAT = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLineCap newValue(Object param1Object) {
      return (STLineCap)STLineCap.type.newValue(param1Object);
    }
    
    public static STLineCap newInstance() {
      return (STLineCap)POIXMLTypeLoader.newInstance(STLineCap.type, null);
    }
    
    public static STLineCap newInstance(XmlOptions param1XmlOptions) {
      return (STLineCap)POIXMLTypeLoader.newInstance(STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(String param1String) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1String, STLineCap.type, null);
    }
    
    public static STLineCap parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1String, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(File param1File) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1File, STLineCap.type, null);
    }
    
    public static STLineCap parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1File, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(URL param1URL) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1URL, STLineCap.type, null);
    }
    
    public static STLineCap parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1URL, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1InputStream, STLineCap.type, null);
    }
    
    public static STLineCap parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1InputStream, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(Reader param1Reader) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1Reader, STLineCap.type, null);
    }
    
    public static STLineCap parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineCap)POIXMLTypeLoader.parse(param1Reader, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineCap.type, null);
    }
    
    public static STLineCap parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(Node param1Node) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1Node, STLineCap.type, null);
    }
    
    public static STLineCap parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineCap)POIXMLTypeLoader.parse(param1Node, STLineCap.type, param1XmlOptions);
    }
    
    public static STLineCap parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLineCap)POIXMLTypeLoader.parse(param1XMLInputStream, STLineCap.type, null);
    }
    
    public static STLineCap parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLineCap)POIXMLTypeLoader.parse(param1XMLInputStream, STLineCap.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineCap.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineCap.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_RND = 1;
    
    static final int INT_SQ = 2;
    
    static final int INT_FLAT = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("rnd", 1), new Enum("sq", 2), new Enum("flat", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STLineCap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */