/*    */ package org.c.a.b.g;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.c.a.b.r.b;
/*    */ import org.c.a.b.r.e;
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
/*    */ public class c
/*    */ {
/*    */   public static String a(org.c.a.a.c[] paramArrayOfc) {
/* 53 */     List<String> list = Arrays.asList(new String[] { "Category", "Version", "Description", "Type", "Installed On", "State" });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     ArrayList<List<String>> arrayList = new ArrayList();
/* 60 */     for (org.c.a.a.c c1 : paramArrayOfc) {
/* 61 */       List<String> list1 = Arrays.asList(new String[] {
/* 62 */             a(c1), 
/* 63 */             b(c1), c1
/* 64 */             .getDescription(), c1
/* 65 */             .a().name(), 
/* 66 */             e.a(c1.d()), c1
/* 67 */             .a().getDisplayName()
/*    */           });
/*    */ 
/*    */ 
/*    */       
/* 72 */       arrayList.add(list1);
/*    */     } 
/*    */     
/* 75 */     return (new b(list, arrayList, true, "", "No migrations found")).eN();
/*    */   }
/*    */   
/*    */   static String a(org.c.a.a.c paramc) {
/* 79 */     if (paramc.a().isSynthetic()) {
/* 80 */       return "";
/*    */     }
/* 82 */     if (paramc.c() == null) {
/* 83 */       return "Repeatable";
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 90 */     return "Versioned";
/*    */   }
/*    */   
/*    */   private static String b(org.c.a.a.c paramc) {
/* 94 */     return (paramc.c() == null) ? "" : paramc.c().toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\g\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */