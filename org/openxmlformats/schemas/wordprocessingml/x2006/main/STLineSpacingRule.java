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

public interface STLineSpacingRule extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STLineSpacingRule.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlinespacingrule6237type");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final Enum EXACT = Enum.forString("exact");
  
  public static final Enum AT_LEAST = Enum.forString("atLeast");
  
  public static final int INT_AUTO = 1;
  
  public static final int INT_EXACT = 2;
  
  public static final int INT_AT_LEAST = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STLineSpacingRule newValue(Object param1Object) {
      return (STLineSpacingRule)STLineSpacingRule.type.newValue(param1Object);
    }
    
    public static STLineSpacingRule newInstance() {
      return (STLineSpacingRule)POIXMLTypeLoader.newInstance(STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule newInstance(XmlOptions param1XmlOptions) {
      return (STLineSpacingRule)POIXMLTypeLoader.newInstance(STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(String param1String) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1String, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1String, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(File param1File) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1File, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1File, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(URL param1URL) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1URL, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1URL, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1InputStream, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1InputStream, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(Reader param1Reader) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1Reader, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1Reader, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1XMLStreamReader, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(Node param1Node) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1Node, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1Node, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static STLineSpacingRule parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1XMLInputStream, STLineSpacingRule.type, null);
    }
    
    public static STLineSpacingRule parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STLineSpacingRule)POIXMLTypeLoader.parse(param1XMLInputStream, STLineSpacingRule.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineSpacingRule.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STLineSpacingRule.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AUTO = 1;
    
    static final int INT_EXACT = 2;
    
    static final int INT_AT_LEAST = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("auto", 1), new Enum("exact", 2), new Enum("atLeast", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STLineSpacingRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */