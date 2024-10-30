/*    */ package org.apache.xmlbeans.impl.soap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SOAPConnectionFactory
/*    */ {
/*    */   private static final String DEFAULT_SOAP_CONNECTION_FACTORY = "org.apache.axis.soap.SOAPConnectionFactoryImpl";
/*    */   private static final String SF_PROPERTY = "javax.xml.soap.SOAPConnectionFactory";
/*    */   
/*    */   public static SOAPConnectionFactory newInstance() throws SOAPException, UnsupportedOperationException {
/*    */     try {
/* 44 */       return (SOAPConnectionFactory)FactoryFinder.find("javax.xml.soap.SOAPConnectionFactory", "org.apache.axis.soap.SOAPConnectionFactoryImpl");
/*    */     }
/* 46 */     catch (Exception exception) {
/* 47 */       throw new SOAPException("Unable to create SOAP connection factory: " + exception.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract SOAPConnection createConnection() throws SOAPException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPConnectionFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */