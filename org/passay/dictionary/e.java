/*    */ package org.passay.dictionary;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.passay.dictionary.a.a;
/*    */ import org.passay.dictionary.a.b;
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
/*    */ public class e
/*    */ {
/* 24 */   private static final a a = (a)new b();
/*    */ 
/*    */   
/* 27 */   private final List<Reader> ba = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean caseSensitive;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e a(String paramString) {
/*    */     try {
/* 43 */       return a(new FileReader(new File(paramString)));
/* 44 */     } catch (FileNotFoundException fileNotFoundException) {
/* 45 */       throw new IllegalArgumentException(paramString + " does not exist", fileNotFoundException);
/*    */     } 
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
/*    */   public e a(Reader paramReader) {
/* 58 */     this.ba.add(paramReader);
/* 59 */     return this;
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
/*    */   public e a(boolean paramBoolean) {
/* 72 */     this.caseSensitive = paramBoolean;
/* 73 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public d b() {
/*    */     try {
/* 85 */       ArrayList<String> arrayList = new ArrayList();
/* 86 */       for (Reader reader : this.ba) {
/* 87 */         l.a(reader, arrayList);
/*    */       }
/*    */       
/* 90 */       String[] arrayOfString = new String[arrayList.size()];
/* 91 */       arrayList.toArray(arrayOfString);
/* 92 */       return new WordListDictionary(new c(arrayOfString, this.caseSensitive, a));
/* 93 */     } catch (IOException iOException) {
/* 94 */       throw new RuntimeException("IO error building dictionary", iOException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */