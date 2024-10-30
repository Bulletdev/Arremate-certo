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

public interface CTSingleXmlCells extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSingleXmlCells.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsinglexmlcells5a6btype");
  
  List<CTSingleXmlCell> getSingleXmlCellList();
  
  CTSingleXmlCell[] getSingleXmlCellArray();
  
  CTSingleXmlCell getSingleXmlCellArray(int paramInt);
  
  int sizeOfSingleXmlCellArray();
  
  void setSingleXmlCellArray(CTSingleXmlCell[] paramArrayOfCTSingleXmlCell);
  
  void setSingleXmlCellArray(int paramInt, CTSingleXmlCell paramCTSingleXmlCell);
  
  CTSingleXmlCell insertNewSingleXmlCell(int paramInt);
  
  CTSingleXmlCell addNewSingleXmlCell();
  
  void removeSingleXmlCell(int paramInt);
  
  public static final class Factory {
    public static CTSingleXmlCells newInstance() {
      return (CTSingleXmlCells)POIXMLTypeLoader.newInstance(CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells newInstance(XmlOptions param1XmlOptions) {
      return (CTSingleXmlCells)POIXMLTypeLoader.newInstance(CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(String param1String) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1String, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1String, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(File param1File) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1File, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1File, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(URL param1URL) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1URL, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1URL, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1InputStream, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1InputStream, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1Reader, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1Reader, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(Node param1Node) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1Node, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1Node, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCells parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1XMLInputStream, CTSingleXmlCells.type, null);
    }
    
    public static CTSingleXmlCells parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSingleXmlCells)POIXMLTypeLoader.parse(param1XMLInputStream, CTSingleXmlCells.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSingleXmlCells.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSingleXmlCells.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSingleXmlCells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */