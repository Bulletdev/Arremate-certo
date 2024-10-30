package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

public interface CTLegend extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLegend.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlegenda54ftype");
  
  CTLegendPos getLegendPos();
  
  boolean isSetLegendPos();
  
  void setLegendPos(CTLegendPos paramCTLegendPos);
  
  CTLegendPos addNewLegendPos();
  
  void unsetLegendPos();
  
  List<CTLegendEntry> getLegendEntryList();
  
  CTLegendEntry[] getLegendEntryArray();
  
  CTLegendEntry getLegendEntryArray(int paramInt);
  
  int sizeOfLegendEntryArray();
  
  void setLegendEntryArray(CTLegendEntry[] paramArrayOfCTLegendEntry);
  
  void setLegendEntryArray(int paramInt, CTLegendEntry paramCTLegendEntry);
  
  CTLegendEntry insertNewLegendEntry(int paramInt);
  
  CTLegendEntry addNewLegendEntry();
  
  void removeLegendEntry(int paramInt);
  
  CTLayout getLayout();
  
  boolean isSetLayout();
  
  void setLayout(CTLayout paramCTLayout);
  
  CTLayout addNewLayout();
  
  void unsetLayout();
  
  CTBoolean getOverlay();
  
  boolean isSetOverlay();
  
  void setOverlay(CTBoolean paramCTBoolean);
  
  CTBoolean addNewOverlay();
  
  void unsetOverlay();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTTextBody getTxPr();
  
  boolean isSetTxPr();
  
  void setTxPr(CTTextBody paramCTTextBody);
  
  CTTextBody addNewTxPr();
  
  void unsetTxPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTLegend newInstance() {
      return (CTLegend)POIXMLTypeLoader.newInstance(CTLegend.type, null);
    }
    
    public static CTLegend newInstance(XmlOptions param1XmlOptions) {
      return (CTLegend)POIXMLTypeLoader.newInstance(CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(String param1String) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1String, CTLegend.type, null);
    }
    
    public static CTLegend parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1String, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(File param1File) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1File, CTLegend.type, null);
    }
    
    public static CTLegend parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1File, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(URL param1URL) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1URL, CTLegend.type, null);
    }
    
    public static CTLegend parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1URL, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1InputStream, CTLegend.type, null);
    }
    
    public static CTLegend parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1InputStream, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1Reader, CTLegend.type, null);
    }
    
    public static CTLegend parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLegend)POIXMLTypeLoader.parse(param1Reader, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegend.type, null);
    }
    
    public static CTLegend parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(Node param1Node) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1Node, CTLegend.type, null);
    }
    
    public static CTLegend parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLegend)POIXMLTypeLoader.parse(param1Node, CTLegend.type, param1XmlOptions);
    }
    
    public static CTLegend parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLegend)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegend.type, null);
    }
    
    public static CTLegend parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLegend)POIXMLTypeLoader.parse(param1XMLInputStream, CTLegend.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegend.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLegend.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLegend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */