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

public interface STFtnEdn extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFtnEdn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stftnednd4c9type");
  
  public static final Enum NORMAL = Enum.forString("normal");
  
  public static final Enum SEPARATOR = Enum.forString("separator");
  
  public static final Enum CONTINUATION_SEPARATOR = Enum.forString("continuationSeparator");
  
  public static final Enum CONTINUATION_NOTICE = Enum.forString("continuationNotice");
  
  public static final int INT_NORMAL = 1;
  
  public static final int INT_SEPARATOR = 2;
  
  public static final int INT_CONTINUATION_SEPARATOR = 3;
  
  public static final int INT_CONTINUATION_NOTICE = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STFtnEdn newValue(Object param1Object) {
      return (STFtnEdn)STFtnEdn.type.newValue(param1Object);
    }
    
    public static STFtnEdn newInstance() {
      return (STFtnEdn)POIXMLTypeLoader.newInstance(STFtnEdn.type, null);
    }
    
    public static STFtnEdn newInstance(XmlOptions param1XmlOptions) {
      return (STFtnEdn)POIXMLTypeLoader.newInstance(STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(String param1String) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1String, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1String, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(File param1File) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1File, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1File, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(URL param1URL) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1URL, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1URL, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1InputStream, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1InputStream, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(Reader param1Reader) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1Reader, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1Reader, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1XMLStreamReader, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1XMLStreamReader, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(Node param1Node) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1Node, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1Node, STFtnEdn.type, param1XmlOptions);
    }
    
    public static STFtnEdn parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1XMLInputStream, STFtnEdn.type, null);
    }
    
    public static STFtnEdn parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFtnEdn)POIXMLTypeLoader.parse(param1XMLInputStream, STFtnEdn.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFtnEdn.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFtnEdn.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NORMAL = 1;
    
    static final int INT_SEPARATOR = 2;
    
    static final int INT_CONTINUATION_SEPARATOR = 3;
    
    static final int INT_CONTINUATION_NOTICE = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("normal", 1), new Enum("separator", 2), new Enum("continuationSeparator", 3), new Enum("continuationNotice", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STFtnEdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */