/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFTheme
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTOfficeStyleSheet _theme;
/*     */   private Map<String, CTColor> _schemeColors;
/*     */   
/*     */   XSLFTheme() {
/*  56 */     this._theme = CTOfficeStyleSheet.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTheme(PackagePart paramPackagePart) throws IOException, XmlException {
/*  63 */     super(paramPackagePart);
/*  64 */     ThemeDocument themeDocument = ThemeDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  66 */     this._theme = themeDocument.getTheme();
/*  67 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XSLFTheme(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  75 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void importTheme(XSLFTheme paramXSLFTheme) {
/*  79 */     this._theme = paramXSLFTheme.getXmlObject();
/*  80 */     this._schemeColors = paramXSLFTheme._schemeColors;
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  84 */     CTBaseStyles cTBaseStyles = this._theme.getThemeElements();
/*  85 */     CTColorScheme cTColorScheme = cTBaseStyles.getClrScheme();
/*     */     
/*  87 */     this._schemeColors = new HashMap<String, CTColor>(12);
/*  88 */     for (XmlObject xmlObject : cTColorScheme.selectPath("*")) {
/*  89 */       CTColor cTColor = (CTColor)xmlObject;
/*  90 */       String str = cTColor.getDomNode().getLocalName();
/*  91 */       this._schemeColors.put(str, cTColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void initColorMap(CTColorMapping paramCTColorMapping) {
/* 101 */     this._schemeColors.put("bg1", this._schemeColors.get(paramCTColorMapping.getBg1().toString()));
/* 102 */     this._schemeColors.put("bg2", this._schemeColors.get(paramCTColorMapping.getBg2().toString()));
/* 103 */     this._schemeColors.put("tx1", this._schemeColors.get(paramCTColorMapping.getTx1().toString()));
/* 104 */     this._schemeColors.put("tx2", this._schemeColors.get(paramCTColorMapping.getTx2().toString()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 112 */     return this._theme.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 121 */     this._theme.setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CTColor getCTColor(String paramString) {
/* 130 */     return this._schemeColors.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTOfficeStyleSheet getXmlObject() {
/* 138 */     return this._theme;
/*     */   }
/*     */   
/*     */   protected final void commit() throws IOException {
/* 142 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 143 */     xmlOptions.setSaveSyntheticDocumentElement(new b("http://schemas.openxmlformats.org/drawingml/2006/main", "theme"));
/*     */ 
/*     */     
/* 146 */     PackagePart packagePart = getPackagePart();
/* 147 */     OutputStream outputStream = packagePart.getOutputStream();
/* 148 */     getXmlObject().save(outputStream, xmlOptions);
/* 149 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMajorFont() {
/* 158 */     return this._theme.getThemeElements().getFontScheme().getMajorFont().getLatin().getTypeface();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMinorFont() {
/* 167 */     return this._theme.getThemeElements().getFontScheme().getMinorFont().getLatin().getTypeface();
/*     */   }
/*     */ 
/*     */   
/*     */   CTTextParagraphProperties getDefaultParagraphStyle() {
/* 172 */     XmlObject[] arrayOfXmlObject = this._theme.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:objectDefaults/a:spDef/a:lstStyle/a:defPPr");
/*     */ 
/*     */ 
/*     */     
/* 176 */     if (arrayOfXmlObject.length == 1) {
/* 177 */       return (CTTextParagraphProperties)arrayOfXmlObject[0];
/*     */     }
/* 179 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */