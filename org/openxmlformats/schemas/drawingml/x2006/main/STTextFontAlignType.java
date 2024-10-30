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

public interface STTextFontAlignType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextFontAlignType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextfontaligntypecb44type");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final Enum T = Enum.forString("t");
  
  public static final Enum CTR = Enum.forString("ctr");
  
  public static final Enum BASE = Enum.forString("base");
  
  public static final Enum B = Enum.forString("b");
  
  public static final int INT_AUTO = 1;
  
  public static final int INT_T = 2;
  
  public static final int INT_CTR = 3;
  
  public static final int INT_BASE = 4;
  
  public static final int INT_B = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextFontAlignType newValue(Object param1Object) {
      return (STTextFontAlignType)STTextFontAlignType.type.newValue(param1Object);
    }
    
    public static STTextFontAlignType newInstance() {
      return (STTextFontAlignType)POIXMLTypeLoader.newInstance(STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType newInstance(XmlOptions param1XmlOptions) {
      return (STTextFontAlignType)POIXMLTypeLoader.newInstance(STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(String param1String) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1String, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1String, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(File param1File) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1File, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1File, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(URL param1URL) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1URL, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1URL, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1InputStream, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1InputStream, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1Reader, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1Reader, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(Node param1Node) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1Node, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1Node, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static STTextFontAlignType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontAlignType.type, null);
    }
    
    public static STTextFontAlignType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextFontAlignType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextFontAlignType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontAlignType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextFontAlignType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AUTO = 1;
    
    static final int INT_T = 2;
    
    static final int INT_CTR = 3;
    
    static final int INT_BASE = 4;
    
    static final int INT_B = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("auto", 1), new Enum("t", 2), new Enum("ctr", 3), new Enum("base", 4), new Enum("b", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextFontAlignType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */