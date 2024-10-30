package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface STFontScheme extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFontScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfontschemef36dtype");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum MAJOR = Enum.forString("major");
  
  public static final Enum MINOR = Enum.forString("minor");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_MAJOR = 2;
  
  public static final int INT_MINOR = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STFontScheme newValue(Object param1Object) {
      return (STFontScheme)STFontScheme.type.newValue(param1Object);
    }
    
    public static STFontScheme newInstance() {
      return (STFontScheme)POIXMLTypeLoader.newInstance(STFontScheme.type, null);
    }
    
    public static STFontScheme newInstance(XmlOptions param1XmlOptions) {
      return (STFontScheme)POIXMLTypeLoader.newInstance(STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(String param1String) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1String, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1String, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(File param1File) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1File, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1File, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(URL param1URL) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1URL, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1URL, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1InputStream, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1InputStream, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(Reader param1Reader) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1Reader, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1Reader, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(Node param1Node) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1Node, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1Node, STFontScheme.type, param1XmlOptions);
    }
    
    public static STFontScheme parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1XMLInputStream, STFontScheme.type, null);
    }
    
    public static STFontScheme parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFontScheme)POIXMLTypeLoader.parse(param1XMLInputStream, STFontScheme.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontScheme.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontScheme.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_MAJOR = 2;
    
    static final int INT_MINOR = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("major", 2), new Enum("minor", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STFontScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */