/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.xssf.usermodel.XSSFColor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
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
/*     */ public class ThemesTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private ThemeDocument theme;
/*     */   
/*     */   public enum ThemeElement
/*     */   {
/*     */     public final int idx;
/*  39 */     LT1(0, "Lt1"),
/*  40 */     DK1(1, "Dk1"),
/*  41 */     LT2(2, "Lt2"),
/*  42 */     DK2(3, "Dk2"),
/*  43 */     ACCENT1(4, "Accent1"),
/*  44 */     ACCENT2(5, "Accent2"),
/*  45 */     ACCENT3(6, "Accent3"),
/*  46 */     ACCENT4(7, "Accent4"),
/*  47 */     ACCENT5(8, "Accent5"),
/*  48 */     ACCENT6(9, "Accent6"),
/*  49 */     HLINK(10, "Hlink"),
/*  50 */     FOLHLINK(11, "FolHlink"),
/*  51 */     UNKNOWN(-1, null); public final String name;
/*     */     
/*     */     public static ThemeElement byId(int param1Int) {
/*  54 */       if (param1Int >= (values()).length || param1Int < 0) return UNKNOWN; 
/*  55 */       return values()[param1Int];
/*     */     }
/*     */     ThemeElement(int param1Int1, String param1String1) {
/*  58 */       this.idx = param1Int1; this.name = param1String1;
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
/*     */   
/*     */   public ThemesTable() {
/*  71 */     this.theme = ThemeDocument.Factory.newInstance();
/*  72 */     this.theme.addNewTheme().addNewThemeElements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThemesTable(PackagePart paramPackagePart) throws IOException {
/*  82 */     super(paramPackagePart);
/*     */     
/*     */     try {
/*  85 */       this.theme = ThemeDocument.Factory.parse(paramPackagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  86 */     } catch (XmlException xmlException) {
/*  87 */       throw new IOException(xmlException.getLocalizedMessage(), xmlException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ThemesTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  96 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThemesTable(ThemeDocument paramThemeDocument) {
/* 104 */     this.theme = paramThemeDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColor getThemeColor(int paramInt) {
/*     */     CTColor cTColor;
/* 116 */     CTColorScheme cTColorScheme = this.theme.getTheme().getThemeElements().getClrScheme();
/*     */     
/* 118 */     switch (ThemeElement.byId(paramInt)) { case LT1:
/* 119 */         cTColor = cTColorScheme.getLt1(); break;
/* 120 */       case DK1: cTColor = cTColorScheme.getDk1(); break;
/* 121 */       case LT2: cTColor = cTColorScheme.getLt2(); break;
/* 122 */       case DK2: cTColor = cTColorScheme.getDk2(); break;
/* 123 */       case ACCENT1: cTColor = cTColorScheme.getAccent1(); break;
/* 124 */       case ACCENT2: cTColor = cTColorScheme.getAccent2(); break;
/* 125 */       case ACCENT3: cTColor = cTColorScheme.getAccent3(); break;
/* 126 */       case ACCENT4: cTColor = cTColorScheme.getAccent4(); break;
/* 127 */       case ACCENT5: cTColor = cTColorScheme.getAccent5(); break;
/* 128 */       case ACCENT6: cTColor = cTColorScheme.getAccent6(); break;
/* 129 */       case HLINK: cTColor = cTColorScheme.getHlink(); break;
/* 130 */       case FOLHLINK: cTColor = cTColorScheme.getFolHlink(); break;
/* 131 */       default: return null; }
/*     */ 
/*     */     
/* 134 */     byte[] arrayOfByte = null;
/* 135 */     if (cTColor.isSetSrgbClr()) {
/*     */       
/* 137 */       arrayOfByte = cTColor.getSrgbClr().getVal();
/* 138 */     } else if (cTColor.isSetSysClr()) {
/*     */       
/* 140 */       arrayOfByte = cTColor.getSysClr().getLastClr();
/*     */     } else {
/* 142 */       return null;
/*     */     } 
/* 144 */     return new XSSFColor(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inheritFromThemeAsRequired(XSSFColor paramXSSFColor) {
/* 153 */     if (paramXSSFColor == null) {
/*     */       return;
/*     */     }
/*     */     
/* 157 */     if (!paramXSSFColor.getCTColor().isSetTheme()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 163 */     XSSFColor xSSFColor = getThemeColor(paramXSSFColor.getTheme());
/*     */ 
/*     */     
/* 166 */     paramXSSFColor.getCTColor().setRgb(xSSFColor.getCTColor().getRgb());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 178 */     this.theme.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 183 */     PackagePart packagePart = getPackagePart();
/* 184 */     OutputStream outputStream = packagePart.getOutputStream();
/* 185 */     writeTo(outputStream);
/* 186 */     outputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\ThemesTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */