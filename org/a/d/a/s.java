/*    */ package org.a.d.a;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum s
/*    */ {
/* 17 */   a,
/*    */   
/* 19 */   b,
/*    */   
/* 21 */   c,
/*    */   
/* 23 */   d,
/*    */   
/* 25 */   e,
/*    */   
/* 27 */   f,
/*    */   
/* 29 */   g,
/*    */   
/* 31 */   h,
/*    */   
/* 33 */   i,
/*    */ 
/*    */ 
/*    */   
/* 37 */   j;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<s> ag() {
/* 46 */     ArrayList<s> arrayList = new ArrayList(Arrays.asList((Object[])values()));
/* 47 */     arrayList.remove(i);
/* 48 */     arrayList.remove(j);
/* 49 */     return arrayList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<s> ah() {
/* 60 */     return new ArrayList<>(Arrays.asList(new s[] { b, c, d, e, f, g }));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\d\a\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */