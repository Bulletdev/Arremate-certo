/*     */ package org.apache.xmlbeans.impl.jam;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamPrinter;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamServiceFactoryImpl;
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
/*     */ public abstract class JamServiceFactory
/*     */ {
/*  53 */   private static final JamServiceFactory DEFAULT = (JamServiceFactory)new JamServiceFactoryImpl();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JamServiceFactory getInstance() {
/*  61 */     return DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract JamServiceParams createServiceParams();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract JamService createService(JamServiceParams paramJamServiceParams) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract JamClassLoader createSystemJamClassLoader();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract JamClassLoader createJamClassLoader(ClassLoader paramClassLoader);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     try {
/* 103 */       JamServiceParams jamServiceParams = getInstance().createServiceParams();
/* 104 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 105 */         jamServiceParams.includeSourcePattern(new File[] { new File(".") }, paramArrayOfString[b]);
/*     */       } 
/* 107 */       JamService jamService = getInstance().createService(jamServiceParams);
/* 108 */       JamPrinter jamPrinter = JamPrinter.newInstance();
/* 109 */       PrintWriter printWriter = new PrintWriter(System.out);
/* 110 */       for (JamClassIterator jamClassIterator = jamService.getClasses(); jamClassIterator.hasNext(); ) {
/* 111 */         printWriter.println("-------- ");
/* 112 */         jamPrinter.print(jamClassIterator.nextClass(), printWriter);
/*     */       } 
/* 114 */       printWriter.flush();
/* 115 */     } catch (Exception exception) {
/* 116 */       exception.printStackTrace();
/*     */     } 
/* 118 */     System.out.flush();
/* 119 */     System.err.flush();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JamServiceFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */