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

public interface STOrientation extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STOrientation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("storientation3c9ftype");
  
  public static final Enum DEFAULT = Enum.forString("default");
  
  public static final Enum PORTRAIT = Enum.forString("portrait");
  
  public static final Enum LANDSCAPE = Enum.forString("landscape");
  
  public static final int INT_DEFAULT = 1;
  
  public static final int INT_PORTRAIT = 2;
  
  public static final int INT_LANDSCAPE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STOrientation newValue(Object param1Object) {
      return (STOrientation)STOrientation.type.newValue(param1Object);
    }
    
    public static STOrientation newInstance() {
      return (STOrientation)POIXMLTypeLoader.newInstance(STOrientation.type, null);
    }
    
    public static STOrientation newInstance(XmlOptions param1XmlOptions) {
      return (STOrientation)POIXMLTypeLoader.newInstance(STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(String param1String) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1String, STOrientation.type, null);
    }
    
    public static STOrientation parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1String, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(File param1File) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1File, STOrientation.type, null);
    }
    
    public static STOrientation parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1File, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(URL param1URL) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1URL, STOrientation.type, null);
    }
    
    public static STOrientation parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1URL, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1InputStream, STOrientation.type, null);
    }
    
    public static STOrientation parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1InputStream, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(Reader param1Reader) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1Reader, STOrientation.type, null);
    }
    
    public static STOrientation parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STOrientation)POIXMLTypeLoader.parse(param1Reader, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1XMLStreamReader, STOrientation.type, null);
    }
    
    public static STOrientation parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1XMLStreamReader, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(Node param1Node) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1Node, STOrientation.type, null);
    }
    
    public static STOrientation parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STOrientation)POIXMLTypeLoader.parse(param1Node, STOrientation.type, param1XmlOptions);
    }
    
    public static STOrientation parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STOrientation)POIXMLTypeLoader.parse(param1XMLInputStream, STOrientation.type, null);
    }
    
    public static STOrientation parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STOrientation)POIXMLTypeLoader.parse(param1XMLInputStream, STOrientation.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOrientation.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STOrientation.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_DEFAULT = 1;
    
    static final int INT_PORTRAIT = 2;
    
    static final int INT_LANDSCAPE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("default", 1), new Enum("portrait", 2), new Enum("landscape", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */