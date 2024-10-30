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

public interface CTWorkbook extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTWorkbook.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbook83c3type");
  
  CTFileVersion getFileVersion();
  
  boolean isSetFileVersion();
  
  void setFileVersion(CTFileVersion paramCTFileVersion);
  
  CTFileVersion addNewFileVersion();
  
  void unsetFileVersion();
  
  CTFileSharing getFileSharing();
  
  boolean isSetFileSharing();
  
  void setFileSharing(CTFileSharing paramCTFileSharing);
  
  CTFileSharing addNewFileSharing();
  
  void unsetFileSharing();
  
  CTWorkbookPr getWorkbookPr();
  
  boolean isSetWorkbookPr();
  
  void setWorkbookPr(CTWorkbookPr paramCTWorkbookPr);
  
  CTWorkbookPr addNewWorkbookPr();
  
  void unsetWorkbookPr();
  
  CTWorkbookProtection getWorkbookProtection();
  
  boolean isSetWorkbookProtection();
  
  void setWorkbookProtection(CTWorkbookProtection paramCTWorkbookProtection);
  
  CTWorkbookProtection addNewWorkbookProtection();
  
  void unsetWorkbookProtection();
  
  CTBookViews getBookViews();
  
  boolean isSetBookViews();
  
  void setBookViews(CTBookViews paramCTBookViews);
  
  CTBookViews addNewBookViews();
  
  void unsetBookViews();
  
  CTSheets getSheets();
  
  void setSheets(CTSheets paramCTSheets);
  
  CTSheets addNewSheets();
  
  CTFunctionGroups getFunctionGroups();
  
  boolean isSetFunctionGroups();
  
  void setFunctionGroups(CTFunctionGroups paramCTFunctionGroups);
  
  CTFunctionGroups addNewFunctionGroups();
  
  void unsetFunctionGroups();
  
  CTExternalReferences getExternalReferences();
  
  boolean isSetExternalReferences();
  
  void setExternalReferences(CTExternalReferences paramCTExternalReferences);
  
  CTExternalReferences addNewExternalReferences();
  
  void unsetExternalReferences();
  
  CTDefinedNames getDefinedNames();
  
  boolean isSetDefinedNames();
  
  void setDefinedNames(CTDefinedNames paramCTDefinedNames);
  
  CTDefinedNames addNewDefinedNames();
  
  void unsetDefinedNames();
  
  CTCalcPr getCalcPr();
  
  boolean isSetCalcPr();
  
  void setCalcPr(CTCalcPr paramCTCalcPr);
  
  CTCalcPr addNewCalcPr();
  
  void unsetCalcPr();
  
  CTOleSize getOleSize();
  
  boolean isSetOleSize();
  
  void setOleSize(CTOleSize paramCTOleSize);
  
  CTOleSize addNewOleSize();
  
  void unsetOleSize();
  
  CTCustomWorkbookViews getCustomWorkbookViews();
  
  boolean isSetCustomWorkbookViews();
  
  void setCustomWorkbookViews(CTCustomWorkbookViews paramCTCustomWorkbookViews);
  
  CTCustomWorkbookViews addNewCustomWorkbookViews();
  
  void unsetCustomWorkbookViews();
  
  CTPivotCaches getPivotCaches();
  
  boolean isSetPivotCaches();
  
  void setPivotCaches(CTPivotCaches paramCTPivotCaches);
  
  CTPivotCaches addNewPivotCaches();
  
  void unsetPivotCaches();
  
  CTSmartTagPr getSmartTagPr();
  
  boolean isSetSmartTagPr();
  
  void setSmartTagPr(CTSmartTagPr paramCTSmartTagPr);
  
  CTSmartTagPr addNewSmartTagPr();
  
  void unsetSmartTagPr();
  
  CTSmartTagTypes getSmartTagTypes();
  
  boolean isSetSmartTagTypes();
  
  void setSmartTagTypes(CTSmartTagTypes paramCTSmartTagTypes);
  
  CTSmartTagTypes addNewSmartTagTypes();
  
  void unsetSmartTagTypes();
  
  CTWebPublishing getWebPublishing();
  
  boolean isSetWebPublishing();
  
  void setWebPublishing(CTWebPublishing paramCTWebPublishing);
  
  CTWebPublishing addNewWebPublishing();
  
  void unsetWebPublishing();
  
  List<CTFileRecoveryPr> getFileRecoveryPrList();
  
  CTFileRecoveryPr[] getFileRecoveryPrArray();
  
  CTFileRecoveryPr getFileRecoveryPrArray(int paramInt);
  
  int sizeOfFileRecoveryPrArray();
  
  void setFileRecoveryPrArray(CTFileRecoveryPr[] paramArrayOfCTFileRecoveryPr);
  
  void setFileRecoveryPrArray(int paramInt, CTFileRecoveryPr paramCTFileRecoveryPr);
  
  CTFileRecoveryPr insertNewFileRecoveryPr(int paramInt);
  
  CTFileRecoveryPr addNewFileRecoveryPr();
  
  void removeFileRecoveryPr(int paramInt);
  
  CTWebPublishObjects getWebPublishObjects();
  
  boolean isSetWebPublishObjects();
  
  void setWebPublishObjects(CTWebPublishObjects paramCTWebPublishObjects);
  
  CTWebPublishObjects addNewWebPublishObjects();
  
  void unsetWebPublishObjects();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTWorkbook newInstance() {
      return (CTWorkbook)POIXMLTypeLoader.newInstance(CTWorkbook.type, null);
    }
    
    public static CTWorkbook newInstance(XmlOptions param1XmlOptions) {
      return (CTWorkbook)POIXMLTypeLoader.newInstance(CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(String param1String) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1String, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1String, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(File param1File) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1File, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1File, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(URL param1URL) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1URL, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1URL, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1InputStream, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1InputStream, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(Reader param1Reader) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1Reader, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1Reader, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(Node param1Node) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1Node, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1Node, CTWorkbook.type, param1XmlOptions);
    }
    
    public static CTWorkbook parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbook.type, null);
    }
    
    public static CTWorkbook parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTWorkbook)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbook.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbook.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbook.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */