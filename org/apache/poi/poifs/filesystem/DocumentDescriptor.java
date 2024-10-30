/*     */ package org.apache.poi.poifs.filesystem;
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
/*     */ public class DocumentDescriptor
/*     */ {
/*     */   private POIFSDocumentPath path;
/*     */   private String name;
/*  33 */   private int hashcode = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentDescriptor(POIFSDocumentPath paramPOIFSDocumentPath, String paramString) {
/*  44 */     if (paramPOIFSDocumentPath == null)
/*     */     {
/*  46 */       throw new NullPointerException("path must not be null");
/*     */     }
/*  48 */     if (paramString == null)
/*     */     {
/*  50 */       throw new NullPointerException("name must not be null");
/*     */     }
/*  52 */     if (paramString.length() == 0)
/*     */     {
/*  54 */       throw new IllegalArgumentException("name cannot be empty");
/*     */     }
/*  56 */     this.path = paramPOIFSDocumentPath;
/*  57 */     this.name = paramString;
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
/*     */   public boolean equals(Object paramObject) {
/*  71 */     boolean bool = false;
/*     */     
/*  73 */     if (paramObject != null && paramObject.getClass() == getClass())
/*     */     {
/*  75 */       if (this == paramObject) {
/*     */         
/*  77 */         bool = true;
/*     */       }
/*     */       else {
/*     */         
/*  81 */         DocumentDescriptor documentDescriptor = (DocumentDescriptor)paramObject;
/*     */         
/*  83 */         bool = (this.path.equals(documentDescriptor.path) && this.name.equals(documentDescriptor.name)) ? true : false;
/*     */       } 
/*     */     }
/*     */     
/*  87 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  98 */     if (this.hashcode == 0)
/*     */     {
/* 100 */       this.hashcode = this.path.hashCode() ^ this.name.hashCode();
/*     */     }
/* 102 */     return this.hashcode;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuffer stringBuffer = new StringBuffer(40 * (this.path.length() + 1));
/*     */     
/* 109 */     for (byte b = 0; b < this.path.length(); b++)
/*     */     {
/* 111 */       stringBuffer.append(this.path.getComponent(b)).append("/");
/*     */     }
/* 113 */     stringBuffer.append(this.name);
/* 114 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\DocumentDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */