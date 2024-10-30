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

public interface STTextAlignType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextAlignType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextaligntypebc93type");
  
  public static final Enum L = Enum.forString("l");
  
  public static final Enum CTR = Enum.forString("ctr");
  
  public static final Enum R = Enum.forString("r");
  
  public static final Enum JUST = Enum.forString("just");
  
  public static final Enum JUST_LOW = Enum.forString("justLow");
  
  public static final Enum DIST = Enum.forString("dist");
  
  public static final Enum THAI_DIST = Enum.forString("thaiDist");
  
  public static final int INT_L = 1;
  
  public static final int INT_CTR = 2;
  
  public static final int INT_R = 3;
  
  public static final int INT_JUST = 4;
  
  public static final int INT_JUST_LOW = 5;
  
  public static final int INT_DIST = 6;
  
  public static final int INT_THAI_DIST = 7;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextAlignType newValue(Object param1Object) {
      return (STTextAlignType)STTextAlignType.type.newValue(param1Object);
    }
    
    public static STTextAlignType newInstance() {
      return (STTextAlignType)POIXMLTypeLoader.newInstance(STTextAlignType.type, null);
    }
    
    public static STTextAlignType newInstance(XmlOptions param1XmlOptions) {
      return (STTextAlignType)POIXMLTypeLoader.newInstance(STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(String param1String) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1String, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1String, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(File param1File) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1File, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1File, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(URL param1URL) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1URL, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1URL, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1InputStream, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1InputStream, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1Reader, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1Reader, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(Node param1Node) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1Node, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1Node, STTextAlignType.type, param1XmlOptions);
    }
    
    public static STTextAlignType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextAlignType.type, null);
    }
    
    public static STTextAlignType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextAlignType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextAlignType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextAlignType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextAlignType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_L = 1;
    
    static final int INT_CTR = 2;
    
    static final int INT_R = 3;
    
    static final int INT_JUST = 4;
    
    static final int INT_JUST_LOW = 5;
    
    static final int INT_DIST = 6;
    
    static final int INT_THAI_DIST = 7;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("l", 1), new Enum("ctr", 2), new Enum("r", 3), new Enum("just", 4), new Enum("justLow", 5), new Enum("dist", 6), new Enum("thaiDist", 7) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextAlignType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */