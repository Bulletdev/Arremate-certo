/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import javax.xml.transform.Source;
/*     */ import org.w3c.dom.Document;
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
/*     */ public abstract class SOAPPart
/*     */   implements Document
/*     */ {
/*     */   public abstract SOAPEnvelope getEnvelope() throws SOAPException;
/*     */   
/*     */   public String getContentId() {
/*  82 */     String[] arrayOfString = getMimeHeader("Content-Id");
/*     */     
/*  84 */     if (arrayOfString != null && arrayOfString.length > 0) {
/*  85 */       return arrayOfString[0];
/*     */     }
/*  87 */     return null;
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
/*     */   public String getContentLocation() {
/* 100 */     String[] arrayOfString = getMimeHeader("Content-Location");
/*     */     
/* 102 */     if (arrayOfString != null && arrayOfString.length > 0) {
/* 103 */       return arrayOfString[0];
/*     */     }
/* 105 */     return null;
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
/*     */   public void setContentId(String paramString) {
/* 119 */     setMimeHeader("Content-Id", paramString);
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
/*     */   public void setContentLocation(String paramString) {
/* 133 */     setMimeHeader("Content-Location", paramString);
/*     */   }
/*     */   
/*     */   public abstract void removeMimeHeader(String paramString);
/*     */   
/*     */   public abstract void removeAllMimeHeaders();
/*     */   
/*     */   public abstract String[] getMimeHeader(String paramString);
/*     */   
/*     */   public abstract void setMimeHeader(String paramString1, String paramString2);
/*     */   
/*     */   public abstract void addMimeHeader(String paramString1, String paramString2);
/*     */   
/*     */   public abstract Iterator getAllMimeHeaders();
/*     */   
/*     */   public abstract Iterator getMatchingMimeHeaders(String[] paramArrayOfString);
/*     */   
/*     */   public abstract Iterator getNonMatchingMimeHeaders(String[] paramArrayOfString);
/*     */   
/*     */   public abstract void setContent(Source paramSource) throws SOAPException;
/*     */   
/*     */   public abstract Source getContent() throws SOAPException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPPart.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */