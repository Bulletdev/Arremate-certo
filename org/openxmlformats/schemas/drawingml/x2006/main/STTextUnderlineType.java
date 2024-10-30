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

public interface STTextUnderlineType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextUnderlineType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextunderlinetype469atype");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum WORDS = Enum.forString("words");
  
  public static final Enum SNG = Enum.forString("sng");
  
  public static final Enum DBL = Enum.forString("dbl");
  
  public static final Enum HEAVY = Enum.forString("heavy");
  
  public static final Enum DOTTED = Enum.forString("dotted");
  
  public static final Enum DOTTED_HEAVY = Enum.forString("dottedHeavy");
  
  public static final Enum DASH = Enum.forString("dash");
  
  public static final Enum DASH_HEAVY = Enum.forString("dashHeavy");
  
  public static final Enum DASH_LONG = Enum.forString("dashLong");
  
  public static final Enum DASH_LONG_HEAVY = Enum.forString("dashLongHeavy");
  
  public static final Enum DOT_DASH = Enum.forString("dotDash");
  
  public static final Enum DOT_DASH_HEAVY = Enum.forString("dotDashHeavy");
  
  public static final Enum DOT_DOT_DASH = Enum.forString("dotDotDash");
  
  public static final Enum DOT_DOT_DASH_HEAVY = Enum.forString("dotDotDashHeavy");
  
  public static final Enum WAVY = Enum.forString("wavy");
  
  public static final Enum WAVY_HEAVY = Enum.forString("wavyHeavy");
  
  public static final Enum WAVY_DBL = Enum.forString("wavyDbl");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_WORDS = 2;
  
  public static final int INT_SNG = 3;
  
  public static final int INT_DBL = 4;
  
  public static final int INT_HEAVY = 5;
  
  public static final int INT_DOTTED = 6;
  
  public static final int INT_DOTTED_HEAVY = 7;
  
  public static final int INT_DASH = 8;
  
  public static final int INT_DASH_HEAVY = 9;
  
  public static final int INT_DASH_LONG = 10;
  
  public static final int INT_DASH_LONG_HEAVY = 11;
  
  public static final int INT_DOT_DASH = 12;
  
  public static final int INT_DOT_DASH_HEAVY = 13;
  
  public static final int INT_DOT_DOT_DASH = 14;
  
  public static final int INT_DOT_DOT_DASH_HEAVY = 15;
  
  public static final int INT_WAVY = 16;
  
  public static final int INT_WAVY_HEAVY = 17;
  
  public static final int INT_WAVY_DBL = 18;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextUnderlineType newValue(Object param1Object) {
      return (STTextUnderlineType)STTextUnderlineType.type.newValue(param1Object);
    }
    
    public static STTextUnderlineType newInstance() {
      return (STTextUnderlineType)POIXMLTypeLoader.newInstance(STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType newInstance(XmlOptions param1XmlOptions) {
      return (STTextUnderlineType)POIXMLTypeLoader.newInstance(STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(String param1String) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1String, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1String, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(File param1File) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1File, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1File, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(URL param1URL) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1URL, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1URL, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1InputStream, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1InputStream, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1Reader, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1Reader, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(Node param1Node) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1Node, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1Node, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static STTextUnderlineType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextUnderlineType.type, null);
    }
    
    public static STTextUnderlineType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextUnderlineType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextUnderlineType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextUnderlineType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextUnderlineType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_WORDS = 2;
    
    static final int INT_SNG = 3;
    
    static final int INT_DBL = 4;
    
    static final int INT_HEAVY = 5;
    
    static final int INT_DOTTED = 6;
    
    static final int INT_DOTTED_HEAVY = 7;
    
    static final int INT_DASH = 8;
    
    static final int INT_DASH_HEAVY = 9;
    
    static final int INT_DASH_LONG = 10;
    
    static final int INT_DASH_LONG_HEAVY = 11;
    
    static final int INT_DOT_DASH = 12;
    
    static final int INT_DOT_DASH_HEAVY = 13;
    
    static final int INT_DOT_DOT_DASH = 14;
    
    static final int INT_DOT_DOT_DASH_HEAVY = 15;
    
    static final int INT_WAVY = 16;
    
    static final int INT_WAVY_HEAVY = 17;
    
    static final int INT_WAVY_DBL = 18;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("none", 1), new Enum("words", 2), new Enum("sng", 3), new Enum("dbl", 4), new Enum("heavy", 5), new Enum("dotted", 6), new Enum("dottedHeavy", 7), new Enum("dash", 8), new Enum("dashHeavy", 9), new Enum("dashLong", 10), 
          new Enum("dashLongHeavy", 11), new Enum("dotDash", 12), new Enum("dotDashHeavy", 13), new Enum("dotDotDash", 14), new Enum("dotDotDashHeavy", 15), new Enum("wavy", 16), new Enum("wavyHeavy", 17), new Enum("wavyDbl", 18) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextUnderlineType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */