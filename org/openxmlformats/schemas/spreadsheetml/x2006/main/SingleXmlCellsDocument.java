package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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

public interface SingleXmlCellsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SingleXmlCellsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("singlexmlcells33bfdoctype");
  
  CTSingleXmlCells getSingleXmlCells();
  
  void setSingleXmlCells(CTSingleXmlCells paramCTSingleXmlCells);
  
  CTSingleXmlCells addNewSingleXmlCells();
  
  public static final class Factory {
    public static SingleXmlCellsDocument newInstance() {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.newInstance(SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument newInstance(XmlOptions param1XmlOptions) {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.newInstance(SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(String param1String) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1String, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1String, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(File param1File) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1File, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1File, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(URL param1URL) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1URL, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1URL, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1InputStream, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1InputStream, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1Reader, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1Reader, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(Node param1Node) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1Node, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1Node, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static SingleXmlCellsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SingleXmlCellsDocument.type, null);
    }
    
    public static SingleXmlCellsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SingleXmlCellsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SingleXmlCellsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SingleXmlCellsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SingleXmlCellsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\SingleXmlCellsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */