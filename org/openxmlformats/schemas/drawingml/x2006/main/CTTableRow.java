package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTableRow extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableRow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablerow4ac7type");
  
  List<CTTableCell> getTcList();
  
  CTTableCell[] getTcArray();
  
  CTTableCell getTcArray(int paramInt);
  
  int sizeOfTcArray();
  
  void setTcArray(CTTableCell[] paramArrayOfCTTableCell);
  
  void setTcArray(int paramInt, CTTableCell paramCTTableCell);
  
  CTTableCell insertNewTc(int paramInt);
  
  CTTableCell addNewTc();
  
  void removeTc(int paramInt);
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getH();
  
  STCoordinate xgetH();
  
  void setH(long paramLong);
  
  void xsetH(STCoordinate paramSTCoordinate);
  
  public static final class Factory {
    public static CTTableRow newInstance() {
      return (CTTableRow)POIXMLTypeLoader.newInstance(CTTableRow.type, null);
    }
    
    public static CTTableRow newInstance(XmlOptions param1XmlOptions) {
      return (CTTableRow)POIXMLTypeLoader.newInstance(CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(String param1String) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1String, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1String, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(File param1File) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1File, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1File, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(URL param1URL) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1URL, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1URL, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1InputStream, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1InputStream, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1Reader, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1Reader, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(Node param1Node) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1Node, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1Node, CTTableRow.type, param1XmlOptions);
    }
    
    public static CTTableRow parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableRow.type, null);
    }
    
    public static CTTableRow parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableRow)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableRow.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableRow.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableRow.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */