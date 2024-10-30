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

public interface STMerge extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stmerge50aatype");
  
  public static final Enum CONTINUE = Enum.forString("continue");
  
  public static final Enum RESTART = Enum.forString("restart");
  
  public static final int INT_CONTINUE = 1;
  
  public static final int INT_RESTART = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STMerge newValue(Object param1Object) {
      return (STMerge)STMerge.type.newValue(param1Object);
    }
    
    public static STMerge newInstance() {
      return (STMerge)POIXMLTypeLoader.newInstance(STMerge.type, null);
    }
    
    public static STMerge newInstance(XmlOptions param1XmlOptions) {
      return (STMerge)POIXMLTypeLoader.newInstance(STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(String param1String) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1String, STMerge.type, null);
    }
    
    public static STMerge parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1String, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(File param1File) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1File, STMerge.type, null);
    }
    
    public static STMerge parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1File, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(URL param1URL) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1URL, STMerge.type, null);
    }
    
    public static STMerge parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1URL, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1InputStream, STMerge.type, null);
    }
    
    public static STMerge parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1InputStream, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(Reader param1Reader) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1Reader, STMerge.type, null);
    }
    
    public static STMerge parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STMerge)POIXMLTypeLoader.parse(param1Reader, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, STMerge.type, null);
    }
    
    public static STMerge parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(Node param1Node) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1Node, STMerge.type, null);
    }
    
    public static STMerge parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STMerge)POIXMLTypeLoader.parse(param1Node, STMerge.type, param1XmlOptions);
    }
    
    public static STMerge parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STMerge)POIXMLTypeLoader.parse(param1XMLInputStream, STMerge.type, null);
    }
    
    public static STMerge parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STMerge)POIXMLTypeLoader.parse(param1XMLInputStream, STMerge.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STMerge.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STMerge.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_CONTINUE = 1;
    
    static final int INT_RESTART = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("continue", 1), new Enum("restart", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */