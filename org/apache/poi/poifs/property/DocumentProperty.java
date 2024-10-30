/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSDocument;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentProperty
/*     */   extends Property
/*     */ {
/*     */   private OPOIFSDocument _document;
/*     */   
/*     */   public DocumentProperty(String paramString, int paramInt) {
/*  45 */     this._document = null;
/*  46 */     setName(paramString);
/*  47 */     setSize(paramInt);
/*  48 */     setNodeColor((byte)1);
/*  49 */     setPropertyType((byte)2);
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
/*     */ 
/*     */   
/*     */   protected DocumentProperty(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/*  63 */     super(paramInt1, paramArrayOfbyte, paramInt2);
/*  64 */     this._document = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocument(OPOIFSDocument paramOPOIFSDocument) {
/*  75 */     this._document = paramOPOIFSDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSDocument getDocument() {
/*  86 */     return this._document;
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
/*     */   
/*     */   public boolean shouldUseSmallBlocks() {
/*  99 */     return super.shouldUseSmallBlocks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preWrite() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSize(int paramInt) {
/* 127 */     setSize(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\DocumentProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */