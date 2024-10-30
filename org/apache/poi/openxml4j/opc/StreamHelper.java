/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
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
/*     */ public final class StreamHelper
/*     */ {
/*  42 */   private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();
/*     */   
/*     */   private static synchronized Transformer getIdentityTransformer() throws TransformerException {
/*  45 */     return transformerFactory.newTransformer();
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
/*     */   public static boolean saveXmlInStream(Document paramDocument, OutputStream paramOutputStream) {
/*     */     try {
/*  61 */       Transformer transformer = getIdentityTransformer();
/*  62 */       DOMSource dOMSource = new DOMSource(paramDocument);
/*     */       
/*  64 */       StreamResult streamResult = new StreamResult(new FilterOutputStream(paramOutputStream)
/*     */           {
/*     */             
/*     */             public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException
/*     */             {
/*  69 */               this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */             }
/*     */ 
/*     */             
/*     */             public void close() throws IOException {
/*  74 */               this.out.flush();
/*     */             }
/*     */           });
/*  77 */       transformer.setOutputProperty("encoding", "UTF-8");
/*  78 */       transformer.setOutputProperty("indent", "yes");
/*  79 */       transformer.setOutputProperty("standalone", "yes");
/*  80 */       transformer.transform(dOMSource, streamResult);
/*  81 */     } catch (TransformerException transformerException) {
/*  82 */       return false;
/*     */     } 
/*  84 */     return true;
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
/*     */   public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream) {
/*     */     try {
/*  98 */       byte[] arrayOfByte = new byte[1024];
/*     */       int i;
/* 100 */       while ((i = paramInputStream.read(arrayOfByte)) >= 0) {
/* 101 */         paramOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 103 */     } catch (Exception exception) {
/* 104 */       return false;
/*     */     } 
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\StreamHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */