/*    */ package org.apache.xmlbeans.impl.piccolo.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ import java.util.Enumeration;
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
/*    */ public class FactoryServiceFinder
/*    */ {
/*    */   static final String SERVICE = "META-INF/services/";
/*    */   
/*    */   public static String findService(String paramString) throws IOException {
/* 39 */     InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("META-INF/services/" + paramString);
/*    */ 
/*    */     
/* 42 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/*    */     
/* 44 */     return bufferedReader.readLine();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Enumeration findServices(String paramString) throws IOException {
/* 52 */     return new FactoryEnumeration(ClassLoader.getSystemClassLoader().getResources(paramString));
/*    */   }
/*    */   
/*    */   private static class FactoryEnumeration
/*    */     implements Enumeration {
/*    */     Enumeration enumValue;
/* 58 */     Object next = null;
/*    */     
/*    */     FactoryEnumeration(Enumeration param1Enumeration) {
/* 61 */       this.enumValue = param1Enumeration;
/* 62 */       nextElement();
/*    */     }
/*    */     
/*    */     public boolean hasMoreElements() {
/* 66 */       return (this.next != null);
/*    */     }
/*    */     
/*    */     public Object nextElement() {
/* 70 */       Object object = this.next;
/*    */       
/*    */       while (true) {
/*    */         try {
/* 74 */           if (this.enumValue.hasMoreElements()) {
/* 75 */             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((URL)this.enumValue.nextElement()).openStream()));
/*    */ 
/*    */             
/* 78 */             this.next = bufferedReader.readLine();
/*    */             break;
/*    */           } 
/* 81 */           this.next = null;
/*    */ 
/*    */           
/*    */           break;
/* 85 */         } catch (IOException iOException) {}
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 90 */       return object;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\FactoryServiceFinder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */