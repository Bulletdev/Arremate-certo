/*    */ package org.apache.poi.openxml4j.opc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.TreeMap;
/*    */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
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
/*    */ public final class PackagePartCollection
/*    */   extends TreeMap<PackagePartName, PackagePart>
/*    */ {
/*    */   private static final long serialVersionUID = 2515031135957635515L;
/* 40 */   private ArrayList<String> registerPartNameStr = new ArrayList<String>();
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 44 */     return super.clone();
/*    */   }
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
/*    */   public PackagePart put(PackagePartName paramPackagePartName, PackagePart paramPackagePart) {
/* 58 */     String[] arrayOfString = paramPackagePartName.getURI().toASCIIString().split(PackagingURIHelper.FORWARD_SLASH_STRING);
/*    */     
/* 60 */     StringBuffer stringBuffer = new StringBuffer();
/* 61 */     for (String str : arrayOfString) {
/* 62 */       if (!str.equals(""))
/* 63 */         stringBuffer.append(PackagingURIHelper.FORWARD_SLASH_CHAR); 
/* 64 */       stringBuffer.append(str);
/* 65 */       if (this.registerPartNameStr.contains(stringBuffer.toString())) {
/* 66 */         throw new InvalidOperationException("You can't add a part with a part name derived from another part ! [M1.11]");
/*    */       }
/*    */     } 
/*    */     
/* 70 */     this.registerPartNameStr.add(paramPackagePartName.getName());
/* 71 */     return super.put(paramPackagePartName, paramPackagePart);
/*    */   }
/*    */ 
/*    */   
/*    */   public PackagePart remove(Object paramObject) {
/* 76 */     if (paramObject instanceof PackagePartName) {
/* 77 */       this.registerPartNameStr.remove(((PackagePartName)paramObject).getName());
/*    */     }
/* 79 */     return super.remove(paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackagePartCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */