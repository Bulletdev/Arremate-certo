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

public interface STHdrFtr extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHdrFtr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthdrftr30catype");
  
  public static final Enum EVEN = Enum.forString("even");
  
  public static final Enum DEFAULT = Enum.forString("default");
  
  public static final Enum FIRST = Enum.forString("first");
  
  public static final int INT_EVEN = 1;
  
  public static final int INT_DEFAULT = 2;
  
  public static final int INT_FIRST = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STHdrFtr newValue(Object param1Object) {
      return (STHdrFtr)STHdrFtr.type.newValue(param1Object);
    }
    
    public static STHdrFtr newInstance() {
      return (STHdrFtr)POIXMLTypeLoader.newInstance(STHdrFtr.type, null);
    }
    
    public static STHdrFtr newInstance(XmlOptions param1XmlOptions) {
      return (STHdrFtr)POIXMLTypeLoader.newInstance(STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(String param1String) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1String, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1String, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(File param1File) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1File, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1File, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(URL param1URL) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1URL, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1URL, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1InputStream, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1InputStream, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(Reader param1Reader) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1Reader, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1Reader, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1XMLStreamReader, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1XMLStreamReader, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(Node param1Node) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1Node, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1Node, STHdrFtr.type, param1XmlOptions);
    }
    
    public static STHdrFtr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1XMLInputStream, STHdrFtr.type, null);
    }
    
    public static STHdrFtr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHdrFtr)POIXMLTypeLoader.parse(param1XMLInputStream, STHdrFtr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHdrFtr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHdrFtr.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_EVEN = 1;
    
    static final int INT_DEFAULT = 2;
    
    static final int INT_FIRST = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("even", 1), new Enum("default", 2), new Enum("first", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHdrFtr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */