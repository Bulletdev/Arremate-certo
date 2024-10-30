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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTWorksheetSource extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTWorksheetSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworksheetsourced4c8type");
  
  String getRef();
  
  STRef xgetRef();
  
  boolean isSetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  void unsetRef();
  
  String getName();
  
  STXstring xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  void unsetName();
  
  String getSheet();
  
  STXstring xgetSheet();
  
  boolean isSetSheet();
  
  void setSheet(String paramString);
  
  void xsetSheet(STXstring paramSTXstring);
  
  void unsetSheet();
  
  String getId();
  
  STRelationshipId xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  void unsetId();
  
  public static final class Factory {
    public static CTWorksheetSource newInstance() {
      return (CTWorksheetSource)POIXMLTypeLoader.newInstance(CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource newInstance(XmlOptions param1XmlOptions) {
      return (CTWorksheetSource)POIXMLTypeLoader.newInstance(CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(String param1String) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1String, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1String, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(File param1File) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1File, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1File, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(URL param1URL) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1URL, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1URL, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1InputStream, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1InputStream, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(Reader param1Reader) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1Reader, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1Reader, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(Node param1Node) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1Node, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1Node, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static CTWorksheetSource parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorksheetSource.type, null);
    }
    
    public static CTWorksheetSource parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTWorksheetSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorksheetSource.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorksheetSource.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorksheetSource.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTWorksheetSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */