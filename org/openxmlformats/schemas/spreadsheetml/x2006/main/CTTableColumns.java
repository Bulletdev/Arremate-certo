package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTableColumns extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableColumns.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecolumnsebb8type");
  
  List<CTTableColumn> getTableColumnList();
  
  CTTableColumn[] getTableColumnArray();
  
  CTTableColumn getTableColumnArray(int paramInt);
  
  int sizeOfTableColumnArray();
  
  void setTableColumnArray(CTTableColumn[] paramArrayOfCTTableColumn);
  
  void setTableColumnArray(int paramInt, CTTableColumn paramCTTableColumn);
  
  CTTableColumn insertNewTableColumn(int paramInt);
  
  CTTableColumn addNewTableColumn();
  
  void removeTableColumn(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTTableColumns newInstance() {
      return (CTTableColumns)POIXMLTypeLoader.newInstance(CTTableColumns.type, null);
    }
    
    public static CTTableColumns newInstance(XmlOptions param1XmlOptions) {
      return (CTTableColumns)POIXMLTypeLoader.newInstance(CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(String param1String) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1String, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1String, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(File param1File) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1File, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1File, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(URL param1URL) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1URL, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1URL, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1InputStream, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1InputStream, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1Reader, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1Reader, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(Node param1Node) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1Node, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1Node, CTTableColumns.type, param1XmlOptions);
    }
    
    public static CTTableColumns parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableColumns.type, null);
    }
    
    public static CTTableColumns parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableColumns)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableColumns.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableColumns.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableColumns.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTableColumns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */