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

public interface STTrueFalse extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTrueFalse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttruefalse4ab9type");
  
  public static final Enum T = Enum.forString("t");
  
  public static final Enum F = Enum.forString("f");
  
  public static final Enum TRUE = Enum.forString("true");
  
  public static final Enum FALSE = Enum.forString("false");
  
  public static final int INT_T = 1;
  
  public static final int INT_F = 2;
  
  public static final int INT_TRUE = 3;
  
  public static final int INT_FALSE = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTrueFalse newValue(Object param1Object) {
      return (STTrueFalse)STTrueFalse.type.newValue(param1Object);
    }
    
    public static STTrueFalse newInstance() {
      return (STTrueFalse)POIXMLTypeLoader.newInstance(STTrueFalse.type, null);
    }
    
    public static STTrueFalse newInstance(XmlOptions param1XmlOptions) {
      return (STTrueFalse)POIXMLTypeLoader.newInstance(STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(String param1String) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1String, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1String, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(File param1File) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1File, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1File, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(URL param1URL) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1URL, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1URL, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1InputStream, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1InputStream, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(Reader param1Reader) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1Reader, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1Reader, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1XMLStreamReader, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1XMLStreamReader, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(Node param1Node) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1Node, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1Node, STTrueFalse.type, param1XmlOptions);
    }
    
    public static STTrueFalse parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1XMLInputStream, STTrueFalse.type, null);
    }
    
    public static STTrueFalse parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTrueFalse)POIXMLTypeLoader.parse(param1XMLInputStream, STTrueFalse.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTrueFalse.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTrueFalse.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_T = 1;
    
    static final int INT_F = 2;
    
    static final int INT_TRUE = 3;
    
    static final int INT_FALSE = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("t", 1), new Enum("f", 2), new Enum("true", 3), new Enum("false", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\STTrueFalse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */