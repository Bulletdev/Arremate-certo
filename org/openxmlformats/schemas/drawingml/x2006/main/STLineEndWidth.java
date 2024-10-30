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

public interface STLineEndWidth extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLineEndWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlineendwidth16aatype");
  
  public static final Enum SM = Enum.forString("sm");
  
  public static final Enum MED = Enum.forString("med");
  
  public static final Enum LG = Enum.forString("lg");
  
  public static final int INT_SM = 1;
  
  public static final int INT_MED = 2;
  
  public static final int INT_LG = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLineEndWidth newValue(Object param1Object) {
      return (STLineEndWidth)STLineEndWidth.type.newValue(param1Object);
    }
    
    public static STLineEndWidth newInstance() {
      return (STLineEndWidth)POIXMLTypeLoader.newInstance(STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth newInstance(XmlOptions param1XmlOptions) {
      return (STLineEndWidth)POIXMLTypeLoader.newInstance(STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(String param1String) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1String, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1String, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(File param1File) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1File, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1File, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(URL param1URL) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1URL, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1URL, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1InputStream, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1InputStream, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(Reader param1Reader) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1Reader, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1Reader, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(Node param1Node) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1Node, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1Node, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static STLineEndWidth parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1XMLInputStream, STLineEndWidth.type, null);
    }
    
    public static STLineEndWidth parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLineEndWidth)POIXMLTypeLoader.parse(param1XMLInputStream, STLineEndWidth.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineEndWidth.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineEndWidth.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SM = 1;
    
    static final int INT_MED = 2;
    
    static final int INT_LG = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("sm", 1), new Enum("med", 2), new Enum("lg", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STLineEndWidth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */