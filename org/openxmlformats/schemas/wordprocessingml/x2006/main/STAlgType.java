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

public interface STAlgType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAlgType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stalgtype156ctype");
  
  public static final Enum TYPE_ANY = Enum.forString("typeAny");
  
  public static final int INT_TYPE_ANY = 1;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STAlgType newValue(Object param1Object) {
      return (STAlgType)STAlgType.type.newValue(param1Object);
    }
    
    public static STAlgType newInstance() {
      return (STAlgType)POIXMLTypeLoader.newInstance(STAlgType.type, null);
    }
    
    public static STAlgType newInstance(XmlOptions param1XmlOptions) {
      return (STAlgType)POIXMLTypeLoader.newInstance(STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(String param1String) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1String, STAlgType.type, null);
    }
    
    public static STAlgType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1String, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(File param1File) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1File, STAlgType.type, null);
    }
    
    public static STAlgType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1File, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(URL param1URL) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1URL, STAlgType.type, null);
    }
    
    public static STAlgType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1URL, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1InputStream, STAlgType.type, null);
    }
    
    public static STAlgType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1InputStream, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(Reader param1Reader) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1Reader, STAlgType.type, null);
    }
    
    public static STAlgType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgType)POIXMLTypeLoader.parse(param1Reader, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1XMLStreamReader, STAlgType.type, null);
    }
    
    public static STAlgType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1XMLStreamReader, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(Node param1Node) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1Node, STAlgType.type, null);
    }
    
    public static STAlgType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgType)POIXMLTypeLoader.parse(param1Node, STAlgType.type, param1XmlOptions);
    }
    
    public static STAlgType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAlgType)POIXMLTypeLoader.parse(param1XMLInputStream, STAlgType.type, null);
    }
    
    public static STAlgType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAlgType)POIXMLTypeLoader.parse(param1XMLInputStream, STAlgType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAlgType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAlgType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TYPE_ANY = 1;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("typeAny", 1) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STAlgType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */