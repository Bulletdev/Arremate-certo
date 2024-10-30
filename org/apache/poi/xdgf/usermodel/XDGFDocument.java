/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ 
/*     */ public class XDGFDocument
/*     */ {
/*     */   protected VisioDocumentType _document;
/*  40 */   Map<Long, XDGFStyleSheet> _styleSheets = new HashMap<Long, XDGFStyleSheet>();
/*     */ 
/*     */   
/*  43 */   long _defaultFillStyle = 0L;
/*  44 */   long _defaultGuideStyle = 0L;
/*  45 */   long _defaultLineStyle = 0L;
/*  46 */   long _defaultTextStyle = 0L;
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFDocument(VisioDocumentType paramVisioDocumentType) {
/*  51 */     this._document = paramVisioDocumentType;
/*     */     
/*  53 */     if (!this._document.isSetDocumentSettings()) {
/*  54 */       throw new POIXMLException("Document settings not found");
/*     */     }
/*  56 */     DocumentSettingsType documentSettingsType = this._document.getDocumentSettings();
/*     */     
/*  58 */     if (documentSettingsType.isSetDefaultFillStyle()) {
/*  59 */       this._defaultFillStyle = documentSettingsType.getDefaultFillStyle();
/*     */     }
/*  61 */     if (documentSettingsType.isSetDefaultGuideStyle()) {
/*  62 */       this._defaultGuideStyle = documentSettingsType.getDefaultGuideStyle();
/*     */     }
/*  64 */     if (documentSettingsType.isSetDefaultLineStyle()) {
/*  65 */       this._defaultLineStyle = documentSettingsType.getDefaultLineStyle();
/*     */     }
/*  67 */     if (documentSettingsType.isSetDefaultTextStyle()) {
/*  68 */       this._defaultTextStyle = documentSettingsType.getDefaultTextStyle();
/*     */     }
/*  70 */     if (this._document.isSetStyleSheets())
/*     */     {
/*  72 */       for (StyleSheetType styleSheetType : this._document.getStyleSheets().getStyleSheetArray()) {
/*  73 */         this._styleSheets.put(Long.valueOf(styleSheetType.getID()), new XDGFStyleSheet(styleSheetType, this));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public VisioDocumentType getXmlObject() {
/*  81 */     return this._document;
/*     */   }
/*     */ 
/*     */   
/*     */   public XDGFStyleSheet getStyleById(long paramLong) {
/*  86 */     return this._styleSheets.get(Long.valueOf(paramLong));
/*     */   }
/*     */ 
/*     */   
/*     */   public XDGFStyleSheet getDefaultFillStyle() {
/*  91 */     XDGFStyleSheet xDGFStyleSheet = getStyleById(this._defaultFillStyle);
/*  92 */     if (xDGFStyleSheet == null)
/*  93 */       throw new POIXMLException("No default fill style found!"); 
/*  94 */     return xDGFStyleSheet;
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getDefaultGuideStyle() {
/*  98 */     XDGFStyleSheet xDGFStyleSheet = getStyleById(this._defaultGuideStyle);
/*  99 */     if (xDGFStyleSheet == null)
/* 100 */       throw new POIXMLException("No default guide style found!"); 
/* 101 */     return xDGFStyleSheet;
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getDefaultLineStyle() {
/* 105 */     XDGFStyleSheet xDGFStyleSheet = getStyleById(this._defaultLineStyle);
/* 106 */     if (xDGFStyleSheet == null)
/* 107 */       throw new POIXMLException("No default line style found!"); 
/* 108 */     return xDGFStyleSheet;
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getDefaultTextStyle() {
/* 112 */     XDGFStyleSheet xDGFStyleSheet = getStyleById(this._defaultTextStyle);
/* 113 */     if (xDGFStyleSheet == null)
/* 114 */       throw new POIXMLException("No default text style found!"); 
/* 115 */     return xDGFStyleSheet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */