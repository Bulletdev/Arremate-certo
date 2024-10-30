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

public interface STAlgClass extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAlgClass.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stalgclass061ctype");
  
  public static final Enum HASH = Enum.forString("hash");
  
  public static final int INT_HASH = 1;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STAlgClass newValue(Object param1Object) {
      return (STAlgClass)STAlgClass.type.newValue(param1Object);
    }
    
    public static STAlgClass newInstance() {
      return (STAlgClass)POIXMLTypeLoader.newInstance(STAlgClass.type, null);
    }
    
    public static STAlgClass newInstance(XmlOptions param1XmlOptions) {
      return (STAlgClass)POIXMLTypeLoader.newInstance(STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(String param1String) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1String, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1String, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(File param1File) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1File, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1File, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(URL param1URL) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1URL, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1URL, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1InputStream, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1InputStream, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(Reader param1Reader) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1Reader, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1Reader, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1XMLStreamReader, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1XMLStreamReader, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(Node param1Node) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1Node, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1Node, STAlgClass.type, param1XmlOptions);
    }
    
    public static STAlgClass parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1XMLInputStream, STAlgClass.type, null);
    }
    
    public static STAlgClass parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAlgClass)POIXMLTypeLoader.parse(param1XMLInputStream, STAlgClass.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAlgClass.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAlgClass.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_HASH = 1;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("hash", 1) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STAlgClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */