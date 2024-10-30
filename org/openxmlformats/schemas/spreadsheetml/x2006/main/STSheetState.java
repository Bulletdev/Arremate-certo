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

public interface STSheetState extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSheetState.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsheetstate158btype");
  
  public static final Enum VISIBLE = Enum.forString("visible");
  
  public static final Enum HIDDEN = Enum.forString("hidden");
  
  public static final Enum VERY_HIDDEN = Enum.forString("veryHidden");
  
  public static final int INT_VISIBLE = 1;
  
  public static final int INT_HIDDEN = 2;
  
  public static final int INT_VERY_HIDDEN = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STSheetState newValue(Object param1Object) {
      return (STSheetState)STSheetState.type.newValue(param1Object);
    }
    
    public static STSheetState newInstance() {
      return (STSheetState)POIXMLTypeLoader.newInstance(STSheetState.type, null);
    }
    
    public static STSheetState newInstance(XmlOptions param1XmlOptions) {
      return (STSheetState)POIXMLTypeLoader.newInstance(STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(String param1String) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1String, STSheetState.type, null);
    }
    
    public static STSheetState parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1String, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(File param1File) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1File, STSheetState.type, null);
    }
    
    public static STSheetState parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1File, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(URL param1URL) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1URL, STSheetState.type, null);
    }
    
    public static STSheetState parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1URL, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1InputStream, STSheetState.type, null);
    }
    
    public static STSheetState parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1InputStream, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(Reader param1Reader) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1Reader, STSheetState.type, null);
    }
    
    public static STSheetState parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSheetState)POIXMLTypeLoader.parse(param1Reader, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1XMLStreamReader, STSheetState.type, null);
    }
    
    public static STSheetState parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1XMLStreamReader, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(Node param1Node) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1Node, STSheetState.type, null);
    }
    
    public static STSheetState parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSheetState)POIXMLTypeLoader.parse(param1Node, STSheetState.type, param1XmlOptions);
    }
    
    public static STSheetState parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSheetState)POIXMLTypeLoader.parse(param1XMLInputStream, STSheetState.type, null);
    }
    
    public static STSheetState parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSheetState)POIXMLTypeLoader.parse(param1XMLInputStream, STSheetState.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSheetState.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSheetState.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_VISIBLE = 1;
    
    static final int INT_HIDDEN = 2;
    
    static final int INT_VERY_HIDDEN = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("visible", 1), new Enum("hidden", 2), new Enum("veryHidden", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STSheetState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */