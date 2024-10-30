/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MessageFactory
/*     */ {
/*     */   private static final String DEFAULT_MESSAGE_FACTORY = "org.apache.axis.soap.MessageFactoryImpl";
/*     */   private static final String MESSAGE_FACTORY_PROPERTY = "javax.xml.soap.MessageFactory";
/*     */   
/*     */   public static MessageFactory newInstance() throws SOAPException {
/*     */     try {
/* 116 */       return (MessageFactory)FactoryFinder.find("javax.xml.soap.MessageFactory", "org.apache.axis.soap.MessageFactoryImpl");
/*     */     }
/* 118 */     catch (Exception exception) {
/* 119 */       throw new SOAPException("Unable to create message factory for SOAP: " + exception.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract SOAPMessage createMessage() throws SOAPException;
/*     */   
/*     */   public abstract SOAPMessage createMessage(MimeHeaders paramMimeHeaders, InputStream paramInputStream) throws IOException, SOAPException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\MessageFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */