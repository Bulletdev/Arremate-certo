/*    */ package org.apache.poi.openxml4j.opc.internal.marshallers;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.StreamHelper;
/*    */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
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
/*    */ public final class ZipPackagePropertiesMarshaller
/*    */   extends PackagePropertiesMarshaller
/*    */ {
/*    */   public boolean marshall(PackagePart paramPackagePart, OutputStream paramOutputStream) throws OpenXML4JException {
/* 40 */     if (!(paramOutputStream instanceof ZipOutputStream)) {
/* 41 */       throw new IllegalArgumentException("ZipOutputStream expected!");
/*    */     }
/* 43 */     ZipOutputStream zipOutputStream = (ZipOutputStream)paramOutputStream;
/*    */ 
/*    */     
/* 46 */     ZipEntry zipEntry = new ZipEntry(ZipHelper.getZipItemNameFromOPCName(paramPackagePart.getPartName().getURI().toString()));
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 51 */       zipOutputStream.putNextEntry(zipEntry);
/* 52 */       super.marshall(paramPackagePart, paramOutputStream);
/*    */       
/* 54 */       if (!StreamHelper.saveXmlInStream(this.xmlDoc, paramOutputStream)) {
/* 55 */         return false;
/*    */       }
/* 57 */       zipOutputStream.closeEntry();
/* 58 */     } catch (IOException iOException) {
/* 59 */       throw new OpenXML4JException(iOException.getLocalizedMessage(), iOException);
/*    */     } 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\marshallers\ZipPackagePropertiesMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */