/*    */ package org.apache.poi.openxml4j.opc.internal.unmarshallers;
/*    */ 
/*    */ import java.util.zip.ZipEntry;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.openxml4j.opc.PackagePartName;
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
/*    */ public final class UnmarshallContext
/*    */ {
/*    */   private OPCPackage _package;
/*    */   private PackagePartName partName;
/*    */   private ZipEntry zipEntry;
/*    */   
/*    */   public UnmarshallContext(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName) {
/* 48 */     this._package = paramOPCPackage;
/* 49 */     this.partName = paramPackagePartName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   OPCPackage getPackage() {
/* 56 */     return this._package;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPackage(OPCPackage paramOPCPackage) {
/* 64 */     this._package = paramOPCPackage;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   PackagePartName getPartName() {
/* 71 */     return this.partName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPartName(PackagePartName paramPackagePartName) {
/* 79 */     this.partName = paramPackagePartName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ZipEntry getZipEntry() {
/* 86 */     return this.zipEntry;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setZipEntry(ZipEntry paramZipEntry) {
/* 94 */     this.zipEntry = paramZipEntry;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\interna\\unmarshallers\UnmarshallContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */