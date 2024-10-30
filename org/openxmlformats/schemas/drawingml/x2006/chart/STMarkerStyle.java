package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface STMarkerStyle extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STMarkerStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stmarkerstyle177ftype");
  
  public static final Enum CIRCLE = Enum.forString("circle");
  
  public static final Enum DASH = Enum.forString("dash");
  
  public static final Enum DIAMOND = Enum.forString("diamond");
  
  public static final Enum DOT = Enum.forString("dot");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum PICTURE = Enum.forString("picture");
  
  public static final Enum PLUS = Enum.forString("plus");
  
  public static final Enum SQUARE = Enum.forString("square");
  
  public static final Enum STAR = Enum.forString("star");
  
  public static final Enum TRIANGLE = Enum.forString("triangle");
  
  public static final Enum X = Enum.forString("x");
  
  public static final int INT_CIRCLE = 1;
  
  public static final int INT_DASH = 2;
  
  public static final int INT_DIAMOND = 3;
  
  public static final int INT_DOT = 4;
  
  public static final int INT_NONE = 5;
  
  public static final int INT_PICTURE = 6;
  
  public static final int INT_PLUS = 7;
  
  public static final int INT_SQUARE = 8;
  
  public static final int INT_STAR = 9;
  
  public static final int INT_TRIANGLE = 10;
  
  public static final int INT_X = 11;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STMarkerStyle newValue(Object param1Object) {
      return (STMarkerStyle)STMarkerStyle.type.newValue(param1Object);
    }
    
    public static STMarkerStyle newInstance() {
      return (STMarkerStyle)POIXMLTypeLoader.newInstance(STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle newInstance(XmlOptions param1XmlOptions) {
      return (STMarkerStyle)POIXMLTypeLoader.newInstance(STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(String param1String) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1String, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1String, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(File param1File) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1File, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1File, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(URL param1URL) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1URL, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1URL, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1InputStream, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1InputStream, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1Reader, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1Reader, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(Node param1Node) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1Node, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1Node, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static STMarkerStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STMarkerStyle.type, null);
    }
    
    public static STMarkerStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STMarkerStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STMarkerStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STMarkerStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STMarkerStyle.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CIRCLE = 1;
    
    static final int INT_DASH = 2;
    
    static final int INT_DIAMOND = 3;
    
    static final int INT_DOT = 4;
    
    static final int INT_NONE = 5;
    
    static final int INT_PICTURE = 6;
    
    static final int INT_PLUS = 7;
    
    static final int INT_SQUARE = 8;
    
    static final int INT_STAR = 9;
    
    static final int INT_TRIANGLE = 10;
    
    static final int INT_X = 11;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("circle", 1), new Enum("dash", 2), new Enum("diamond", 3), new Enum("dot", 4), new Enum("none", 5), new Enum("picture", 6), new Enum("plus", 7), new Enum("square", 8), new Enum("star", 9), new Enum("triangle", 10), 
          new Enum("x", 11) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STMarkerStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */