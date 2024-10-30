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

public interface CTSheetViews extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetViews.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetviewsb918type");
  
  List<CTSheetView> getSheetViewList();
  
  CTSheetView[] getSheetViewArray();
  
  CTSheetView getSheetViewArray(int paramInt);
  
  int sizeOfSheetViewArray();
  
  void setSheetViewArray(CTSheetView[] paramArrayOfCTSheetView);
  
  void setSheetViewArray(int paramInt, CTSheetView paramCTSheetView);
  
  CTSheetView insertNewSheetView(int paramInt);
  
  CTSheetView addNewSheetView();
  
  void removeSheetView(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTSheetViews newInstance() {
      return (CTSheetViews)POIXMLTypeLoader.newInstance(CTSheetViews.type, null);
    }
    
    public static CTSheetViews newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetViews)POIXMLTypeLoader.newInstance(CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(String param1String) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1String, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1String, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(File param1File) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1File, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1File, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1URL, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1URL, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1InputStream, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1InputStream, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1Reader, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1Reader, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(Node param1Node) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1Node, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1Node, CTSheetViews.type, param1XmlOptions);
    }
    
    public static CTSheetViews parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetViews.type, null);
    }
    
    public static CTSheetViews parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetViews)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetViews.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetViews.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetViews.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */