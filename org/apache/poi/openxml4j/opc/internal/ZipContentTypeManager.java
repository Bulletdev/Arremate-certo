/*    */ package org.apache.poi.openxml4j.opc.internal;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.openxml4j.opc.StreamHelper;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
/*    */ import org.w3c.dom.Document;
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
/*    */ public class ZipContentTypeManager
/*    */   extends ContentTypeManager
/*    */ {
/* 41 */   private static POILogger logger = POILogFactory.getLogger(ZipContentTypeManager.class);
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
/*    */   public ZipContentTypeManager(InputStream paramInputStream, OPCPackage paramOPCPackage) throws InvalidFormatException {
/* 54 */     super(paramInputStream, paramOPCPackage);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean saveImpl(Document paramDocument, OutputStream paramOutputStream) {
/* 60 */     ZipOutputStream zipOutputStream = null;
/* 61 */     if (paramOutputStream instanceof ZipOutputStream) {
/* 62 */       zipOutputStream = (ZipOutputStream)paramOutputStream;
/*    */     } else {
/* 64 */       zipOutputStream = new ZipOutputStream(paramOutputStream);
/*    */     } 
/* 66 */     ZipEntry zipEntry = new ZipEntry("[Content_Types].xml");
/*    */     
/*    */     try {
/* 69 */       zipOutputStream.putNextEntry(zipEntry);
/*    */       
/* 71 */       if (!StreamHelper.saveXmlInStream(paramDocument, zipOutputStream)) {
/* 72 */         return false;
/*    */       }
/* 74 */       zipOutputStream.closeEntry();
/* 75 */     } catch (IOException iOException) {
/* 76 */       logger.log(7, new Object[] { "Cannot write: [Content_Types].xml in Zip !", iOException });
/*    */       
/* 78 */       return false;
/*    */     } 
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\ZipContentTypeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */