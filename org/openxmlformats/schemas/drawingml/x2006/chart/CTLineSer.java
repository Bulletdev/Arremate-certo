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
import org.w3c.dom.Node;

public interface CTLineSer extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlineserd01atype");
  
  CTUnsignedInt getIdx();
  
  void setIdx(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewIdx();
  
  CTUnsignedInt getOrder();
  
  void setOrder(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewOrder();
  
  CTSerTx getTx();
  
  boolean isSetTx();
  
  void setTx(CTSerTx paramCTSerTx);
  
  CTSerTx addNewTx();
  
  void unsetTx();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTMarker getMarker();
  
  boolean isSetMarker();
  
  void setMarker(CTMarker paramCTMarker);
  
  CTMarker addNewMarker();
  
  void unsetMarker();
  
  List<CTDPt> getDPtList();
  
  CTDPt[] getDPtArray();
  
  CTDPt getDPtArray(int paramInt);
  
  int sizeOfDPtArray();
  
  void setDPtArray(CTDPt[] paramArrayOfCTDPt);
  
  void setDPtArray(int paramInt, CTDPt paramCTDPt);
  
  CTDPt insertNewDPt(int paramInt);
  
  CTDPt addNewDPt();
  
  void removeDPt(int paramInt);
  
  CTDLbls getDLbls();
  
  boolean isSetDLbls();
  
  void setDLbls(CTDLbls paramCTDLbls);
  
  CTDLbls addNewDLbls();
  
  void unsetDLbls();
  
  List<CTTrendline> getTrendlineList();
  
  CTTrendline[] getTrendlineArray();
  
  CTTrendline getTrendlineArray(int paramInt);
  
  int sizeOfTrendlineArray();
  
  void setTrendlineArray(CTTrendline[] paramArrayOfCTTrendline);
  
  void setTrendlineArray(int paramInt, CTTrendline paramCTTrendline);
  
  CTTrendline insertNewTrendline(int paramInt);
  
  CTTrendline addNewTrendline();
  
  void removeTrendline(int paramInt);
  
  CTErrBars getErrBars();
  
  boolean isSetErrBars();
  
  void setErrBars(CTErrBars paramCTErrBars);
  
  CTErrBars addNewErrBars();
  
  void unsetErrBars();
  
  CTAxDataSource getCat();
  
  boolean isSetCat();
  
  void setCat(CTAxDataSource paramCTAxDataSource);
  
  CTAxDataSource addNewCat();
  
  void unsetCat();
  
  CTNumDataSource getVal();
  
  boolean isSetVal();
  
  void setVal(CTNumDataSource paramCTNumDataSource);
  
  CTNumDataSource addNewVal();
  
  void unsetVal();
  
  CTBoolean getSmooth();
  
  boolean isSetSmooth();
  
  void setSmooth(CTBoolean paramCTBoolean);
  
  CTBoolean addNewSmooth();
  
  void unsetSmooth();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTLineSer newInstance() {
      return (CTLineSer)POIXMLTypeLoader.newInstance(CTLineSer.type, null);
    }
    
    public static CTLineSer newInstance(XmlOptions param1XmlOptions) {
      return (CTLineSer)POIXMLTypeLoader.newInstance(CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(String param1String) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1String, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1String, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(File param1File) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1File, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1File, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(URL param1URL) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1URL, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1URL, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1InputStream, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1InputStream, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1Reader, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1Reader, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(Node param1Node) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1Node, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1Node, CTLineSer.type, param1XmlOptions);
    }
    
    public static CTLineSer parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineSer.type, null);
    }
    
    public static CTLineSer parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineSer.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineSer.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineSer.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLineSer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */