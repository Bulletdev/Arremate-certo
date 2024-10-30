package com.microsoft.schemas.office.excel;

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

public interface STTrueFalseBlank extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTrueFalseBlank.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttruefalseblanka061type");
  
  public static final Enum TRUE = Enum.forString("True");
  
  public static final Enum T = Enum.forString("t");
  
  public static final Enum FALSE = Enum.forString("False");
  
  public static final Enum F = Enum.forString("f");
  
  public static final Enum X = Enum.forString("");
  
  public static final int INT_TRUE = 1;
  
  public static final int INT_T = 2;
  
  public static final int INT_FALSE = 3;
  
  public static final int INT_F = 4;
  
  public static final int INT_X = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTrueFalseBlank newValue(Object param1Object) {
      return (STTrueFalseBlank)STTrueFalseBlank.type.newValue(param1Object);
    }
    
    public static STTrueFalseBlank newInstance() {
      return (STTrueFalseBlank)POIXMLTypeLoader.newInstance(STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank newInstance(XmlOptions param1XmlOptions) {
      return (STTrueFalseBlank)POIXMLTypeLoader.newInstance(STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(String param1String) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1String, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1String, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(File param1File) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1File, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1File, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(URL param1URL) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1URL, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1URL, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1InputStream, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1InputStream, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(Reader param1Reader) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1Reader, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1Reader, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1XMLStreamReader, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1XMLStreamReader, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(Node param1Node) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1Node, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1Node, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static STTrueFalseBlank parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1XMLInputStream, STTrueFalseBlank.type, null);
    }
    
    public static STTrueFalseBlank parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTrueFalseBlank)POIXMLTypeLoader.parse(param1XMLInputStream, STTrueFalseBlank.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTrueFalseBlank.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTrueFalseBlank.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TRUE = 1;
    
    static final int INT_T = 2;
    
    static final int INT_FALSE = 3;
    
    static final int INT_F = 4;
    
    static final int INT_X = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("True", 1), new Enum("t", 2), new Enum("False", 3), new Enum("f", 4), new Enum("", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\excel\STTrueFalseBlank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */