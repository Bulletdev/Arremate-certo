/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZipPackagePart
/*     */   extends PackagePart
/*     */ {
/*     */   private ZipEntry zipEntry;
/*     */   
/*     */   public ZipPackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, String paramString) throws InvalidFormatException {
/*  59 */     super(paramOPCPackage, paramPackagePartName, paramString);
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
/*     */   public ZipPackagePart(OPCPackage paramOPCPackage, ZipEntry paramZipEntry, PackagePartName paramPackagePartName, String paramString) throws InvalidFormatException {
/*  79 */     super(paramOPCPackage, paramPackagePartName, paramString);
/*  80 */     this.zipEntry = paramZipEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZipEntry getZipArchive() {
/*  89 */     return this.zipEntry;
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
/*     */   protected InputStream getInputStreamImpl() throws IOException {
/* 102 */     return ((ZipPackage)this._container).getZipArchive().getInputStream(this.zipEntry);
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
/*     */   protected OutputStream getOutputStreamImpl() {
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 119 */     return this.zipEntry.getSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean save(OutputStream paramOutputStream) throws OpenXML4JException {
/* 124 */     return (new ZipPartMarshaller()).marshall(this, paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public boolean load(InputStream paramInputStream) {
/* 130 */     throw new InvalidOperationException("Method not implemented !");
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void close() {
/* 136 */     throw new InvalidOperationException("Method not implemented !");
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void flush() {
/* 142 */     throw new InvalidOperationException("Method not implemented !");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\ZipPackagePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */