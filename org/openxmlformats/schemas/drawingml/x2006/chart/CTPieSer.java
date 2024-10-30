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

public interface CTPieSer extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPieSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpieser5248type");
  
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
  
  CTUnsignedInt getExplosion();
  
  boolean isSetExplosion();
  
  void setExplosion(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewExplosion();
  
  void unsetExplosion();
  
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
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTPieSer newInstance() {
      return (CTPieSer)POIXMLTypeLoader.newInstance(CTPieSer.type, null);
    }
    
    public static CTPieSer newInstance(XmlOptions param1XmlOptions) {
      return (CTPieSer)POIXMLTypeLoader.newInstance(CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(String param1String) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1String, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1String, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(File param1File) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1File, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1File, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(URL param1URL) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1URL, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1URL, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1InputStream, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1InputStream, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1Reader, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1Reader, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(Node param1Node) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1Node, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1Node, CTPieSer.type, param1XmlOptions);
    }
    
    public static CTPieSer parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTPieSer.type, null);
    }
    
    public static CTPieSer parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPieSer)POIXMLTypeLoader.parse(param1XMLInputStream, CTPieSer.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPieSer.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPieSer.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTPieSer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */