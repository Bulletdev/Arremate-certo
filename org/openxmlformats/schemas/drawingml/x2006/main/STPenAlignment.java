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

public interface STPenAlignment extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPenAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpenalignmentd775type");
  
  public static final Enum CTR = Enum.forString("ctr");
  
  public static final Enum IN = Enum.forString("in");
  
  public static final int INT_CTR = 1;
  
  public static final int INT_IN = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPenAlignment newValue(Object param1Object) {
      return (STPenAlignment)STPenAlignment.type.newValue(param1Object);
    }
    
    public static STPenAlignment newInstance() {
      return (STPenAlignment)POIXMLTypeLoader.newInstance(STPenAlignment.type, null);
    }
    
    public static STPenAlignment newInstance(XmlOptions param1XmlOptions) {
      return (STPenAlignment)POIXMLTypeLoader.newInstance(STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(String param1String) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1String, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1String, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(File param1File) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1File, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1File, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(URL param1URL) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1URL, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1URL, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1InputStream, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1InputStream, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(Reader param1Reader) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1Reader, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1Reader, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(Node param1Node) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1Node, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1Node, STPenAlignment.type, param1XmlOptions);
    }
    
    public static STPenAlignment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STPenAlignment.type, null);
    }
    
    public static STPenAlignment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPenAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STPenAlignment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPenAlignment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPenAlignment.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CTR = 1;
    
    static final int INT_IN = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("ctr", 1), new Enum("in", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPenAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */