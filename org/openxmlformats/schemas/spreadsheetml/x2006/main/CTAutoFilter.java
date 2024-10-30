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

public interface CTAutoFilter extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAutoFilter.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctautofiltera8d0type");
  
  List<CTFilterColumn> getFilterColumnList();
  
  CTFilterColumn[] getFilterColumnArray();
  
  CTFilterColumn getFilterColumnArray(int paramInt);
  
  int sizeOfFilterColumnArray();
  
  void setFilterColumnArray(CTFilterColumn[] paramArrayOfCTFilterColumn);
  
  void setFilterColumnArray(int paramInt, CTFilterColumn paramCTFilterColumn);
  
  CTFilterColumn insertNewFilterColumn(int paramInt);
  
  CTFilterColumn addNewFilterColumn();
  
  void removeFilterColumn(int paramInt);
  
  CTSortState getSortState();
  
  boolean isSetSortState();
  
  void setSortState(CTSortState paramCTSortState);
  
  CTSortState addNewSortState();
  
  void unsetSortState();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getRef();
  
  STRef xgetRef();
  
  boolean isSetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  void unsetRef();
  
  public static final class Factory {
    public static CTAutoFilter newInstance() {
      return (CTAutoFilter)POIXMLTypeLoader.newInstance(CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter newInstance(XmlOptions param1XmlOptions) {
      return (CTAutoFilter)POIXMLTypeLoader.newInstance(CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(String param1String) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1String, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1String, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(File param1File) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1File, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1File, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(URL param1URL) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1URL, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1URL, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1InputStream, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1InputStream, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1Reader, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1Reader, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(Node param1Node) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1Node, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1Node, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static CTAutoFilter parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1XMLInputStream, CTAutoFilter.type, null);
    }
    
    public static CTAutoFilter parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAutoFilter)POIXMLTypeLoader.parse(param1XMLInputStream, CTAutoFilter.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAutoFilter.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAutoFilter.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTAutoFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */