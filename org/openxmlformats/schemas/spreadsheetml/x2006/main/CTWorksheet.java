package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTWorksheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTWorksheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworksheet530dtype");
  
  CTSheetPr getSheetPr();
  
  boolean isSetSheetPr();
  
  void setSheetPr(CTSheetPr paramCTSheetPr);
  
  CTSheetPr addNewSheetPr();
  
  void unsetSheetPr();
  
  CTSheetDimension getDimension();
  
  boolean isSetDimension();
  
  void setDimension(CTSheetDimension paramCTSheetDimension);
  
  CTSheetDimension addNewDimension();
  
  void unsetDimension();
  
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
  
  List<CTCols> getColsList();
  
  CTCols[] getColsArray();
  
  CTCols getColsArray(int paramInt);
  
  int sizeOfColsArray();
  
  void setColsArray(CTCols[] paramArrayOfCTCols);
  
  void setColsArray(int paramInt, CTCols paramCTCols);
  
  CTCols insertNewCols(int paramInt);
  
  CTCols addNewCols();
  
  void removeCols(int paramInt);
  
  CTSheetData getSheetData();
  
  void setSheetData(CTSheetData paramCTSheetData);
  
  CTSheetData addNewSheetData();
  
  CTSheetCalcPr getSheetCalcPr();
  
  boolean isSetSheetCalcPr();
  
  void setSheetCalcPr(CTSheetCalcPr paramCTSheetCalcPr);
  
  CTSheetCalcPr addNewSheetCalcPr();
  
  void unsetSheetCalcPr();
  
  CTSheetProtection getSheetProtection();
  
  boolean isSetSheetProtection();
  
  void setSheetProtection(CTSheetProtection paramCTSheetProtection);
  
  CTSheetProtection addNewSheetProtection();
  
  void unsetSheetProtection();
  
  CTProtectedRanges getProtectedRanges();
  
  boolean isSetProtectedRanges();
  
  void setProtectedRanges(CTProtectedRanges paramCTProtectedRanges);
  
  CTProtectedRanges addNewProtectedRanges();
  
  void unsetProtectedRanges();
  
  CTScenarios getScenarios();
  
  boolean isSetScenarios();
  
  void setScenarios(CTScenarios paramCTScenarios);
  
  CTScenarios addNewScenarios();
  
  void unsetScenarios();
  
  CTAutoFilter getAutoFilter();
  
  boolean isSetAutoFilter();
  
  void setAutoFilter(CTAutoFilter paramCTAutoFilter);
  
  CTAutoFilter addNewAutoFilter();
  
  void unsetAutoFilter();
  
  CTSortState getSortState();
  
  boolean isSetSortState();
  
  void setSortState(CTSortState paramCTSortState);
  
  CTSortState addNewSortState();
  
  void unsetSortState();
  
  CTDataConsolidate getDataConsolidate();
  
  boolean isSetDataConsolidate();
  
  void setDataConsolidate(CTDataConsolidate paramCTDataConsolidate);
  
  CTDataConsolidate addNewDataConsolidate();
  
  void unsetDataConsolidate();
  
  CTCustomSheetViews getCustomSheetViews();
  
  boolean isSetCustomSheetViews();
  
  void setCustomSheetViews(CTCustomSheetViews paramCTCustomSheetViews);
  
  CTCustomSheetViews addNewCustomSheetViews();
  
  void unsetCustomSheetViews();
  
  CTMergeCells getMergeCells();
  
  boolean isSetMergeCells();
  
  void setMergeCells(CTMergeCells paramCTMergeCells);
  
  CTMergeCells addNewMergeCells();
  
  void unsetMergeCells();
  
  CTPhoneticPr getPhoneticPr();
  
  boolean isSetPhoneticPr();
  
  void setPhoneticPr(CTPhoneticPr paramCTPhoneticPr);
  
  CTPhoneticPr addNewPhoneticPr();
  
  void unsetPhoneticPr();
  
  List<CTConditionalFormatting> getConditionalFormattingList();
  
  CTConditionalFormatting[] getConditionalFormattingArray();
  
  CTConditionalFormatting getConditionalFormattingArray(int paramInt);
  
  int sizeOfConditionalFormattingArray();
  
  void setConditionalFormattingArray(CTConditionalFormatting[] paramArrayOfCTConditionalFormatting);
  
  void setConditionalFormattingArray(int paramInt, CTConditionalFormatting paramCTConditionalFormatting);
  
  CTConditionalFormatting insertNewConditionalFormatting(int paramInt);
  
  CTConditionalFormatting addNewConditionalFormatting();
  
  void removeConditionalFormatting(int paramInt);
  
  CTDataValidations getDataValidations();
  
  boolean isSetDataValidations();
  
  void setDataValidations(CTDataValidations paramCTDataValidations);
  
  CTDataValidations addNewDataValidations();
  
  void unsetDataValidations();
  
  CTHyperlinks getHyperlinks();
  
  boolean isSetHyperlinks();
  
  void setHyperlinks(CTHyperlinks paramCTHyperlinks);
  
  CTHyperlinks addNewHyperlinks();
  
  void unsetHyperlinks();
  
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
  
  CTPageBreak getRowBreaks();
  
  boolean isSetRowBreaks();
  
  void setRowBreaks(CTPageBreak paramCTPageBreak);
  
  CTPageBreak addNewRowBreaks();
  
  void unsetRowBreaks();
  
  CTPageBreak getColBreaks();
  
  boolean isSetColBreaks();
  
  void setColBreaks(CTPageBreak paramCTPageBreak);
  
  CTPageBreak addNewColBreaks();
  
  void unsetColBreaks();
  
  CTCustomProperties getCustomProperties();
  
  boolean isSetCustomProperties();
  
  void setCustomProperties(CTCustomProperties paramCTCustomProperties);
  
  CTCustomProperties addNewCustomProperties();
  
  void unsetCustomProperties();
  
  CTCellWatches getCellWatches();
  
  boolean isSetCellWatches();
  
  void setCellWatches(CTCellWatches paramCTCellWatches);
  
  CTCellWatches addNewCellWatches();
  
  void unsetCellWatches();
  
  CTIgnoredErrors getIgnoredErrors();
  
  boolean isSetIgnoredErrors();
  
  void setIgnoredErrors(CTIgnoredErrors paramCTIgnoredErrors);
  
  CTIgnoredErrors addNewIgnoredErrors();
  
  void unsetIgnoredErrors();
  
  CTSmartTags getSmartTags();
  
  boolean isSetSmartTags();
  
  void setSmartTags(CTSmartTags paramCTSmartTags);
  
  CTSmartTags addNewSmartTags();
  
  void unsetSmartTags();
  
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
  
  CTSheetBackgroundPicture getPicture();
  
  boolean isSetPicture();
  
  void setPicture(CTSheetBackgroundPicture paramCTSheetBackgroundPicture);
  
  CTSheetBackgroundPicture addNewPicture();
  
  void unsetPicture();
  
  CTOleObjects getOleObjects();
  
  boolean isSetOleObjects();
  
  void setOleObjects(CTOleObjects paramCTOleObjects);
  
  CTOleObjects addNewOleObjects();
  
  void unsetOleObjects();
  
  CTControls getControls();
  
  boolean isSetControls();
  
  void setControls(CTControls paramCTControls);
  
  CTControls addNewControls();
  
  void unsetControls();
  
  CTWebPublishItems getWebPublishItems();
  
  boolean isSetWebPublishItems();
  
  void setWebPublishItems(CTWebPublishItems paramCTWebPublishItems);
  
  CTWebPublishItems addNewWebPublishItems();
  
  void unsetWebPublishItems();
  
  CTTableParts getTableParts();
  
  boolean isSetTableParts();
  
  void setTableParts(CTTableParts paramCTTableParts);
  
  CTTableParts addNewTableParts();
  
  void unsetTableParts();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTWorksheet newInstance() {
      return (CTWorksheet)POIXMLTypeLoader.newInstance(CTWorksheet.type, null);
    }
    
    public static CTWorksheet newInstance(XmlOptions param1XmlOptions) {
      return (CTWorksheet)POIXMLTypeLoader.newInstance(CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(String param1String) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1String, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1String, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(File param1File) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1File, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1File, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(URL param1URL) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1URL, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1URL, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1InputStream, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1InputStream, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1Reader, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1Reader, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(Node param1Node) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1Node, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1Node, CTWorksheet.type, param1XmlOptions);
    }
    
    public static CTWorksheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorksheet.type, null);
    }
    
    public static CTWorksheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTWorksheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorksheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorksheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorksheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTWorksheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */