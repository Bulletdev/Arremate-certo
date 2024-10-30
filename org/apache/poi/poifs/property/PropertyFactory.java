/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.storage.ListManagedBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PropertyFactory
/*     */ {
/*     */   static List<Property> convertToProperties(ListManagedBlock[] paramArrayOfListManagedBlock) throws IOException {
/*  61 */     ArrayList<Property> arrayList = new ArrayList();
/*     */     
/*  63 */     for (byte b = 0; b < paramArrayOfListManagedBlock.length; b++) {
/*  64 */       byte[] arrayOfByte = paramArrayOfListManagedBlock[b].getData();
/*  65 */       convertToProperties(arrayOfByte, arrayList);
/*     */     } 
/*  67 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void convertToProperties(byte[] paramArrayOfbyte, List<Property> paramList) throws IOException {
/*  73 */     int i = paramArrayOfbyte.length / 128;
/*  74 */     byte b1 = 0;
/*     */     
/*  76 */     for (byte b2 = 0; b2 < i; b2++) {
/*  77 */       switch (paramArrayOfbyte[b1 + 66]) {
/*     */         case 1:
/*  79 */           paramList.add(new DirectoryProperty(paramList.size(), paramArrayOfbyte, b1));
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/*  85 */           paramList.add(new DocumentProperty(paramList.size(), paramArrayOfbyte, b1));
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/*  91 */           paramList.add(new RootProperty(paramList.size(), paramArrayOfbyte, b1));
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/*  97 */           paramList.add(null);
/*     */           break;
/*     */       } 
/*     */       
/* 101 */       b1 += 128;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\PropertyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */