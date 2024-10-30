/*    */ package org.apache.commons.collections4;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.commons.collections4.iterators.EnumerationIterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumerationUtils
/*    */ {
/*    */   public static <T> T get(Enumeration<T> paramEnumeration, int paramInt) {
/* 55 */     int i = paramInt;
/* 56 */     CollectionUtils.checkIndexBounds(i);
/* 57 */     while (paramEnumeration.hasMoreElements()) {
/* 58 */       i--;
/* 59 */       if (i == -1) {
/* 60 */         return paramEnumeration.nextElement();
/*    */       }
/* 62 */       paramEnumeration.nextElement();
/*    */     } 
/*    */     
/* 65 */     throw new IndexOutOfBoundsException("Entry does not exist: " + i);
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
/*    */   
/*    */   public static <E> List<E> toList(Enumeration<? extends E> paramEnumeration) {
/* 80 */     return IteratorUtils.toList((Iterator<? extends E>)new EnumerationIterator(paramEnumeration));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<String> toList(StringTokenizer paramStringTokenizer) {
/* 91 */     ArrayList<String> arrayList = new ArrayList(paramStringTokenizer.countTokens());
/* 92 */     while (paramStringTokenizer.hasMoreTokens()) {
/* 93 */       arrayList.add(paramStringTokenizer.nextToken());
/*    */     }
/* 95 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\EnumerationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */