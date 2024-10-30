/*    */ package org.c.a.b.m;
/*    */ 
/*    */ import org.c.a.a.a;
/*    */ import org.c.a.a.g;
/*    */ import org.c.a.b.r.l;
/*    */ import org.c.a.b.r.n;
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
/*    */   public static l<g, String> a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean) {
/* 49 */     String str1 = a(paramString1, paramString2, paramArrayOfString);
/*    */ 
/*    */     
/* 52 */     int i = str1.indexOf(paramString3);
/* 53 */     if (i < 0) {
/* 54 */       throw new a("Wrong migration name format: " + paramString1 + "(It should look like this: " + paramString2 + (
/*    */           
/* 56 */           paramBoolean ? "" : "1.2") + paramString3 + "Description" + paramArrayOfString[0] + ")");
/*    */     }
/*    */     
/* 59 */     String str2 = str1.substring(0, i);
/* 60 */     String str3 = str1.substring(i + paramString3.length()).replace("_", " ");
/* 61 */     if (n.X(str2)) {
/* 62 */       if (paramBoolean) {
/* 63 */         throw new a("Wrong repeatable migration name format: " + paramString1 + "(It cannot contain a version and should look like this: " + paramString2 + paramString3 + str3 + paramArrayOfString[0] + ")");
/*    */       }
/*    */ 
/*    */       
/* 67 */       return l.a(g.a(str2), str3);
/*    */     } 
/* 69 */     if (!paramBoolean) {
/* 70 */       throw new a("Wrong versioned migration name format: " + paramString1 + "(It must contain a version and should look like this: " + paramString2 + "1.2" + paramString3 + str3 + paramArrayOfString[0] + ")");
/*    */     }
/*    */ 
/*    */     
/* 74 */     return l.a(null, str3);
/*    */   }
/*    */   
/*    */   private static String a(String paramString1, String paramString2, String[] paramArrayOfString) {
/* 78 */     for (String str : paramArrayOfString) {
/* 79 */       if (paramString1.endsWith(str)) {
/* 80 */         return paramString1.substring(
/* 81 */             n.W(paramString2) ? paramString2.length() : 0, paramString1
/* 82 */             .length() - str.length());
/*    */       }
/*    */     } 
/* 85 */     return paramString1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */