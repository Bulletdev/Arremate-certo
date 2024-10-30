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

public interface STFontCollectionIndex extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFontCollectionIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfontcollectionindex6766type");
  
  public static final Enum MAJOR = Enum.forString("major");
  
  public static final Enum MINOR = Enum.forString("minor");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final int INT_MAJOR = 1;
  
  public static final int INT_MINOR = 2;
  
  public static final int INT_NONE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STFontCollectionIndex newValue(Object param1Object) {
      return (STFontCollectionIndex)STFontCollectionIndex.type.newValue(param1Object);
    }
    
    public static STFontCollectionIndex newInstance() {
      return (STFontCollectionIndex)POIXMLTypeLoader.newInstance(STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex newInstance(XmlOptions param1XmlOptions) {
      return (STFontCollectionIndex)POIXMLTypeLoader.newInstance(STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(String param1String) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1String, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1String, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(File param1File) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1File, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1File, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(URL param1URL) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1URL, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1URL, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1InputStream, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1InputStream, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(Reader param1Reader) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1Reader, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1Reader, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(Node param1Node) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1Node, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1Node, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static STFontCollectionIndex parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STFontCollectionIndex.type, null);
    }
    
    public static STFontCollectionIndex parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFontCollectionIndex)POIXMLTypeLoader.parse(param1XMLInputStream, STFontCollectionIndex.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontCollectionIndex.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontCollectionIndex.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_MAJOR = 1;
    
    static final int INT_MINOR = 2;
    
    static final int INT_NONE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("major", 1), new Enum("minor", 2), new Enum("none", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STFontCollectionIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */