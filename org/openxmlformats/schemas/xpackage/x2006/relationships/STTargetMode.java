package org.openxmlformats.schemas.xpackage.x2006.relationships;

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

public interface STTargetMode extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTargetMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("sttargetmode0e8ctype");
  
  public static final Enum EXTERNAL = Enum.forString("External");
  
  public static final Enum INTERNAL = Enum.forString("Internal");
  
  public static final int INT_EXTERNAL = 1;
  
  public static final int INT_INTERNAL = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTargetMode newValue(Object param1Object) {
      return (STTargetMode)STTargetMode.type.newValue(param1Object);
    }
    
    public static STTargetMode newInstance() {
      return (STTargetMode)POIXMLTypeLoader.newInstance(STTargetMode.type, null);
    }
    
    public static STTargetMode newInstance(XmlOptions param1XmlOptions) {
      return (STTargetMode)POIXMLTypeLoader.newInstance(STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(String param1String) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1String, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1String, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(File param1File) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1File, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1File, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(URL param1URL) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1URL, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1URL, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1InputStream, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1InputStream, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(Reader param1Reader) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1Reader, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1Reader, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(Node param1Node) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1Node, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1Node, STTargetMode.type, param1XmlOptions);
    }
    
    public static STTargetMode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1XMLInputStream, STTargetMode.type, null);
    }
    
    public static STTargetMode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTargetMode)POIXMLTypeLoader.parse(param1XMLInputStream, STTargetMode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTargetMode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTargetMode.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_EXTERNAL = 1;
    
    static final int INT_INTERNAL = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("External", 1), new Enum("Internal", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\STTargetMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */