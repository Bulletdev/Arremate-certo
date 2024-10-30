/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class IntMapper<T>
/*    */ {
/*    */   private List<T> elements;
/*    */   private Map<T, Integer> valueKeyMap;
/*    */   private static final int _default_size = 10;
/*    */   
/*    */   public IntMapper() {
/* 50 */     this(10);
/*    */   }
/*    */ 
/*    */   
/*    */   public IntMapper(int paramInt) {
/* 55 */     this.elements = new ArrayList<T>(paramInt);
/* 56 */     this.valueKeyMap = new HashMap<T, Integer>(paramInt);
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
/*    */   public boolean add(T paramT) {
/* 69 */     int i = this.elements.size();
/* 70 */     this.elements.add(paramT);
/* 71 */     this.valueKeyMap.put(paramT, Integer.valueOf(i));
/* 72 */     return true;
/*    */   }
/*    */   
/*    */   public int size() {
/* 76 */     return this.elements.size();
/*    */   }
/*    */   
/*    */   public T get(int paramInt) {
/* 80 */     return this.elements.get(paramInt);
/*    */   }
/*    */   
/*    */   public int getIndex(T paramT) {
/* 84 */     Integer integer = this.valueKeyMap.get(paramT);
/* 85 */     if (integer == null)
/* 86 */       return -1; 
/* 87 */     return integer.intValue();
/*    */   }
/*    */   
/*    */   public Iterator<T> iterator() {
/* 91 */     return this.elements.iterator();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\IntMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */