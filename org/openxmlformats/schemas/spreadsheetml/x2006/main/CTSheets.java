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

public interface CTSheets extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheets.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheets49fdtype");
  
  List<CTSheet> getSheetList();
  
  CTSheet[] getSheetArray();
  
  CTSheet getSheetArray(int paramInt);
  
  int sizeOfSheetArray();
  
  void setSheetArray(CTSheet[] paramArrayOfCTSheet);
  
  void setSheetArray(int paramInt, CTSheet paramCTSheet);
  
  CTSheet insertNewSheet(int paramInt);
  
  CTSheet addNewSheet();
  
  void removeSheet(int paramInt);
  
  public static final class Factory {
    public static CTSheets newInstance() {
      return (CTSheets)POIXMLTypeLoader.newInstance(CTSheets.type, null);
    }
    
    public static CTSheets newInstance(XmlOptions param1XmlOptions) {
      return (CTSheets)POIXMLTypeLoader.newInstance(CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(String param1String) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1String, CTSheets.type, null);
    }
    
    public static CTSheets parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1String, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(File param1File) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1File, CTSheets.type, null);
    }
    
    public static CTSheets parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1File, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(URL param1URL) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1URL, CTSheets.type, null);
    }
    
    public static CTSheets parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1URL, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1InputStream, CTSheets.type, null);
    }
    
    public static CTSheets parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1InputStream, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1Reader, CTSheets.type, null);
    }
    
    public static CTSheets parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheets)POIXMLTypeLoader.parse(param1Reader, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheets.type, null);
    }
    
    public static CTSheets parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(Node param1Node) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1Node, CTSheets.type, null);
    }
    
    public static CTSheets parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheets)POIXMLTypeLoader.parse(param1Node, CTSheets.type, param1XmlOptions);
    }
    
    public static CTSheets parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheets)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheets.type, null);
    }
    
    public static CTSheets parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheets)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheets.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheets.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheets.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */