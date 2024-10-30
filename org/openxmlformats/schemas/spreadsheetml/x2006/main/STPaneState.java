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

public interface STPaneState extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STPaneState.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpanestateae58type");
  
  public static final Enum SPLIT = Enum.forString("split");
  
  public static final Enum FROZEN = Enum.forString("frozen");
  
  public static final Enum FROZEN_SPLIT = Enum.forString("frozenSplit");
  
  public static final int INT_SPLIT = 1;
  
  public static final int INT_FROZEN = 2;
  
  public static final int INT_FROZEN_SPLIT = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STPaneState newValue(Object param1Object) {
      return (STPaneState)STPaneState.type.newValue(param1Object);
    }
    
    public static STPaneState newInstance() {
      return (STPaneState)POIXMLTypeLoader.newInstance(STPaneState.type, null);
    }
    
    public static STPaneState newInstance(XmlOptions param1XmlOptions) {
      return (STPaneState)POIXMLTypeLoader.newInstance(STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(String param1String) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1String, STPaneState.type, null);
    }
    
    public static STPaneState parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1String, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(File param1File) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1File, STPaneState.type, null);
    }
    
    public static STPaneState parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1File, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(URL param1URL) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1URL, STPaneState.type, null);
    }
    
    public static STPaneState parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1URL, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1InputStream, STPaneState.type, null);
    }
    
    public static STPaneState parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1InputStream, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(Reader param1Reader) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1Reader, STPaneState.type, null);
    }
    
    public static STPaneState parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STPaneState)POIXMLTypeLoader.parse(param1Reader, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1XMLStreamReader, STPaneState.type, null);
    }
    
    public static STPaneState parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1XMLStreamReader, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(Node param1Node) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1Node, STPaneState.type, null);
    }
    
    public static STPaneState parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STPaneState)POIXMLTypeLoader.parse(param1Node, STPaneState.type, param1XmlOptions);
    }
    
    public static STPaneState parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STPaneState)POIXMLTypeLoader.parse(param1XMLInputStream, STPaneState.type, null);
    }
    
    public static STPaneState parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STPaneState)POIXMLTypeLoader.parse(param1XMLInputStream, STPaneState.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPaneState.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STPaneState.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SPLIT = 1;
    
    static final int INT_FROZEN = 2;
    
    static final int INT_FROZEN_SPLIT = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("split", 1), new Enum("frozen", 2), new Enum("frozenSplit", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STPaneState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */