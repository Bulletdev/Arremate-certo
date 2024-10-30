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

public interface STTabJc extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTabJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttabjc10f4type");
  
  public static final Enum CLEAR = Enum.forString("clear");
  
  public static final Enum LEFT = Enum.forString("left");
  
  public static final Enum CENTER = Enum.forString("center");
  
  public static final Enum RIGHT = Enum.forString("right");
  
  public static final Enum DECIMAL = Enum.forString("decimal");
  
  public static final Enum BAR = Enum.forString("bar");
  
  public static final Enum NUM = Enum.forString("num");
  
  public static final int INT_CLEAR = 1;
  
  public static final int INT_LEFT = 2;
  
  public static final int INT_CENTER = 3;
  
  public static final int INT_RIGHT = 4;
  
  public static final int INT_DECIMAL = 5;
  
  public static final int INT_BAR = 6;
  
  public static final int INT_NUM = 7;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTabJc newValue(Object param1Object) {
      return (STTabJc)STTabJc.type.newValue(param1Object);
    }
    
    public static STTabJc newInstance() {
      return (STTabJc)POIXMLTypeLoader.newInstance(STTabJc.type, null);
    }
    
    public static STTabJc newInstance(XmlOptions param1XmlOptions) {
      return (STTabJc)POIXMLTypeLoader.newInstance(STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(String param1String) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1String, STTabJc.type, null);
    }
    
    public static STTabJc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1String, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(File param1File) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1File, STTabJc.type, null);
    }
    
    public static STTabJc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1File, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(URL param1URL) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1URL, STTabJc.type, null);
    }
    
    public static STTabJc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1URL, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1InputStream, STTabJc.type, null);
    }
    
    public static STTabJc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1InputStream, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(Reader param1Reader) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1Reader, STTabJc.type, null);
    }
    
    public static STTabJc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTabJc)POIXMLTypeLoader.parse(param1Reader, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STTabJc.type, null);
    }
    
    public static STTabJc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1XMLStreamReader, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(Node param1Node) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1Node, STTabJc.type, null);
    }
    
    public static STTabJc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTabJc)POIXMLTypeLoader.parse(param1Node, STTabJc.type, param1XmlOptions);
    }
    
    public static STTabJc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTabJc)POIXMLTypeLoader.parse(param1XMLInputStream, STTabJc.type, null);
    }
    
    public static STTabJc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTabJc)POIXMLTypeLoader.parse(param1XMLInputStream, STTabJc.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTabJc.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTabJc.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CLEAR = 1;
    
    static final int INT_LEFT = 2;
    
    static final int INT_CENTER = 3;
    
    static final int INT_RIGHT = 4;
    
    static final int INT_DECIMAL = 5;
    
    static final int INT_BAR = 6;
    
    static final int INT_NUM = 7;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("clear", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("decimal", 5), new Enum("bar", 6), new Enum("num", 7) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STTabJc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */