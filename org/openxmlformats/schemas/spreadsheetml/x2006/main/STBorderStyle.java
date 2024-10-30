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

public interface STBorderStyle extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STBorderStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stborderstylec774type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum THIN = Enum.forString("thin");
  
  public static final Enum MEDIUM = Enum.forString("medium");
  
  public static final Enum DASHED = Enum.forString("dashed");
  
  public static final Enum DOTTED = Enum.forString("dotted");
  
  public static final Enum THICK = Enum.forString("thick");
  
  public static final Enum DOUBLE = Enum.forString("double");
  
  public static final Enum HAIR = Enum.forString("hair");
  
  public static final Enum MEDIUM_DASHED = Enum.forString("mediumDashed");
  
  public static final Enum DASH_DOT = Enum.forString("dashDot");
  
  public static final Enum MEDIUM_DASH_DOT = Enum.forString("mediumDashDot");
  
  public static final Enum DASH_DOT_DOT = Enum.forString("dashDotDot");
  
  public static final Enum MEDIUM_DASH_DOT_DOT = Enum.forString("mediumDashDotDot");
  
  public static final Enum SLANT_DASH_DOT = Enum.forString("slantDashDot");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_THIN = 2;
  
  public static final int INT_MEDIUM = 3;
  
  public static final int INT_DASHED = 4;
  
  public static final int INT_DOTTED = 5;
  
  public static final int INT_THICK = 6;
  
  public static final int INT_DOUBLE = 7;
  
  public static final int INT_HAIR = 8;
  
  public static final int INT_MEDIUM_DASHED = 9;
  
  public static final int INT_DASH_DOT = 10;
  
  public static final int INT_MEDIUM_DASH_DOT = 11;
  
  public static final int INT_DASH_DOT_DOT = 12;
  
  public static final int INT_MEDIUM_DASH_DOT_DOT = 13;
  
  public static final int INT_SLANT_DASH_DOT = 14;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STBorderStyle newValue(Object param1Object) {
      return (STBorderStyle)STBorderStyle.type.newValue(param1Object);
    }
    
    public static STBorderStyle newInstance() {
      return (STBorderStyle)POIXMLTypeLoader.newInstance(STBorderStyle.type, null);
    }
    
    public static STBorderStyle newInstance(XmlOptions param1XmlOptions) {
      return (STBorderStyle)POIXMLTypeLoader.newInstance(STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(String param1String) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1String, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1String, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(File param1File) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1File, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1File, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(URL param1URL) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1URL, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1URL, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1InputStream, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1InputStream, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1Reader, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1Reader, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(Node param1Node) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1Node, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1Node, STBorderStyle.type, param1XmlOptions);
    }
    
    public static STBorderStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STBorderStyle.type, null);
    }
    
    public static STBorderStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STBorderStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STBorderStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBorderStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBorderStyle.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_THIN = 2;
    
    static final int INT_MEDIUM = 3;
    
    static final int INT_DASHED = 4;
    
    static final int INT_DOTTED = 5;
    
    static final int INT_THICK = 6;
    
    static final int INT_DOUBLE = 7;
    
    static final int INT_HAIR = 8;
    
    static final int INT_MEDIUM_DASHED = 9;
    
    static final int INT_DASH_DOT = 10;
    
    static final int INT_MEDIUM_DASH_DOT = 11;
    
    static final int INT_DASH_DOT_DOT = 12;
    
    static final int INT_MEDIUM_DASH_DOT_DOT = 13;
    
    static final int INT_SLANT_DASH_DOT = 14;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("none", 1), new Enum("thin", 2), new Enum("medium", 3), new Enum("dashed", 4), new Enum("dotted", 5), new Enum("thick", 6), new Enum("double", 7), new Enum("hair", 8), new Enum("mediumDashed", 9), new Enum("dashDot", 10), 
          new Enum("mediumDashDot", 11), new Enum("dashDotDot", 12), new Enum("mediumDashDotDot", 13), new Enum("slantDashDot", 14) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STBorderStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */