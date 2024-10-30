/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOAPElementFactory
/*     */ {
/*     */   private SOAPFactory sf;
/*     */   
/*     */   private SOAPElementFactory(SOAPFactory paramSOAPFactory) {
/*  40 */     this.sf = paramSOAPFactory;
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
/*     */   public SOAPElement create(Name paramName) throws SOAPException {
/*  56 */     return this.sf.createElement(paramName);
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
/*     */   public SOAPElement create(String paramString) throws SOAPException {
/*  72 */     return this.sf.createElement(paramString);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public SOAPElement create(String paramString1, String paramString2, String paramString3) throws SOAPException {
/*  94 */     return this.sf.createElement(paramString1, paramString2, paramString3);
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
/*     */   public static SOAPElementFactory newInstance() throws SOAPException {
/*     */     try {
/* 109 */       return new SOAPElementFactory(SOAPFactory.newInstance());
/* 110 */     } catch (Exception exception) {
/* 111 */       throw new SOAPException("Unable to create SOAP Element Factory: " + exception.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPElementFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */