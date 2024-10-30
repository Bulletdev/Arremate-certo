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

public interface STCellFormulaType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCellFormulaType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellformulatypee2cdtype");
  
  public static final Enum NORMAL = Enum.forString("normal");
  
  public static final Enum ARRAY = Enum.forString("array");
  
  public static final Enum DATA_TABLE = Enum.forString("dataTable");
  
  public static final Enum SHARED = Enum.forString("shared");
  
  public static final int INT_NORMAL = 1;
  
  public static final int INT_ARRAY = 2;
  
  public static final int INT_DATA_TABLE = 3;
  
  public static final int INT_SHARED = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCellFormulaType newValue(Object param1Object) {
      return (STCellFormulaType)STCellFormulaType.type.newValue(param1Object);
    }
    
    public static STCellFormulaType newInstance() {
      return (STCellFormulaType)POIXMLTypeLoader.newInstance(STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType newInstance(XmlOptions param1XmlOptions) {
      return (STCellFormulaType)POIXMLTypeLoader.newInstance(STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(String param1String) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1String, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1String, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(File param1File) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1File, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1File, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(URL param1URL) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1URL, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1URL, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1InputStream, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1InputStream, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(Reader param1Reader) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1Reader, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1Reader, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(Node param1Node) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1Node, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1Node, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static STCellFormulaType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1XMLInputStream, STCellFormulaType.type, null);
    }
    
    public static STCellFormulaType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCellFormulaType)POIXMLTypeLoader.parse(param1XMLInputStream, STCellFormulaType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellFormulaType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellFormulaType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NORMAL = 1;
    
    static final int INT_ARRAY = 2;
    
    static final int INT_DATA_TABLE = 3;
    
    static final int INT_SHARED = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("normal", 1), new Enum("array", 2), new Enum("dataTable", 3), new Enum("shared", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCellFormulaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */