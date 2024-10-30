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

public interface STHexColorAuto extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHexColorAuto.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexcolorauto3ce1type");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final int INT_AUTO = 1;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STHexColorAuto newValue(Object param1Object) {
      return (STHexColorAuto)STHexColorAuto.type.newValue(param1Object);
    }
    
    public static STHexColorAuto newInstance() {
      return (STHexColorAuto)POIXMLTypeLoader.newInstance(STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto newInstance(XmlOptions param1XmlOptions) {
      return (STHexColorAuto)POIXMLTypeLoader.newInstance(STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(String param1String) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1String, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1String, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(File param1File) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1File, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1File, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(URL param1URL) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1URL, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1URL, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1InputStream, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1InputStream, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(Reader param1Reader) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1Reader, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1Reader, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1XMLStreamReader, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(Node param1Node) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1Node, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1Node, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static STHexColorAuto parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColorAuto.type, null);
    }
    
    public static STHexColorAuto parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHexColorAuto)POIXMLTypeLoader.parse(param1XMLInputStream, STHexColorAuto.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColorAuto.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHexColorAuto.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AUTO = 1;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("auto", 1) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHexColorAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */