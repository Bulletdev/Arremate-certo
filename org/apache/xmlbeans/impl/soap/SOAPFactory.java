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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SOAPFactory
/*     */ {
/*     */   private static final String SF_PROPERTY = "javax.xml.soap.SOAPFactory";
/*     */   private static final String DEFAULT_SF = "org.apache.axis.soap.SOAPFactoryImpl";
/*     */   
/*     */   public abstract SOAPElement createElement(Name paramName) throws SOAPException;
/*     */   
/*     */   public abstract SOAPElement createElement(String paramString) throws SOAPException;
/*     */   
/*     */   public abstract SOAPElement createElement(String paramString1, String paramString2, String paramString3) throws SOAPException;
/*     */   
/*     */   public abstract Detail createDetail() throws SOAPException;
/*     */   
/*     */   public abstract Name createName(String paramString1, String paramString2, String paramString3) throws SOAPException;
/*     */   
/*     */   public abstract Name createName(String paramString) throws SOAPException;
/*     */   
/*     */   public static SOAPFactory newInstance() throws SOAPException {
/*     */     try {
/* 136 */       return (SOAPFactory)FactoryFinder.find("javax.xml.soap.SOAPFactory", "org.apache.axis.soap.SOAPFactoryImpl");
/* 137 */     } catch (Exception exception) {
/* 138 */       throw new SOAPException("Unable to create SOAP Factory: " + exception.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */