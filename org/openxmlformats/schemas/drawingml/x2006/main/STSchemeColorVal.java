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

public interface STSchemeColorVal extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSchemeColorVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stschemecolorval722etype");
  
  public static final Enum BG_1 = Enum.forString("bg1");
  
  public static final Enum TX_1 = Enum.forString("tx1");
  
  public static final Enum BG_2 = Enum.forString("bg2");
  
  public static final Enum TX_2 = Enum.forString("tx2");
  
  public static final Enum ACCENT_1 = Enum.forString("accent1");
  
  public static final Enum ACCENT_2 = Enum.forString("accent2");
  
  public static final Enum ACCENT_3 = Enum.forString("accent3");
  
  public static final Enum ACCENT_4 = Enum.forString("accent4");
  
  public static final Enum ACCENT_5 = Enum.forString("accent5");
  
  public static final Enum ACCENT_6 = Enum.forString("accent6");
  
  public static final Enum HLINK = Enum.forString("hlink");
  
  public static final Enum FOL_HLINK = Enum.forString("folHlink");
  
  public static final Enum PH_CLR = Enum.forString("phClr");
  
  public static final Enum DK_1 = Enum.forString("dk1");
  
  public static final Enum LT_1 = Enum.forString("lt1");
  
  public static final Enum DK_2 = Enum.forString("dk2");
  
  public static final Enum LT_2 = Enum.forString("lt2");
  
  public static final int INT_BG_1 = 1;
  
  public static final int INT_TX_1 = 2;
  
  public static final int INT_BG_2 = 3;
  
  public static final int INT_TX_2 = 4;
  
  public static final int INT_ACCENT_1 = 5;
  
  public static final int INT_ACCENT_2 = 6;
  
  public static final int INT_ACCENT_3 = 7;
  
  public static final int INT_ACCENT_4 = 8;
  
  public static final int INT_ACCENT_5 = 9;
  
  public static final int INT_ACCENT_6 = 10;
  
  public static final int INT_HLINK = 11;
  
  public static final int INT_FOL_HLINK = 12;
  
  public static final int INT_PH_CLR = 13;
  
  public static final int INT_DK_1 = 14;
  
  public static final int INT_LT_1 = 15;
  
  public static final int INT_DK_2 = 16;
  
  public static final int INT_LT_2 = 17;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STSchemeColorVal newValue(Object param1Object) {
      return (STSchemeColorVal)STSchemeColorVal.type.newValue(param1Object);
    }
    
    public static STSchemeColorVal newInstance() {
      return (STSchemeColorVal)POIXMLTypeLoader.newInstance(STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal newInstance(XmlOptions param1XmlOptions) {
      return (STSchemeColorVal)POIXMLTypeLoader.newInstance(STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(String param1String) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1String, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1String, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(File param1File) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1File, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1File, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(URL param1URL) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1URL, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1URL, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1InputStream, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1InputStream, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(Reader param1Reader) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1Reader, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1Reader, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(Node param1Node) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1Node, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1Node, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static STSchemeColorVal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1XMLInputStream, STSchemeColorVal.type, null);
    }
    
    public static STSchemeColorVal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSchemeColorVal)POIXMLTypeLoader.parse(param1XMLInputStream, STSchemeColorVal.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSchemeColorVal.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSchemeColorVal.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BG_1 = 1;
    
    static final int INT_TX_1 = 2;
    
    static final int INT_BG_2 = 3;
    
    static final int INT_TX_2 = 4;
    
    static final int INT_ACCENT_1 = 5;
    
    static final int INT_ACCENT_2 = 6;
    
    static final int INT_ACCENT_3 = 7;
    
    static final int INT_ACCENT_4 = 8;
    
    static final int INT_ACCENT_5 = 9;
    
    static final int INT_ACCENT_6 = 10;
    
    static final int INT_HLINK = 11;
    
    static final int INT_FOL_HLINK = 12;
    
    static final int INT_PH_CLR = 13;
    
    static final int INT_DK_1 = 14;
    
    static final int INT_LT_1 = 15;
    
    static final int INT_DK_2 = 16;
    
    static final int INT_LT_2 = 17;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("bg1", 1), new Enum("tx1", 2), new Enum("bg2", 3), new Enum("tx2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), 
          new Enum("hlink", 11), new Enum("folHlink", 12), new Enum("phClr", 13), new Enum("dk1", 14), new Enum("lt1", 15), new Enum("dk2", 16), new Enum("lt2", 17) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STSchemeColorVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */