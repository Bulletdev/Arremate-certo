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

public interface CTBookViews extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBookViews.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookviewsb864type");
  
  List<CTBookView> getWorkbookViewList();
  
  CTBookView[] getWorkbookViewArray();
  
  CTBookView getWorkbookViewArray(int paramInt);
  
  int sizeOfWorkbookViewArray();
  
  void setWorkbookViewArray(CTBookView[] paramArrayOfCTBookView);
  
  void setWorkbookViewArray(int paramInt, CTBookView paramCTBookView);
  
  CTBookView insertNewWorkbookView(int paramInt);
  
  CTBookView addNewWorkbookView();
  
  void removeWorkbookView(int paramInt);
  
  public static final class Factory {
    public static CTBookViews newInstance() {
      return (CTBookViews)POIXMLTypeLoader.newInstance(CTBookViews.type, null);
    }
    
    public static CTBookViews newInstance(XmlOptions param1XmlOptions) {
      return (CTBookViews)POIXMLTypeLoader.newInstance(CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(String param1String) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1String, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1String, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(File param1File) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1File, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1File, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(URL param1URL) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1URL, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1URL, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1InputStream, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1InputStream, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1Reader, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1Reader, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(Node param1Node) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1Node, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1Node, CTBookViews.type, param1XmlOptions);
    }
    
    public static CTBookViews parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookViews.type, null);
    }
    
    public static CTBookViews parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBookViews)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookViews.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookViews.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookViews.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBookViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */