package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface STTabTlc extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTabTlc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttabtlc6f42type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum DOT = Enum.forString("dot");
  
  public static final Enum HYPHEN = Enum.forString("hyphen");
  
  public static final Enum UNDERSCORE = Enum.forString("underscore");
  
  public static final Enum HEAVY = Enum.forString("heavy");
  
  public static final Enum MIDDLE_DOT = Enum.forString("middleDot");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_DOT = 2;
  
  public static final int INT_HYPHEN = 3;
  
  public static final int INT_UNDERSCORE = 4;
  
  public static final int INT_HEAVY = 5;
  
  public static final int INT_MIDDLE_DOT = 6;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTabTlc newValue(Object param1Object) {
      return (STTabTlc)STTabTlc.type.newValue(param1Object);
    }
    
    public static STTabTlc newInstance() {
      return (STTabTlc)POIXMLTypeLoader.newInstance(STTabTlc.type, null);
    }
    
    public static STTabTlc newInstance(XmlOptions param1XmlOptions) {
      return (STTabTlc)POIXMLTypeLoader.newInstance(STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(String param1String) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1String, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1String, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(File param1File) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1File, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1File, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(URL param1URL) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1URL, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1URL, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1InputStream, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1InputStream, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(Reader param1Reader) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1Reader, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1Reader, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1XMLStreamReader, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1XMLStreamReader, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(Node param1Node) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1Node, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1Node, STTabTlc.type, param1XmlOptions);
    }
    
    public static STTabTlc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1XMLInputStream, STTabTlc.type, null);
    }
    
    public static STTabTlc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTabTlc)POIXMLTypeLoader.parse(param1XMLInputStream, STTabTlc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTabTlc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTabTlc.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_DOT = 2;
    
    static final int INT_HYPHEN = 3;
    
    static final int INT_UNDERSCORE = 4;
    
    static final int INT_HEAVY = 5;
    
    static final int INT_MIDDLE_DOT = 6;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("dot", 2), new Enum("hyphen", 3), new Enum("underscore", 4), new Enum("heavy", 5), new Enum("middleDot", 6) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STTabTlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */