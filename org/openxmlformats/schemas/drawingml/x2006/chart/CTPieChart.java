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
import org.w3c.dom.Node;

public interface CTPieChart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPieChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpiechartd34atype");
  
  CTBoolean getVaryColors();
  
  boolean isSetVaryColors();
  
  void setVaryColors(CTBoolean paramCTBoolean);
  
  CTBoolean addNewVaryColors();
  
  void unsetVaryColors();
  
  List<CTPieSer> getSerList();
  
  CTPieSer[] getSerArray();
  
  CTPieSer getSerArray(int paramInt);
  
  int sizeOfSerArray();
  
  void setSerArray(CTPieSer[] paramArrayOfCTPieSer);
  
  void setSerArray(int paramInt, CTPieSer paramCTPieSer);
  
  CTPieSer insertNewSer(int paramInt);
  
  CTPieSer addNewSer();
  
  void removeSer(int paramInt);
  
  CTDLbls getDLbls();
  
  boolean isSetDLbls();
  
  void setDLbls(CTDLbls paramCTDLbls);
  
  CTDLbls addNewDLbls();
  
  void unsetDLbls();
  
  CTFirstSliceAng getFirstSliceAng();
  
  boolean isSetFirstSliceAng();
  
  void setFirstSliceAng(CTFirstSliceAng paramCTFirstSliceAng);
  
  CTFirstSliceAng addNewFirstSliceAng();
  
  void unsetFirstSliceAng();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTPieChart newInstance() {
      return (CTPieChart)POIXMLTypeLoader.newInstance(CTPieChart.type, null);
    }
    
    public static CTPieChart newInstance(XmlOptions param1XmlOptions) {
      return (CTPieChart)POIXMLTypeLoader.newInstance(CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(String param1String) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1String, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1String, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(File param1File) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1File, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1File, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(URL param1URL) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1URL, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1URL, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1InputStream, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1InputStream, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1Reader, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1Reader, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(Node param1Node) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1Node, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1Node, CTPieChart.type, param1XmlOptions);
    }
    
    public static CTPieChart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTPieChart.type, null);
    }
    
    public static CTPieChart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPieChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTPieChart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPieChart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPieChart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTPieChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */