/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
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
/*     */ public abstract class AbstractXWPFSDT
/*     */   implements ISDTContents
/*     */ {
/*     */   private final String title;
/*     */   private final String tag;
/*     */   private final IBody part;
/*     */   
/*     */   public AbstractXWPFSDT(CTSdtPr paramCTSdtPr, IBody paramIBody) {
/*  37 */     CTString[] arrayOfCTString1 = paramCTSdtPr.getAliasArray();
/*  38 */     if (arrayOfCTString1 != null && arrayOfCTString1.length > 0) {
/*  39 */       this.title = arrayOfCTString1[0].getVal();
/*     */     } else {
/*  41 */       this.title = "";
/*     */     } 
/*  43 */     CTString[] arrayOfCTString2 = paramCTSdtPr.getTagArray();
/*  44 */     if (arrayOfCTString2 != null && arrayOfCTString2.length > 0) {
/*  45 */       this.tag = arrayOfCTString2[0].getVal();
/*     */     } else {
/*  47 */       this.tag = "";
/*     */     } 
/*  49 */     this.part = paramIBody;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  57 */     return this.title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTag() {
/*  64 */     return this.tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ISDTContent getContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IBody getBody() {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getPart() {
/*  83 */     return this.part.getPart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyType getPartType() {
/*  90 */     return BodyType.CONTENTCONTROL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyElementType getElementType() {
/*  97 */     return BodyElementType.CONTENTCONTROL;
/*     */   }
/*     */   
/*     */   public XWPFDocument getDocument() {
/* 101 */     return this.part.getXWPFDocument();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\AbstractXWPFSDT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */