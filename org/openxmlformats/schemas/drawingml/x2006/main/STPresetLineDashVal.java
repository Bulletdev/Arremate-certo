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

public interface STPresetLineDashVal extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPresetLineDashVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpresetlinedashval159dtype");
  
  public static final Enum SOLID = Enum.forString("solid");
  
  public static final Enum DOT = Enum.forString("dot");
  
  public static final Enum DASH = Enum.forString("dash");
  
  public static final Enum LG_DASH = Enum.forString("lgDash");
  
  public static final Enum DASH_DOT = Enum.forString("dashDot");
  
  public static final Enum LG_DASH_DOT = Enum.forString("lgDashDot");
  
  public static final Enum LG_DASH_DOT_DOT = Enum.forString("lgDashDotDot");
  
  public static final Enum SYS_DASH = Enum.forString("sysDash");
  
  public static final Enum SYS_DOT = Enum.forString("sysDot");
  
  public static final Enum SYS_DASH_DOT = Enum.forString("sysDashDot");
  
  public static final Enum SYS_DASH_DOT_DOT = Enum.forString("sysDashDotDot");
  
  public static final int INT_SOLID = 1;
  
  public static final int INT_DOT = 2;
  
  public static final int INT_DASH = 3;
  
  public static final int INT_LG_DASH = 4;
  
  public static final int INT_DASH_DOT = 5;
  
  public static final int INT_LG_DASH_DOT = 6;
  
  public static final int INT_LG_DASH_DOT_DOT = 7;
  
  public static final int INT_SYS_DASH = 8;
  
  public static final int INT_SYS_DOT = 9;
  
  public static final int INT_SYS_DASH_DOT = 10;
  
  public static final int INT_SYS_DASH_DOT_DOT = 11;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPresetLineDashVal newValue(Object param1Object) {
      return (STPresetLineDashVal)STPresetLineDashVal.type.newValue(param1Object);
    }
    
    public static STPresetLineDashVal newInstance() {
      return (STPresetLineDashVal)POIXMLTypeLoader.newInstance(STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal newInstance(XmlOptions param1XmlOptions) {
      return (STPresetLineDashVal)POIXMLTypeLoader.newInstance(STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(String param1String) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1String, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1String, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(File param1File) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1File, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1File, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(URL param1URL) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1URL, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1URL, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1InputStream, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1InputStream, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(Reader param1Reader) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1Reader, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1Reader, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(Node param1Node) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1Node, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1Node, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static STPresetLineDashVal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1XMLInputStream, STPresetLineDashVal.type, null);
    }
    
    public static STPresetLineDashVal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPresetLineDashVal)POIXMLTypeLoader.parse(param1XMLInputStream, STPresetLineDashVal.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPresetLineDashVal.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPresetLineDashVal.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SOLID = 1;
    
    static final int INT_DOT = 2;
    
    static final int INT_DASH = 3;
    
    static final int INT_LG_DASH = 4;
    
    static final int INT_DASH_DOT = 5;
    
    static final int INT_LG_DASH_DOT = 6;
    
    static final int INT_LG_DASH_DOT_DOT = 7;
    
    static final int INT_SYS_DASH = 8;
    
    static final int INT_SYS_DOT = 9;
    
    static final int INT_SYS_DASH_DOT = 10;
    
    static final int INT_SYS_DASH_DOT_DOT = 11;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("solid", 1), new Enum("dot", 2), new Enum("dash", 3), new Enum("lgDash", 4), new Enum("dashDot", 5), new Enum("lgDashDot", 6), new Enum("lgDashDotDot", 7), new Enum("sysDash", 8), new Enum("sysDot", 9), new Enum("sysDashDot", 10), 
          new Enum("sysDashDotDot", 11) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STPresetLineDashVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */