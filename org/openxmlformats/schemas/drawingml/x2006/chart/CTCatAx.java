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

public interface CTCatAx extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCatAx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcatax7159type");
  
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
  
  CTBoolean getAuto();
  
  boolean isSetAuto();
  
  void setAuto(CTBoolean paramCTBoolean);
  
  CTBoolean addNewAuto();
  
  void unsetAuto();
  
  CTLblAlgn getLblAlgn();
  
  boolean isSetLblAlgn();
  
  void setLblAlgn(CTLblAlgn paramCTLblAlgn);
  
  CTLblAlgn addNewLblAlgn();
  
  void unsetLblAlgn();
  
  CTLblOffset getLblOffset();
  
  boolean isSetLblOffset();
  
  void setLblOffset(CTLblOffset paramCTLblOffset);
  
  CTLblOffset addNewLblOffset();
  
  void unsetLblOffset();
  
  CTSkip getTickLblSkip();
  
  boolean isSetTickLblSkip();
  
  void setTickLblSkip(CTSkip paramCTSkip);
  
  CTSkip addNewTickLblSkip();
  
  void unsetTickLblSkip();
  
  CTSkip getTickMarkSkip();
  
  boolean isSetTickMarkSkip();
  
  void setTickMarkSkip(CTSkip paramCTSkip);
  
  CTSkip addNewTickMarkSkip();
  
  void unsetTickMarkSkip();
  
  CTBoolean getNoMultiLvlLbl();
  
  boolean isSetNoMultiLvlLbl();
  
  void setNoMultiLvlLbl(CTBoolean paramCTBoolean);
  
  CTBoolean addNewNoMultiLvlLbl();
  
  void unsetNoMultiLvlLbl();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTCatAx newInstance() {
      return (CTCatAx)POIXMLTypeLoader.newInstance(CTCatAx.type, null);
    }
    
    public static CTCatAx newInstance(XmlOptions param1XmlOptions) {
      return (CTCatAx)POIXMLTypeLoader.newInstance(CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(String param1String) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1String, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1String, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(File param1File) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1File, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1File, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(URL param1URL) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1URL, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1URL, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1InputStream, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1InputStream, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1Reader, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1Reader, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(Node param1Node) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1Node, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1Node, CTCatAx.type, param1XmlOptions);
    }
    
    public static CTCatAx parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1XMLInputStream, CTCatAx.type, null);
    }
    
    public static CTCatAx parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCatAx)POIXMLTypeLoader.parse(param1XMLInputStream, CTCatAx.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCatAx.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCatAx.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTCatAx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */