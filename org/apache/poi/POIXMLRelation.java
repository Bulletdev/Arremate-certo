/*     */ package org.apache.poi;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class POIXMLRelation
/*     */ {
/*     */   protected String _type;
/*     */   protected String _relation;
/*     */   protected String _defaultName;
/*     */   private Class<? extends POIXMLDocumentPart> _cls;
/*     */   
/*     */   public POIXMLRelation(String paramString1, String paramString2, String paramString3, Class<? extends POIXMLDocumentPart> paramClass) {
/*  53 */     this._type = paramString1;
/*  54 */     this._relation = paramString2;
/*  55 */     this._defaultName = paramString3;
/*  56 */     this._cls = paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLRelation(String paramString1, String paramString2, String paramString3) {
/*  67 */     this(paramString1, paramString2, paramString3, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/*  76 */     return this._type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRelation() {
/*  87 */     return this._relation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultFileName() {
/*  97 */     return this._defaultName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName(int paramInt) {
/* 107 */     if (this._defaultName.indexOf("#") == -1)
/*     */     {
/* 109 */       return getDefaultFileName();
/*     */     }
/* 111 */     return this._defaultName.replace("#", Integer.toString(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFileNameIndex(POIXMLDocumentPart paramPOIXMLDocumentPart) {
/* 122 */     String str = this._defaultName.replace("#", "(\\d+)");
/* 123 */     return Integer.valueOf(paramPOIXMLDocumentPart.getPackagePart().getPartName().getName().replaceAll(str, "$1"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends POIXMLDocumentPart> getRelationClass() {
/* 132 */     return this._cls;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */