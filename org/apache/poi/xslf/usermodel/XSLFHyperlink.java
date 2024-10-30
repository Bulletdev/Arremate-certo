/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.net.URI;
/*     */ import org.apache.poi.common.usermodel.HyperlinkType;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.sl.usermodel.Hyperlink;
/*     */ import org.apache.poi.sl.usermodel.Slide;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
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
/*     */ public class XSLFHyperlink
/*     */   implements Hyperlink<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   final XSLFSheet _sheet;
/*     */   final CTHyperlink _link;
/*     */   
/*     */   XSLFHyperlink(CTHyperlink paramCTHyperlink, XSLFSheet paramXSLFSheet) {
/*  36 */     this._sheet = paramXSLFSheet;
/*  37 */     this._link = paramCTHyperlink;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTHyperlink getXmlObject() {
/*  42 */     return this._link;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/*  47 */     linkToUrl(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAddress() {
/*  52 */     String str = this._link.getId();
/*  53 */     if (str == null || "".equals(str)) {
/*  54 */       return this._link.getAction();
/*     */     }
/*     */     
/*  57 */     URI uRI = this._sheet.getPackagePart().getRelationship(str).getTargetURI();
/*     */     
/*  59 */     return uRI.toASCIIString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLabel() {
/*  64 */     return this._link.getTooltip();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLabel(String paramString) {
/*  69 */     this._link.setTooltip(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  78 */     return getTypeEnum().getCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public HyperlinkType getTypeEnum() {
/*  83 */     String str1 = this._link.getAction();
/*  84 */     if (str1 == null) {
/*  85 */       str1 = "";
/*     */     }
/*  87 */     if (str1.equals("ppaction://hlinksldjump") || str1.startsWith("ppaction://hlinkshowjump")) {
/*  88 */       return HyperlinkType.DOCUMENT;
/*     */     }
/*     */     
/*  91 */     String str2 = getAddress();
/*  92 */     if (str2 == null) {
/*  93 */       str2 = "";
/*     */     }
/*  95 */     if (str2.startsWith("mailto:")) {
/*  96 */       return HyperlinkType.EMAIL;
/*     */     }
/*  98 */     return HyperlinkType.URL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void linkToEmail(String paramString) {
/* 104 */     linkToExternal("mailto:" + paramString);
/* 105 */     setLabel(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToUrl(String paramString) {
/* 110 */     linkToExternal(paramString);
/* 111 */     setLabel(paramString);
/*     */   }
/*     */   
/*     */   private void linkToExternal(String paramString) {
/* 115 */     PackagePart packagePart = this._sheet.getPackagePart();
/* 116 */     if (this._link.isSetId() && !this._link.getId().isEmpty()) {
/* 117 */       packagePart.removeRelationship(this._link.getId());
/*     */     }
/* 119 */     PackageRelationship packageRelationship = packagePart.addExternalRelationship(paramString, XSLFRelation.HYPERLINK.getRelation());
/* 120 */     this._link.setId(packageRelationship.getId());
/* 121 */     if (this._link.isSetAction()) {
/* 122 */       this._link.unsetAction();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToSlide(Slide<XSLFShape, XSLFTextParagraph> paramSlide) {
/* 128 */     PackagePart packagePart = this._sheet.getPackagePart();
/* 129 */     PackagePartName packagePartName = ((XSLFSheet)paramSlide).getPackagePart().getPartName();
/* 130 */     if (this._link.isSetId() && !this._link.getId().isEmpty()) {
/* 131 */       packagePart.removeRelationship(this._link.getId());
/*     */     }
/* 133 */     PackageRelationship packageRelationship = packagePart.addRelationship(packagePartName, TargetMode.INTERNAL, XSLFRelation.SLIDE.getRelation());
/*     */     
/* 135 */     this._link.setId(packageRelationship.getId());
/* 136 */     this._link.setAction("ppaction://hlinksldjump");
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToNextSlide() {
/* 141 */     linkToRelativeSlide("nextslide");
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToPreviousSlide() {
/* 146 */     linkToRelativeSlide("previousslide");
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToFirstSlide() {
/* 151 */     linkToRelativeSlide("firstslide");
/*     */   }
/*     */ 
/*     */   
/*     */   public void linkToLastSlide() {
/* 156 */     linkToRelativeSlide("lastslide");
/*     */   }
/*     */   
/*     */   private void linkToRelativeSlide(String paramString) {
/* 160 */     PackagePart packagePart = this._sheet.getPackagePart();
/* 161 */     if (this._link.isSetId() && !this._link.getId().isEmpty()) {
/* 162 */       packagePart.removeRelationship(this._link.getId());
/*     */     }
/* 164 */     this._link.setId("");
/* 165 */     this._link.setAction("ppaction://hlinkshowjump?jump=" + paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */