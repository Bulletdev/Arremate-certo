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

public interface CTScatterChart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTScatterChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscatterchart2bfctype");
  
  CTScatterStyle getScatterStyle();
  
  void setScatterStyle(CTScatterStyle paramCTScatterStyle);
  
  CTScatterStyle addNewScatterStyle();
  
  CTBoolean getVaryColors();
  
  boolean isSetVaryColors();
  
  void setVaryColors(CTBoolean paramCTBoolean);
  
  CTBoolean addNewVaryColors();
  
  void unsetVaryColors();
  
  List<CTScatterSer> getSerList();
  
  CTScatterSer[] getSerArray();
  
  CTScatterSer getSerArray(int paramInt);
  
  int sizeOfSerArray();
  
  void setSerArray(CTScatterSer[] paramArrayOfCTScatterSer);
  
  void setSerArray(int paramInt, CTScatterSer paramCTScatterSer);
  
  CTScatterSer insertNewSer(int paramInt);
  
  CTScatterSer addNewSer();
  
  void removeSer(int paramInt);
  
  CTDLbls getDLbls();
  
  boolean isSetDLbls();
  
  void setDLbls(CTDLbls paramCTDLbls);
  
  CTDLbls addNewDLbls();
  
  void unsetDLbls();
  
  List<CTUnsignedInt> getAxIdList();
  
  CTUnsignedInt[] getAxIdArray();
  
  CTUnsignedInt getAxIdArray(int paramInt);
  
  int sizeOfAxIdArray();
  
  void setAxIdArray(CTUnsignedInt[] paramArrayOfCTUnsignedInt);
  
  void setAxIdArray(int paramInt, CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt insertNewAxId(int paramInt);
  
  CTUnsignedInt addNewAxId();
  
  void removeAxId(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTScatterChart newInstance() {
      return (CTScatterChart)POIXMLTypeLoader.newInstance(CTScatterChart.type, null);
    }
    
    public static CTScatterChart newInstance(XmlOptions param1XmlOptions) {
      return (CTScatterChart)POIXMLTypeLoader.newInstance(CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(String param1String) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1String, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1String, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(File param1File) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1File, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1File, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(URL param1URL) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1URL, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1URL, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1InputStream, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1InputStream, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1Reader, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1Reader, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(Node param1Node) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1Node, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1Node, CTScatterChart.type, param1XmlOptions);
    }
    
    public static CTScatterChart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterChart.type, null);
    }
    
    public static CTScatterChart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTScatterChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTScatterChart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterChart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScatterChart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTScatterChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */