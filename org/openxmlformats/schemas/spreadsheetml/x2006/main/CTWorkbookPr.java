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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTWorkbookPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTWorkbookPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbookpr03a5type");
  
  boolean getDate1904();
  
  XmlBoolean xgetDate1904();
  
  boolean isSetDate1904();
  
  void setDate1904(boolean paramBoolean);
  
  void xsetDate1904(XmlBoolean paramXmlBoolean);
  
  void unsetDate1904();
  
  STObjects$Enum getShowObjects();
  
  STObjects xgetShowObjects();
  
  boolean isSetShowObjects();
  
  void setShowObjects(STObjects$Enum paramSTObjects$Enum);
  
  void xsetShowObjects(STObjects paramSTObjects);
  
  void unsetShowObjects();
  
  boolean getShowBorderUnselectedTables();
  
  XmlBoolean xgetShowBorderUnselectedTables();
  
  boolean isSetShowBorderUnselectedTables();
  
  void setShowBorderUnselectedTables(boolean paramBoolean);
  
  void xsetShowBorderUnselectedTables(XmlBoolean paramXmlBoolean);
  
  void unsetShowBorderUnselectedTables();
  
  boolean getFilterPrivacy();
  
  XmlBoolean xgetFilterPrivacy();
  
  boolean isSetFilterPrivacy();
  
  void setFilterPrivacy(boolean paramBoolean);
  
  void xsetFilterPrivacy(XmlBoolean paramXmlBoolean);
  
  void unsetFilterPrivacy();
  
  boolean getPromptedSolutions();
  
  XmlBoolean xgetPromptedSolutions();
  
  boolean isSetPromptedSolutions();
  
  void setPromptedSolutions(boolean paramBoolean);
  
  void xsetPromptedSolutions(XmlBoolean paramXmlBoolean);
  
  void unsetPromptedSolutions();
  
  boolean getShowInkAnnotation();
  
  XmlBoolean xgetShowInkAnnotation();
  
  boolean isSetShowInkAnnotation();
  
  void setShowInkAnnotation(boolean paramBoolean);
  
  void xsetShowInkAnnotation(XmlBoolean paramXmlBoolean);
  
  void unsetShowInkAnnotation();
  
  boolean getBackupFile();
  
  XmlBoolean xgetBackupFile();
  
  boolean isSetBackupFile();
  
  void setBackupFile(boolean paramBoolean);
  
  void xsetBackupFile(XmlBoolean paramXmlBoolean);
  
  void unsetBackupFile();
  
  boolean getSaveExternalLinkValues();
  
  XmlBoolean xgetSaveExternalLinkValues();
  
  boolean isSetSaveExternalLinkValues();
  
  void setSaveExternalLinkValues(boolean paramBoolean);
  
  void xsetSaveExternalLinkValues(XmlBoolean paramXmlBoolean);
  
  void unsetSaveExternalLinkValues();
  
  STUpdateLinks$Enum getUpdateLinks();
  
  STUpdateLinks xgetUpdateLinks();
  
  boolean isSetUpdateLinks();
  
  void setUpdateLinks(STUpdateLinks$Enum paramSTUpdateLinks$Enum);
  
  void xsetUpdateLinks(STUpdateLinks paramSTUpdateLinks);
  
  void unsetUpdateLinks();
  
  String getCodeName();
  
  XmlString xgetCodeName();
  
  boolean isSetCodeName();
  
  void setCodeName(String paramString);
  
  void xsetCodeName(XmlString paramXmlString);
  
  void unsetCodeName();
  
  boolean getHidePivotFieldList();
  
  XmlBoolean xgetHidePivotFieldList();
  
  boolean isSetHidePivotFieldList();
  
  void setHidePivotFieldList(boolean paramBoolean);
  
  void xsetHidePivotFieldList(XmlBoolean paramXmlBoolean);
  
  void unsetHidePivotFieldList();
  
  boolean getShowPivotChartFilter();
  
  XmlBoolean xgetShowPivotChartFilter();
  
  boolean isSetShowPivotChartFilter();
  
  void setShowPivotChartFilter(boolean paramBoolean);
  
  void xsetShowPivotChartFilter(XmlBoolean paramXmlBoolean);
  
  void unsetShowPivotChartFilter();
  
  boolean getAllowRefreshQuery();
  
  XmlBoolean xgetAllowRefreshQuery();
  
  boolean isSetAllowRefreshQuery();
  
  void setAllowRefreshQuery(boolean paramBoolean);
  
  void xsetAllowRefreshQuery(XmlBoolean paramXmlBoolean);
  
  void unsetAllowRefreshQuery();
  
  boolean getPublishItems();
  
  XmlBoolean xgetPublishItems();
  
  boolean isSetPublishItems();
  
  void setPublishItems(boolean paramBoolean);
  
  void xsetPublishItems(XmlBoolean paramXmlBoolean);
  
  void unsetPublishItems();
  
  boolean getCheckCompatibility();
  
  XmlBoolean xgetCheckCompatibility();
  
  boolean isSetCheckCompatibility();
  
  void setCheckCompatibility(boolean paramBoolean);
  
  void xsetCheckCompatibility(XmlBoolean paramXmlBoolean);
  
  void unsetCheckCompatibility();
  
  boolean getAutoCompressPictures();
  
  XmlBoolean xgetAutoCompressPictures();
  
  boolean isSetAutoCompressPictures();
  
  void setAutoCompressPictures(boolean paramBoolean);
  
  void xsetAutoCompressPictures(XmlBoolean paramXmlBoolean);
  
  void unsetAutoCompressPictures();
  
  boolean getRefreshAllConnections();
  
  XmlBoolean xgetRefreshAllConnections();
  
  boolean isSetRefreshAllConnections();
  
  void setRefreshAllConnections(boolean paramBoolean);
  
  void xsetRefreshAllConnections(XmlBoolean paramXmlBoolean);
  
  void unsetRefreshAllConnections();
  
  long getDefaultThemeVersion();
  
  XmlUnsignedInt xgetDefaultThemeVersion();
  
  boolean isSetDefaultThemeVersion();
  
  void setDefaultThemeVersion(long paramLong);
  
  void xsetDefaultThemeVersion(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDefaultThemeVersion();
  
  public static final class Factory {
    public static CTWorkbookPr newInstance() {
      return (CTWorkbookPr)POIXMLTypeLoader.newInstance(CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr newInstance(XmlOptions param1XmlOptions) {
      return (CTWorkbookPr)POIXMLTypeLoader.newInstance(CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(String param1String) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1String, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1String, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(File param1File) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1File, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1File, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(URL param1URL) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1URL, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1URL, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1InputStream, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1InputStream, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1Reader, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1Reader, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(Node param1Node) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1Node, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1Node, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static CTWorkbookPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbookPr.type, null);
    }
    
    public static CTWorkbookPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTWorkbookPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbookPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbookPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbookPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTWorkbookPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */