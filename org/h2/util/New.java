/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
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
/*    */ public class New
/*    */ {
/*    */   public static <T> ArrayList<T> arrayList() {
/* 26 */     return new ArrayList<>(4);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <K, V> HashMap<K, V> hashMap() {
/* 37 */     return new HashMap<>();
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
/*    */   public static <K, V> HashMap<K, V> hashMap(int paramInt) {
/* 49 */     return new HashMap<>(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> HashSet<T> hashSet() {
/* 59 */     return new HashSet<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> ArrayList<T> arrayList(Collection<T> paramCollection) {
/* 70 */     return new ArrayList<>(paramCollection);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> ArrayList<T> arrayList(int paramInt) {
/* 81 */     return new ArrayList<>(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\New.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */