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

public interface STTextVerticalType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextVerticalType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextverticaltyped988type");
  
  public static final Enum HORZ = Enum.forString("horz");
  
  public static final Enum VERT = Enum.forString("vert");
  
  public static final Enum VERT_270 = Enum.forString("vert270");
  
  public static final Enum WORD_ART_VERT = Enum.forString("wordArtVert");
  
  public static final Enum EA_VERT = Enum.forString("eaVert");
  
  public static final Enum MONGOLIAN_VERT = Enum.forString("mongolianVert");
  
  public static final Enum WORD_ART_VERT_RTL = Enum.forString("wordArtVertRtl");
  
  public static final int INT_HORZ = 1;
  
  public static final int INT_VERT = 2;
  
  public static final int INT_VERT_270 = 3;
  
  public static final int INT_WORD_ART_VERT = 4;
  
  public static final int INT_EA_VERT = 5;
  
  public static final int INT_MONGOLIAN_VERT = 6;
  
  public static final int INT_WORD_ART_VERT_RTL = 7;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextVerticalType newValue(Object param1Object) {
      return (STTextVerticalType)STTextVerticalType.type.newValue(param1Object);
    }
    
    public static STTextVerticalType newInstance() {
      return (STTextVerticalType)POIXMLTypeLoader.newInstance(STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType newInstance(XmlOptions param1XmlOptions) {
      return (STTextVerticalType)POIXMLTypeLoader.newInstance(STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(String param1String) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1String, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1String, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(File param1File) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1File, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1File, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(URL param1URL) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1URL, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1URL, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1InputStream, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1InputStream, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1Reader, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1Reader, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(Node param1Node) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1Node, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1Node, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static STTextVerticalType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextVerticalType.type, null);
    }
    
    public static STTextVerticalType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextVerticalType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextVerticalType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextVerticalType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextVerticalType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_HORZ = 1;
    
    static final int INT_VERT = 2;
    
    static final int INT_VERT_270 = 3;
    
    static final int INT_WORD_ART_VERT = 4;
    
    static final int INT_EA_VERT = 5;
    
    static final int INT_MONGOLIAN_VERT = 6;
    
    static final int INT_WORD_ART_VERT_RTL = 7;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("horz", 1), new Enum("vert", 2), new Enum("vert270", 3), new Enum("wordArtVert", 4), new Enum("eaVert", 5), new Enum("mongolianVert", 6), new Enum("wordArtVertRtl", 7) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextVerticalType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */