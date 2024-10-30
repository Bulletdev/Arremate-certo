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

public interface CTScatterSer extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTScatterSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscatterser2f7atype");
  
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
  
  List<CTErrBars> getErrBarsList();
  
  CTErrBars[] getErrBarsArray();
  
  CTErrBars getErrBarsArray(int paramInt);
  
  int sizeOfErrBarsArray();
  
  void setErrBarsArray(CTErrBars[] paramArrayOfCTErrBars);
  
  void setErrBarsArray(int paramInt, CTErrBars paramCTErrBars);
  
  CTErrBars insertNewErrBars(int paramInt);
  
  CTErrBars addNewErrBars();
  
  void removeErrBars(int paramInt);
  
  CTAxDataSource getXVal();
  
  boolean isSetXVal();
  
  void setXVal(CTAxDataSource paramCTAxDataSource);
  
  CTAxDataSource addNewXVal();
  
  void unsetXVal();
  
  CTNumDataSource getYVal();
  
  boolean isSetYVal();
  
  void setYVal(CTNumDataSource paramCTNumDataSource);
  
  CTNumDataSource addNewYVal();
  
  void unsetYVal();
  
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
    public static CTScatterSer newInstance() {
      return (CTScatterSer)POIXMLTypeLoader.newInstance(CTScatterSer.type, null);
    }
    
    public static CTScatterSer newInstance(XmlOptions param1XmlOptions) {
      return (CTScatterSer)POIXMLTypeLoader.newInstance(CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(String param1String) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1String, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1String, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(File param1File) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1File, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1File, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(URL param1URL) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1URL, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1URL, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1InputStream, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1InputStream, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(Reader param1Reader) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1Reader, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1Reader, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(Node param1Node) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1Node, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1Node, CTScatterSer.type, param1XmlOptions);
    }
    
    public static CTScatterSer parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterSer.type, null);
    }
    
    public static CTScatterSer parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTScatterSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterSer.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterSer.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterSer.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTScatterSer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */