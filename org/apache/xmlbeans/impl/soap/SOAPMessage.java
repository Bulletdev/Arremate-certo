/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SOAPMessage
/*     */ {
/*     */   public static final String CHARACTER_SET_ENCODING = "javax.xml.soap.character-set-encoding";
/*     */   public static final String WRITE_XML_DECLARATION = "javax.xml.soap.write-xml-declaration";
/*     */   
/*     */   public abstract String getContentDescription();
/*     */   
/*     */   public abstract void setContentDescription(String paramString);
/*     */   
/*     */   public abstract SOAPPart getSOAPPart();
/*     */   
/*     */   public abstract void removeAllAttachments();
/*     */   
/*     */   public abstract int countAttachments();
/*     */   
/*     */   public abstract Iterator getAttachments();
/*     */   
/*     */   public abstract Iterator getAttachments(MimeHeaders paramMimeHeaders);
/*     */   
/*     */   public abstract void addAttachmentPart(AttachmentPart paramAttachmentPart);
/*     */   
/*     */   public abstract AttachmentPart createAttachmentPart();
/*     */   
/*     */   public abstract MimeHeaders getMimeHeaders();
/*     */   
/*     */   public AttachmentPart createAttachmentPart(Object paramObject, String paramString) {
/* 243 */     AttachmentPart attachmentPart = createAttachmentPart();
/*     */     
/* 245 */     attachmentPart.setContent(paramObject, paramString);
/*     */     
/* 247 */     return attachmentPart;
/*     */   }
/*     */   
/*     */   public abstract void saveChanges() throws SOAPException;
/*     */   
/*     */   public abstract boolean saveRequired();
/*     */   
/*     */   public abstract void writeTo(OutputStream paramOutputStream) throws SOAPException, IOException;
/*     */   
/*     */   public abstract SOAPBody getSOAPBody() throws SOAPException;
/*     */   
/*     */   public abstract SOAPHeader getSOAPHeader() throws SOAPException;
/*     */   
/*     */   public abstract void setProperty(String paramString, Object paramObject) throws SOAPException;
/*     */   
/*     */   public abstract Object getProperty(String paramString) throws SOAPException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPMessage.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */