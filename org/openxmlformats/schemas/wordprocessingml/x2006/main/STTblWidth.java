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

public interface STTblWidth extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTblWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttblwidth3a30type");
  
  public static final Enum NIL = Enum.forString("nil");
  
  public static final Enum PCT = Enum.forString("pct");
  
  public static final Enum DXA = Enum.forString("dxa");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final int INT_NIL = 1;
  
  public static final int INT_PCT = 2;
  
  public static final int INT_DXA = 3;
  
  public static final int INT_AUTO = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTblWidth newValue(Object param1Object) {
      return (STTblWidth)STTblWidth.type.newValue(param1Object);
    }
    
    public static STTblWidth newInstance() {
      return (STTblWidth)POIXMLTypeLoader.newInstance(STTblWidth.type, null);
    }
    
    public static STTblWidth newInstance(XmlOptions param1XmlOptions) {
      return (STTblWidth)POIXMLTypeLoader.newInstance(STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(String param1String) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1String, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1String, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(File param1File) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1File, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1File, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(URL param1URL) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1URL, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1URL, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1InputStream, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1InputStream, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(Reader param1Reader) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1Reader, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1Reader, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(Node param1Node) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1Node, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1Node, STTblWidth.type, param1XmlOptions);
    }
    
    public static STTblWidth parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1XMLInputStream, STTblWidth.type, null);
    }
    
    public static STTblWidth parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTblWidth)POIXMLTypeLoader.parse(param1XMLInputStream, STTblWidth.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTblWidth.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTblWidth.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NIL = 1;
    
    static final int INT_PCT = 2;
    
    static final int INT_DXA = 3;
    
    static final int INT_AUTO = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("nil", 1), new Enum("pct", 2), new Enum("dxa", 3), new Enum("auto", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STTblWidth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */