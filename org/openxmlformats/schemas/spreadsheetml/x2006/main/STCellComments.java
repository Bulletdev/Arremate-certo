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

public interface STCellComments extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCellComments.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellcomments7e4ftype");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum AS_DISPLAYED = Enum.forString("asDisplayed");
  
  public static final Enum AT_END = Enum.forString("atEnd");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_AS_DISPLAYED = 2;
  
  public static final int INT_AT_END = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCellComments newValue(Object param1Object) {
      return (STCellComments)STCellComments.type.newValue(param1Object);
    }
    
    public static STCellComments newInstance() {
      return (STCellComments)POIXMLTypeLoader.newInstance(STCellComments.type, null);
    }
    
    public static STCellComments newInstance(XmlOptions param1XmlOptions) {
      return (STCellComments)POIXMLTypeLoader.newInstance(STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(String param1String) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1String, STCellComments.type, null);
    }
    
    public static STCellComments parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1String, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(File param1File) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1File, STCellComments.type, null);
    }
    
    public static STCellComments parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1File, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(URL param1URL) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1URL, STCellComments.type, null);
    }
    
    public static STCellComments parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1URL, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1InputStream, STCellComments.type, null);
    }
    
    public static STCellComments parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1InputStream, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(Reader param1Reader) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1Reader, STCellComments.type, null);
    }
    
    public static STCellComments parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellComments)POIXMLTypeLoader.parse(param1Reader, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellComments.type, null);
    }
    
    public static STCellComments parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(Node param1Node) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1Node, STCellComments.type, null);
    }
    
    public static STCellComments parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellComments)POIXMLTypeLoader.parse(param1Node, STCellComments.type, param1XmlOptions);
    }
    
    public static STCellComments parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCellComments)POIXMLTypeLoader.parse(param1XMLInputStream, STCellComments.type, null);
    }
    
    public static STCellComments parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCellComments)POIXMLTypeLoader.parse(param1XMLInputStream, STCellComments.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellComments.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellComments.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_AS_DISPLAYED = 2;
    
    static final int INT_AT_END = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("asDisplayed", 2), new Enum("atEnd", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCellComments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */