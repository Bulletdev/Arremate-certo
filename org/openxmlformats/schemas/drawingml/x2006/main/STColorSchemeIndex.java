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

public interface STColorSchemeIndex extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STColorSchemeIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcolorschemeindexe6f5type");
  
  public static final Enum DK_1 = Enum.forString("dk1");
  
  public static final Enum LT_1 = Enum.forString("lt1");
  
  public static final Enum DK_2 = Enum.forString("dk2");
  
  public static final Enum LT_2 = Enum.forString("lt2");
  
  public static final Enum ACCENT_1 = Enum.forString("accent1");
  
  public static final Enum ACCENT_2 = Enum.forString("accent2");
  
  public static final Enum ACCENT_3 = Enum.forString("accent3");
  
  public static final Enum ACCENT_4 = Enum.forString("accent4");
  
  public static final Enum ACCENT_5 = Enum.forString("accent5");
  
  public static final Enum ACCENT_6 = Enum.forString("accent6");
  
  public static final Enum HLINK = Enum.forString("hlink");
  
  public static final Enum FOL_HLINK = Enum.forString("folHlink");
  
  public static final int INT_DK_1 = 1;
  
  public static final int INT_LT_1 = 2;
  
  public static final int INT_DK_2 = 3;
  
  public static final int INT_LT_2 = 4;
  
  public static final int INT_ACCENT_1 = 5;
  
  public static final int INT_ACCENT_2 = 6;
  
  public static final int INT_ACCENT_3 = 7;
  
  public static final int INT_ACCENT_4 = 8;
  
  public static final int INT_ACCENT_5 = 9;
  
  public static final int INT_ACCENT_6 = 10;
  
  public static final int INT_HLINK = 11;
  
  public static final int INT_FOL_HLINK = 12;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STColorSchemeIndex newValue(Object param1Object) {
      return (STColorSchemeIndex)STColorSchemeIndex.type.newValue(param1Object);
    }
    
    public static STColorSchemeIndex newInstance() {
      return (STColorSchemeIndex)POIXMLTypeLoader.newInstance(STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex newInstance(XmlOptions param1XmlOptions) {
      return (STColorSchemeIndex)POIXMLTypeLoader.newInstance(STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(String param1String) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1String, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1String, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(File param1File) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1File, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1File, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(URL param1URL) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1URL, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1URL, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1InputStream, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1InputStream, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(Reader param1Reader) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1Reader, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1Reader, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(Node param1Node) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1Node, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1Node, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static STColorSchemeIndex parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STColorSchemeIndex.type, null);
    }
    
    public static STColorSchemeIndex parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STColorSchemeIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STColorSchemeIndex.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STColorSchemeIndex.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STColorSchemeIndex.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_DK_1 = 1;
    
    static final int INT_LT_1 = 2;
    
    static final int INT_DK_2 = 3;
    
    static final int INT_LT_2 = 4;
    
    static final int INT_ACCENT_1 = 5;
    
    static final int INT_ACCENT_2 = 6;
    
    static final int INT_ACCENT_3 = 7;
    
    static final int INT_ACCENT_4 = 8;
    
    static final int INT_ACCENT_5 = 9;
    
    static final int INT_ACCENT_6 = 10;
    
    static final int INT_HLINK = 11;
    
    static final int INT_FOL_HLINK = 12;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("dk1", 1), new Enum("lt1", 2), new Enum("dk2", 3), new Enum("lt2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), 
          new Enum("hlink", 11), new Enum("folHlink", 12) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STColorSchemeIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */