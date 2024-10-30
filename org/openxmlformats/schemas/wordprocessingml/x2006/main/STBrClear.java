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

public interface STBrClear extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STBrClear.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stbrclearb1e5type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum LEFT = Enum.forString("left");
  
  public static final Enum RIGHT = Enum.forString("right");
  
  public static final Enum ALL = Enum.forString("all");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_LEFT = 2;
  
  public static final int INT_RIGHT = 3;
  
  public static final int INT_ALL = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STBrClear newValue(Object param1Object) {
      return (STBrClear)STBrClear.type.newValue(param1Object);
    }
    
    public static STBrClear newInstance() {
      return (STBrClear)POIXMLTypeLoader.newInstance(STBrClear.type, null);
    }
    
    public static STBrClear newInstance(XmlOptions param1XmlOptions) {
      return (STBrClear)POIXMLTypeLoader.newInstance(STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(String param1String) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1String, STBrClear.type, null);
    }
    
    public static STBrClear parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1String, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(File param1File) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1File, STBrClear.type, null);
    }
    
    public static STBrClear parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1File, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(URL param1URL) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1URL, STBrClear.type, null);
    }
    
    public static STBrClear parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1URL, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1InputStream, STBrClear.type, null);
    }
    
    public static STBrClear parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1InputStream, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(Reader param1Reader) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1Reader, STBrClear.type, null);
    }
    
    public static STBrClear parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBrClear)POIXMLTypeLoader.parse(param1Reader, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1XMLStreamReader, STBrClear.type, null);
    }
    
    public static STBrClear parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1XMLStreamReader, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(Node param1Node) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1Node, STBrClear.type, null);
    }
    
    public static STBrClear parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STBrClear)POIXMLTypeLoader.parse(param1Node, STBrClear.type, param1XmlOptions);
    }
    
    public static STBrClear parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STBrClear)POIXMLTypeLoader.parse(param1XMLInputStream, STBrClear.type, null);
    }
    
    public static STBrClear parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STBrClear)POIXMLTypeLoader.parse(param1XMLInputStream, STBrClear.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBrClear.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBrClear.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_LEFT = 2;
    
    static final int INT_RIGHT = 3;
    
    static final int INT_ALL = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("left", 2), new Enum("right", 3), new Enum("all", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STBrClear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */