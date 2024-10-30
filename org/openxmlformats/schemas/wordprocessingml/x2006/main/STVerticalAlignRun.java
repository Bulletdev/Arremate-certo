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

public interface STVerticalAlignRun extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STVerticalAlignRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stverticalalignrun297ctype");
  
  public static final Enum BASELINE = Enum.forString("baseline");
  
  public static final Enum SUPERSCRIPT = Enum.forString("superscript");
  
  public static final Enum SUBSCRIPT = Enum.forString("subscript");
  
  public static final int INT_BASELINE = 1;
  
  public static final int INT_SUPERSCRIPT = 2;
  
  public static final int INT_SUBSCRIPT = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STVerticalAlignRun newValue(Object param1Object) {
      return (STVerticalAlignRun)STVerticalAlignRun.type.newValue(param1Object);
    }
    
    public static STVerticalAlignRun newInstance() {
      return (STVerticalAlignRun)POIXMLTypeLoader.newInstance(STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun newInstance(XmlOptions param1XmlOptions) {
      return (STVerticalAlignRun)POIXMLTypeLoader.newInstance(STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(String param1String) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1String, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1String, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(File param1File) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1File, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1File, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(URL param1URL) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1URL, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1URL, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1InputStream, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1InputStream, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(Reader param1Reader) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1Reader, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1Reader, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1XMLStreamReader, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(Node param1Node) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1Node, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1Node, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static STVerticalAlignRun parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalAlignRun.type, null);
    }
    
    public static STVerticalAlignRun parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STVerticalAlignRun)POIXMLTypeLoader.parse(param1XMLInputStream, STVerticalAlignRun.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalAlignRun.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STVerticalAlignRun.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BASELINE = 1;
    
    static final int INT_SUPERSCRIPT = 2;
    
    static final int INT_SUBSCRIPT = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("baseline", 1), new Enum("superscript", 2), new Enum("subscript", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STVerticalAlignRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */