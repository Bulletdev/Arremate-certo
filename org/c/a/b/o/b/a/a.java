/*    */ package org.c.a.b.o.b.a;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.net.URL;
/*    */ import org.c.a.b.o.b.i;
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
/*    */ public class a
/*    */   implements i
/*    */ {
/*    */   public URL a(URL paramURL) {
/*    */     try {
/* 30 */       Class<?> clazz1 = Class.forName("org.jboss.virtual.VFS");
/* 31 */       Class<?> clazz2 = Class.forName("org.jboss.virtual.VFSUtils");
/* 32 */       Class<?> clazz3 = Class.forName("org.jboss.virtual.VirtualFile");
/*    */       
/* 34 */       Method method1 = clazz1.getMethod("getRoot", new Class[] { URL.class });
/* 35 */       Method method2 = clazz2.getMethod("getRealURL", new Class[] { clazz3 });
/*    */       
/* 37 */       Object object = method1.invoke(null, new Object[] { paramURL });
/* 38 */       return (URL)method2.invoke(null, new Object[] { object });
/* 39 */     } catch (Exception exception) {
/* 40 */       throw new org.c.a.a.a("JBoss VFS v2 call failed", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */