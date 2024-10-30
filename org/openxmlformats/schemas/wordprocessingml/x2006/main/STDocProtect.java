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

public interface STDocProtect extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDocProtect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdocprotect5801type");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final Enum READ_ONLY = Enum.forString("readOnly");
  
  public static final Enum COMMENTS = Enum.forString("comments");
  
  public static final Enum TRACKED_CHANGES = Enum.forString("trackedChanges");
  
  public static final Enum FORMS = Enum.forString("forms");
  
  public static final int INT_NONE = 1;
  
  public static final int INT_READ_ONLY = 2;
  
  public static final int INT_COMMENTS = 3;
  
  public static final int INT_TRACKED_CHANGES = 4;
  
  public static final int INT_FORMS = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STDocProtect newValue(Object param1Object) {
      return (STDocProtect)STDocProtect.type.newValue(param1Object);
    }
    
    public static STDocProtect newInstance() {
      return (STDocProtect)POIXMLTypeLoader.newInstance(STDocProtect.type, null);
    }
    
    public static STDocProtect newInstance(XmlOptions param1XmlOptions) {
      return (STDocProtect)POIXMLTypeLoader.newInstance(STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(String param1String) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1String, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1String, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(File param1File) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1File, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1File, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(URL param1URL) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1URL, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1URL, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1InputStream, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1InputStream, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(Reader param1Reader) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1Reader, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1Reader, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1XMLStreamReader, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1XMLStreamReader, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(Node param1Node) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1Node, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1Node, STDocProtect.type, param1XmlOptions);
    }
    
    public static STDocProtect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1XMLInputStream, STDocProtect.type, null);
    }
    
    public static STDocProtect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDocProtect)POIXMLTypeLoader.parse(param1XMLInputStream, STDocProtect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDocProtect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDocProtect.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    
    static final int INT_READ_ONLY = 2;
    
    static final int INT_COMMENTS = 3;
    
    static final int INT_TRACKED_CHANGES = 4;
    
    static final int INT_FORMS = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("none", 1), new Enum("readOnly", 2), new Enum("comments", 3), new Enum("trackedChanges", 4), new Enum("forms", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STDocProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */