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

public interface STHighlightColor extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHighlightColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthighlightcolora8e9type");
  
  public static final Enum BLACK = Enum.forString("black");
  
  public static final Enum BLUE = Enum.forString("blue");
  
  public static final Enum CYAN = Enum.forString("cyan");
  
  public static final Enum GREEN = Enum.forString("green");
  
  public static final Enum MAGENTA = Enum.forString("magenta");
  
  public static final Enum RED = Enum.forString("red");
  
  public static final Enum YELLOW = Enum.forString("yellow");
  
  public static final Enum WHITE = Enum.forString("white");
  
  public static final Enum DARK_BLUE = Enum.forString("darkBlue");
  
  public static final Enum DARK_CYAN = Enum.forString("darkCyan");
  
  public static final Enum DARK_GREEN = Enum.forString("darkGreen");
  
  public static final Enum DARK_MAGENTA = Enum.forString("darkMagenta");
  
  public static final Enum DARK_RED = Enum.forString("darkRed");
  
  public static final Enum DARK_YELLOW = Enum.forString("darkYellow");
  
  public static final Enum DARK_GRAY = Enum.forString("darkGray");
  
  public static final Enum LIGHT_GRAY = Enum.forString("lightGray");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final int INT_BLACK = 1;
  
  public static final int INT_BLUE = 2;
  
  public static final int INT_CYAN = 3;
  
  public static final int INT_GREEN = 4;
  
  public static final int INT_MAGENTA = 5;
  
  public static final int INT_RED = 6;
  
  public static final int INT_YELLOW = 7;
  
  public static final int INT_WHITE = 8;
  
  public static final int INT_DARK_BLUE = 9;
  
  public static final int INT_DARK_CYAN = 10;
  
  public static final int INT_DARK_GREEN = 11;
  
  public static final int INT_DARK_MAGENTA = 12;
  
  public static final int INT_DARK_RED = 13;
  
  public static final int INT_DARK_YELLOW = 14;
  
  public static final int INT_DARK_GRAY = 15;
  
  public static final int INT_LIGHT_GRAY = 16;
  
  public static final int INT_NONE = 17;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STHighlightColor newValue(Object param1Object) {
      return (STHighlightColor)STHighlightColor.type.newValue(param1Object);
    }
    
    public static STHighlightColor newInstance() {
      return (STHighlightColor)POIXMLTypeLoader.newInstance(STHighlightColor.type, null);
    }
    
    public static STHighlightColor newInstance(XmlOptions param1XmlOptions) {
      return (STHighlightColor)POIXMLTypeLoader.newInstance(STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(String param1String) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1String, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1String, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(File param1File) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1File, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1File, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(URL param1URL) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1URL, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1URL, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1InputStream, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1InputStream, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(Reader param1Reader) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1Reader, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1Reader, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1XMLStreamReader, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1XMLStreamReader, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(Node param1Node) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1Node, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1Node, STHighlightColor.type, param1XmlOptions);
    }
    
    public static STHighlightColor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1XMLInputStream, STHighlightColor.type, null);
    }
    
    public static STHighlightColor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHighlightColor)POIXMLTypeLoader.parse(param1XMLInputStream, STHighlightColor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHighlightColor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHighlightColor.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BLACK = 1;
    
    static final int INT_BLUE = 2;
    
    static final int INT_CYAN = 3;
    
    static final int INT_GREEN = 4;
    
    static final int INT_MAGENTA = 5;
    
    static final int INT_RED = 6;
    
    static final int INT_YELLOW = 7;
    
    static final int INT_WHITE = 8;
    
    static final int INT_DARK_BLUE = 9;
    
    static final int INT_DARK_CYAN = 10;
    
    static final int INT_DARK_GREEN = 11;
    
    static final int INT_DARK_MAGENTA = 12;
    
    static final int INT_DARK_RED = 13;
    
    static final int INT_DARK_YELLOW = 14;
    
    static final int INT_DARK_GRAY = 15;
    
    static final int INT_LIGHT_GRAY = 16;
    
    static final int INT_NONE = 17;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("black", 1), new Enum("blue", 2), new Enum("cyan", 3), new Enum("green", 4), new Enum("magenta", 5), new Enum("red", 6), new Enum("yellow", 7), new Enum("white", 8), new Enum("darkBlue", 9), new Enum("darkCyan", 10), 
          new Enum("darkGreen", 11), new Enum("darkMagenta", 12), new Enum("darkRed", 13), new Enum("darkYellow", 14), new Enum("darkGray", 15), new Enum("lightGray", 16), new Enum("none", 17) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STHighlightColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */