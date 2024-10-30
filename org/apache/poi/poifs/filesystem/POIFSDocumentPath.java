/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.File;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class POIFSDocumentPath
/*     */ {
/*  36 */   private static final POILogger log = POILogFactory.getLogger(POIFSDocumentPath.class);
/*     */   
/*     */   private final String[] components;
/*  39 */   private int hashcode = 0;
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
/*     */   public POIFSDocumentPath(String[] paramArrayOfString) throws IllegalArgumentException {
/*  68 */     if (paramArrayOfString == null) {
/*     */       
/*  70 */       this.components = new String[0];
/*     */     }
/*     */     else {
/*     */       
/*  74 */       this.components = new String[paramArrayOfString.length];
/*  75 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */         
/*  77 */         if (paramArrayOfString[b] == null || paramArrayOfString[b].length() == 0)
/*     */         {
/*     */           
/*  80 */           throw new IllegalArgumentException("components cannot contain null or empty strings");
/*     */         }
/*     */         
/*  83 */         this.components[b] = paramArrayOfString[b];
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
/*     */   
/*     */   public POIFSDocumentPath() {
/*  97 */     this.components = new String[0];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIFSDocumentPath(POIFSDocumentPath paramPOIFSDocumentPath, String[] paramArrayOfString) throws IllegalArgumentException {
/* 116 */     if (paramArrayOfString == null) {
/*     */       
/* 118 */       this.components = new String[paramPOIFSDocumentPath.components.length];
/*     */     }
/*     */     else {
/*     */       
/* 122 */       this.components = new String[paramPOIFSDocumentPath.components.length + paramArrayOfString.length];
/*     */     } 
/*     */     byte b;
/* 125 */     for (b = 0; b < paramPOIFSDocumentPath.components.length; b++)
/*     */     {
/* 127 */       this.components[b] = paramPOIFSDocumentPath.components[b];
/*     */     }
/* 129 */     if (paramArrayOfString != null)
/*     */     {
/* 131 */       for (b = 0; b < paramArrayOfString.length; b++) {
/*     */         
/* 133 */         if (paramArrayOfString[b] == null)
/*     */         {
/* 135 */           throw new IllegalArgumentException("components cannot contain null");
/*     */         }
/*     */         
/* 138 */         if (paramArrayOfString[b].length() == 0)
/*     */         {
/* 140 */           log.log(5, new Object[] { "Directory under " + paramPOIFSDocumentPath + " has an empty name, " + "not all OLE2 readers will handle this file correctly!" });
/*     */         }
/*     */ 
/*     */         
/* 144 */         this.components[b + paramPOIFSDocumentPath.components.length] = paramArrayOfString[b];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 162 */     boolean bool = false;
/*     */     
/* 164 */     if (paramObject != null && paramObject.getClass() == getClass())
/*     */     {
/* 166 */       if (this == paramObject) {
/*     */         
/* 168 */         bool = true;
/*     */       }
/*     */       else {
/*     */         
/* 172 */         POIFSDocumentPath pOIFSDocumentPath = (POIFSDocumentPath)paramObject;
/*     */         
/* 174 */         if (pOIFSDocumentPath.components.length == this.components.length) {
/*     */           
/* 176 */           bool = true;
/* 177 */           for (byte b = 0; b < this.components.length; b++) {
/*     */             
/* 179 */             if (!pOIFSDocumentPath.components[b].equals(this.components[b])) {
/*     */ 
/*     */               
/* 182 */               bool = false;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 189 */     return bool;
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
/* 200 */     if (this.hashcode == 0)
/*     */     {
/* 202 */       this.hashcode = computeHashCode();
/*     */     }
/* 204 */     return this.hashcode;
/*     */   }
/*     */   
/*     */   private int computeHashCode() {
/* 208 */     int i = 0;
/* 209 */     for (byte b = 0; b < this.components.length; b++)
/*     */     {
/* 211 */       i += this.components[b].hashCode();
/*     */     }
/* 213 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 222 */     return this.components.length;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComponent(int paramInt) throws ArrayIndexOutOfBoundsException {
/* 239 */     return this.components[paramInt];
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
/*     */   public POIFSDocumentPath getParent() {
/* 252 */     int i = this.components.length - 1;
/*     */     
/* 254 */     if (i < 0)
/*     */     {
/* 256 */       return null;
/*     */     }
/* 258 */     String[] arrayOfString = new String[i];
/* 259 */     System.arraycopy(this.components, 0, arrayOfString, 0, i);
/* 260 */     return new POIFSDocumentPath(arrayOfString);
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
/*     */   
/*     */   public String getName() {
/* 275 */     if (this.components.length == 0) {
/* 276 */       return "";
/*     */     }
/* 278 */     return this.components[this.components.length - 1];
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
/*     */   public String toString() {
/* 292 */     StringBuffer stringBuffer = new StringBuffer();
/* 293 */     int i = length();
/*     */     
/* 295 */     stringBuffer.append(File.separatorChar);
/* 296 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 298 */       stringBuffer.append(getComponent(b));
/* 299 */       if (b < i - 1)
/*     */       {
/* 301 */         stringBuffer.append(File.separatorChar);
/*     */       }
/*     */     } 
/* 304 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\POIFSDocumentPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */