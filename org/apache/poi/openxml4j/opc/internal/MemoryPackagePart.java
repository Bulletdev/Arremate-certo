/*     */ package org.apache.poi.openxml4j.opc.internal;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MemoryPackagePart
/*     */   extends PackagePart
/*     */ {
/*     */   protected byte[] data;
/*     */   
/*     */   public MemoryPackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, String paramString) throws InvalidFormatException {
/*  61 */     super(paramOPCPackage, paramPackagePartName, paramString);
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
/*     */   public MemoryPackagePart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName, String paramString, boolean paramBoolean) throws InvalidFormatException {
/*  81 */     super(paramOPCPackage, paramPackagePartName, new ContentType(paramString), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InputStream getInputStreamImpl() {
/*  89 */     if (this.data == null) {
/*  90 */       this.data = new byte[0];
/*     */     }
/*  92 */     return new ByteArrayInputStream(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   protected OutputStream getOutputStreamImpl() {
/*  97 */     return new MemoryPackagePartOutputStream(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 102 */     return (this.data == null) ? 0L : this.data.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     this.data = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean save(OutputStream paramOutputStream) throws OpenXML4JException {
/* 112 */     return (new ZipPartMarshaller()).marshall(this, paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean load(InputStream paramInputStream) throws InvalidFormatException {
/* 118 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 120 */       IOUtils.copy(paramInputStream, byteArrayOutputStream);
/* 121 */     } catch (IOException iOException) {
/* 122 */       throw new InvalidFormatException(iOException.getMessage());
/*     */     } 
/*     */ 
/*     */     
/* 126 */     this.data = byteArrayOutputStream.toByteArray();
/*     */ 
/*     */     
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   public void close() {}
/*     */   
/*     */   public void flush() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\MemoryPackagePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */