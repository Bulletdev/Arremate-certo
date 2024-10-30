package com.microsoft.schemas.vml;

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

public interface STExt extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STExt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stext2fe5type");
  
  public static final Enum VIEW = Enum.forString("view");
  
  public static final Enum EDIT = Enum.forString("edit");
  
  public static final Enum BACKWARD_COMPATIBLE = Enum.forString("backwardCompatible");
  
  public static final int INT_VIEW = 1;
  
  public static final int INT_EDIT = 2;
  
  public static final int INT_BACKWARD_COMPATIBLE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STExt newValue(Object param1Object) {
      return (STExt)STExt.type.newValue(param1Object);
    }
    
    public static STExt newInstance() {
      return (STExt)POIXMLTypeLoader.newInstance(STExt.type, null);
    }
    
    public static STExt newInstance(XmlOptions param1XmlOptions) {
      return (STExt)POIXMLTypeLoader.newInstance(STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(String param1String) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1String, STExt.type, null);
    }
    
    public static STExt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1String, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(File param1File) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1File, STExt.type, null);
    }
    
    public static STExt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1File, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(URL param1URL) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1URL, STExt.type, null);
    }
    
    public static STExt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1URL, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1InputStream, STExt.type, null);
    }
    
    public static STExt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1InputStream, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(Reader param1Reader) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1Reader, STExt.type, null);
    }
    
    public static STExt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STExt)POIXMLTypeLoader.parse(param1Reader, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1XMLStreamReader, STExt.type, null);
    }
    
    public static STExt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1XMLStreamReader, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(Node param1Node) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1Node, STExt.type, null);
    }
    
    public static STExt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STExt)POIXMLTypeLoader.parse(param1Node, STExt.type, param1XmlOptions);
    }
    
    public static STExt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STExt)POIXMLTypeLoader.parse(param1XMLInputStream, STExt.type, null);
    }
    
    public static STExt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STExt)POIXMLTypeLoader.parse(param1XMLInputStream, STExt.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STExt.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STExt.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_VIEW = 1;
    
    static final int INT_EDIT = 2;
    
    static final int INT_BACKWARD_COMPATIBLE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("view", 1), new Enum("edit", 2), new Enum("backwardCompatible", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\STExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */