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

public interface CTSelection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSelection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctselectionca2btype");
  
  STPane.Enum getPane();
  
  STPane xgetPane();
  
  boolean isSetPane();
  
  void setPane(STPane.Enum paramEnum);
  
  void xsetPane(STPane paramSTPane);
  
  void unsetPane();
  
  String getActiveCell();
  
  STCellRef xgetActiveCell();
  
  boolean isSetActiveCell();
  
  void setActiveCell(String paramString);
  
  void xsetActiveCell(STCellRef paramSTCellRef);
  
  void unsetActiveCell();
  
  long getActiveCellId();
  
  XmlUnsignedInt xgetActiveCellId();
  
  boolean isSetActiveCellId();
  
  void setActiveCellId(long paramLong);
  
  void xsetActiveCellId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetActiveCellId();
  
  List getSqref();
  
  STSqref xgetSqref();
  
  boolean isSetSqref();
  
  void setSqref(List paramList);
  
  void xsetSqref(STSqref paramSTSqref);
  
  void unsetSqref();
  
  public static final class Factory {
    public static CTSelection newInstance() {
      return (CTSelection)POIXMLTypeLoader.newInstance(CTSelection.type, null);
    }
    
    public static CTSelection newInstance(XmlOptions param1XmlOptions) {
      return (CTSelection)POIXMLTypeLoader.newInstance(CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(String param1String) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1String, CTSelection.type, null);
    }
    
    public static CTSelection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1String, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(File param1File) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1File, CTSelection.type, null);
    }
    
    public static CTSelection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1File, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(URL param1URL) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1URL, CTSelection.type, null);
    }
    
    public static CTSelection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1URL, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1InputStream, CTSelection.type, null);
    }
    
    public static CTSelection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1InputStream, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1Reader, CTSelection.type, null);
    }
    
    public static CTSelection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSelection)POIXMLTypeLoader.parse(param1Reader, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSelection.type, null);
    }
    
    public static CTSelection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(Node param1Node) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1Node, CTSelection.type, null);
    }
    
    public static CTSelection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSelection)POIXMLTypeLoader.parse(param1Node, CTSelection.type, param1XmlOptions);
    }
    
    public static CTSelection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSelection)POIXMLTypeLoader.parse(param1XMLInputStream, CTSelection.type, null);
    }
    
    public static CTSelection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSelection)POIXMLTypeLoader.parse(param1XMLInputStream, CTSelection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSelection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSelection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSelection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */