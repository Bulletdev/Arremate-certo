/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;
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
/*     */ public class XWPFStyles
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTStyles ctStyles;
/*  55 */   private List<XWPFStyle> listStyle = new ArrayList<XWPFStyle>();
/*     */ 
/*     */   
/*     */   private XWPFLatentStyles latentStyles;
/*     */ 
/*     */   
/*     */   private XWPFDefaultRunStyle defaultRunStyle;
/*     */ 
/*     */   
/*     */   private XWPFDefaultParagraphStyle defaultParaStyle;
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyles(PackagePart paramPackagePart) throws IOException, OpenXML4JException {
/*  69 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFStyles(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, OpenXML4JException {
/*  77 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyles() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  92 */     InputStream inputStream = getPackagePart().getInputStream();
/*     */     try {
/*  94 */       StylesDocument stylesDocument = StylesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  95 */       setStyles(stylesDocument.getStyles());
/*  96 */       this.latentStyles = new XWPFLatentStyles(this.ctStyles.getLatentStyles(), this);
/*  97 */     } catch (XmlException xmlException) {
/*  98 */       throw new POIXMLException("Unable to read styles", xmlException);
/*     */     } finally {
/* 100 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 106 */     if (this.ctStyles == null) {
/* 107 */       throw new IllegalStateException("Unable to write out styles that were never read in!");
/*     */     }
/*     */     
/* 110 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 111 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTStyles.type.getName().getNamespaceURI(), "styles"));
/* 112 */     PackagePart packagePart = getPackagePart();
/* 113 */     OutputStream outputStream = packagePart.getOutputStream();
/* 114 */     this.ctStyles.save(outputStream, xmlOptions);
/* 115 */     outputStream.close();
/*     */   }
/*     */   
/*     */   protected void ensureDocDefaults() {
/* 119 */     if (!this.ctStyles.isSetDocDefaults()) {
/* 120 */       this.ctStyles.addNewDocDefaults();
/*     */     }
/*     */     
/* 123 */     CTDocDefaults cTDocDefaults = this.ctStyles.getDocDefaults();
/* 124 */     if (!cTDocDefaults.isSetPPrDefault())
/* 125 */       cTDocDefaults.addNewPPrDefault(); 
/* 126 */     if (!cTDocDefaults.isSetRPrDefault()) {
/* 127 */       cTDocDefaults.addNewRPrDefault();
/*     */     }
/* 129 */     CTPPrDefault cTPPrDefault = cTDocDefaults.getPPrDefault();
/* 130 */     CTRPrDefault cTRPrDefault = cTDocDefaults.getRPrDefault();
/* 131 */     if (!cTPPrDefault.isSetPPr()) cTPPrDefault.addNewPPr(); 
/* 132 */     if (!cTRPrDefault.isSetRPr()) cTRPrDefault.addNewRPr();
/*     */     
/* 134 */     this.defaultRunStyle = new XWPFDefaultRunStyle(cTRPrDefault.getRPr());
/* 135 */     this.defaultParaStyle = new XWPFDefaultParagraphStyle(cTPPrDefault.getPPr());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyles(CTStyles paramCTStyles) {
/* 144 */     this.ctStyles = paramCTStyles;
/*     */ 
/*     */     
/* 147 */     for (CTStyle cTStyle : this.ctStyles.getStyleArray()) {
/* 148 */       this.listStyle.add(new XWPFStyle(cTStyle, this));
/*     */     }
/* 150 */     if (this.ctStyles.isSetDocDefaults()) {
/* 151 */       CTDocDefaults cTDocDefaults = this.ctStyles.getDocDefaults();
/* 152 */       if (cTDocDefaults.isSetRPrDefault() && cTDocDefaults.getRPrDefault().isSetRPr()) {
/* 153 */         this.defaultRunStyle = new XWPFDefaultRunStyle(cTDocDefaults.getRPrDefault().getRPr());
/*     */       }
/*     */       
/* 156 */       if (cTDocDefaults.isSetPPrDefault() && cTDocDefaults.getPPrDefault().isSetPPr()) {
/* 157 */         this.defaultParaStyle = new XWPFDefaultParagraphStyle(cTDocDefaults.getPPrDefault().getPPr());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean styleExist(String paramString) {
/* 170 */     for (XWPFStyle xWPFStyle : this.listStyle) {
/* 171 */       if (xWPFStyle.getStyleId().equals(paramString))
/* 172 */         return true; 
/*     */     } 
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addStyle(XWPFStyle paramXWPFStyle) {
/* 184 */     this.listStyle.add(paramXWPFStyle);
/* 185 */     this.ctStyles.addNewStyle();
/* 186 */     int i = this.ctStyles.sizeOfStyleArray() - 1;
/* 187 */     this.ctStyles.setStyleArray(i, paramXWPFStyle.getCTStyle());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyle getStyle(String paramString) {
/* 197 */     for (XWPFStyle xWPFStyle : this.listStyle) {
/* 198 */       if (xWPFStyle.getStyleId().equals(paramString))
/* 199 */         return xWPFStyle; 
/*     */     } 
/* 201 */     return null;
/*     */   }
/*     */   
/*     */   public int getNumberOfStyles() {
/* 205 */     return this.listStyle.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFStyle> getUsedStyleList(XWPFStyle paramXWPFStyle) {
/* 216 */     ArrayList<XWPFStyle> arrayList = new ArrayList();
/* 217 */     arrayList.add(paramXWPFStyle);
/* 218 */     return getUsedStyleList(paramXWPFStyle, arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<XWPFStyle> getUsedStyleList(XWPFStyle paramXWPFStyle, List<XWPFStyle> paramList) {
/* 228 */     String str1 = paramXWPFStyle.getBasisStyleID();
/* 229 */     XWPFStyle xWPFStyle1 = getStyle(str1);
/* 230 */     if (xWPFStyle1 != null && !paramList.contains(xWPFStyle1)) {
/* 231 */       paramList.add(xWPFStyle1);
/* 232 */       getUsedStyleList(xWPFStyle1, paramList);
/*     */     } 
/* 234 */     String str2 = paramXWPFStyle.getLinkStyleID();
/* 235 */     XWPFStyle xWPFStyle2 = getStyle(str2);
/* 236 */     if (xWPFStyle2 != null && !paramList.contains(xWPFStyle2)) {
/* 237 */       paramList.add(xWPFStyle2);
/* 238 */       getUsedStyleList(xWPFStyle2, paramList);
/*     */     } 
/*     */     
/* 241 */     String str3 = paramXWPFStyle.getNextStyleID();
/* 242 */     XWPFStyle xWPFStyle3 = getStyle(str3);
/* 243 */     if (xWPFStyle3 != null && !paramList.contains(xWPFStyle3)) {
/* 244 */       paramList.add(xWPFStyle2);
/* 245 */       getUsedStyleList(xWPFStyle2, paramList);
/*     */     } 
/* 247 */     return paramList;
/*     */   }
/*     */   
/*     */   protected CTLanguage getCTLanguage() {
/* 251 */     ensureDocDefaults();
/*     */     
/* 253 */     CTLanguage cTLanguage = null;
/* 254 */     if (this.defaultRunStyle.getRPr().isSetLang()) {
/* 255 */       cTLanguage = this.defaultRunStyle.getRPr().getLang();
/*     */     } else {
/* 257 */       cTLanguage = this.defaultRunStyle.getRPr().addNewLang();
/*     */     } 
/*     */     
/* 260 */     return cTLanguage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSpellingLanguage(String paramString) {
/* 269 */     CTLanguage cTLanguage = getCTLanguage();
/* 270 */     cTLanguage.setVal(paramString);
/* 271 */     cTLanguage.setBidi(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEastAsia(String paramString) {
/* 280 */     CTLanguage cTLanguage = getCTLanguage();
/* 281 */     cTLanguage.setEastAsia(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultFonts(CTFonts paramCTFonts) {
/* 290 */     ensureDocDefaults();
/*     */     
/* 292 */     CTRPr cTRPr = this.defaultRunStyle.getRPr();
/* 293 */     cTRPr.setRFonts(paramCTFonts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyle getStyleWithSameName(XWPFStyle paramXWPFStyle) {
/* 301 */     for (XWPFStyle xWPFStyle : this.listStyle) {
/* 302 */       if (xWPFStyle.hasSameName(paramXWPFStyle)) {
/* 303 */         return xWPFStyle;
/*     */       }
/*     */     } 
/* 306 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFDefaultRunStyle getDefaultRunStyle() {
/* 313 */     ensureDocDefaults();
/* 314 */     return this.defaultRunStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFDefaultParagraphStyle getDefaultParagraphStyle() {
/* 321 */     ensureDocDefaults();
/* 322 */     return this.defaultParaStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFLatentStyles getLatentStyles() {
/* 329 */     return this.latentStyles;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */