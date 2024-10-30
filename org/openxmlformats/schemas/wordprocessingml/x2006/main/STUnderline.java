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

public interface STUnderline extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STUnderline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunderlinef416type");
  
  public static final Enum SINGLE = Enum.forString("single");
  
  public static final Enum WORDS = Enum.forString("words");
  
  public static final Enum DOUBLE = Enum.forString("double");
  
  public static final Enum THICK = Enum.forString("thick");
  
  public static final Enum DOTTED = Enum.forString("dotted");
  
  public static final Enum DOTTED_HEAVY = Enum.forString("dottedHeavy");
  
  public static final Enum DASH = Enum.forString("dash");
  
  public static final Enum DASHED_HEAVY = Enum.forString("dashedHeavy");
  
  public static final Enum DASH_LONG = Enum.forString("dashLong");
  
  public static final Enum DASH_LONG_HEAVY = Enum.forString("dashLongHeavy");
  
  public static final Enum DOT_DASH = Enum.forString("dotDash");
  
  public static final Enum DASH_DOT_HEAVY = Enum.forString("dashDotHeavy");
  
  public static final Enum DOT_DOT_DASH = Enum.forString("dotDotDash");
  
  public static final Enum DASH_DOT_DOT_HEAVY = Enum.forString("dashDotDotHeavy");
  
  public static final Enum WAVE = Enum.forString("wave");
  
  public static final Enum WAVY_HEAVY = Enum.forString("wavyHeavy");
  
  public static final Enum WAVY_DOUBLE = Enum.forString("wavyDouble");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final int INT_SINGLE = 1;
  
  public static final int INT_WORDS = 2;
  
  public static final int INT_DOUBLE = 3;
  
  public static final int INT_THICK = 4;
  
  public static final int INT_DOTTED = 5;
  
  public static final int INT_DOTTED_HEAVY = 6;
  
  public static final int INT_DASH = 7;
  
  public static final int INT_DASHED_HEAVY = 8;
  
  public static final int INT_DASH_LONG = 9;
  
  public static final int INT_DASH_LONG_HEAVY = 10;
  
  public static final int INT_DOT_DASH = 11;
  
  public static final int INT_DASH_DOT_HEAVY = 12;
  
  public static final int INT_DOT_DOT_DASH = 13;
  
  public static final int INT_DASH_DOT_DOT_HEAVY = 14;
  
  public static final int INT_WAVE = 15;
  
  public static final int INT_WAVY_HEAVY = 16;
  
  public static final int INT_WAVY_DOUBLE = 17;
  
  public static final int INT_NONE = 18;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STUnderline newValue(Object param1Object) {
      return (STUnderline)STUnderline.type.newValue(param1Object);
    }
    
    public static STUnderline newInstance() {
      return (STUnderline)POIXMLTypeLoader.newInstance(STUnderline.type, null);
    }
    
    public static STUnderline newInstance(XmlOptions param1XmlOptions) {
      return (STUnderline)POIXMLTypeLoader.newInstance(STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(String param1String) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1String, STUnderline.type, null);
    }
    
    public static STUnderline parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1String, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(File param1File) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1File, STUnderline.type, null);
    }
    
    public static STUnderline parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1File, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(URL param1URL) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1URL, STUnderline.type, null);
    }
    
    public static STUnderline parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1URL, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1InputStream, STUnderline.type, null);
    }
    
    public static STUnderline parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1InputStream, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(Reader param1Reader) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1Reader, STUnderline.type, null);
    }
    
    public static STUnderline parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderline)POIXMLTypeLoader.parse(param1Reader, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnderline.type, null);
    }
    
    public static STUnderline parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(Node param1Node) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1Node, STUnderline.type, null);
    }
    
    public static STUnderline parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderline)POIXMLTypeLoader.parse(param1Node, STUnderline.type, param1XmlOptions);
    }
    
    public static STUnderline parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STUnderline)POIXMLTypeLoader.parse(param1XMLInputStream, STUnderline.type, null);
    }
    
    public static STUnderline parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STUnderline)POIXMLTypeLoader.parse(param1XMLInputStream, STUnderline.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnderline.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnderline.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SINGLE = 1;
    
    static final int INT_WORDS = 2;
    
    static final int INT_DOUBLE = 3;
    
    static final int INT_THICK = 4;
    
    static final int INT_DOTTED = 5;
    
    static final int INT_DOTTED_HEAVY = 6;
    
    static final int INT_DASH = 7;
    
    static final int INT_DASHED_HEAVY = 8;
    
    static final int INT_DASH_LONG = 9;
    
    static final int INT_DASH_LONG_HEAVY = 10;
    
    static final int INT_DOT_DASH = 11;
    
    static final int INT_DASH_DOT_HEAVY = 12;
    
    static final int INT_DOT_DOT_DASH = 13;
    
    static final int INT_DASH_DOT_DOT_HEAVY = 14;
    
    static final int INT_WAVE = 15;
    
    static final int INT_WAVY_HEAVY = 16;
    
    static final int INT_WAVY_DOUBLE = 17;
    
    static final int INT_NONE = 18;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("single", 1), new Enum("words", 2), new Enum("double", 3), new Enum("thick", 4), new Enum("dotted", 5), new Enum("dottedHeavy", 6), new Enum("dash", 7), new Enum("dashedHeavy", 8), new Enum("dashLong", 9), new Enum("dashLongHeavy", 10), 
          new Enum("dotDash", 11), new Enum("dashDotHeavy", 12), new Enum("dotDotDash", 13), new Enum("dashDotDotHeavy", 14), new Enum("wave", 15), new Enum("wavyHeavy", 16), new Enum("wavyDouble", 17), new Enum("none", 18) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STUnderline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */