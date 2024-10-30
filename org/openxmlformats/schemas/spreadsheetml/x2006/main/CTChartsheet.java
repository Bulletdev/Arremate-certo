package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.w3c.dom.Node;

public interface CTChartsheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTChartsheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctchartsheetf68atype");
  
  CTChartsheetPr getSheetPr();
  
  boolean isSetSheetPr();
  
  void setSheetPr(CTChartsheetPr paramCTChartsheetPr);
  
  CTChartsheetPr addNewSheetPr();
  
  void unsetSheetPr();
  
  CTChartsheetViews getSheetViews();
  
  void setSheetViews(CTChartsheetViews paramCTChartsheetViews);
  
  CTChartsheetViews addNewSheetViews();
  
  CTChartsheetProtection getSheetProtection();
  
  boolean isSetSheetProtection();
  
  void setSheetProtection(CTChartsheetProtection paramCTChartsheetProtection);
  
  CTChartsheetProtection addNewSheetProtection();
  
  void unsetSheetProtection();
  
  CTCustomChartsheetViews getCustomSheetViews();
  
  boolean isSetCustomSheetViews();
  
  void setCustomSheetViews(CTCustomChartsheetViews paramCTCustomChartsheetViews);
  
  CTCustomChartsheetViews addNewCustomSheetViews();
  
  void unsetCustomSheetViews();
  
  CTPageMargins getPageMargins();
  
  boolean isSetPageMargins();
  
  void setPageMargins(CTPageMargins paramCTPageMargins);
  
  CTPageMargins addNewPageMargins();
  
  void unsetPageMargins();
  
  CTCsPageSetup getPageSetup();
  
  boolean isSetPageSetup();
  
  void setPageSetup(CTCsPageSetup paramCTCsPageSetup);
  
  CTCsPageSetup addNewPageSetup();
  
  void unsetPageSetup();
  
  CTHeaderFooter getHeaderFooter();
  
  boolean isSetHeaderFooter();
  
  void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHeaderFooter();
  
  void unsetHeaderFooter();
  
  CTDrawing getDrawing();
  
  void setDrawing(CTDrawing paramCTDrawing);
  
  CTDrawing addNewDrawing();
  
  CTLegacyDrawing getLegacyDrawing();
  
  boolean isSetLegacyDrawing();
  
  void setLegacyDrawing(CTLegacyDrawing paramCTLegacyDrawing);
  
  CTLegacyDrawing addNewLegacyDrawing();
  
  void unsetLegacyDrawing();
  
  CTLegacyDrawing getLegacyDrawingHF();
  
  boolean isSetLegacyDrawingHF();
  
  void setLegacyDrawingHF(CTLegacyDrawing paramCTLegacyDrawing);
  
  CTLegacyDrawing addNewLegacyDrawingHF();
  
  void unsetLegacyDrawingHF();
  
  CTSheetBackgroundPicture getPicture();
  
  boolean isSetPicture();
  
  void setPicture(CTSheetBackgroundPicture paramCTSheetBackgroundPicture);
  
  CTSheetBackgroundPicture addNewPicture();
  
  void unsetPicture();
  
  CTWebPublishItems getWebPublishItems();
  
  boolean isSetWebPublishItems();
  
  void setWebPublishItems(CTWebPublishItems paramCTWebPublishItems);
  
  CTWebPublishItems addNewWebPublishItems();
  
  void unsetWebPublishItems();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTChartsheet newInstance() {
      return (CTChartsheet)POIXMLTypeLoader.newInstance(CTChartsheet.type, null);
    }
    
    public static CTChartsheet newInstance(XmlOptions param1XmlOptions) {
      return (CTChartsheet)POIXMLTypeLoader.newInstance(CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(String param1String) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1String, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1String, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(File param1File) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1File, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1File, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(URL param1URL) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1URL, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1URL, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1InputStream, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1InputStream, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1Reader, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1Reader, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(Node param1Node) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1Node, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1Node, CTChartsheet.type, param1XmlOptions);
    }
    
    public static CTChartsheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTChartsheet.type, null);
    }
    
    public static CTChartsheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTChartsheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTChartsheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChartsheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChartsheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTChartsheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */