/*    */ package org.apache.poi.ddf;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.util.LittleEndian;
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
/*    */ public final class EscherPropertyFactory
/*    */ {
/*    */   public List<EscherProperty> createProperties(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
/* 38 */     ArrayList<EscherBoolProperty> arrayList = new ArrayList();
/*    */     
/* 40 */     int i = paramInt;
/*    */     
/* 42 */     for (byte b = 0; b < paramShort; b++) {
/*    */ 
/*    */       
/* 45 */       short s1 = LittleEndian.getShort(paramArrayOfbyte, i);
/* 46 */       int j = LittleEndian.getInt(paramArrayOfbyte, i + 2);
/* 47 */       short s2 = (short)(s1 & 0x3FFF);
/* 48 */       boolean bool = ((s1 & Short.MIN_VALUE) != 0) ? true : false;
/*    */ 
/*    */       
/* 51 */       byte b1 = EscherProperties.getPropertyType(s2);
/* 52 */       if (b1 == 1) {
/* 53 */         arrayList.add(new EscherBoolProperty(s1, j));
/* 54 */       } else if (b1 == 2) {
/* 55 */         arrayList.add(new EscherRGBProperty(s1, j));
/* 56 */       } else if (b1 == 3) {
/* 57 */         arrayList.add(new EscherShapePathProperty(s1, j));
/*    */       
/*    */       }
/* 60 */       else if (!bool) {
/* 61 */         arrayList.add(new EscherSimpleProperty(s1, j));
/*    */       
/*    */       }
/* 64 */       else if (b1 == 5) {
/* 65 */         arrayList.add(new EscherArrayProperty(s1, new byte[j]));
/*    */       } else {
/* 67 */         arrayList.add(new EscherComplexProperty(s1, new byte[j]));
/*    */       } 
/*    */       
/* 70 */       i += 6;
/*    */     } 
/*    */ 
/*    */     
/* 74 */     for (EscherProperty escherProperty : arrayList) {
/* 75 */       if (escherProperty instanceof EscherComplexProperty) {
/* 76 */         if (escherProperty instanceof EscherArrayProperty) {
/* 77 */           i += ((EscherArrayProperty)escherProperty).setArrayData(paramArrayOfbyte, i); continue;
/*    */         } 
/* 79 */         byte[] arrayOfByte = ((EscherComplexProperty)escherProperty).getComplexData();
/*    */         
/* 81 */         int j = paramArrayOfbyte.length - i;
/* 82 */         if (j < arrayOfByte.length) {
/* 83 */           throw new IllegalStateException("Could not read complex escher property, lenght was " + arrayOfByte.length + ", but had only " + j + " bytes left");
/*    */         }
/*    */ 
/*    */         
/* 87 */         System.arraycopy(paramArrayOfbyte, i, arrayOfByte, 0, arrayOfByte.length);
/* 88 */         i += arrayOfByte.length;
/*    */       } 
/*    */     } 
/*    */     
/* 92 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherPropertyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */