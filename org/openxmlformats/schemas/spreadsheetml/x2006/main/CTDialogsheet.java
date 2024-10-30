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

public interface CTDialogsheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDialogsheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdialogsheet6f36type");
  
  CTSheetPr getSheetPr();
  
  boolean isSetSheetPr();
  
  void setSheetPr(CTSheetPr paramCTSheetPr);
  
  CTSheetPr addNewSheetPr();
  
  void unsetSheetPr();
  
  CTSheetViews getSheetViews();
  
  boolean isSetSheetViews();
  
  void setSheetViews(CTSheetViews paramCTSheetViews);
  
  CTSheetViews addNewSheetViews();
  
  void unsetSheetViews();
  
  CTSheetFormatPr getSheetFormatPr();
  
  boolean isSetSheetFormatPr();
  
  void setSheetFormatPr(CTSheetFormatPr paramCTSheetFormatPr);
  
  CTSheetFormatPr addNewSheetFormatPr();
  
  void unsetSheetFormatPr();
  
  CTSheetProtection getSheetProtection();
  
  boolean isSetSheetProtection();
  
  void setSheetProtection(CTSheetProtection paramCTSheetProtection);
  
  CTSheetProtection addNewSheetProtection();
  
  void unsetSheetProtection();
  
  CTCustomSheetViews getCustomSheetViews();
  
  boolean isSetCustomSheetViews();
  
  void setCustomSheetViews(CTCustomSheetViews paramCTCustomSheetViews);
  
  CTCustomSheetViews addNewCustomSheetViews();
  
  void unsetCustomSheetViews();
  
  CTPrintOptions getPrintOptions();
  
  boolean isSetPrintOptions();
  
  void setPrintOptions(CTPrintOptions paramCTPrintOptions);
  
  CTPrintOptions addNewPrintOptions();
  
  void unsetPrintOptions();
  
  CTPageMargins getPageMargins();
  
  boolean isSetPageMargins();
  
  void setPageMargins(CTPageMargins paramCTPageMargins);
  
  CTPageMargins addNewPageMargins();
  
  void unsetPageMargins();
  
  CTPageSetup getPageSetup();
  
  boolean isSetPageSetup();
  
  void setPageSetup(CTPageSetup paramCTPageSetup);
  
  CTPageSetup addNewPageSetup();
  
  void unsetPageSetup();
  
  CTHeaderFooter getHeaderFooter();
  
  boolean isSetHeaderFooter();
  
  void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHeaderFooter();
  
  void unsetHeaderFooter();
  
  CTDrawing getDrawing();
  
  boolean isSetDrawing();
  
  void setDrawing(CTDrawing paramCTDrawing);
  
  CTDrawing addNewDrawing();
  
  void unsetDrawing();
  
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
  
  CTOleObjects getOleObjects();
  
  boolean isSetOleObjects();
  
  void setOleObjects(CTOleObjects paramCTOleObjects);
  
  CTOleObjects addNewOleObjects();
  
  void unsetOleObjects();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTDialogsheet newInstance() {
      return (CTDialogsheet)POIXMLTypeLoader.newInstance(CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet newInstance(XmlOptions param1XmlOptions) {
      return (CTDialogsheet)POIXMLTypeLoader.newInstance(CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(String param1String) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1String, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1String, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(File param1File) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1File, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1File, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(URL param1URL) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1URL, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1URL, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1InputStream, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1InputStream, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1Reader, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1Reader, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(Node param1Node) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1Node, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1Node, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static CTDialogsheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTDialogsheet.type, null);
    }
    
    public static CTDialogsheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDialogsheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTDialogsheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDialogsheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDialogsheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDialogsheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */