package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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

public interface CTValAx extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTValAx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvalaxd06etype");
  
  CTUnsignedInt getAxId();
  
  void setAxId(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewAxId();
  
  CTScaling getScaling();
  
  void setScaling(CTScaling paramCTScaling);
  
  CTScaling addNewScaling();
  
  CTBoolean getDelete();
  
  boolean isSetDelete();
  
  void setDelete(CTBoolean paramCTBoolean);
  
  CTBoolean addNewDelete();
  
  void unsetDelete();
  
  CTAxPos getAxPos();
  
  void setAxPos(CTAxPos paramCTAxPos);
  
  CTAxPos addNewAxPos();
  
  CTChartLines getMajorGridlines();
  
  boolean isSetMajorGridlines();
  
  void setMajorGridlines(CTChartLines paramCTChartLines);
  
  CTChartLines addNewMajorGridlines();
  
  void unsetMajorGridlines();
  
  CTChartLines getMinorGridlines();
  
  boolean isSetMinorGridlines();
  
  void setMinorGridlines(CTChartLines paramCTChartLines);
  
  CTChartLines addNewMinorGridlines();
  
  void unsetMinorGridlines();
  
  CTTitle getTitle();
  
  boolean isSetTitle();
  
  void setTitle(CTTitle paramCTTitle);
  
  CTTitle addNewTitle();
  
  void unsetTitle();
  
  CTNumFmt getNumFmt();
  
  boolean isSetNumFmt();
  
  void setNumFmt(CTNumFmt paramCTNumFmt);
  
  CTNumFmt addNewNumFmt();
  
  void unsetNumFmt();
  
  CTTickMark getMajorTickMark();
  
  boolean isSetMajorTickMark();
  
  void setMajorTickMark(CTTickMark paramCTTickMark);
  
  CTTickMark addNewMajorTickMark();
  
  void unsetMajorTickMark();
  
  CTTickMark getMinorTickMark();
  
  boolean isSetMinorTickMark();
  
  void setMinorTickMark(CTTickMark paramCTTickMark);
  
  CTTickMark addNewMinorTickMark();
  
  void unsetMinorTickMark();
  
  CTTickLblPos getTickLblPos();
  
  boolean isSetTickLblPos();
  
  void setTickLblPos(CTTickLblPos paramCTTickLblPos);
  
  CTTickLblPos addNewTickLblPos();
  
  void unsetTickLblPos();
  
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
  
  CTUnsignedInt getCrossAx();
  
  void setCrossAx(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewCrossAx();
  
  CTCrosses getCrosses();
  
  boolean isSetCrosses();
  
  void setCrosses(CTCrosses paramCTCrosses);
  
  CTCrosses addNewCrosses();
  
  void unsetCrosses();
  
  CTDouble getCrossesAt();
  
  boolean isSetCrossesAt();
  
  void setCrossesAt(CTDouble paramCTDouble);
  
  CTDouble addNewCrossesAt();
  
  void unsetCrossesAt();
  
  CTCrossBetween getCrossBetween();
  
  boolean isSetCrossBetween();
  
  void setCrossBetween(CTCrossBetween paramCTCrossBetween);
  
  CTCrossBetween addNewCrossBetween();
  
  void unsetCrossBetween();
  
  CTAxisUnit getMajorUnit();
  
  boolean isSetMajorUnit();
  
  void setMajorUnit(CTAxisUnit paramCTAxisUnit);
  
  CTAxisUnit addNewMajorUnit();
  
  void unsetMajorUnit();
  
  CTAxisUnit getMinorUnit();
  
  boolean isSetMinorUnit();
  
  void setMinorUnit(CTAxisUnit paramCTAxisUnit);
  
  CTAxisUnit addNewMinorUnit();
  
  void unsetMinorUnit();
  
  CTDispUnits getDispUnits();
  
  boolean isSetDispUnits();
  
  void setDispUnits(CTDispUnits paramCTDispUnits);
  
  CTDispUnits addNewDispUnits();
  
  void unsetDispUnits();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTValAx newInstance() {
      return (CTValAx)POIXMLTypeLoader.newInstance(CTValAx.type, null);
    }
    
    public static CTValAx newInstance(XmlOptions param1XmlOptions) {
      return (CTValAx)POIXMLTypeLoader.newInstance(CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(String param1String) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1String, CTValAx.type, null);
    }
    
    public static CTValAx parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1String, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(File param1File) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1File, CTValAx.type, null);
    }
    
    public static CTValAx parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1File, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(URL param1URL) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1URL, CTValAx.type, null);
    }
    
    public static CTValAx parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1URL, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1InputStream, CTValAx.type, null);
    }
    
    public static CTValAx parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1InputStream, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(Reader param1Reader) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1Reader, CTValAx.type, null);
    }
    
    public static CTValAx parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTValAx)POIXMLTypeLoader.parse(param1Reader, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTValAx.type, null);
    }
    
    public static CTValAx parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(Node param1Node) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1Node, CTValAx.type, null);
    }
    
    public static CTValAx parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTValAx)POIXMLTypeLoader.parse(param1Node, CTValAx.type, param1XmlOptions);
    }
    
    public static CTValAx parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTValAx)POIXMLTypeLoader.parse(param1XMLInputStream, CTValAx.type, null);
    }
    
    public static CTValAx parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTValAx)POIXMLTypeLoader.parse(param1XMLInputStream, CTValAx.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTValAx.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTValAx.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTValAx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */