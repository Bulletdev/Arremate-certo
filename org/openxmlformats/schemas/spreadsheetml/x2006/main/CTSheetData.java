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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSheetData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetdata8408type");
  
  List<CTRow> getRowList();
  
  CTRow[] getRowArray();
  
  CTRow getRowArray(int paramInt);
  
  int sizeOfRowArray();
  
  void setRowArray(CTRow[] paramArrayOfCTRow);
  
  void setRowArray(int paramInt, CTRow paramCTRow);
  
  CTRow insertNewRow(int paramInt);
  
  CTRow addNewRow();
  
  void removeRow(int paramInt);
  
  public static final class Factory {
    public static CTSheetData newInstance() {
      return (CTSheetData)POIXMLTypeLoader.newInstance(CTSheetData.type, null);
    }
    
    public static CTSheetData newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetData)POIXMLTypeLoader.newInstance(CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(String param1String) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1String, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1String, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(File param1File) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1File, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1File, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1URL, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1URL, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1InputStream, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1InputStream, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1Reader, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1Reader, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(Node param1Node) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1Node, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1Node, CTSheetData.type, param1XmlOptions);
    }
    
    public static CTSheetData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetData.type, null);
    }
    
    public static CTSheetData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetData)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */